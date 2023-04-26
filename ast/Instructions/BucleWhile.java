package ast.Instructions;

import ast.Programa;
import ast.Expresions.E;
import java.util.List;

public class BucleWhile extends Bloque {

    private E cond;
    
    public BucleWhile(E exp, List<Instruccion> instrucciones){
        super(instrucciones);
        this.cond = exp;
    }

    public void vincular() {
        Programa.pila.abreBloque();
        cond.vincular();
        for(Instruccion instruccion : instList){
            instruccion.vincular();
        }
        Programa.pila.cierraBloque();
    }

    public void checkType(){
        cond.checkType();
        if(cond.tipo == null || !cond.tipo.toString().equals("BOOL")){ // La condicion tiene que ser bool
            System.out.println("Error tipo: condicion while " + cond + "("+ cond.tipo +")"); 
            Programa.okTipos = false;
        } 
        for(Instruccion instruccion : instList){
            instruccion.checkType();
        }
    }

    public KindInstruction kind() {
        return KindInstruction.BUCLEWHILE;
    }
    public String toString() {
        return "While (Condición: " + this.cond.toString() + ", Cuerpo: " + this.instList.toString() + ")";
    }
}
