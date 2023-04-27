package ast.Types;

import ast.Expresions.E;

public class ArrayType extends Types{

    protected E tam;

    public  ArrayType(Types tipo, E tam) {
        this.tipo = tipo;
        this.tam = tam;
    }


    public KindTypes kind() {
        return KindTypes.ARRAY;
    }

    

    public String toString(){
        if(tam != null)
            return "Array " + "<" + tipo.toString() + ">" ;
        else 
            return "Array "+ "<" + tipo.toString() + ">" ;
    }

    
}
