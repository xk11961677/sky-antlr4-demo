package com.sky.antlr4.demo.core

class Literal(val value:Any,val type:PrimitiveType) {

    companion object {
        fun of(value: Any, type:PrimitiveType):Literal {
            return Literal(value,type)
        }

        fun cast(value: Any, type:PrimitiveType):Literal {
            val expectedValue = when(type) {
                PrimitiveType.Integer -> value.toString().toInt()
                PrimitiveType.Float -> value.toString().toFloat()
                PrimitiveType.Long -> value.toString().toLong()
                PrimitiveType.Double -> value.toString().toDouble()
                PrimitiveType.Boolean -> value.toString().toBoolean()
                PrimitiveType.Byte -> value.toString().toByte()
//                PrimitiveType.Char -> value.toString().charAt(0).toChar()
                PrimitiveType.Short -> value.toString().toShort()
                PrimitiveType.String -> value.toString()
                PrimitiveType.Null -> PrimitiveType.Null.toString()
                else -> {
                    throw IllegalArgumentException("不支持的类型")
                }
            }
            return of(expectedValue,type)
        }
    }
}