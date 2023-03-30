package ast.Estructuras;

import ast.Expresions.E;
import ast.Instructions.Asignacion;
import ast.Types.KindTypes;

public class Definition {
    
    private String name;
    private KindTypes tipo;
    private Object valor = null;

    public Definition(KindTypes tipo, String name){
        this.tipo = tipo;
        this.name = name;
    }

    public Definition(KindTypes tipo, String name, Object valor){
        this.tipo = tipo;
        this.name = name;
        System.out.println("Valor: " + valor.toString());
        this.valor = valor;
    }

    public String toString(){
        String out;
        // System.out.println("Valor: " + valor.toString());
        if (valor != null){
            out = tipo.toString() + " " + name + " = " + valor.toString();
        } else {
            out = "(" + tipo.toString() + " " + name + ")";
        }
        return out;
    }

}
