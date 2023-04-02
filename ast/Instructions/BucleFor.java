package ast.Instructions;
import java.util.List;

import ast.Expresions.E;



public class BucleFor extends Bloque{
    private KindInstruction tipoIns = KindInstruction.BUCLEFOR; // esto sirve de algo?
    private Asignacion var;
    private Object valor;
    private Asignacion a;


    public BucleFor(Asignacion variable, E exp , Asignacion a ,  List<Instruccion> instList ){
        super(instList);
        this.var = variable;
        this.valor = exp;
        this.a = a;
    }

    public KindInstruction kind() {return tipoIns;}
    public String toString() {
        return tipoIns.toString() + " Variable: " + var.toString() + " Condicion:  " + valor.toString() + "Asignacion: " + a.toString()
                + "Cuerpo: {" +instList.toString() + "}"; 
    }

    public Asignacion getId(){
        return this.var;
    }

    public Asignacion getAsignacion(){
        return this.a;
    }

    public Object getValor(){
        return this.valor;
    }
}
