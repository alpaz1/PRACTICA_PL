package ast.Instructions;

import ast.Expresions.E;
import java.util.*;

public class IfElse extends Bloque {

    protected E condicion;
    protected List<Instruccion> instrucciones_then;
    protected List<Instruccion> instrucciones_else;

    public IfElse(E exp, List<Instruccion> instrucciones_then) {
        this.condicion = exp;
        this.instrucciones_then = instrucciones_then;
    }

    public IfElse(E exp, List<Instruccion> instrucciones_then, List<Instruccion> instrucciones_else) {
        this.condicion = exp;
        this.instrucciones_then = instrucciones_then;
        this.instrucciones_else = instrucciones_else;
    }

    public String toString() {
        String inst = "";
        for (Instruccion i : instrucciones_then) {
            inst = inst + i + "\n";
        }
        String el = "";
        if (instrucciones_else != null) {
            for (Instruccion i : instrucciones_else) {
                el = el + i + "\n";
            }
        }

        return "If (Condición:" + condicion.toString() + ", Instrucciones:\n" + inst + "Else:\n" + el + ")";
    }

    public KindInstruction kind() {
        return KindInstruction.IFELSE;
    }

}
