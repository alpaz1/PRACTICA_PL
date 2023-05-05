package ast.Accesos;

import ast.Programa;
import ast.Types.KindTypes;
import ast.Types.PointerType;

public class AccesoPuntero extends Acceso{

    public AccesoPuntero(Acceso puntero) {
        this.nodoVinculo = puntero;
    }

    public String toString(){
        return "AccPtr(@" + nodoVinculo +")";
    }

    public void vincular() {
        nodoVinculo.vincular();
    }

    @Override
    public void checkType() {
        nodoVinculo.checkType();
        // Checkea que nodoVinculo es un puntero
        if (nodoVinculo.getTipo().kind() != KindTypes.POINTER){
            System.out.println("Error tipo: intento de acceso a puntero en una varible que no es un puntero");
            Programa.okTipos = false;
        }
        setTipo(nodoVinculo.getTipo().getTipo()); // puntero.getTipo() devuelve tipo puntero a .getTipo()
    }

    @Override
    public void calcularDirRelativa() {
        nodoVinculo.generaCodigo();
    }
}
