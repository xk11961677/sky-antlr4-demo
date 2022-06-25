package com.sky.antlr4.demo.core

import com.sky.antlr4.demo.parser.ArithmeticBaseVisitor
import com.sky.antlr4.demo.parser.ArithmeticParser.*
import java.lang.Boolean
import kotlin.Any
import kotlin.IllegalArgumentException


class CustomArithmeticBaseVisitor : ArithmeticBaseVisitor<Any>() {

    override fun visitExpression(ctx: ExpressionContext): Any {
        var rtn: Any?=null
        if (ctx.bop != null && ctx.expression().size >= 2) {
            val left = visitExpression(ctx.expression(0))
            val right = visitExpression(ctx.expression(1))
            rtn = calculate(ctx,left,right, null)
        }  else if (ctx.primary() != null) {
            rtn = visitPrimary(ctx.primary())
        } else if (ctx.postfix != null) {
            //todo 进行运算
            var value = visitExpression(ctx.expression(0))
            rtn = value
        }else if(ctx.expectType != null && ctx.expression().size ==1) {
            val typeType = ctx.typeType()
            val typeLiteral = typeType.primitiveType()?.text?:typeType.IDENTIFIER().text
            val expectType= PrimitiveType.get(typeLiteral)
            val value = visitExpression(ctx.expression(0))
            rtn = Literal.cast(value, expectType).value
        }else {
            super.visitChildren(ctx)
        }
        return rtn!!
    }

    private fun calculate(ctx: ExpressionContext,left:Any, right:Any , expectType: PrimitiveType?): Any? {
        var rtn:Any?
        var leftObject = (left as Literal).value
        var rightObject = (right as Literal).value
        var leftType = left.type
        var rightType = right.type

        val type = expectType ?: PrimitiveType.getUpperType(leftType, rightType)

        //左右两个子节点的类型
        rtn = when (ctx.bop.type) {
            ADD -> ArithmeticUtils.add(leftObject, rightObject, type)
            SUB -> ArithmeticUtils.minus(leftObject, rightObject, type)
            MUL -> ArithmeticUtils.mul(leftObject, rightObject, type)
            DIV -> ArithmeticUtils.div(leftObject, rightObject, type)
            EQUAL -> ArithmeticUtils.eq(leftObject, rightObject, type)
            NOTEQUAL -> !ArithmeticUtils.eq(leftObject, rightObject, type)
            LE -> ArithmeticUtils.le(leftObject, rightObject, type)
            LT -> ArithmeticUtils.lt(leftObject, rightObject, type)
            GE -> ArithmeticUtils.ge(leftObject, rightObject, type)
            GT -> ArithmeticUtils.gt(leftObject, rightObject, type)
            AND -> leftObject.toString().toBoolean() && rightObject.toString().toBoolean()
            OR -> leftObject.toString().toBoolean() || rightObject.toString().toBoolean()
            else -> {
                throw IllegalArgumentException("Unsupported feature during unknown")
            }
        }
        return rtn
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
            rtn = ctx.IDENTIFIER().text
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