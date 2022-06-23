package com.sky.antlr4.demo.core

class PrimitiveType private constructor(private val name: String) {

    override fun toString(): String {
        return name!!
    }

    companion object {
        // 把常见的基础数据类型都定义出来
        var Integer = PrimitiveType("Integer")
        var Long = PrimitiveType("Long")
        var Float = PrimitiveType("Float")
        var Double = PrimitiveType("Double")
        var Boolean = PrimitiveType("Boolean")
        var Byte = PrimitiveType("Byte")
        var Char = PrimitiveType("Char")
        var Short = PrimitiveType("Short")
        var String = PrimitiveType("Short") //增加String为基础类型
        var Null = PrimitiveType("null")

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
    }
}