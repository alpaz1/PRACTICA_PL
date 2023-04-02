package ast.Instructions;

import ast.Expresions.E;
import ast.Types.KindTypes;

public class Asignacion extends Instruccion{
    private KindInstruction tipoIns = KindInstruction.ASIGNACION; // esto sirve de algo?
    private String iden;
    private Object valor;
    private KindTypes tipo;


    public Asignacion(String iden, Object valor){
        this.iden = iden;
        this.valor = valor;
    }


    public Asignacion(String iden, E valor, KindTypes tipo){
        this.iden = iden;
        this.tipo = tipo;
        this.valor = valor;
    }

    public KindInstruction kind() {return tipoIns;}
    public String toString() {
        if(tipo != null)    return tipoIns.toString() + ": " + iden  + "(" + this.tipo + ") = " + valor.toString();

        else return tipoIns.toString() + ": " + iden + " = " + valor.toString();
    }

    public String getId(){
        return this.iden;
    }

    public Object getValor(){
        return this.valor;
    }
}
