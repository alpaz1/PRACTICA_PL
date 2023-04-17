package ast;

public abstract class ASTNode {

    public NodeKind tipo;  // tipo de su nodo
    public ASTNode nodoVinculo; // nodo con el que se vinculan
    
    public ASTNode(){}

    public abstract void vincular();
    //public abstract NodeKind nodeKind();
    //public abstract String toString();
}
