package ast.Types;

import ast.Expresions.Const;

public class ArrayType extends Types{

    protected Const tam;

    public ArrayType(Types tipo, Const tam) {
        this.tipo = tipo;
        this.tam = tam;
    }


    public KindTypes kind() {
        return KindTypes.ARRAY;
    }

    public String toString(){
        return "Array " + "<" + tipo.toString() + ">";
    }


    @Override
    public int getTam() {

        // System.out.println("Cada " + tipo +" ocupa " + tipo.getTam() + ". Como hay " + tam.getValor() + " el tam total es " +  tipo.getTam() * Integer.parseInt(tam.getValor()));

        return tipo.getTam() * Integer.parseInt(tam.getValor());
       
    }

    
}
