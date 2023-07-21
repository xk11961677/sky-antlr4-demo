package com.sky.antlr4.demo.ast

class IfStatementExpression(val test:ProgramASTNode, val consequent:ProgramASTNode, val alternate: ProgramASTNode):ProgramASTNode()