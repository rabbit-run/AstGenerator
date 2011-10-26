abstract class Visitor {
  Object defaultVisit(AstNode ast) {
    assert false : "not implemented";
    return null;
  }
  Object visit(Program ast) { return defaultVisit(ast); }
  Object visit(FunDef ast) { return defaultVisit(ast); }
  Object visit(FunDefListHead ast) { return defaultVisit(ast); }
  Object visit(FunDefListTail ast) { return defaultVisit(ast); }
  Object visit(FunId ast) { return defaultVisit(ast); }
}
