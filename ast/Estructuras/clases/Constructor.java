package ast.Estructuras.clases;

import java.util.List;
import ast.Instructions.Instruccion;
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
    }

    public String toString() {
        return this.modo.toString() + " Constructor: " + "(" + Util.prettify(paramList) + ")" + "{" + Util.prettify(instList) + "}";
    }
}
