package com.sky.antlr4.demo.ast

class CallExpression(val callee:ProgramASTNode, val arguments:List<ProgramASTNode>):ProgramASTNode()