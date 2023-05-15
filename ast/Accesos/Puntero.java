package ast.Accesos;

import ast.Types.PointerType;

public class Puntero extends Acceso {

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
        nodoVinculo.calcularDirRelativa(); // Pones la direccion de la variable a la que haces referencia en la cima de la pila
    }

    @Override
    public String toString() {
        return "*" + nodoVinculo;
    }

    @Override
    public boolean isInMemory() {
        return false;
    }
}
