package ast.Accesos;

import ast.Expresions.E;

public class AccesoArray extends Acceso{
    protected Acceso acceso;
    protected E exp;

    public AccesoArray(Acceso acceso, E exp) {
        this.exp = exp;
        this.acceso = acceso;
    }

    public void vincular() {
        acceso.vincular();
        this.nodoVinculo = acceso.nodoVinculo;
        exp.vincular();
    }

    public String toString() {
        return "AccArr(" + acceso + "[" + exp + "])";
    }

}
