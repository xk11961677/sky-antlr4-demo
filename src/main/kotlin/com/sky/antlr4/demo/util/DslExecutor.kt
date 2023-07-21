package com.sky.antlr4.demo.util

import com.sky.antlr4.demo.core.DslContext

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
//        val lexer = ExpressionLexer(CharStreams.fromString(ctx.data.toString()))
//        val parser = ExpressionParser(CommonTokenStream(lexer))
//        lexer.removeErrorListeners()
//        parser.removeErrorListeners()
//        parser.addErrorListener(ErrorListener)
//        val tree = parser.expr()
//        return ExprBaseVisitor().visit(tree)
        return null
    }
}