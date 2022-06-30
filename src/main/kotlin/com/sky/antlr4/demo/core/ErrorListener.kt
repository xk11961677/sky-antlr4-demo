package com.sky.antlr4.demo.core

import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import org.apache.logging.log4j.LogManager

/**
 * 语法错误监听器
 */
object ErrorListener : BaseErrorListener() {
    private val log = LogManager.getLogger(ErrorListener::class.java)

    override fun syntaxError(recognizer: Recognizer<*, *>?,offendingSymbol: Any,line: Int,charPositionInLine: Int,msg: String,e: RecognitionException) {
        val reportMsg = "line $line:$charPositionInLine $msg"
        log.warn("语法错误:  $reportMsg")
        throw IllegalArgumentException(reportMsg)
    }
}