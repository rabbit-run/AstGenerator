import java.util.*;

//see aho_et_al_2007 Figure 5.13 (Page 321)
class TreeNormalizer extends Visitor {
  Object visit(Program ast) {
    @SuppressWarnings("unchecked")
      List<FunDef> functions = (List<FunDef>)ast._raw.accept(this);
    ast._functions = functions;
    ast._raw = null;
    return ast;
  }

  Object visit(FunDef ast) {
    ast._name = (FunId)ast._name.accept(this);
    return ast;
  }

  Object visit(FunDefList ast) {
    List<FunDef> result = new ArrayList<FunDef>();
    if (null == ast._first)
      return result;
    result.add((FunDef)ast._first.accept(this));
    ast._tail._inh = result;
    return ast._tail.accept(this);
  }
  Object visit(FunDefListTail ast) {
    if (null == ast._next)
      return ast._inh;
    ast._inh.add((FunDef)ast._next.accept(this));
    ast._tail._inh = ast._inh;
    return ast._tail.accept(this);
  }

  Object visit(FunId ast) {
    return ast;
  }
}
