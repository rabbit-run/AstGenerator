import java.util.List;

import xtc.tree.Location;

/**
 * 
 */

/**
 * @version    
 * @author     Zehua Mai
 *
 */
abstract class Expr extends AstNode{
    Expr(Location loc) { super(loc); }
    abstract Object accept(Visitor visitor);
}

class CallExpr extends Expr {
    List<Expr> _exprs;
    FunId _id;
    CallActuals _call;
    CallExpr(Location loc, FunId id, CallActuals call) {
        super(loc); _id = id; _call = call; _exprs = null;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class CallActuals extends Expr {
    List<Expr> _exprs;
    ExprList _raw;
    CallActuals(Location loc, ExprList exprList) {
        super(loc); exprList = _raw;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FunId extends Expr {
    String _id;
    FunId(Location loc, String id) { super(loc); _id = id; }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class StringLit extends Expr {
    String _value;
    StringLit(Location loc, String value) { super(loc); _value = value; }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class IntLit extends Expr {
    String _value;
    IntLit(Location loc, String value) { super(loc); _value = value; }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class BoolLit extends Expr {
    String _value;
    BoolLit(Location loc, String value) { super(loc); _value = value; }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class ExprList extends AstNode {
    Expr _first;
    ExprListTail _tail;
    ExprList(Location loc) { super(loc); _first = null; _tail = null; }
    ExprList(Location loc, Expr first, ExprListTail tail) {
      super(loc); _first = first; _tail = tail;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class ExprListTail extends AstNode {
    List<Expr> _inh;
    Expr _next;
    ExprListTail _tail;
    ExprListTail(Location loc) { super(loc); _next = null; _tail = null; }
    ExprListTail(Location loc,Expr next,ExprListTail tail) {
      super(loc); _next = next; _tail = tail;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}
