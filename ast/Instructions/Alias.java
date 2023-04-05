package ast.Instructions;

import ast.Types.Types;

public class Alias extends Instruccion{

    private Types tipo;
    private String nombre;

    public Alias(String nombre, Types t){
        this.nombre = nombre;
        this.tipo = t;
    }

    public KindInstruction kind() {
        return KindInstruction.ALIAS;
    }

    public String toString() {
        return "ALIAS: " + nombre + " - " + tipo.toString();
    }
    
}
