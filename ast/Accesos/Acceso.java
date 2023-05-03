package ast.Accesos;

import ast.Programa;
import ast.Expresions.E;
import ast.Expresions.KindE;

public abstract class Acceso extends E{

    public Acceso() {}

    public KindE kindExp() {
       return KindE.ACCESS;
    }

    public abstract void vincular();

    public void calcularDirRelativa() {} 

    @Override
    public void generaCodigo() {
        calcularDirRelativa(); // Accedemos a la posicion
        Programa.codigo.println("i32.load"); //deja el valor en la pila
    }
    
}
