package ast.Instructions;

import ast.Programa;
import ast.Expresions.E;
import ast.Types.Types;

import java.util.List;

public class CasoSwitch extends Bloque {

    private E caso;
    private boolean parada;

    public CasoSwitch(E condicion, List<Instruccion> instrucciones, boolean parada) {
        super(instrucciones);
        this.caso = condicion;
        this.parada = parada;
    }

    public CasoSwitch(List<Instruccion> instrucciones) {
        super(instrucciones);
        this.caso = null;
    }

    public void vincular(){
        if (caso != null)
            caso.vincular();

        Programa.pila.abreBloque();
        for (Instruccion instruccion : instList) {
            instruccion.vincular();
        }
        Programa.pila.cierraBloque();
    }

    public void chequea() {
        if (caso != null)
            caso.checkType();
        for (Instruccion instruccion : instList) {
            instruccion.checkType();
        }
    }

    public KindInstruction kind() {
        return KindInstruction.CASE;
    }
    
    public String toString(){
        if (caso == null)
            return "default: " + this.instList.toString();
        else
            if (this.parada)
                return "case " + caso.toString() + ": " + this.instList.toString() + " BREAK";
            else
                return "case " + caso.toString() + ": " + this.instList.toString();
    }

    public Types getTipo() {
        return caso.tipo;
    }
}
