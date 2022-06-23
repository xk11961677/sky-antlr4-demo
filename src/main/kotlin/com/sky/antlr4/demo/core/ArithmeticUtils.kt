package com.sky.antlr4.demo.core

/**
 * 运算工具类
 */
object ArithmeticUtils {

    fun add(obj1: Any, obj2: Any, targetType: PrimitiveType): Any? {
        var rtn: Any? = null
        if (targetType === PrimitiveType.String) {
            rtn = obj1.toString() + obj2.toString()
        } else if (targetType === PrimitiveType.Integer) {
            rtn = (obj1 as Number).toInt() + (obj2 as Number).toInt()
        } else if (targetType === PrimitiveType.Float) {
            rtn = (obj1 as Number).toFloat() + (obj2 as Number).toFloat()
        } else if (targetType === PrimitiveType.Long) {
            rtn = (obj1 as Number).toLong() + (obj2 as Number).toLong()
        } else if (targetType === PrimitiveType.Double) {
            rtn = (obj1 as Number).toDouble() + (obj2 as Number).toDouble()
        } else if (targetType === PrimitiveType.Short) {
            rtn = (obj1 as Number).toShort() + (obj2 as Number).toShort()
        } else {
            println("unsupported add operation")
        }
        return rtn
    }

    fun minus(obj1: Any, obj2: Any, targetType: PrimitiveType): Any? {
        var rtn: Any? = null
        if (targetType === PrimitiveType.Integer) {
            rtn = (obj1 as Number).toInt() - (obj2 as Number).toInt()
        } else if (targetType === PrimitiveType.Float) {
            rtn = (obj1 as Number).toFloat() - (obj2 as Number).toFloat()
        } else if (targetType === PrimitiveType.Long) {
            rtn = (obj1 as Number).toLong() - (obj2 as Number).toLong()
        } else if (targetType === PrimitiveType.Double) {
            rtn = (obj1 as Number).toDouble() - (obj2 as Number).toDouble()
        } else if (targetType === PrimitiveType.Short) {
            rtn = (obj1 as Number).toShort() - (obj2 as Number).toShort()
        }
        return rtn
    }

    fun mul(obj1: Any, obj2: Any, targetType: PrimitiveType): Any? {
        var rtn: Any? = null
        if (targetType === PrimitiveType.Integer) {
            rtn = (obj1 as Number).toInt() * (obj2 as Number).toInt()
        } else if (targetType === PrimitiveType.Float) {
            rtn = (obj1 as Number).toFloat() * (obj2 as Number).toFloat()
        } else if (targetType === PrimitiveType.Long) {
            rtn = (obj1 as Number).toLong() * (obj2 as Number).toLong()
        } else if (targetType === PrimitiveType.Double) {
            rtn = (obj1 as Number).toDouble() * (obj2 as Number).toDouble()
        } else if (targetType === PrimitiveType.Short) {
            rtn = (obj1 as Number).toShort() * (obj2 as Number).toShort()
        }
        return rtn
    }

    fun div(obj1: Any, obj2: Any, targetType: PrimitiveType): Any? {
        var rtn: Any? = null
        if (targetType === PrimitiveType.Integer) {
            rtn = (obj1 as Number).toInt() / (obj2 as Number).toInt()
        } else if (targetType === PrimitiveType.Float) {
            rtn = (obj1 as Number).toFloat() / (obj2 as Number).toFloat()
        } else if (targetType === PrimitiveType.Long) {
            rtn = (obj1 as Number).toLong() / (obj2 as Number).toLong()
        } else if (targetType === PrimitiveType.Double) {
            rtn = (obj1 as Number).toDouble() / (obj2 as Number).toDouble()
        } else if (targetType === PrimitiveType.Short) {
            rtn = (obj1 as Number).toShort() / (obj2 as Number).toShort()
        }
        return rtn
    }

