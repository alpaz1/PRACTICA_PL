package ast.Estructuras;
import java.util.ArrayList;
import java.util.List;

import ast.ASTNode;
import ast.Programa;
import ast.Util;
import ast.Expresions.Const;

public class EnumClass extends ASTNode{
    private String name;
    private List<String> campos;

    public EnumClass(String name, List<String> campos){
        this.name = name;
        this.campos = campos;
        //Programa.tipos_enum.add(this);
    }

    public void vincular() {
        ASTNode nodo = Programa.pila.buscaId(name);
        if (nodo == null) { // devuelve null cuando no esta
            Programa.pila.insertaId(name, this);
            for (String c : campos) {
                //Programa.pila.insertaId(c, c);
            }
        } else {
            System.out.println("Error vinculacion: Este identificador ya esta usado: " + name);
            Programa.okVinculacion = false;
        }
    }

    public String toString(){ // enum{a,b,c}
        return name + '{' + Util.prettify(campos) + '}';
    }
    
}
