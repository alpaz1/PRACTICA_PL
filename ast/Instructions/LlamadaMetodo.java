package ast.Instructions;

import ast.Accesos.Acceso;
import ast.Expresions.LlamadaFunExp;

public class LlamadaMetodo extends Instruccion {
    private Acceso ref;
    private LlamadaFunExp llamada;

    public LlamadaMetodo(Acceso ref, LlamadaFunExp llamada){
        this.ref = ref;
        this.llamada = llamada;
    }

    public String toString() {
        return "Clase: " + ref + " " + llamada.toString();
    }

    public void vincular() {
        ref.vincular();
        llamada.vincular();
    }

    @Override
    public KindInstruction kind() {
        return KindInstruction.LLAMADAMETODO;
    }
}
