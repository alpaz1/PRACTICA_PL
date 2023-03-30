package ast.Estructuras;
import ast.Types.KindTypes;

public class Funcion {
    private String name;
    private KindTypes tipo;

    public Funcion(String name, KindTypes tipo){
        this.name = name;
        this.tipo = tipo;
    }

    public String toString(){
        return "(" + tipo.toString() + " " + name + ")";
    }
}
