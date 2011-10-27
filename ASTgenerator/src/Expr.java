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
    FunId _id;
    CallActuals _call;
    CallExpr(Location loc, FunId id, CallActuals call) {
        super(loc); _id = id; _call = call;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class CallActuals extends Expr {
    FunId _id;
    CallActuals _CallActuals;
    CallActuals(Location loc, FunId id, CallActuals CallActuals) {
        super(loc); _id = id; _CallActuals = CallActuals;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FunId extends Expr {
    String _id;
    FunId(Location loc, String id) { super(loc); _id = id; }
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
