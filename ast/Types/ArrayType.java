package ast.Types;

import ast.Expresions.E;

public class ArrayType extends Types{

    public KindTypes tipo;
    protected E tam;

    public  ArrayType(KindTypes tipo, E tam) {
        this.tipo = tipo;
        this.tam = tam;
    }


    public KindTypes kind() {
        return KindTypes.ARRAY;
    }

    public String toString(){
        if(tam != null)
            return "Array " + "<" + tipo.toString() + ">" + "["+tam+"]";
        else 
            return "Array "+ "<" + tipo.toString() + ">" + "[]";
    }

    
}
