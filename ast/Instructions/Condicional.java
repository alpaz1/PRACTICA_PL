package ast.Instructions;

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
