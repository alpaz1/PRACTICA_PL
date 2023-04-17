package ast.Instructions;

import ast.Expresions.LlamadaFunExp;

public class LlamadaFunInst extends Instruccion {
    private LlamadaFunExp funcion;

    public LlamadaFunInst(LlamadaFunExp funcion){
        this.funcion = funcion;
    }

    public KindInstruction kind() {
        return KindInstruction.FUNCALL;
    }

    public void vincular() {
        funcion.vincular();
    }

    public String toString(){
        return funcion.toString();
    }
}