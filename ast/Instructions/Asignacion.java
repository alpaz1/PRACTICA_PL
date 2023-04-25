package ast.Instructions;

import ast.Expresions.E;
import ast.Types.KindTypes;
import ast.Types.Types;
import ast.Programa;
import ast.Accesos.*;

public class Asignacion extends Instruccion{
    private KindInstruction tipoIns = KindInstruction.ASIGNACION; // esto sirve de algo?
    private Acceso iden;
    private E exp;

    public Asignacion(Acceso iden, E exp){
        this.iden = iden;
        this.exp = exp;
    }


    public Asignacion(Acceso iden, E exp, Types tipo){
        this.iden = iden;
        this.tipo = tipo;
        this.exp = exp;
    }

    public KindInstruction kind() {return tipoIns;}
    public String toString() {
        if(tipo != null)    
            return tipoIns.toString() + ": " + iden  + "(" + this.tipo + ") = " + exp.toString();

        else 
            return tipoIns.toString() + ": " + iden + " = " + exp.toString();
    }

    public Acceso getId(){
        return this.iden;
    }

    public E getValor(){
        return this.exp;
    }

    public void vincular() {
        iden.vincular();
        exp.vincular();
    }

    public void checkType(){
        iden.checkType();
        exp.checkType();

      
        if( iden.tipo != null && !iden.tipo.toString().equals(exp.tipo.toString())){
            System.out.println("Error tipo: Asignacion " + iden + "=" + exp + "(" + iden.tipo + "," + exp.tipo + ")");
            Programa.okTipos = false;
        }
        else  System.out.println("tipo OK");

    }
}
