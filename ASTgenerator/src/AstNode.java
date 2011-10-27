import java.util.List;
import xtc.tree.Location;

abstract class AstNode {
    Location _loc;

    AstNode(Location loc) {
        _loc = loc;
    }

    abstract Object accept(Visitor visitor);
}

class Program extends AstNode {
    FunDefList _raw;
    List<FunDef> _functions;

    Program(Location loc, FunDefList raw) {
        super(loc);
        _raw = raw;
        _functions = null;
    }

    Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

class FunDef extends AstNode {
    FunId _name;
    FunType _type;
    BlockStmt _block;

    FunDef(Location loc, FunId name, FunType type, BlockStmt block) {
        super(loc);
        _name = name;
        _type = type;
        _block = block;
    }

    Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

class FunDefList extends AstNode {
    FunDef _first;
    FunDefListTail _tail;

    FunDefList(Location loc) {
        super(loc);
        _first = null;
        _tail = null;
    }

    FunDefList(Location loc, FunDef first, FunDefListTail tail) {
        super(loc);
        _first = first;
        _tail = tail;
    }

    Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

class FunDefListTail extends AstNode {
    List<FunDef> _inh;
    FunDef _next;
    FunDefListTail _tail;

    FunDefListTail(Location loc) {
        super(loc);
        _next = null;
        _tail = null;
    }

    FunDefListTail(Location loc, FunDef next, FunDefListTail tail) {
        super(loc);
        _next = next;
        _tail = tail;
    }

    Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

class FieldId extends AstNode {
    String _id;

    FieldId(Location loc, String id) {
        super(loc);
        _id = id;
    }

    Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
