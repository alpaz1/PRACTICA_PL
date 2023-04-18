package ast.Instructions;

import ast.ASTNode;
import ast.Programa;
import ast.Types.Types;

public class Alias extends ASTNode{

    private Types tipo;
    private String nombre;

    public Alias(String nombre, Types t){
        this.nombre = nombre;
        this.tipo = t;
    }

    public KindInstruction kind() {
        return KindInstruction.ALIAS;
    }

    public String toString() {
        return "ALIAS: " + nombre + " - " + tipo.toString();
    }

    public void vincular() {
        ASTNode nodo = Programa.pila.buscaIdCima(nombre);
        if (nodo == null) { // devuelve null cuando no esta
            // System.out.println("Vinculando " + name);
            Programa.pila.insertaId(nombre, this);
            // Algo relacionado con expresiones de tipos???
        } else {
            System.out.println("Error vinculacion: Este identificador ya esta usado: " + nombre);
            Programa.okVinculacion = false;
        }
    }
    
}
