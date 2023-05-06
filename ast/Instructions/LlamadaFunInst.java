package ast.Instructions;

import ast.Programa;
import ast.Expresions.LlamadaFunExp;

public class LlamadaFunInst extends Instruccion {
    private LlamadaFunExp llamadaFuncion;

    public LlamadaFunInst(LlamadaFunExp llamadaFuncion){
        this.llamadaFuncion = llamadaFuncion;
    }

    public KindInstruction kind() {
        return KindInstruction.FUNCALL;
    }

    public void vincular() {
        llamadaFuncion.vincular();
    }

    @Override
    public void checkType() {
        llamadaFuncion.checkType();
    }

    @Override
    public void generaCodigo() {
        llamadaFuncion.generaCodigo();
        Programa.codigo.println("drop");
    }

    public String toString(){
        return llamadaFuncion.toString();
    }
}