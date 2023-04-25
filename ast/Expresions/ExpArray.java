package ast.Expresions;

import java.util.ArrayList;

import ast.Types.ArrayType;
import ast.Types.BasicTypes;
import ast.Types.KindTypes;

public class ExpArray  extends E{

    ArrayList<E> valor;

    public ExpArray( ArrayList<E> valor){
        this.valor = valor;
        this.tipo = new ArrayType(valor.get(0).tipo, null);
    }

    @Override
    public KindE kindExp() {
        return KindE.ARRAY;
    }


    @Override
    public void checkType() {

        for(E e: valor){
            if(!e.getTipo().toString().equals(tipo.getTipo().toString())){
            
                System.out.println("La expresion con la que se inicializa un array debe ser homogénea");
               // System.out.println(e.getTipo().toString());
                //System.out.println(tipo.toString());
                this.tipo = new BasicTypes(KindTypes.ERROR);
                break;
            }
        }
    }

    public String toString(){
        return this.valor.toString();
    }

    @Override
    public void vincular() {
        for(E e: valor){
            e.vincular();
        }
    }
    
}
