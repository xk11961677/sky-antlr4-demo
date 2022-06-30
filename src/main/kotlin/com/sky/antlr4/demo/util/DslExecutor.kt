package com.sky.antlr4.demo.util

import com.sky.antlr4.demo.core.DslContext
import com.sky.antlr4.demo.core.ErrorListener
import com.sky.antlr4.demo.core.ExpFxBaseVisitor
import com.sky.antlr4.demo.parser.FxLexer
import com.sky.antlr4.demo.parser.FxParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

object DslExecutor {

    /**
     * 校验语法
     */
    fun validate(ctx: DslContext):Boolean {
        return true
    }

    /**
     * 执行语法
     */
    fun execute(ctx: DslContext):Any? {
        /**
        ParserErrorStrategy strategy=new ParserErrorStrategy(this.sql);
        lexer.removeErrorListeners();
        parser.removeErrorListeners();
        parser.setErrorHandler(strategy);
         */
        val lexer = FxLexer(CharStreams.fromString(ctx.data.toString()))
        val parser = FxParser(CommonTokenStream(lexer))
        lexer.removeErrorListeners()
        parser.removeErrorListeners()
        parser.addErrorListener(ErrorListener)
        val tree = parser.prog()
        return ExpFxBaseVisitor().visit(tree)
    }
}