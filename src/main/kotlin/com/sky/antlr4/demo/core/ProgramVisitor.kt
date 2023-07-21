//package com.sky.antlr4.demo.core
//
//import com.sky.antlr4.demo.ast.*
//import com.sky.antlr4.demo.ast.Literal
//import com.sky.antlr4.demo.parser.ProgramParser.*
//import com.sky.antlr4.demo.parser.ProgramParserBaseVisitor
//
//class ProgramVisitor : ProgramParserBaseVisitor<ProgramASTNode>() {
//
//    override fun visitProgram(ctx: ProgramContext): ProgramASTNode {
//        return Program(visitStatement(ctx.body))
//    }
//
//    override fun visitStatement(ctx: StatementContext): Statement {
//        return visitChildren(ctx) as Statement
//    }
//
//    override fun visitBlockStatement(ctx: BlockStatementContext): BlockStatement {
//        return BlockStatement(ctx.body.statement().map { visitStatement(it) })
//    }
//
//    override fun visitExpressionStatement(ctx: ExpressionStatementContext): ExpressionStatement {
//        return ExpressionStatement(visit(ctx.expression))
//    }
//
//    override fun visitAssignmentExpression(ctx: AssignmentExpressionContext): AssignmentExpression {
//        return AssignmentExpression(visitExpression_leftHandSide(ctx.left) , ctx.operator.text, visit(ctx.right))
//    }
//
//    override fun visitEmptyStatement(ctx: EmptyStatementContext): ProgramASTNode {
//        return EmptyStatement()
//    }
//
//    override fun visitExpression_leftHandSide(ctx: Expression_leftHandSideContext?): ProgramASTNode {
//        return visitChildren(ctx)
//    }
//
//    override fun visitArrayExpression(ctx: ArrayExpressionContext): ProgramASTNode {
//        return visitChildren(ctx)
//    }
//
//    override fun visitSpreadElement(ctx: SpreadElementContext): ProgramASTNode {
//        return SpreadElement(visit(ctx.argument))
//    }
//
//    override fun visitObjectExpression(ctx: ObjectExpressionContext): ProgramASTNode {
//
//
//        return visitChildren(ctx)
//    }
//
//    override fun visitAst_objectProperty(ctx: Ast_objectPropertyContext?): ProgramASTNode {
//        return visitChildren(ctx)
//    }
//
//    override fun visitPropertyAssignment_assign(ctx: PropertyAssignment_assignContext?): ProgramASTNode {
//        return visitChildren(ctx)
//    }
//
//    override fun visitPropertyAssignment_computed(ctx: PropertyAssignment_computedContext?): ProgramASTNode {
//        return visitChildren(ctx)
//    }
//
//    override fun visitPropertyAssignment_shorthand(ctx: PropertyAssignment_shorthandContext?): ProgramASTNode {
//        return visitChildren(ctx)
//    }
//
//    override fun visitArguments_(ctx: Arguments_Context?): ProgramASTNode {
//        return visitChildren(ctx)
//    }
//
//    override fun visitObjectExpression_expr(ctx: ObjectExpression_exprContext): ProgramASTNode {
//        return ObjectExpression(ctx.objectExpression().properties.ast_objectProperty().map { visitAst_objectProperty(it) })
//    }
//
//    override fun visitBinaryExpression(ctx: BinaryExpressionContext): ProgramASTNode {
//        return BinaryExpression(visit(ctx.left), ctx.operator.text, visit(ctx.right))
//    }
//
//    override fun visitInExpression(ctx: InExpressionContext): ProgramASTNode {
//        return InExpression(visit(ctx.left), visit(ctx.right))
//    }
//
//    override fun visitIfStatement_expr(ctx: IfStatement_exprContext): ProgramASTNode {
//        return IfStatementExpression(visit(ctx.test), visit(ctx.consequent), visit(ctx.alternate))
//    }
//
//    override fun visitIdentifier_expr(ctx: Identifier_exprContext): ProgramASTNode {
//        return Identifier(ctx.text)
//    }
//
//    override fun visitArrayExpression_expr(ctx: ArrayExpression_exprContext): ProgramASTNode {
//        return ArrayExpression(ctx.arrayExpression().elements.ast_arrayElement().map { visitAst_arrayElement(it) })
//    }
//
//    override fun visitUnaryExpression(ctx: UnaryExpressionContext): ProgramASTNode {
//        return UnaryExpression(visit(ctx.argument), ctx.operator.text)
//    }
//
//    override fun visitLiteral_expr(ctx: Literal_exprContext): ProgramASTNode {
//        return Literal(ctx.text)
//    }
//
//    override fun visitUpdateExpression(ctx: UpdateExpressionContext): ProgramASTNode {
//        return UpdateExpression(visit(ctx.argument), ctx.operator.text, false)
//    }
//
//    override fun visitCallExpression(ctx: CallExpressionContext): ProgramASTNode {
//        return CallExpression(visit(ctx.callee), ctx.arguments.expression_single().map { visit(it) })
//    }
//
//    override fun visitBraceExpression(ctx: BraceExpressionContext?): ProgramASTNode {
//        return visitChildren(ctx)
//    }
//
//    override fun visitMemberExpression_index2(ctx: MemberExpression_index2Context?): ProgramASTNode {
//        return visitChildren(ctx)
//    }
//
//    override fun visitMemberExpression_dot2(ctx: MemberExpression_dot2Context?): ProgramASTNode {
//        return visitChildren(ctx)
//    }
//
//    override fun visitAssignmentOperator_(ctx: AssignmentOperator_Context?): ProgramASTNode {
//        return visitChildren(ctx)
//    }
//
//    override fun visitEos__(ctx: Eos__Context?): ProgramASTNode {
//        return visitChildren(ctx)
//    }
//
//
//    override fun visitExpression_propName(ctx: Expression_propNameContext?): ProgramASTNode {
//        return visitChildren(ctx)
//    }
//
//
//    override fun visitIdentifier_ex(ctx: Identifier_exContext?): ProgramASTNode {
//        return visitChildren(ctx)
//    }
//
//
//    override fun visitIdentifier(ctx: IdentifierContext?): ProgramASTNode {
//        return visitChildren(ctx)
//    }
//
//    override fun visitIdentifierOrKeyword_(ctx: IdentifierOrKeyword_Context?): ProgramASTNode {
//        return visitChildren(ctx)
//    }
//
//
//    override fun visitReservedWord_(ctx: ReservedWord_Context?): ProgramASTNode {
//        return visitChildren(ctx)
//    }
//
//    override fun visitKeyword_(ctx: Keyword_Context?): ProgramASTNode {
//        return visitChildren(ctx)
//    }
//
//
//    override fun visitLiteral(ctx: LiteralContext?): ProgramASTNode {
//        return visitChildren(ctx)
//    }
//
//
//    override fun visitLiteral_numeric(ctx: Literal_numericContext?): ProgramASTNode {
//        return visitChildren(ctx)
//    }
//
//
//    override fun visitLiteral_string(ctx: Literal_stringContext?): ProgramASTNode {
//        return visitChildren(ctx)
//    }
//}