package ast.Instructions;

import ast.Programa;
import ast.Estructuras.Funcion;
import ast.Expresions.E;
import ast.Types.BasicTypes;
import ast.Types.KindTypes;

public class Devuelve extends Instruccion {
    protected E valorRetorno;
    Funcion funcion;


    public Devuelve(E exp) {
        this.valorRetorno = exp;
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
        funcion = (Funcion) nodoVinculo;
    }

    @Override
    public void generaCodigo() {
        if (valorRetorno.isBasica()){
            valorRetorno.generaCodigo();
        } else {
            valorRetorno.calcularDirRelativa(); // si es un struct, array, etc se devuelve por referencia
        }
        Programa.codigo.println("return");
    }

    @Override
    public void checkType() {
        if (valorRetorno != null){
            valorRetorno.checkType();
            tipo = valorRetorno.getTipo();
        }
        if (!nodoVinculo.getTipo().toString().equals(this.tipo.toString())){
            System.err.println("Error de tipo: el valor devuelto (" + this.tipo.toString() + ") no se corresponde con el de la función (" +
            nodoVinculo.getTipo() + ")");
            Programa.okVinculacion = false;
        }
    }
}
