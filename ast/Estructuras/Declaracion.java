package ast.Estructuras;

import ast.Expresions.E;
import ast.Instructions.Instruccion;
import ast.Instructions.KindInstruction;
import ast.Types.ArrayType;
import ast.Types.KindTypes;
import ast.Types.Types;
import ast.ASTNode;
import ast.Programa;

public class Declaracion extends Instruccion {
    
    protected String name;
    protected KindTypes tipo = null;
    private E exp = null;
    protected Types tipoCompuesto = null;

   


    public Declaracion(Types tipo, String name){
        this.tipoCompuesto = tipo;
        this.name = name;
        this.tipo = tipo.kind();
    }
   

    public Declaracion(Types tipo, String name, E valor){
        this.tipoCompuesto = tipo;
        this.name = name;
        this.exp = valor;
        this.tipo = tipo.kind();

    }

    public KindTypes getTipo() {
        return this.tipo;
    }
    public String getName() {
        return this.name;
    }


    public void vincular() {
        // Tenemos un buscaId particular para este caso
        // Va a permitir de declarar con un mismo identificador siempre y cuado no se
        // haya declarado uno con el
        // mismo name en ese bloque
        ASTNode nodo = Programa.pila.buscaIdCima(name);
        if (nodo == null) { // devuelve null cuando no esta
            // System.out.println("Vinculando " + name);
            Programa.pila.insertaId(name, this);
            if (exp != null)
                exp.vincular();
        } 
        else {
            System.out.println("Error vinculacion: Este identificador ya esta usado: " + name);
            Programa.okVinculacion = false;
        }
    }

    public String toString(){
        String out;
        if (exp != null){
            out = tipo.toString() + " " + name + " = " + exp.toString();
        } else {
            out = tipo.toString() + " " + name;
        }
        return out;
    }


    public void checkType() {
        // El tipo de la parte izquierda es this.tipo
        //tipo.chequea();

        if (exp != null) {
            exp.checkType();
            

            if(tipo.toString().equals("ARRAY")){ //tipo ARRAY
                if (!((ArrayType)tipoCompuesto).tipo.equals(exp.tipo)){
                    System.out.println("Tipo del Array: " + ((ArrayType)tipoCompuesto).tipo.toString());
                    System.out.println("Tipo de la expresion: " + exp.tipo);
                }
                else System.out.println("tipo OK");
            }
            else if (!this.tipo.equals(exp.tipo)) { //tipos básicos
                System.out.println("Error tipo: Declaracion " + tipo + " " + name + "=" + exp + "(" + this.tipo + ","+ exp.tipo + ")");
                Programa.okTipos = false;
            }
            else System.out.println("tipo OK");

        }
       
    }

    @Override
    public KindInstruction kind() {
        return KindInstruction.DECLARACION;
    }

}
