package ast.Estructuras.clases;

import java.util.Collections;
import java.util.List;
import ast.Instructions.Instruccion;
import ast.Programa;
import ast.Util;
import ast.Auxiliares.*;

public class Constructor {
    
    private PrivacyMode modo;
    private List<Instruccion> instList;
    private List<Parametro> paramList;

    public Constructor(PrivacyMode modo,List<Parametro> param,List<Instruccion> list){
        this.modo = modo;
        this.instList = list;
        this.paramList = param;
        Collections.reverse(this.instList);
        Collections.reverse(this.paramList);
    }

    public String toString() {
        return this.modo.toString() + " Constructor: " + "(" + Util.prettify(paramList) + ")" + "{" + Util.prettify(instList) + "}";
    }

    public void vincular() {
        Programa.pila.abreBloque();
        for (Parametro param: paramList)
            param.vincular();
        for (Instruccion inst: instList)
            inst.vincular();
        Programa.pila.cierraBloque();
    }
}
