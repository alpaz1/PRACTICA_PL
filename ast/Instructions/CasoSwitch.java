package ast.Instructions;

import ast.Expresions.E;
import java.util.List;

public class CasoSwitch extends Bloque {

    private E caso;

    public CasoSwitch(E condicion, List<Instruccion> instrucciones) {
        super(instrucciones);
        this.caso = condicion;
    }

    public CasoSwitch(List<Instruccion> instrucciones) {
        super(instrucciones);
        this.caso = null;
    }

    public KindInstruction kind() {
        return KindInstruction.CASE;
    }
    
    public String toString(){
        if (caso == null)
            return "default: " + this.instList.toString();
        else
            return "case " + caso.toString() + ": " + this.instList.toString();
    }
}
