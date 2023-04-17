package ast.Instructions;

import ast.Programa;
import ast.Expresions.E;
import java.util.List;

public class BucleWhile extends Bloque {

    private E cond;
    
    public BucleWhile(E exp, List<Instruccion> instrucciones){
        super(instrucciones);
        this.cond = exp;
    }

    public void vincular() {
        Programa.pila.abreBloque();
        cond.vincular();
        for(Instruccion instruccion : instList){
            instruccion.vincular();
        }
        Programa.pila.cierraBloque();
    }

    public KindInstruction kind() {
        return KindInstruction.BUCLEWHILE;
    }
    public String toString() {
        return "While (Condición: " + this.cond.toString() + ", Cuerpo: " + this.instList.toString() + ")";
    }
}