    fun eq(obj1: Any, obj2: Any, targetType: PrimitiveType): Boolean {
        var rtn = if (targetType === PrimitiveType.Integer) {
            (obj1 as Number).toInt() == (obj2 as Number).toInt()
        } else if (targetType === PrimitiveType.Float) {
            (obj1 as Number).toFloat() == (obj2 as Number).toFloat()
        } else if (targetType === PrimitiveType.Long) {
            (obj1 as Number).toLong() == (obj2 as Number).toLong()
        } else if (targetType === PrimitiveType.Double) {
            (obj1 as Number).toDouble() == (obj2 as Number).toDouble()
        } else if (targetType === PrimitiveType.Short) {
            (obj1 as Number).toShort() == (obj2 as Number).toShort()
        } else {
            obj1 === obj2
        }
        return rtn
    }

    fun ge(obj1: Any, obj2: Any, targetType: PrimitiveType): Any {
        var rtn = if (targetType === PrimitiveType.Integer) {
            (obj1 as Number).toInt() >= (obj2 as Number).toInt()
        } else if (targetType === PrimitiveType.Float) {
            (obj1 as Number).toFloat() >= (obj2 as Number).toFloat()
        } else if (targetType === PrimitiveType.Long) {
            (obj1 as Number).toLong() >= (obj2 as Number).toLong()
        } else if (targetType === PrimitiveType.Double) {
            (obj1 as Number).toDouble() >= (obj2 as Number).toDouble()
        } else if (targetType === PrimitiveType.Short) {
            (obj1 as Number).toShort() >= (obj2 as Number).toShort()
        } else {
            //todo
            println("该对象无法比较大小")
        }
        return rtn
    }

    fun gt(obj1: Any, obj2: Any, targetType: PrimitiveType): Any {
        var rtn = if (targetType === PrimitiveType.Integer) {
            (obj1 as Number).toInt() > (obj2 as Number).toInt()
        } else if (targetType === PrimitiveType.Float) {
            (obj1 as Number).toFloat() > (obj2 as Number).toFloat()
        } else if (targetType === PrimitiveType.Long) {
            (obj1 as Number).toLong() > (obj2 as Number).toLong()
        } else if (targetType === PrimitiveType.Double) {
            (obj1 as Number).toDouble() > (obj2 as Number).toDouble()
        } else if (targetType === PrimitiveType.Short) {
            (obj1 as Number).toShort() > (obj2 as Number).toShort()
        }else {
            //todo
            println("该对象无法比较大小")
        }
        return rtn
    }

    fun le(obj1: Any, obj2: Any, targetType: PrimitiveType): Any {
        var rtn = if (targetType === PrimitiveType.Integer) {
            (obj1 as Number).toInt() <= (obj2 as Number).toInt()
        } else if (targetType === PrimitiveType.Float) {
            (obj1 as Number).toFloat() <= (obj2 as Number).toFloat()
        } else if (targetType === PrimitiveType.Long) {
            (obj1 as Number).toLong() <= (obj2 as Number).toLong()
        } else if (targetType === PrimitiveType.Double) {
            (obj1 as Number).toDouble() <= (obj2 as Number).toDouble()
        } else if (targetType === PrimitiveType.Short) {
            (obj1 as Number).toShort() <= (obj2 as Number).toShort()
        }else {
            // todo
            println("该对象无法比较大小")
        }
        return rtn
    }

    fun lt(obj1: Any, obj2: Any, targetType: PrimitiveType): Any {
        var rtn = if (targetType === PrimitiveType.Integer) {
            (obj1 as Number).toInt() < (obj2 as Number).toInt()
        } else if (targetType === PrimitiveType.Float) {
            (obj1 as Number).toFloat() < (obj2 as Number).toFloat()
        } else if (targetType === PrimitiveType.Long) {
            (obj1 as Number).toLong() < (obj2 as Number).toLong()
        } else if (targetType === PrimitiveType.Double) {
            (obj1 as Number).toDouble() < (obj2 as Number).toDouble()
        } else if (targetType === PrimitiveType.Short) {
            (obj1 as Number).toShort() < (obj2 as Number).toShort()
        }else {
            //todo
            println("该对象无法比较大小")
        }
        return rtn
    }
}