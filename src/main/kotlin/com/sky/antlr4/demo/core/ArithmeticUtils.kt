package com.sky.antlr4.demo.core

/**
 * 运算工具类
 */
object ArithmeticUtils {

    fun add(obj1: Any, obj2: Any, targetType: PrimitiveType): Any {
        val rtn = if (targetType === PrimitiveType.String) {
            obj1.toString() + obj2.toString()
        } else if (targetType === PrimitiveType.Integer) {
            (obj1 as Number).toInt() + (obj2 as Number).toInt()
        } else if (targetType === PrimitiveType.Float) {
            (obj1 as Number).toFloat() + (obj2 as Number).toFloat()
        } else if (targetType === PrimitiveType.Long) {
            (obj1 as Number).toLong() + (obj2 as Number).toLong()
        } else if (targetType === PrimitiveType.Double) {
            (obj1 as Number).toDouble() + (obj2 as Number).toDouble()
        } else if (targetType === PrimitiveType.Short) {
            (obj1 as Number).toShort() + (obj2 as Number).toShort()
        } else {
            throw IllegalArgumentException("无法计算add")
        }
        return Literal.of(rtn,targetType)
    }

    fun minus(obj1: Any, obj2: Any, targetType: PrimitiveType): Any {
        val rtn = if (targetType === PrimitiveType.Integer) {
            (obj1 as Number).toInt() - (obj2 as Number).toInt()
        } else if (targetType === PrimitiveType.Float) {
            (obj1 as Number).toFloat() - (obj2 as Number).toFloat()
        } else if (targetType === PrimitiveType.Long) {
            (obj1 as Number).toLong() - (obj2 as Number).toLong()
        } else if (targetType === PrimitiveType.Double) {
            (obj1 as Number).toDouble() - (obj2 as Number).toDouble()
        } else if (targetType === PrimitiveType.Short) {
            (obj1 as Number).toShort() - (obj2 as Number).toShort()
        }else {
            throw IllegalArgumentException("无法计算minus")
        }
        return Literal.of(rtn,targetType)
    }

    fun mul(obj1: Any, obj2: Any, targetType: PrimitiveType): Any {
        val rtn = if (targetType === PrimitiveType.Integer) {
            (obj1 as Number).toInt() * (obj2 as Number).toInt()
        } else if (targetType === PrimitiveType.Float) {
            (obj1 as Number).toFloat() * (obj2 as Number).toFloat()
        } else if (targetType === PrimitiveType.Long) {
            (obj1 as Number).toLong() * (obj2 as Number).toLong()
        } else if (targetType === PrimitiveType.Double) {
            (obj1 as Number).toDouble() * (obj2 as Number).toDouble()
        } else if (targetType === PrimitiveType.Short) {
            (obj1 as Number).toShort() * (obj2 as Number).toShort()
        }else {
            throw IllegalArgumentException("无法计算mul")
        }
        return Literal.of(rtn,targetType)
    }

    fun div(obj1: Any, obj2: Any, targetType: PrimitiveType): Any {
        val rtn = if (targetType === PrimitiveType.Integer) {
            (obj1 as Number).toInt() / (obj2 as Number).toInt()
        } else if (targetType === PrimitiveType.Float) {
            (obj1 as Number).toFloat() / (obj2 as Number).toFloat()
        } else if (targetType === PrimitiveType.Long) {
            (obj1 as Number).toLong() / (obj2 as Number).toLong()
        } else if (targetType === PrimitiveType.Double) {
            (obj1 as Number).toDouble() / (obj2 as Number).toDouble()
        } else if (targetType === PrimitiveType.Short) {
            (obj1 as Number).toShort() / (obj2 as Number).toShort()
        }else {
            throw IllegalArgumentException("无法计算div")
        }
        return Literal.of(rtn,targetType)
    }

    fun eq(obj1: Any, obj2: Any, targetType: PrimitiveType): Any {
        val rtn = if (targetType === PrimitiveType.Integer) {
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
        return Literal.of(rtn,PrimitiveType.Boolean)
    }

    fun notEq(obj1: Any, obj2: Any, targetType: PrimitiveType): Any {
        val literal = eq(obj1, obj2, targetType) as Literal
        return Literal.of(!(literal.value as Boolean), PrimitiveType.Boolean)
    }

    fun ge(obj1: Any, obj2: Any, targetType: PrimitiveType): Any {
        val rtn = if (targetType === PrimitiveType.Integer) {
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
            throw IllegalArgumentException("无法计算ge")
        }
        return Literal.of(rtn,PrimitiveType.Boolean)
    }

    fun gt(obj1: Any, obj2: Any, targetType: PrimitiveType): Any {
        val rtn = if (targetType === PrimitiveType.Integer) {
            (obj1 as Number).toInt() > (obj2 as Number).toInt()
        } else if (targetType === PrimitiveType.Float) {
            (obj1 as Number).toFloat() > (obj2 as Number).toFloat()
        } else if (targetType === PrimitiveType.Long) {
            (obj1 as Number).toLong() > (obj2 as Number).toLong()
        } else if (targetType === PrimitiveType.Double) {
            (obj1 as Number).toDouble() > (obj2 as Number).toDouble()
        } else if (targetType === PrimitiveType.Short) {
            (obj1 as Number).toShort() > (obj2 as Number).toShort()
        } else {
            throw IllegalArgumentException("无法计算gt")
        }
        return Literal.of(rtn,PrimitiveType.Boolean)
    }

    fun le(obj1: Any, obj2: Any, targetType: PrimitiveType): Any {
        val rtn = if (targetType === PrimitiveType.Integer) {
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
            throw IllegalArgumentException("无法计算le")
        }
        return Literal.of(rtn,PrimitiveType.Boolean)
    }

    fun lt(obj1: Any, obj2: Any, targetType: PrimitiveType): Any {
        val rtn = if (targetType === PrimitiveType.Integer) {
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
            throw IllegalArgumentException("无法计算lt")
        }
        return Literal.of(rtn,PrimitiveType.Boolean)
    }

    fun incr(obj1: Any,targetType: PrimitiveType): Any {
        return add(obj1, Literal.of(1,PrimitiveType.Integer), targetType)
    }

    fun decr(obj1: Any,targetType: PrimitiveType): Any {
        return minus(obj1, Literal.of(1,PrimitiveType.Integer), targetType)
    }

    fun and(obj1: Any,obj2: Any):Any {
        return Literal.of(obj1.toString().toBoolean() && obj2.toString().toBoolean(),PrimitiveType.Boolean)
    }

    fun or(obj1: Any,obj2: Any):Any {
        return Literal.of(obj1.toString().toBoolean() || obj2.toString().toBoolean(),PrimitiveType.Boolean)
    }
}