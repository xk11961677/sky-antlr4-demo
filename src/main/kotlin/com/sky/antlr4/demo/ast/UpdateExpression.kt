package com.sky.antlr4.demo.ast

class UpdateExpression(val argument:ProgramASTNode, val operator:String, val prefix: Boolean):ProgramASTNode()