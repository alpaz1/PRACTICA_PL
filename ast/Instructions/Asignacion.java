package ast.Instructions;

import ast.Expresions.E;
import ast.Types.KindTypes;
import ast.Accesos.*;

public class Asignacion extends Instruccion{
    private KindInstruction tipoIns = KindInstruction.ASIGNACION; // esto sirve de algo?
    private Acceso iden;
    private E valor;
    private KindTypes tipo;


    public Asignacion(Acceso iden, E valor){
        this.iden = iden;
        this.valor = valor;
    }


    public Asignacion(Acceso iden, E valor, KindTypes tipo){
        this.iden = iden;
        this.tipo = tipo;
        this.valor = valor;
    }

    public KindInstruction kind() {return tipoIns;}
    public String toString() {
        if(tipo != null)    return tipoIns.toString() + ": " + iden  + "(" + this.tipo + ") = " + valor.toString();

        else return tipoIns.toString() + ": " + iden + " = " + valor.toString();
    }

    public Acceso getId(){
        return this.iden;
    }

    public E getValor(){
        return this.valor;
    }
}
