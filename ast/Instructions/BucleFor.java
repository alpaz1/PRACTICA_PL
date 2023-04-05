package ast.Instructions;
import java.util.List;

import ast.Expresions.E;



public class BucleFor extends Bloque{

    private Asignacion var;
    private E valor;
    private Asignacion a;


    public BucleFor(E exp , Asignacion a ,  List<Instruccion> instList ){
        super(instList);
        this.valor = exp;
        this.a = a;
        this.var = null;
    }

    public BucleFor(Asignacion variable, E exp , Asignacion a ,  List<Instruccion> instList ){
        super(instList);
        this.var = variable;
        this.valor = exp;
        this.a = a;
    }

    public KindInstruction kind() {
        return KindInstruction.BUCLEFOR;
    }

    public String toString() {
        if (this.var != null)
            return "FOR: (" + "Variable: " + var.toString() + " Condicion:  " + valor.toString() + "Asignacion: " + a.toString() + ")"
                + "Cuerpo: {" +instList.toString() + "}"; 
        else 
        return "FOR: (" + " Variable: " + ";" + " Condicion:  " + valor.toString() + "Asignacion: " + a.toString() + ")"
        + "Cuerpo: {" +instList.toString() + "}"; 
    }

    public Asignacion getId(){
        return this.var;
    }

    public Asignacion getAsignacion(){
        return this.a;
    }

    public E getValor(){
        return this.valor;
    }
}
