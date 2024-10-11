import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class VariableDeclarationVisitor extends VoidVisitorAdapter<Void> {

    private String prevVar;
    private int prevVarLine;

    private void printCodeAndPos(VariableDeclarator n){
        n.getBegin().ifPresent(pos -> {
            System.out.println("Line: " + pos.line);
        });
        System.out.println("Offending code: " + n.toString());
    }




    @Override
    public void visit(VariableDeclarator n, Void args){
        super.visit(n, args);
        String name = n.getNameAsString();
        final int[] line = new int[1];
        Optional<Expression> init = n.getInitializer();
        if (init.isPresent()){
            if (init.get() instanceof AssignExpr){
                System.out.println("Bad Practice Found: Keep Assignments Simple");
                printCodeAndPos(n);
            } else {
                System.out.println("Bad Practice found: Initialise local variables on declaration");
               printCodeAndPos(n);
            }
        }


        n.getBegin().ifPresent(pos -> {
            line[0] =  pos.line;
        });
        // System.out.println("Name: " + name + ", Prev Name: " + this.prevVar);
        if (line[0] == this.prevVarLine){
            System.out.println("Bad Practice found: One variable per declaration");
            System.out.println("Line: " + line[0]);
            System.out.println("Offending code: " + n.getType().toString() + " " + this.prevVar +","+ n.toString());
        }
        this.prevVar = name;
        this.prevVarLine = line[0];
    }



}


