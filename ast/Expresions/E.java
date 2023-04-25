package ast.Expresions;

import ast.ASTNode;
import ast.NodeKind;
import ast.Types.BasicTypes;
import ast.Types.KindTypes;
import ast.Types.Types;

public abstract class E extends ASTNode {
    public abstract KindE kindExp();
    public  Types getTipo(){
        return this.tipo;
    }

    public abstract void checkType();
    // public E opnd1() {throw new UnsupportedOperationException("opnd1");} 
    // public E opnd2() {throw new UnsupportedOperationException("opnd2");} 
    public String num() {throw new UnsupportedOperationException("num");}
    public NodeKind nodeKind() {return NodeKind.EXPRESSION;}
    public String toString() {return "";}

}
