/**
 * 
 */
import xtc.tree.Location;
import java.util.List;
/**
 * @version    
 * @author     Zehua Mai
 *
 */
abstract class Stmt extends AstNode {
    Stmt(Location loc) {
        super(loc);
    }
    abstract Object accept(Visitor visitor);
}

class BlockStmt extends Stmt {
    List<Stmt> _stmts;
    StmtList _raw;
    BlockStmt(Location loc, StmtList stmt) {
        super(loc); _raw = stmt;
        _stmts = null;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class CallStmt extends Stmt {
    CallExpr _expr;
    CallStmt(Location loc, CallExpr expr) {
        super(loc); _expr = expr;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class ReturnStmt extends Stmt {
    Expr _expr;
    ReturnStmt(Location loc, Expr expr) {
        super(loc); _expr = expr;
    }
    ReturnStmt(Location loc) {
        super(loc); _expr = null;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class StmtList extends Stmt {
    Stmt _first;
    StmtListTail _tail;
    
    StmtList(Location loc, Stmt stmt, StmtListTail tail) {
        super(loc); _first = stmt; _tail = tail;
    }
    StmtList(Location loc) {
        super(loc); _first = null; _tail = null;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class StmtListTail extends Stmt {
    List<Stmt> _inh;
    Stmt _next;
    StmtListTail _tail;
    StmtListTail(Location loc, Stmt next, StmtListTail tail) {
        super(loc);
        _next = next;
        _tail = tail;
    }
    StmtListTail(Location loc) {
        super(loc);
        _next = null;
        _tail = null;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

