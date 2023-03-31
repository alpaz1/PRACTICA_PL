package ast.Instructions;

import ast.Expresions.E;

public class Asignacion extends Instruccion{
    private KindInstruction tipoIns = KindInstruction.ASIGNACION; // esto sirve de algo?
    private String iden;
    private Object valor;


    public Asignacion(String iden, E valor){
        this.iden = iden;
        this.valor = valor;
    }

    public KindInstruction kind() {return tipoIns;}
    public String toString() {
        return tipoIns.toString() + ": " + iden + " = " + valor.toString();
    }

    public String getId(){
        return this.iden;
    }

    public Object getValor(){
        return this.valor;
    }
}
