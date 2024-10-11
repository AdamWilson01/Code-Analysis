import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("C:\\Users\\awils\\Documents\\Personal Projects\\Recipe\\Recipe\\src\\Recipe.java"); // TODO: add java file path.
            CompilationUnit cu;
            try {
                cu = StaticJavaParser.parse(in); // build ast for java file
                cu.accept(new VariableDeclarationVisitor(), null);
            } finally{
                in.close();
            }
        } catch (IOException e) {
            System.err.println("File Not Found");
        }
    }
}
