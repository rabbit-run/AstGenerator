import java.util.*;

//see aho_et_al_2007 Figure 5.13 (Page 321)
class TreeNormalizer extends Visitor {
//---------------------------Program-------------------------------
    Object visit(Program ast) {
        @SuppressWarnings("unchecked")
        List<FunDef> functions = (List<FunDef>) ast._raw.accept(this);
        ast._functions = functions;
        ast._raw = null;
        return ast;
    }

    Object visit(FunDef ast) {
        ast._name = (FunId) ast._name.accept(this);
        ast._type = (FunType)ast._type.accept(this);
        ast._block = (BlockStmt)ast._block.accept(this);
        return ast;
    }

    Object visit(FunDefList ast) {
        List<FunDef> result = new ArrayList<FunDef>();
        if (null == ast._first)
            return result;
        result.add((FunDef) ast._first.accept(this));
        ast._tail._inh = result;
        return ast._tail.accept(this);
    }

    Object visit(FunDefListTail ast) {
        if (null == ast._next)
            return ast._inh;
        ast._inh.add((FunDef) ast._next.accept(this));
        ast._tail._inh = ast._inh;
        return ast._tail.accept(this);
    }

    Object visit(FunId ast) {
        return ast;
    }
    
//-----------------------------Record Type------------------------
    Object visit(FunType ast) {
        ast._args = (RecordType)ast._args.accept(this);
        return ast;
    }
    
    Object visit(RecordType ast) {
        @SuppressWarnings("unchecked")
        List<FieldType> fieldTypes = (List<FieldType>) ast._raw.accept(this);
        ast._fieldTypes = fieldTypes;
        ast._raw = null;
        return ast;
    }

    Object visit(FieldType ast) {
        ast._name = (FieldId) ast._name.accept(this);
        return ast;
    }

    Object visit(FieldTypeList ast) {
        List<FieldType> result = new ArrayList<FieldType>();
        if (null == ast._first)
            return result;
        result.add((FieldType) ast._first.accept(this));
        ast._tail._inh = result;
        return ast._tail.accept(this);
    }

    Object visit(FieldTypeListTail ast) {
        if (null == ast._next)
            return ast._inh;
        ast._inh.add((FieldType) ast._next.accept(this));
        ast._tail._inh = ast._inh;
        return ast._tail.accept(this);
    }

    Object visit(FieldId ast) {
        return ast;
    }
    
    
  //-----------------------------Stmt------------------------
    Object visit(BlockStmt ast) {
        @SuppressWarnings("unchecked")
        List<Stmt> Stmts = (List<Stmt>) ast._raw.accept(this);
        ast._stmts = Stmts;
        ast._raw = null;
        return ast;
    }

    Object visit(Stmt ast) {
        return ast.accept(this);
    }

    Object visit(StmtList ast) {
        List<Stmt> result = new ArrayList<Stmt>();
        if (null == ast._first)
            return result;
        result.add((Stmt) ast._first.accept(this));
        ast._tail._inh = result;
        return ast._tail.accept(this);
    }

    Object visit(StmtListTail ast) {
        if (null == ast._next)
            return ast._inh;
        ast._inh.add((Stmt) ast._next.accept(this));
        ast._tail._inh = ast._inh;
        return ast._tail.accept(this);
    }
    
    Object visit(CallStmt ast) {
        ast._expr = (CallExpr) ast._expr.accept(this);
        return ast;
    }
    
    Object visit(ReturnStmt ast) {
        ast._expr = (Expr) ast._expr.accept(this);
        return ast;
    }
    
//------------------------Expr---------------------------------
    Object visit(CallExpr ast) {
        ast._id = (FunId) ast._id.accept(this);
        ast._exprs = (List<Expr>)ast._call.accept(this);
        ast._call = null;
        return ast;
    }
    
    Object visit(CallActuals ast) {
        @SuppressWarnings("unchecked")
        List<Expr> exprs = (List<Expr>)ast._raw.accept(this);
        ast._exprs = exprs;
        ast._raw = null;
        return exprs;
    }
    
    Object visit(ExprList ast) {
        List<Expr> result = new ArrayList<Expr>();
        if (null == ast._first)
            return result;
        result.add((Expr) ast._first.accept(this));
        ast._tail._inh = result;
        return ast._tail.accept(this);
    }

    Object visit(ExprListTail ast) {
        if (null == ast._next)
            return ast._inh;
        ast._inh.add((Expr) ast._next.accept(this));
        ast._tail._inh = ast._inh;
        return ast._tail.accept(this);
    }
    
    Object visit(StringLit ast) {
        return ast;
    }
    
    Object visit(IntLit ast) {
        return ast;
    }
    
    Object visit(BoolLit ast) {
        return ast;
    }
}
