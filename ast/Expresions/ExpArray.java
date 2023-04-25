package ast.Expresions;

import java.util.ArrayList;

import ast.Types.KindTypes;

public class ExpArray  extends E{

    ArrayList<E> valor;

    public ExpArray( ArrayList<E> valor){
        this.valor = valor;
        this.tipo = valor.get(0).tipo;
        
    }

    @Override
    public KindE kindExp() {
        return KindE.ARRAY;
    }

    public KindTypes kind(){
        return this.valor.get(0).kind();
    }

    @Override
    public void checkType() {

        for(E e: valor){
            if(!e.kind().equals(tipo)){
                this.tipo = KindTypes.ERROR;
                System.out.println("La expresion con la que se inicializa un array debe ser homogénea");
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
