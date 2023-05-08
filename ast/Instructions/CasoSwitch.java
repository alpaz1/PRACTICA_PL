package ast.Instructions;

import ast.Programa;
import ast.Expresions.E;
import ast.Types.Types;

import java.util.List;

public class CasoSwitch extends Bloque {

    private E caso;
    private boolean parada;

    public CasoSwitch(E condicion, List<Instruccion> instrucciones, boolean parada) {
        super(instrucciones);
        this.caso = condicion;
        this.parada = parada;
    }

    public CasoSwitch(List<Instruccion> instrucciones) {
        super(instrucciones);
        this.caso = null;
        this.parada = true;
    }

    public void generaCodigo() {
        Programa.codigo.println("end"); // comienzo del caso
        Programa.codigo.println("get_local $temp"); // dejo en la cima de la pila la condicion pa no perderla
        if (caso != null) {
            caso.generaCodigo();
            //if (caso instanceof Acceso) {
              //  Programa.codigo.println("i32.load"); // si es acceso, obtengo su valor
            //}
            Programa.codigo.println("get_local $temp"); // temp tiene el valor de la exp del switch
            Programa.codigo.println("i32.eq"); // si es es caso adecuado
            Programa.codigo.println("i32.eqz"); // cambio el valor
            Programa.codigo.println("br_if 0"); // si no es el valor entonces salto al siguiente caso
        } 
        // si es el caso, tengo que hacer sus instrucciones
        for (Instruccion instruccion : instList) {
            instruccion.generaCodigo();
        }
        if (parada)
            Programa.codigo.println("br $break"); // ;; salto al end del switch bc of break
    }

    public void vincular(){
        if (caso != null)
            caso.vincular();

        Programa.pila.abreBloque();
        for (Instruccion instruccion : instList) {
            instruccion.vincular();
        }
        Programa.pila.cierraBloque();
    }

    public void checkType() {
        if (caso != null)
            caso.checkType();
        for (Instruccion instruccion : instList) {
            instruccion.checkType();
        }
    }

    public KindInstruction kind() {
        return KindInstruction.CASE;
    }
    
    public String toString(){
        if (caso == null)
            return "default: " + this.instList.toString();
        else
            if (this.parada)
                return "case " + caso.toString() + ": " + this.instList.toString() + " BREAK";
            else
                return "case " + caso.toString() + ": " + this.instList.toString();
    }

    public Types getTipo() {
        return caso.tipo;
    }
}
