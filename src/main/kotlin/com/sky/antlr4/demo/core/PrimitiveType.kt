package com.sky.antlr4.demo.core

class PrimitiveType private constructor(private val name: String) {

    override fun toString(): String {
        return name!!
    }

    companion object {
        // 把常见的基础数据类型都定义出来
        val Integer = PrimitiveType("Integer")
        val Long = PrimitiveType("Long")
        val Float = PrimitiveType("Float")
        val Double = PrimitiveType("Double")
        val Boolean = PrimitiveType("Boolean")
        val Byte = PrimitiveType("Byte")
        val Char = PrimitiveType("Char")
        val Short = PrimitiveType("Short")
        val String = PrimitiveType("String")
        val Null = PrimitiveType("null")

        val container = listOf(Integer,Long,Float,Double,Boolean,Byte,Char,Short,String,Null)

        /**
         * 计算两个类型中比较“高”的一级，比如int和long相加，要取long
         *
         * @param type1
         * @param type2
         * @return
         */
        fun getUpperType(type1: PrimitiveType, type2: PrimitiveType): PrimitiveType {
            var type = if (type1 === String || type2 === String) {
                String
            } else if (type1 === Double || type2 === Double) {
                Double
            } else if (type1 === Float || type2 === Float) {
                Float
            } else if (type1 === Long || type2 === Long) {
                Long
            } else if (type1 === Integer || type2 === Integer) {
                Integer
            } else if (type1 === Short || type2 === Short) {
                Short
            } else {
                Byte // TODO 以上这些规则有没有漏洞？
            }
            return type
        }

        /**
         * 某个类型是不是数值型的（以便进行数值型运算）
         *
         * @param type
         * @return
         */
        fun isNumeric(type: PrimitiveType): Boolean {
            return type === Byte || type === Short || type === Integer || type === Long || type === Float || type === Double
        }

        fun get(identifier:String):PrimitiveType {
            return container.first{ it.name.uppercase() == identifier.uppercase()}
        }
    }
}