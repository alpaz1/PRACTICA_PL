package ast.Auxiliares;

import ast.Estructuras.Declaracion;
import ast.Types.KindTypes;

public class Parametro extends Declaracion{
    private boolean ampersand;

    public Parametro(KindTypes tipo, String nombre, boolean ampersand){
        super(tipo,nombre);
        this.ampersand = ampersand;
    }

    @Override
    public String toString() {
        return tipo.toString() + " " + (ampersand ? "&":"") + this.name;
    }
}
