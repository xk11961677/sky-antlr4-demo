package com.sky.antlr4.demo.core

class Literal(val value:Any,val type:PrimitiveType) {

    companion object {
        fun of(value: Any, type:PrimitiveType):Literal {
            return Literal(value,type)
        }
    }
}