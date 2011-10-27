/**
 * 
 */
import java.util.List;
import xtc.tree.Location;

/**
 * @version    
 * @author     Zehua Mai
 *
 */
abstract class Type extends AstNode{
    Type(Location loc) { super(loc); }
    abstract Object accept(Visitor visitor);
}

class ArrayType extends Type {
    Type _type;
    ArrayType(Location loc, Type type) {
        super(loc);
        _type = type;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FunType extends Type {
    RecordType _args;
    Type _returnType;
    
    FunType(Location loc, RecordType args, Type type) {
        super(loc);
        _returnType = type;
        _args = args;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class RecordType extends Type {
    List<FieldType> _fieldTypes;
    FieldTypeList _raw;
    RecordType(Location loc, FieldTypeList fieldType) {
        super(loc);
        _raw = fieldType;
        _fieldTypes = null;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FieldTypeList extends Type {
    FieldType _first;
    FieldTypeListTail _tail;
    FieldTypeList(Location loc, FieldType first, FieldTypeListTail tail) {
        super(loc);
        _first = first;
        _tail = tail;
    }
    FieldTypeList(Location loc) {
        super(loc);
        _first = null;
        _tail = null;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FieldTypeListTail extends Type {
    List<FieldType> _inh;
    FieldType _next;
    FieldTypeListTail _tail;
    FieldTypeListTail(Location loc, FieldType next, FieldTypeListTail tail) {
        super(loc);
        _next = next;
        _tail = tail;
    }
    FieldTypeListTail(Location loc) {
        super(loc);
        _next = null;
        _tail = null;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FieldType extends Type {
    FieldId _name;
    Type _type;
    FieldType(Location loc, FieldId name, Type type) {
        super(loc);
        _name = name;
        _type = type;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

//??? why primitive type
class PrimitiveType extends Type {
    String _name;
    PrimitiveType(Location loc, String name) {
        super(loc);
        _name = name;
    }
    Object accept(Visitor visitor) { return visitor.visit(this); }
}

