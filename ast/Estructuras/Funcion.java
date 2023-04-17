package ast.Estructuras;

import java.util.List;

import ast.ASTNode;
import ast.Programa;
import ast.Util;
import ast.Auxiliares.Parametro;
import ast.Instructions.Instruccion;
import ast.Types.KindTypes;

public class Funcion extends ASTNode{
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

    public void vincular() {
        ASTNode nodo = Programa.pila.buscaId(nombre);
        if (nodo == null) {
            Programa.pila.insertaId(nombre, this);
            Programa.pila.abreBloque();

            for (Parametro param : paramList) {
                param.vincular();
            }

            // si es void no hace falta
            for (Instruccion instruccion : instList) {
                instruccion.vincular();
                // Vincular el return
                // if (! (instruccion instanceof AsigClass || instruccion instanceof DecClass || 
                //     instruccion instanceof FuncallClass)){
                //         instruccion.setReturn(this);
                //     }
            }

            Programa.pila.cierraBloque();
        } else {
            System.err.println("Error vinculacion: Este identificador ya esta usado: " + nombre);
            Programa.okVinculacion = false;
        }

    }

    public String toString(){
        return tipo.toString() + " " + nombre + "(" + Util.prettify(paramList) + ")" + "{" + Util.prettify(instList) + "}";
    }

    public KindTypes getTipo(){
        return this.tipo;
    }
    public String getName(){
        return this.nombre;
    }
    public List<Instruccion> getInst(){
        return this.instList;
    }
    public List<Parametro> getParams(){
        return this.paramList;
    }

}
