package ast.Estructuras;
import java.util.List;

import ast.ASTNode;
import ast.Programa;
import ast.Util;

public class StructClass extends ASTNode{
    private String name;
    private List<Declaracion> campos;

    public StructClass(String name, List<Declaracion> campos){
        this.name = name;
        this.campos = campos;
    }

    public String toString(){ // enum{a,b,c}
        return name + '{' + Util.prettify(campos) + '}';
    }

    @Override
    public void vincular() {
        ASTNode nodo = Programa.pila.buscaId(name);
        if (nodo == null) { //devuelve null cuando no esta
            Programa.pila.insertaId(name, this);
        } else {
            System.out.println("Error vinculacion: Este identificador ya esta usado: " + name);
            Programa.okVinculacion = false;
        }
    }
}
