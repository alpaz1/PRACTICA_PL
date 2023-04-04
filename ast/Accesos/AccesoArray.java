package ast.Accesos;

import ast.Expresions.E;

public class AccesoArray extends Acceso{
    protected Acceso acceso;
    protected E exp;

    public AccesoArray(Acceso acceso, E exp) {
        this.exp = exp;
        this.acceso = acceso;
    }
    public String toString() {
        return "ExpAccArr(" + acceso + "[" + exp + "])";
    }

}
