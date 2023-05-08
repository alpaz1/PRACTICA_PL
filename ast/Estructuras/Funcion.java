package ast.Estructuras;

import java.util.Collections;
import java.util.List;

import ast.ASTNode;
import ast.NodeKind;
import ast.Programa;
import ast.Util;
import ast.Auxiliares.Parametro;
import ast.Estructuras.clases.Atributo;
import ast.Instructions.Alias;
import ast.Instructions.Bloque;
import ast.Instructions.Instruccion;
import ast.Types.Types;

public class Funcion extends ASTNode{
    private static final NodeKind TIPO_NODO = NodeKind.FUNCION;
    private String nombre;
    List<Instruccion> instList;
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

    public int maxMemoria() {
        int max = Bloque.maxMemoria(instList);
        for (Parametro param: paramList){
            max += param.maxMemoria();
        }
        return max;
    }

    @Override
    public void generaCodigo() {
        // int tam = 200; // TODO: cambiar esto a lo que ocupa la funcion
        int tam = maxMemoria();
        Programa.codigo.print("(func $" + nombre);
        // for (Parametro param: paramList){
        //     param.respresentacionWasm();
        // }
        // RETURN TIPE
        if (! tipo.toString().equals("VOID")){
            Programa.codigo.print(" (result " + tipo.respresentacionWasm() +")");
        }
        Programa.codigo.println("");
        Programa.codigo.println(" (local $localsStart i32)");
        Programa.codigo.println(" (local $temp i32)");
        Programa.codigo.println(" i32.const " + tam); //  ;; let this be the stack size needed (params+locals+2)*4");
        Programa.codigo.println(" call $reserveStack"); // ;; returns old MP (dynamic link)");
        
        Programa.codigo.println(" set_local $temp");
        Programa.codigo.println(" get_global $MP");
        Programa.codigo.println(" get_local $temp");
        Programa.codigo.println(" i32.store"); // Guardo el MP antiguo en mp
        Programa.codigo.println(" get_global $MP");
        Programa.codigo.println(" get_global $SP"); 
        Programa.codigo.println(" i32.store offset=4"); // Guardo el SP en mp + 4
        Programa.codigo.println(" get_global $MP");
        Programa.codigo.println(" i32.const 8"); // salto el mp antiguo y el sp
        Programa.codigo.println(" i32.add");
        Programa.codigo.println(" set_local $localsStart"); // La funcion empieza aqui
        // for (Parametro param: paramList){
        //     param.generaCodigo();
        // }
        for (Instruccion instruccion: instList){
            instruccion.generaCodigo(); 
        }
        Programa.codigo.println(" call $freeStack");
        // meto algo en la pila por si no hay un return
        if (! tipo.toString().equals("VOID")){
            Programa.codigo.println("i32.const 0");
            Programa.codigo.println(tipo.respresentacionWasm() + ".load");
        }
        Programa.codigo.println(")");
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

    public void simplifyAlias(List<Alias> lista_alias) {
        for (Alias a: lista_alias){
            if (this.tipo.toString().equals(a.getNombre()))
                this.tipo = a.getTipo();
        }
        for (Parametro param: paramList)
                param.simplifyAlias(lista_alias);    
        for (Instruccion ins: instList)
            ins.simplifyAlias(lista_alias);
    }

}
