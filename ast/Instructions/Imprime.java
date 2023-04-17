package ast.Instructions;

import ast.Expresions.E;

public class Imprime extends Instruccion {
    protected E exp;
    
    public Imprime(E exp){
        this.exp = exp;
    }

    public void vincular() {
        this.exp.vincular();
    }

    public KindInstruction kind() {
        return KindInstruction.PRINT;
    }

    public String toString() {
        return "Imprime (" + exp.toString() + ")";
    }
}
