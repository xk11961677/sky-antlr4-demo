package com.sky.antlr4.demo.core

import com.sky.antlr4.demo.parser.*
import com.sky.antlr4.demo.parser.ExpressionParser.*
import java.lang.Boolean
import kotlin.Any
import kotlin.IllegalArgumentException


class ExprBaseVisitor : ExpressionBaseVisitor<Any>() {

    override fun visitExpr(ctx: ExprContext):Any {
        return visit(ctx.expression())
    }

    override fun visitExpression(ctx: ExpressionContext): Any {
        val rtn = if (ctx.bop != null && ctx.expression().size >= 2) {
            val left = visitExpression(ctx.expression(0))
            val right = visitExpression(ctx.expression(1))
            calculate(ctx,left,right, null)
        }  else if (ctx.primary() != null) {
            visitPrimary(ctx.primary())
        } else if (ctx.postfix != null) {
            var value = visitExpression(ctx.expression(0)) as Literal
            val rtn = when (ctx.postfix.type) {
                INC -> {
                    ArithmeticUtils.incr(value, value.type)
                }
                DEC -> {
                    ArithmeticUtils.decr(value, value.type)
                }
                else -> {
                    throw IllegalArgumentException("无法解析表达式")
                }
            }
            rtn
        }else if(ctx.expectType != null && ctx.expression().size ==1) {
            val expectType = this.visitPrimitiveType(ctx.typeType().primitiveType()) as PrimitiveType
            val value = visitExpression(ctx.expression(0))
            Literal.cast(value, expectType)
        }else if(ctx.prefix != null) {
            var value = visitExpression(ctx.expression(0)) as Literal
            val rtn = when (ctx.prefix.type) {
                INC -> {
                    ArithmeticUtils.incr(value, value.type)
                }
                DEC -> {
                    ArithmeticUtils.decr(value, value.type)
                }
                BANG -> {
                    Literal.of(!value.toString().toBoolean(),PrimitiveType.Boolean)
                }
                TILDE -> {
                    throw IllegalArgumentException("暂不支持非运算符")
                }
                ADD -> {
                    // 正号
                    value
                }
                SUB -> {
                    // 负号
                    var valueStr = (value).value.toString()
                    val valueAfter = if(valueStr.startsWith("-")) valueStr.replaceFirst("-","") else "-$valueStr"
                    Literal.cast(valueAfter,value.type)
                }
                else -> {
                    throw IllegalArgumentException("无法解析表达式")
                }
            }
            rtn
        }else {
            super.visitChildren(ctx)
        }
        return rtn
    }

    private fun calculate(ctx: ExpressionContext,left:Any, right:Any , expectType: PrimitiveType?): Any {
        var leftObject = (left as Literal).value
        var rightObject = (right as Literal).value
        var leftType = left.type
        var rightType = right.type

        val type = expectType ?: PrimitiveType.getUpperType(leftType, rightType)

        //左右两个子节点的类型
        val rtn = when (ctx.bop.type) {
            ADD -> ArithmeticUtils.add(leftObject, rightObject, type)
            SUB -> ArithmeticUtils.minus(leftObject, rightObject, type)
            MUL -> ArithmeticUtils.mul(leftObject, rightObject, type)
            DIV -> ArithmeticUtils.div(leftObject, rightObject, type)
            EQUAL -> ArithmeticUtils.eq(leftObject, rightObject, type)
            NOTEQUAL -> ArithmeticUtils.notEq(leftObject, rightObject, type)
            LE -> ArithmeticUtils.le(leftObject, rightObject, type)
            LT -> ArithmeticUtils.lt(leftObject, rightObject, type)
            GE -> ArithmeticUtils.ge(leftObject, rightObject, type)
            GT -> ArithmeticUtils.gt(leftObject, rightObject, type)
            AND -> ArithmeticUtils.and(leftObject, rightObject)
            OR -> ArithmeticUtils.or(leftObject, rightObject)
            else -> {
                throw IllegalArgumentException("暂不支持的表达式计算")
            }
        }
        return rtn
    }

    override fun visitLiteral(ctx: LiteralContext): Any {
        //整数
        val rtn = if (ctx.integerLiteral() != null) {
            visitIntegerLiteral(ctx.integerLiteral())
        } else if (ctx.floatLiteral() != null) {
            visitFloatLiteral(ctx.floatLiteral())
        } else if (ctx.BOOL_LITERAL() != null) {
            if (ctx.BOOL_LITERAL().text == "true") {
                Literal.of(Boolean.TRUE,PrimitiveType.Boolean)
            } else {
                Literal.of(Boolean.FALSE,PrimitiveType.Boolean)
            }
        } else if (ctx.STRING_LITERAL() != null) {
            val withQuotationMark = ctx.STRING_LITERAL().text
            Literal.of(withQuotationMark.substring(1, withQuotationMark.length - 1),PrimitiveType.String)
        } else if (ctx.CHAR_LITERAL() != null) {
            Literal.of(ctx.CHAR_LITERAL().text[0],PrimitiveType.Char)
        } else if (ctx.NULL_LITERAL() != null) {
           Literal.of("null",PrimitiveType.Null)
        } else {
            throw IllegalArgumentException("不支持的字面量")
        }
        return rtn
    }

    override fun visitIntegerLiteral(ctx: IntegerLiteralContext): Any {
        val rtn = if (ctx.DECIMAL_LITERAL() != null) {
            Literal.of(Integer.valueOf(ctx.DECIMAL_LITERAL().text),PrimitiveType.Integer)
        }else if(ctx.HEX_LITERAL() != null) {
             Literal.of(Integer.valueOf(ctx.HEX_LITERAL().text),PrimitiveType.Integer)
        }else if(ctx.OCT_LITERAL() != null) {
            Literal.of(Integer.valueOf(ctx.OCT_LITERAL().text),PrimitiveType.Integer)
        }else if(ctx.BINARY_LITERAL() != null) {
            Literal.of(Integer.valueOf(ctx.BINARY_LITERAL().text),PrimitiveType.Integer)
        }else {
            throw IllegalArgumentException("不支持的integer字面量")
        }
        return rtn
    }

    override fun visitFloatLiteral(ctx: FloatLiteralContext): Any {
        return Literal.of(java.lang.Float.valueOf(ctx.text),PrimitiveType.Float)
    }

    override fun visitPrimary(ctx: PrimaryContext): Any {
        //字面量
        val rtn = if (ctx.literal() != null) {
            visitLiteral(ctx.literal())
        } else if (ctx.IDENTIFIER() != null) {
            ctx.IDENTIFIER().text
        } else if (ctx.expression() != null) {
            visitExpression(ctx.expression())
        } else {
            throw IllegalArgumentException("不支持的表达式计算")
        }
        return rtn
    }

    override fun visitPrimitiveType(ctx: PrimitiveTypeContext): Any {
        return PrimitiveType.match(ctx.text) ?: throw IllegalArgumentException("不支持的类型")
    }
}