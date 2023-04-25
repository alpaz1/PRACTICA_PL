package ast.Estructuras.clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ast.Instructions.Instruccion;
import ast.Types.BasicTypes;
import ast.Types.KindTypes;
import ast.Programa;
import ast.Util;
import ast.Auxiliares.*;
import ast.Estructuras.Funcion;

public class Constructor extends Funcion{
    
    private static String name;
    private PrivacyMode modo;
    private List<Instruccion> instList;
    private List<Parametro> paramList;

    private List<Atributo> atributos = new ArrayList<Atributo>();

    public void addAtr(Atributo a){
        this.atributos.add(a);
    }

    public void setName(String name){
        this.name = name;
    }

    public Constructor(PrivacyMode modo,List<Parametro> param,List<Instruccion> list){
        super(new BasicTypes( KindTypes.CONSTRUCTOR), name, param, list);
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
        Programa.pila.insertaId(name, this);

        Programa.pila.abreBloque();
        for(Atributo a: atributos){
            a.vincular();
        }
        for (Parametro param: paramList)
            param.vincular();
        for (Instruccion inst: instList)
            inst.vincular();
            
        Programa.pila.cierraBloque();
    }

    public PrivacyMode getPrivacyMode() {
        return this.modo;
    }
}
