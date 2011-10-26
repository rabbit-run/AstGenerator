import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import xtc.tree.Location;

class Main {
  public static void main(final String[] args) throws IOException {
    String fileName = args[0];
    final Reader reader = new FileReader(fileName);
    final TackParser parser = new TackParser(reader, fileName);
    final xtc.parser.Result result = parser.pprogram(0);
    if (!result.hasValue()) {
      Location loc = parser.location(result.index);
      System.err.println(loc.toString() + ": Syntax error.");
      System.exit(-1);
    }
    final AstNode rawAst = (AstNode)result.semanticValue();
    final PrintWriter writer = new PrintWriter(System.out, true);
    final SyntaxTreePrinter syntaxTreePrinter = new SyntaxTreePrinter(writer);
    System.out.println("--- Raw AST ----");
    rawAst.accept(syntaxTreePrinter);
    final TreeNormalizer normalizer = new TreeNormalizer();
    final AstNode ast = (AstNode)rawAst.accept(normalizer);
    System.out.println("--- Normalized AST ----");
    ast.accept(syntaxTreePrinter);
  }
}
