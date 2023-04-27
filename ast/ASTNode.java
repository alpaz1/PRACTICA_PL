package ast;

import ast.Types.Types;

public abstract class ASTNode {

    public NodeKind tipoNodo;  // tipo de su nodo
    public ASTNode nodoVinculo; // nodo con el que se vinculan
    public Types tipo; //tipo del nodo
    public ASTNode(){}

    public abstract void vincular();
    public Types getTipo(){return tipo;}
    public void checkType() {}
    //public abstract NodeKind nodeKind();
    //public abstract String toString();
}
