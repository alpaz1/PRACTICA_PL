package ast;

public abstract class Instruction extends ASTNode {
    public abstract KindInstruction kind();
    public NodeKind nodeKind() {return NodeKind.INSTRUCTION;}
    public String toString() {return "";}

}
