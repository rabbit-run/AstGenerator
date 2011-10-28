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
}

class LogicOrExpr extends Expr {
    InfixExpr _infix;
    LogicAndExpr _andExpr;
    LogicOrExprTail _tail;
    LogicOrExpr(Location loc, LogicAndExpr andExpr, LogicOrExprTail tail) {
        super(loc);
        _andExpr = andExpr;
        _tail = tail;
        _infix = null;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class LogicOrExprTail extends Expr {
    String _op;
    Expr _head;
    Expr _andExpr;
    LogicOrExprTail _tail;
    LogicOrExprTail(Location loc, String op, LogicAndExpr andExpr, LogicOrExprTail tail) {
        super(loc);
        _op = op;
        _andExpr = andExpr;
        _tail = tail;
    }
    LogicOrExprTail(Location loc) {
        super(loc);
        _andExpr = null;
        _tail = null;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class LogicAndExpr extends Expr {
    InfixExpr _infix;
    EqExpr _eqExpr;
    LogicAndExprTail _tail;
    LogicAndExpr(Location loc, EqExpr eqExpr, LogicAndExprTail tail) {
        super(loc);
        _eqExpr = eqExpr;
        _tail = tail;
        _infix = null;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class LogicAndExprTail extends Expr {
    String _op;
    Expr _head;
    Expr _eqExpr;
    LogicAndExprTail _tail;
    LogicAndExprTail(Location loc, String op, EqExpr eqExpr, LogicAndExprTail tail) {
        super(loc);
        _op = op;
        _eqExpr = eqExpr;
        _tail = tail;
    }
    LogicAndExprTail(Location loc) {
        super(loc);
        _eqExpr = null;
        _tail = null;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class EqExpr extends Expr {
    RelExpr _relExpr;
    EqExprTail _tail;
    EqExpr(Location loc, RelExpr relExpr, EqExprTail tail) {
        super(loc);
        _relExpr = relExpr;
        _tail = tail;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class EqExprTail extends Expr {
    String _op;
    Expr _head;
    Expr _relExpr;
    EqExprTail _tail;
    EqExprTail(Location loc,String op,  RelExpr relExpr, EqExprTail tail) {
        super(loc);
        _op = op;
        _relExpr = relExpr;
        _tail = tail;
    }
    EqExprTail(Location loc) {
        super(loc);
        _relExpr = null;
        _tail = null;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class RelExpr extends Expr {
    AddExpr _addExpr;
    RelExprTail _tail;
    RelExpr(Location loc, AddExpr addExpr, RelExprTail tail) {
        super(loc);
        _addExpr = addExpr;
        _tail = tail;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class RelExprTail extends Expr {
    String _op;
    Expr _head;
    Expr _addExpr;
    RelExprTail _tail;
    RelExprTail(Location loc, String op, AddExpr addExpr, RelExprTail tail) {
        super(loc);
        _op = op;
        _addExpr = addExpr;
        _tail = tail;
    }
    RelExprTail(Location loc) {
        super(loc);
        _addExpr = null;
        _tail = null;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class AddExpr extends Expr {
    MultExpr _multExpr;
    AddExprTail _tail;
    AddExpr(Location loc, MultExpr multExpr, AddExprTail tail) {
        super(loc);
        _multExpr = multExpr;
        _tail = tail;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class AddExprTail extends Expr {
    Expr _head;
    Expr _multExpr;
    AddExprTail _tail;
    String _op;
    AddExprTail(Location loc, String op, MultExpr multExpr, AddExprTail tail) {
        super(loc);
        _multExpr = multExpr;
        _tail = tail;
        _op = op;
    }
    AddExprTail(Location loc) {
        super(loc);
        _multExpr = null;
        _tail = null;
        _op = null;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class MultExpr extends Expr {
    PrimExpr _prefixExpr;
    MultExprTail _tail;
    MultExpr(Location loc, PrimExpr prefixExpr, MultExprTail tail) {
        super(loc);
        _prefixExpr = prefixExpr;
        _tail = tail;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class MultExprTail extends Expr {
    //test change PrimExpr to PrefixExpr afterwards
    PrimExpr _prefixExpr;
    Expr _head;
    MultExprTail _tail;
    String _op;
    MultExprTail(Location loc, String op, PrimExpr prefixExpr, MultExprTail tail) {
        super(loc);
        _prefixExpr = prefixExpr;
        _tail = tail;
        _op = op;
    }
    MultExprTail(Location loc) {
        super(loc);
        _prefixExpr = null;
        _tail = null;
        _op = null;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class PrefixExpr extends Expr {
    String _op;
    PrefixExpr _expr;
    
    PrefixExpr(Location loc, String op, PrefixExpr expr){
        super(loc);
        _op = op;
        _expr = expr;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class PostfixExpr extends Expr {
    PrimExpr _prim;
    PostfixExprTail _tail;
    
    PostfixExpr(Location loc, PrimExpr prim, PostfixExprTail tail) {
        super(loc);
        _prim = prim;
        _tail = tail;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

abstract class PostfixExprTail extends Expr {
    PostfixExprTail(Location loc) { super(loc); }
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
        super(loc); _raw = exprList;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}


class InfixExpr extends Expr {
    String _op;
    Expr _lhs;
    Expr _rhs;
    
    InfixExpr(Location loc, String op, Expr lhs, Expr rhs) {
        super(loc);
        _op = op;
        _lhs = lhs;
        _rhs = rhs;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

abstract class PrimExpr extends Expr{
    PrimExpr(Location loc) { super(loc); }
}

class VarId extends PrimExpr {
    String _name;
    VarId(Location loc, String name) { super(loc); _name = name; }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FunId extends Expr {
    String _id;
    FunId(Location loc, String id) { super(loc); _id = id; }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class ParenExpr extends PrimExpr {
    Expr _expr;
    ParenExpr (Location loc, Expr expr){
        super(loc);
        _expr = expr;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class ArrayLit extends PrimExpr {
    List<Expr> _exprs;
    ExprList _raw;
    ArrayLit (Location loc, ExprList exprs){
        super(loc);
        _raw = exprs;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class RecordLit extends PrimExpr {
    List<FieldLit> _fields;
    FieldLitList _raw;
    RecordLit (Location loc, FieldLitList fields){
        super(loc);
        _raw = fields;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FieldLitList extends Expr {
    FieldLit _first;
    FieldLitListTail _tail;
    
    FieldLitList(Location loc) {
        super(loc);
        _first = null;
        _tail = null;
    }
    FieldLitList(Location loc, FieldLit first, FieldLitListTail tail) {
        super(loc);
        _first = first;
        _tail = tail;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FieldLitListTail extends Expr {
    List<FieldLit> _inh;
    FieldLit _next;
    FieldLitListTail _tail;
    
    FieldLitListTail(Location loc) {
        super(loc);
        _next = null;
        _tail = null;
    }
    FieldLitListTail(Location loc, FieldLit next, FieldLitListTail tail) {
        super(loc);
        _next = next;
        _tail = tail;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class StringLit extends PrimExpr {
    String _value;
    StringLit(Location loc, String value) { super(loc); _value = value; }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class IntLit extends PrimExpr {
    String _value;
    IntLit(Location loc, String value) { super(loc); _value = value; }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class BoolLit extends PrimExpr {
    String _value;
    BoolLit(Location loc, String value) { super(loc); _value = value; }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class NullLit extends PrimExpr {
    String _value;
    NullLit(Location loc, String value) { super(loc); _value = value; }
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
