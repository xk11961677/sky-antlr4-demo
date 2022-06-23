package com.sky.antlr4.demo.core

import com.sky.antlr4.demo.parser.ArithmeticBaseVisitor
import com.sky.antlr4.demo.parser.ArithmeticParser.*
import java.lang.Boolean
import kotlin.Any


class CustomArithmeticBaseVisitor : ArithmeticBaseVisitor<Any>() {

    override fun visitExpression(ctx: ExpressionContext): Any {
        var rtn: Any? = null
        if (ctx.bop != null && ctx.expression().size >= 2) {
            val left = visitExpression(ctx.expression(0))
            val right = visitExpression(ctx.expression(1))
            var leftObject = (left as Literal).value
            var rightObject = (right as Literal).value
            var leftType = left.type
            var rightType = right.type

            //左右两个子节点的类型
            when (ctx.bop.type) {
                ADD -> rtn = ArithmeticUtils.add(leftObject, rightObject, PrimitiveType.getUpperType(leftType, rightType))
                SUB -> rtn = ArithmeticUtils.minus(leftObject, rightObject, PrimitiveType.getUpperType(leftType, rightType))
                MUL -> rtn = ArithmeticUtils.mul(leftObject, rightObject, PrimitiveType.getUpperType(leftType, rightType))
                DIV -> rtn = ArithmeticUtils.div(leftObject, rightObject, PrimitiveType.getUpperType(leftType, rightType))
                EQUAL -> rtn = ArithmeticUtils.eq(leftObject, rightObject, PrimitiveType.getUpperType(leftType, rightType))
                NOTEQUAL -> rtn = !ArithmeticUtils.eq(leftObject, rightObject, PrimitiveType.getUpperType(leftType, rightType))
                LE -> rtn = ArithmeticUtils.le(leftObject, rightObject, PrimitiveType.getUpperType(leftType, rightType))
                LT -> rtn = ArithmeticUtils.lt(leftObject, rightObject, PrimitiveType.getUpperType(leftType, rightType))
                GE -> rtn = ArithmeticUtils.ge(leftObject, rightObject, PrimitiveType.getUpperType(leftType, rightType))
                GT -> rtn = ArithmeticUtils.gt(leftObject, rightObject, PrimitiveType.getUpperType(leftType, rightType))
                AND -> rtn = leftObject.toString().toBoolean() && rightObject.toString().toBoolean()
                OR -> rtn = leftObject.toString().toBoolean() || rightObject.toString().toBoolean()
                ASSIGN ->  println("Unsupported feature during assignment")
                else -> {
                    println("aaaa")
                }
            }
        } else if (ctx.bop != null && ctx.bop.type === DOT) {
            // 此语法是左递归的，算法体现这一点
            val leftObject = visitExpression(ctx.expression(0))
            println("Expecting an Object Reference")
        } else if (ctx.primary() != null) {
            rtn = visitPrimary(ctx.primary())
        } else if (ctx.postfix != null) {
            var value = visitExpression(ctx.expression(0))
            rtn = value
        } else if(ctx.typeType() != null) {
            // todo 强转
            println()
        }
        return rtn!!
    }

    override fun visitLiteral(ctx: LiteralContext): Any? {
        var rtn: Any? = null
        //整数
        if (ctx.integerLiteral() != null) {
            rtn = visitIntegerLiteral(ctx.integerLiteral())
        } else if (ctx.floatLiteral() != null) {
            rtn = visitFloatLiteral(ctx.floatLiteral())
        } else if (ctx.BOOL_LITERAL() != null) {
            rtn = if (ctx.BOOL_LITERAL().text == "true") {
                Literal.of(Boolean.TRUE,PrimitiveType.Boolean)
            } else {
                Literal.of(Boolean.FALSE,PrimitiveType.Boolean)
            }
        } else if (ctx.STRING_LITERAL() != null) {
            val withQuotationMark = ctx.STRING_LITERAL().text
            rtn = withQuotationMark.substring(1, withQuotationMark.length - 1)
            rtn = Literal.of(rtn,PrimitiveType.String)
        } else if (ctx.CHAR_LITERAL() != null) {
            rtn = Literal.of(ctx.CHAR_LITERAL().text[0],PrimitiveType.Char)
        } else if (ctx.NULL_LITERAL() != null) {
            rtn = Literal.of("null",PrimitiveType.Null)
        }
        return rtn
    }

    override fun visitIntegerLiteral(ctx: IntegerLiteralContext): Any? {
        var rtn: Any? = null
        if (ctx.DECIMAL_LITERAL() != null) {
            rtn = Literal.of(Integer.valueOf(ctx.DECIMAL_LITERAL().text),PrimitiveType.Integer)
        }
        return rtn
    }

    override fun visitFloatLiteral(ctx: FloatLiteralContext): Any? {
        return Literal.of(java.lang.Float.valueOf(ctx.text),PrimitiveType.Float)
    }


    override fun visitPrimary(ctx: PrimaryContext): Any? {
        var rtn: Any? = null
        //字面量
        if (ctx.literal() != null) {
            rtn = visitLiteral(ctx.literal())
        } else if (ctx.IDENTIFIER() != null) {
            println("标识")
        } else if (ctx.expression() != null) {
            rtn = visitExpression(ctx.expression())
        }
        return rtn
    }

    override fun visitPrimitiveType(ctx: PrimitiveTypeContext): Any? {
        var rtn: Any? = null
        if (ctx.INT() != null) {
            rtn = INT
        } else if (ctx.LONG() != null) {
            rtn = LONG
        } else if (ctx.FLOAT() != null) {
            rtn = FLOAT
        } else if (ctx.DOUBLE() != null) {
            rtn = DOUBLE
        } else if (ctx.BOOLEAN() != null) {
            rtn = BOOLEAN
        } else if (ctx.CHAR() != null) {
            rtn = CHAR
        } else if (ctx.SHORT() != null) {
            rtn = SHORT
        } else if (ctx.BYTE() != null) {
            rtn = BYTE
        }
        return rtn
    }
}