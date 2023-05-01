package ast.Instructions;

import ast.Programa;
import ast.Expresions.E;
import java.util.*;

public class Condicional extends Bloque {

    protected E condicion;
    protected List<Instruccion> instrucciones_else;

    public Condicional(E exp, List<Instruccion> instrucciones_then) {
        super(instrucciones_then);
        this.condicion = exp;
        instrucciones_else = null;
    }

    public Condicional(E exp, List<Instruccion> instrucciones_then, List<Instruccion> instrucciones_else) {
        super(instrucciones_then);
        this.condicion = exp;
        this.instrucciones_else = instrucciones_else;
    }

    public void vincular() {
        condicion.vincular();
        Programa.pila.abreBloque();
        for (Instruccion instruccion : this.instList) {
            instruccion.vincular();
        }
        Programa.pila.cierraBloque();
        if (instrucciones_else != null) {
            Programa.pila.abreBloque();
            for (Instruccion instruccion : instrucciones_else) {
                instruccion.vincular();
            }
            Programa.pila.cierraBloque();
        }
    }

    public void checkType() {
        condicion.checkType();
        if (condicion.tipo == null || !condicion.tipo.toString().equals("BOOL")) { // La condicion tiene que ser bool
            System.out.println("Error tipo: condicion if " + condicion + "(" + condicion.tipo + ")");
            Programa.okTipos = false;
        }
        for (Instruccion instruccion : instList) {
            instruccion.checkType();
        }
        if (instrucciones_else != null) {
            for (Instruccion instruccion : instrucciones_else) {
                instruccion.checkType();
            }
        }
    }

    @Override
    public int maxMemoria(List<? extends Instruccion> instList) {
        int si = super.maxMemoria(instList);
        int sino = super.maxMemoria(instrucciones_else);
        return Integer.max(si, sino);
    }

    @Override
    public void generaCodigo() {
        condicion.generaCodigo();
        Programa.codigo.println("if");
        for (Instruccion instruccion: instList){
            instruccion.generaCodigo();
        }
        if (instrucciones_else != null){
            Programa.codigo.println("else");
            for (Instruccion instruccion: instrucciones_else){
                instruccion.generaCodigo();
            }
        }
        Programa.codigo.println("end");
    }

    public String toString() {
        if (this.instrucciones_else == null)
            return "If (Condición:" + this.condicion.toString() + ", Instrucciones:\n" + this.instList.toString() + ")";
        else
            return "If (Condición:" + this.condicion.toString() + ", Instrucciones:\n" + this.instList.toString()
            + "Else:\n" + this.instrucciones_else.toString() + ")";
    }

    public KindInstruction kind() {
        return KindInstruction.IFELSE;
    }

}
