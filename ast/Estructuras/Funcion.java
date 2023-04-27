package ast.Estructuras;

import java.util.Collections;
import java.util.List;

import ast.ASTNode;
import ast.NodeKind;
import ast.Programa;
import ast.Util;
import ast.Auxiliares.Parametro;
import ast.Estructuras.clases.Atributo;
import ast.Instructions.Instruccion;
import ast.Types.Types;

public class Funcion extends ASTNode{
    private static final NodeKind TIPO_NODO = NodeKind.FUNCION;
    private String nombre;
    private List<Instruccion> instList;
    private List<Parametro> paramList;

    public Funcion(Types tipo, String name, List<Parametro> paramList, List<Instruccion> instList){
        this.nombre = name;
        this.tipo = tipo;
        this.instList = instList;
        this.paramList = paramList;
        this.tipoNodo = TIPO_NODO;
        Collections.reverse(this.instList);
        Collections.reverse(this.paramList);
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
            }

            Programa.pila.cierraBloque();
        } else {
            System.err.println("Error vinculacion: Este identificador ya esta usado: " + nombre);
            Programa.okVinculacion = false;
        }

    }

    public void vincular(List<Atributo> atributos) {
        ASTNode nodo = Programa.pila.buscaId(nombre);
        if (nodo == null) {
            Programa.pila.insertaId(nombre, this);
            Programa.pila.abreBloque();

            for (Parametro param : paramList) {
                param.vincular();
            }

            for(Atributo a: atributos){  // TODO: no debería hacer falta?
                a.vincular();
            }

            for (Instruccion instruccion : instList) {
                instruccion.vincular();
            }

            Programa.pila.cierraBloque();
        } else {
            System.err.println("Error vinculacion: Este identificador ya esta usado: " + nombre);
            Programa.okVinculacion = false;
        }

    }

    public void checkType() {
        //this.tipo.chequea();

        for (Parametro p : paramList) {
            p.checkType();
        }

        for (Instruccion ins : instList) {
            ins.checkType();
        }
    }

    public String toString(){
        return tipo.toString() + " " + nombre + "(" + Util.prettify(paramList) + ")" + "{" + Util.prettify(instList) + "}";
    }

    public Types getTipo(){
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
