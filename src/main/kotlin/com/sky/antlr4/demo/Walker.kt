package com.sky.antlr4.demo

import com.sky.antlr4.demo.core.DslContext
import com.sky.antlr4.demo.util.DslExecutor
import org.apache.logging.log4j.LogManager

class Application
private val log = LogManager.getLogger(Application::class.java)

fun main() {
    val dsl = "(Double)(2 + 1)"
    val ctx = DslContext(dsl)
    val validation = DslExecutor.validate(ctx)
    println("规则合法可配置:  validation:$validation")

    var result = DslExecutor.execute(ctx)
    println("规则${ctx.data}:  执行结果:${result} ")
}