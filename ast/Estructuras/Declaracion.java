package ast.Estructuras;

import ast.Expresions.E;
import ast.Instructions.Instruccion;
import ast.Instructions.KindInstruction;
import ast.Types.KindTypes;
import ast.ASTNode;
import ast.Programa;

public class Declaracion extends Instruccion {
    
    protected String name;
    protected KindTypes tipo;
    private E exp = null;

    public Declaracion(KindTypes tipo, String name){
        this.tipo = tipo;
        this.name = name;
    }
    public KindTypes getTipo() {
        return this.tipo;
    }
    public String getName() {
        return this.name;
    }

    public Declaracion(KindTypes tipo, String name, E valor){
        this.tipo = tipo;
        this.name = name;
        this.exp = valor;
    }


    public void vincular() {
        // Tenemos un buscaId particular para este caso
        // Va a permitir de declarar con un mismo identificador siempre y cuado no se
        // haya declarado uno con el
        // mismo name en ese bloque
        ASTNode nodo = Programa.pila.buscaIdCima(name);
        if (nodo == null) { // devuelve null cuando no esta
            Programa.pila.insertaId(name, this);
            if (exp != null)
                exp.vincular();
        } else {
            System.out.println("Error vinculacion: Este identificador ya esta usado: " + name);
            Programa.okVinculacion = false;
        }
    }

    public String toString(){
        String out;
        if (exp != null){
            out = tipo.toString() + " " + name + " = " + exp.toString();
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
