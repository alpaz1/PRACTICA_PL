package ast.Estructuras;

import ast.Expresions.E;
import ast.Instructions.Asignacion;
import ast.Instructions.Instruccion;
import ast.Instructions.KindInstruction;
import ast.Types.KindTypes;

public class Declaracion extends Instruccion {
    
    private String name;
    private KindTypes tipo;
    private Object valor = null;

    public Declaracion(KindTypes tipo, String name){
        this.tipo = tipo;
        this.name = name;
    }

    public Declaracion(KindTypes tipo, String name, Object valor){
        this.tipo = tipo;
        this.name = name;
        this.valor = valor;
    }

    public String toString(){
        String out;
        if (valor != null){
            out = tipo.toString() + " " + name + " = " + valor.toString();
        } else {
            out = tipo.toString() + " " + name;
        }
        return out;
    }

    @Override
    public KindInstruction kind() {
        return KindInstruction.DECLARACION;
    }

}
