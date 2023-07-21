package com.sky.antlr4.demo.ast

class AssignmentExpression(val left:ProgramASTNode,operator:String,val right:ProgramASTNode):Statement()