package ast;

public abstract class Types extends ASTNode {
    public abstract KindTypes kind();
    public NodeKind nodeKind() {return NodeKind.TYPE;}
    public String toString() {return "";}
}
