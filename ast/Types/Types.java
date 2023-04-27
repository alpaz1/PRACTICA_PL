package ast.Types;

import ast.NodeKind;

public abstract class Types {

    public Types tipo;

    public Types getTipo(){
        return tipo;
    }

    public void setTipo(Types t){
        this.tipo = t;
    }

    public boolean equals(Types tipo2) {
        return tipo.equals(tipo2.tipo);
    }

    public abstract KindTypes kind();
    public NodeKind nodeKind() {return NodeKind.TYPE;}
    public String toString() {return "";}
}
