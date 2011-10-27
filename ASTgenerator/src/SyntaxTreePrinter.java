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
        for (int i = 0, n = _stack.size(); i < n; i++)
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
        assert (-1 == s.indexOf('\n'));
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
        begin(ast);
        p(ast._name);
        p(ast._type);
        p(ast._block);
        return end(ast);
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

    Object visit(FieldId ast) {
        return begin(ast, ast._id).end(ast);
    }

    // ------------------Type-------------------------
    Object visit(ArrayType ast) {
        return begin(ast).p(ast._type).end(ast);
    }

    Object visit(FunType ast) {
        begin(ast);
        p(ast._args);
        p(ast._returnType);
        return end(ast);
    }

    Object visit(RecordType ast) {
        begin(ast);
        if (null != ast._raw)
            p(ast._raw);
        else
            for (FieldType f : ast._fieldTypes)
                p(f);
        return end(ast);
    }

    Object visit(FieldTypeList ast) {
        begin(ast);
        if (null != ast._first)
            p(ast._first).p(ast._tail);
        return end(ast);
    }

    Object visit(FieldTypeListTail ast) {
        begin(ast);
        if (null != ast._next)
            p(ast._next).p(ast._tail);
        return end(ast);
    }

    Object visit(PrimitiveType ast) {
        return begin(ast, ast._name).end(ast);
    }

    // -----------------Expr--------------------------

    Object visit(FunId ast) {
        return begin(ast, ast._id).end(ast);
    }

    Object visit(CallExpr ast) {
        begin(ast);
        if (null == ast._exprs) {
            p(ast._id);
            p(ast._call);
        } else {
            p(ast._id);
            for (Expr e : ast._exprs)
                p(e);
        }
        return end(ast);
    }
    
    Object visit(CallActuals ast) {
        begin(ast);
        if (null == ast._exprs) {
            p(ast._raw);
        } else {
            for (Expr e : ast._exprs)
                p(e);
        }
        return end(ast);
    }
    
    Object visit(ExprList ast) {
        begin(ast);
        if (null != ast._first)
            p(ast._first).p(ast._tail);
        return end(ast);
    }

    Object visit(ExprListTail ast) {
        begin(ast);
        if (null != ast._next)
            p(ast._next).p(ast._tail);
        return end(ast);
    }
    
    Object visit(StringLit ast) {
        return begin(ast, ast._value).end(ast);
    }
    
    Object visit(IntLit ast) {
        return begin(ast, ast._value).end(ast);
    }
    
    Object visit(BoolLit ast) {
        return begin(ast, ast._value).end(ast);
    }
    
    //----------------Stmt---------------------------
    Object visit(BlockStmt ast) {
        begin(ast);
        if (null != ast._raw) {
            p(ast._raw);
        } else {
            for (Stmt s : ast._stmts)
                p(s);
        }
        return end(ast);
    }
    
    Object visit(CallStmt ast) {
        begin(ast);
        p(ast._expr);
        return end(ast);
    }
    
    Object visit(ReturnStmt ast) {
        begin(ast);
        if (ast._expr != null)
            p(ast._expr);
        return end(ast);
    }
    
    Object visit(StmtList ast) {
        begin(ast);
        if (null != ast._first)
            p(ast._first).p(ast._tail);
        return end(ast);
    }

    Object visit(StmtListTail ast) {
        begin(ast);
        if (null != ast._next)
            p(ast._next).p(ast._tail);
        return end(ast);
    }
}
