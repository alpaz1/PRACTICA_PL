package ast.Expresions;

import java.util.ArrayList;

import ast.Programa;
import ast.Types.BasicTypes;
import ast.Types.KindTypes;

public class Lee extends E{
    
    public Lee() {
        this.tipo = new BasicTypes(KindTypes.INT); // Es una expresion de tipo entero siempre
        // Ya que solo podemos leer enteros con el read dado
    }

    public String toString() {
        return "Leer";
    }

    public void vincular() {}

    public void generaCodigo() {
        Programa.codigo.println("call $read");
    }

    @Override
    public KindE kindExp() {
        return KindE.READ;
    }

    @Override
    public void checkType() {}
}
