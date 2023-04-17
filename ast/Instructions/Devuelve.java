package ast.Instructions;

import ast.Expresions.E;

public class Devuelve extends Instruccion {
    protected E valorRetorno;

    public Devuelve(E exp) {
        this.valorRetorno = exp;
    }

    public Devuelve() {
        this.valorRetorno = null;
    }

    public KindInstruction kind() {
        return KindInstruction.RETURN;
    }

    public String toString() {
        return "Devuelve " + valorRetorno.toString();
    }

    @Override
    public void vincular() {
        if (valorRetorno != null)
            valorRetorno.vincular();
    }
}
