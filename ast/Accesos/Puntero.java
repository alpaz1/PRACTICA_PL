package ast.Accesos;

import ast.Programa;
import ast.Types.PointerType;

public class Puntero extends Acceso {
    private int direccion;

    public Puntero(Acceso variable){
        this.nodoVinculo = variable;
    }

    @Override
    public void vincular() {
        nodoVinculo.vincular();
    }

    @Override
    public void checkType() {
        nodoVinculo.checkType();
        setTipo(new PointerType(nodoVinculo.getTipo()));
    }

    @Override
    public void generaCodigo() {
        Programa.codigo.println("i32.const " + nodoVinculo.getDelta()); // Pones la direccion de la variable a la que haces referencia en la cima de la pila
    }

    public int getDireccion() {
        return direccion;
    }
}
