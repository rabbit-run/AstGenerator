import java.io.PrintWriter;
import java.util.Stack;

class SyntaxTreePrinter extends Visitor {
  PrintWriter _writer;
  Stack<AstNode> _stack;

  SyntaxTreePrinter(PrintWriter writer) {
    _writer = writer;
    _stack = new Stack<AstNode>();
  }

  // ---------------- helper methods ----------------
  SyntaxTreePrinter begin(AstNode ast) {
    return begin(ast, null);
  }
  SyntaxTreePrinter begin(AstNode ast, String attr) {
    for (int i=0, n=_stack.size(); i<n; i++)
      p("  ");
    _stack.push(ast);
    p(ast.getClass().getSimpleName());
    if (null != attr)
      p(" ").p(attr);
    return pln();
  }
  SyntaxTreePrinter end(AstNode ast) {
    AstNode top = _stack.pop();
    assert top == ast;
    return this;
  }

  SyntaxTreePrinter p(AstNode ast) {
    ast.accept(this);
    return this;
  }
  SyntaxTreePrinter p(String s) {
    assert(-1 == s.indexOf('\n'));
    _writer.print(s);
    return this;
  }
  SyntaxTreePrinter pln() {
    _writer.println();
    return this;
  }

  // ---------------- visit methods ----------------
  Object visit(Program ast) {
    begin(ast);
    if (null != ast._raw)
      p(ast._raw);
    else
      for (FunDef f : ast._functions)
        p(f);
    return end(ast);
  }

  Object visit(FunDef ast) {
    return begin(ast).p(ast._name).end(ast);
  }

  Object visit(FunDefList ast) {
    begin(ast);
    if (null != ast._first)
      p(ast._first).p(ast._tail);
    return end(ast);
  }
  Object visit(FunDefListTail ast) {
    begin(ast);
    if (null != ast._next)
      p(ast._next).p(ast._tail);
    return end(ast);
  }

  Object visit(FunId ast) {
    return begin(ast, ast._id).end(ast);
  }
}
