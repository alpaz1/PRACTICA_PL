package ast.Instructions;

import java.util.Collections;
import java.util.List;

import ast.Estructuras.Declaracion;

public class Bloque extends Instruccion{
    public List<? extends Instruccion> instList;

    public Bloque(){}
    public Bloque(List<Instruccion> inst){
        this.instList = inst;
        Collections.reverse(this.instList);
    }
    
    public String toString() {
        return "Bloque {" + instList + "}";
    }

    @Override
    public KindInstruction kind() {
        return KindInstruction.BLOCK;
    }


    public static int maxMemoria(List<? extends Instruccion> instList) {
        int tamDeclaraciones = 0;
        int maximoBloque = 0;
        for (Instruccion instruccion : instList) {
            if (instruccion instanceof Declaracion) {
                tamDeclaraciones += instruccion.maxMemoria(); // Sumamos el tamaño de las variables
            } else if (instruccion instanceof Bloque) {
                int tamBloque = instruccion.maxMemoria(); // Y el del bloque mas grande
                if (tamBloque > maximoBloque) {
                    maximoBloque = tamBloque;
                }
            }
        }
        return maximoBloque + tamDeclaraciones;
    }

    @Override
    public int maxMemoria() {
        return maxMemoria(instList);
    }

    @Override
    public void vincular() {}

}
