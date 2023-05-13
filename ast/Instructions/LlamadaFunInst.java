package ast.Instructions;

import ast.Programa;
import ast.Expresions.LlamadaFunExp;
import ast.Types.KindTypes;

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
        this.tipo = llamadaFuncion.getTipo();
    }

    @Override
    public void generaCodigo() {
        llamadaFuncion.generaCodigo();
        if (tipo.kind() != KindTypes.VOID){
            Programa.codigo.println("drop");
        }
    }

    public String toString(){
        return llamadaFuncion.toString();
    }
}