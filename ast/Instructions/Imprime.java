package ast.Instructions;

import ast.Programa;
import ast.Expresions.E;
import ast.Types.KindTypes;

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
        if (exp.getTipo().toString().equals(KindTypes.BOOL.toString())){
            // Programa.codigo.println("call ");
        }
        Programa.codigo.println("call $print");
    }

    public KindInstruction kind() {
        return KindInstruction.PRINT;
    }

    public String toString() {
        return "Imprime (" + exp.toString() + ")";
    }
}
