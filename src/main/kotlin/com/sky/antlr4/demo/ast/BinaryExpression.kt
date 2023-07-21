package com.sky.antlr4.demo.ast

class BinaryExpression(val left:ProgramASTNode, val operator:String, val right:ProgramASTNode):ProgramASTNode()