package ast;

import ast.Types.KindTypes;

public abstract class ASTNode {

    public NodeKind tipoNodo;  // tipo de su nodo
    public ASTNode nodoVinculo; // nodo con el que se vinculan
    public KindTypes tipo; //tipo int, bool...
    public ASTNode(){}
    public abstract void vincular();
    //public abstract NodeKind nodeKind();
    //public abstract String toString();
}
