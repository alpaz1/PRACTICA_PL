package ast;

import ast.Types.Types;

public abstract class ASTNode {

    public NodeKind tipoNodo;  // tipo de su nodo
    public ASTNode nodoVinculo; // nodo con el que se vinculan
    public Types tipo; //tipo del nodo
    public int delta;//posición dentro de su ámbtio de dicho nodo
    public ASTNode(){}

    public abstract void vincular();
    public Types getTipo(){return tipo;}
    public void setTipo(Types tipo){this.tipo = tipo;}
    public void checkType() {}
    public void generaCodigo() {}
    public void setDelta(){
        delta = Programa.pila.getDelta();

        int tam = tipo.getTam();

        System.out.println("Tipo: " + tipo + " tamaño: " + tam);

        Programa.pila.updateDelta(tam);
    }

    public int getDelta() {
        return delta;
    }
    public void calcularDirRelativa(){
        throw new UnsupportedOperationException("Unimplemented method 'calcularDirRelativa'");
    }
    //public abstract NodeKind nodeKind();
    //public abstract String toString();
}
