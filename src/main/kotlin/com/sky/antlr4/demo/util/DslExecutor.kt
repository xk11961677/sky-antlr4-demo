package com.sky.antlr4.demo.util

import com.sky.antlr4.demo.core.CustomArithmeticBaseVisitor
import com.sky.antlr4.demo.core.DslContext
import com.sky.antlr4.demo.parser.ArithmeticLexer
import com.sky.antlr4.demo.parser.ArithmeticParser
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
        val lexer = ArithmeticLexer(CharStreams.fromString(ctx.data.toString()))
        val parser = ArithmeticParser(CommonTokenStream(lexer))
        val parseTree = parser.expression()
        val visitor = CustomArithmeticBaseVisitor()
        return visitor.visit(parseTree)
    }
}