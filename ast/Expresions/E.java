package ast.Expresions;

import ast.ASTNode;
import ast.NodeKind;
import ast.Types.KindTypes;

public abstract class E extends ASTNode {
    public abstract KindE kindExp();
    public abstract void checkType();
    // public E opnd1() {throw new UnsupportedOperationException("opnd1");} 
    // public E opnd2() {throw new UnsupportedOperationException("opnd2");} 
    public String num() {throw new UnsupportedOperationException("num");}
    public NodeKind nodeKind() {return NodeKind.EXPRESSION;}
    public String toString() {return "";}
    public Object getNombreEnum() {
        return null;
    }
    public boolean isInMemory() {
        // Dice si es una expresion guardada en memoria o si es 3 + 4 por ejemplo
        return false;
    }

    public boolean isBasica() {
        boolean basica = false;
        switch (tipo.kind()){
            case INT:
            case FLOAT:
            case POINTER:
            basica = true;
            default:
        }
        return basica;
    }
    public void calcularDirRelativa(){
        throw new UnsupportedOperationException();
    }
}
