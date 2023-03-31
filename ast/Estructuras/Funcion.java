package ast.Estructuras;

import java.util.List;

import ast.Util;
import ast.Auxiliares.Parametro;
import ast.Instructions.Instruccion;
import ast.Types.KindTypes;

public class Funcion {
    private String nombre;
    private KindTypes tipo;
    private List<Instruccion> instList;
    private List<Parametro> paramList;

    public Funcion(KindTypes tipo, String name, List<Parametro> paramList, List<Instruccion> instList){
        this.nombre = name;
        this.tipo = tipo;
        this.instList = instList;
        this.paramList = paramList;
    }

    public String toString(){
        return tipo.toString() + " " + nombre + "(" + Util.prettify(paramList) + ")" + "{" + Util.prettify(instList) + "}";
    }
}
