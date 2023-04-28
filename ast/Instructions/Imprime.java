package ast.Instructions;

import ast.Programa;
import ast.Expresions.E;

public class Imprime extends Instruccion {
    protected E exp;
    
    public Imprime(E exp){
        this.exp = exp;
    }

    public void vincular() {
        this.exp.vincular();
    }

    @Override
    public void generaCodigo() {
        exp.generaCodigo();
        Programa.codigo.println("call $print");
    }

    public KindInstruction kind() {
        return KindInstruction.PRINT;
    }

    public String toString() {
        return "Imprime (" + exp.toString() + ")";
    }
}
