package ast.Accesos;

import ast.Expresions.LlamadaFunExp;

public class AccesoMetodo extends Acceso {
    
    private Acceso ref;
    private LlamadaFunExp llamada;

    public AccesoMetodo(Acceso ref, LlamadaFunExp llamada){
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
}
