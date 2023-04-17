package ast.Accesos;

import java.util.List;

import ast.Expresions.E;
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

    @Override
    public void vincular() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'vincular'");
    }
}
