package ast.Estructuras;

import java.util.ArrayList;
import java.util.List;

import ast.Auxiliares.Parametro;
import ast.Instructions.Instruccion;
import ast.Types.KindTypes;

public class FMain extends Funcion{

    public FMain(List<Instruccion> instList) {
        super(KindTypes.VOID, "principal", new ArrayList<Parametro>(), instList);
    }
    
}
