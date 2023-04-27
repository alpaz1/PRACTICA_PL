package ast.Instructions;

import ast.Programa;
import ast.Estructuras.Funcion;
import ast.Expresions.E;
import ast.Types.BasicTypes;
import ast.Types.KindTypes;
import ast.Types.Types;

public class Devuelve extends Instruccion {
    protected E valorRetorno;


    public Devuelve(E exp) {
        this.valorRetorno = exp;
        this.tipo = exp.getTipo();
    }

    public Devuelve() {
        this.valorRetorno = null;
        this.tipo = new BasicTypes(KindTypes.VOID);
    }

    public KindInstruction kind() {
        return KindInstruction.RETURN;
    }

    public String toString() {
        return "Devuelve " + valorRetorno.toString();
    }

    @Override
    public void vincular() {
        if (valorRetorno != null)
            valorRetorno.vincular();
        this.nodoVinculo = Programa.pila.buscaIdFuncionActual();
    }

    @Override
    public void checkType() {
        if (nodoVinculo.getTipo() != this.tipo){
            System.err.println("Error de tipo: el valor devuelto no se corresponde con el de la función");
            Programa.okVinculacion = false;
        }
    }
}
