abstract class Visitor {
  Object defaultVisit(AstNode ast) {
    assert false : "not implemented";
    return null;
  }
  Object visit(Program ast) { return defaultVisit(ast); }
  Object visit(FunDef ast) { return defaultVisit(ast); }
  Object visit(FunDefList ast) { return defaultVisit(ast); }
  Object visit(FunDefListTail ast) { return defaultVisit(ast); }
  
  Object visit(Type type) { return defaultVisit(type); }
  Object visit(ArrayType type) { return defaultVisit(type); }
  Object visit(RecordType type) { return defaultVisit(type); }
  Object visit(FieldTypeList type) { return defaultVisit(type); }
  Object visit(FieldTypeListTail type) { return defaultVisit(type); }
  Object visit(FieldType type) { return defaultVisit(type); }
//  Object visit(BoolType ast) { return defaultVisit(ast); }
//  Object visit(IntType ast) { return defaultVisit(ast); }
//  Object visit(StringType ast) { return defaultVisit(ast); }
  Object visit(FunType ast) { return defaultVisit(ast); }
//  Object visit(ReturnType ast) { return defaultVisit(ast); }
//  Object visit(VoidType ast) { return defaultVisit(ast); }
  
  Object visit(Stmt ast) { return defaultVisit(ast); }
  Object visit(VarDef ast) { return defaultVisit(ast); }
//  Object visit(AssignStmt ast) { return defaultVisit(ast); }
  Object visit(BlockStmt ast) { return defaultVisit(ast); }
  Object visit(CallStmt ast) { return defaultVisit(ast); }
//  Object visit(ForStmt ast) { return defaultVisit(ast); }
//  Object visit(IfStmt ast) { return defaultVisit(ast); }
  Object visit(ReturnStmt ast) { return defaultVisit(ast); }
//  Object visit(WhileStmt ast) { return defaultVisit(ast); }
//  
  Object visit(StmtList ast) { return defaultVisit(ast); }
  Object visit(StmtListTail ast) { return defaultVisit(ast); }
//  
//  
  Object visit(Expr ast) { return defaultVisit(ast); }
  Object visit(LogicOrExpr ast) { return defaultVisit(ast); }
  Object visit(LogicOrExprTail ast) { return defaultVisit(ast); }
  Object visit(LogicAndExpr ast) { return defaultVisit(ast); }
  Object visit(LogicAndExprTail ast) { return defaultVisit(ast); }
  Object visit(RelExpr ast) { return defaultVisit(ast); }
  Object visit(EqExprTail ast) { return defaultVisit(ast); }
  Object visit(RelExprTail ast) { return defaultVisit(ast); }
  Object visit(AddExpr ast) { return defaultVisit(ast); }
  Object visit(AddExprTail ast) { return defaultVisit(ast); }
  Object visit(MultExpr ast) { return defaultVisit(ast); }
  Object visit(MultExprTail ast) { return defaultVisit(ast); }
  Object visit(PrefixExpr ast) { return defaultVisit(ast); }
//  Object visit(PostfixExpr ast) { return defaultVisit(ast); }
//  Object visit(PostfixExprTail ast) { return defaultVisit(ast); }
//  Object visit(EmptyPostfixTail ast) { return defaultVisit(ast); }
  Object visit(CallExpr ast) { return defaultVisit(ast); }
  Object visit(CallActuals ast) { return defaultVisit(ast); }
//  Object visit(CallExprTail ast) { return defaultVisit(ast); }
//  Object visit(CastExprTail ast) { return defaultVisit(ast); }
//  Object visit(FieldExprTail ast) { return defaultVisit(ast); }
//  Object visit(SubScriptExprTail ast) { return defaultVisit(ast); }
  Object visit(ExprList ast) { return defaultVisit(ast); }
  Object visit(ExprListTail ast) { return defaultVisit(ast); }
//  Object visit(PrimExpr ast) { return defaultVisit(ast); }
//  Object visit(ParenExpr ast) { return defaultVisit(ast); }
//  
//  Object visit(ArrayLit ast) { return defaultVisit(ast); }
//  Object visit(RecordLit ast) { return defaultVisit(ast); }
//  Object visit(FieldLitList ast) { return defaultVisit(ast); }
//  Object visit(FieldLitListTail ast) { return defaultVisit(ast); }
//  Object visit(FieldLit ast) { return defaultVisit(ast); }
  Object visit(BoolLit ast) { return defaultVisit(ast); }
  Object visit(IntLit ast) { return defaultVisit(ast); }
//  Object visit(NullLit ast) { return defaultVisit(ast); }
  Object visit(StringLit ast) { return defaultVisit(ast); }
  Object visit(FieldId ast) { return defaultVisit(ast); }
  Object visit(FunId ast) { return defaultVisit(ast); }
  Object visit(VarId ast) { return defaultVisit(ast); }
  Object visit(PrimitiveType type) { return defaultVisit(type); }
  Object visit(InfixExpr ast) { return defaultVisit(ast); }
}
