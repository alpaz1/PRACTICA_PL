package ast.Expresions;

import java.util.List;

public class LlamadaFunExp extends E {
    protected String nombre;
    protected List<E> parametros;

    public LlamadaFunExp(String nombre, List<E> parametros) {
        this.nombre = nombre;
        this.parametros = parametros;
    }

    public KindE kind() {
        return KindE.LLAMADAFUN;
    }

    public String toString(){
        return "Llamada " + nombre + " (" + parametros.toString() + ")";
    }
}
