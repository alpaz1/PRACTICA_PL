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
    public void checkType() {
        exp.checkType();
    }

    @Override
    public void generaCodigo() {
        Programa.codigo.println(";; Inicio imprime " + exp);
        exp.generaCodigo();
        // if (exp.getTipo().toString().equals(KindTypes.BOOL.toString())){
        //     // Programa.codigo.println("call ");
        // }
        Programa.codigo.println("call $print");
        Programa.codigo.println(";; Fin imprime " + exp);
    }

    public KindInstruction kind() {
        return KindInstruction.PRINT;
    }

    public String toString() {
        return "Imprime (" + exp.toString() + ")";
    }
}
