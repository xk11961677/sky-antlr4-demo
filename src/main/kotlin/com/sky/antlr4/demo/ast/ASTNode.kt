package com.sky.antlr4.demo.ast

abstract class ASTNode<P : ASTNode<P>> {
    var parent:P? = null
}