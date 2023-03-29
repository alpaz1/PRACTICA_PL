package ast.Estructuras;

import ast.Types.KindTypes;

public class BasicStructure {
    
    private String name;
    private KindTypes tipo;

    public BasicStructure(String name, KindTypes tipo){
        this.name = name;
        this.tipo = tipo;
    }

    public String toString(){
        return "(" + name + tipo.toString() + ")";
    }

}
