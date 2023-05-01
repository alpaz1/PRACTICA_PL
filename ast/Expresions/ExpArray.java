package ast.Expresions;

import java.util.ArrayList;
import java.util.List;

import ast.Types.ArrayType;
import ast.Types.BasicTypes;
import ast.Types.KindTypes;

public class ExpArray  extends E{

    public ArrayList<E> valor;

    public ExpArray( ArrayList<E> valor){
        this.valor = valor;    
    }

    @Override
    public KindE kindExp() {
        return KindE.ARRAY;
    }

 


    @Override
    public void checkType() {
        valor.get(0).checkType();
        //System.out.println("HOLA" + valor.get(0).kindExp());
        this.tipo = new ArrayType(valor.get(0).getTipo(), null);    
        for(int i = 1; i < valor.size(); ++i){  
           // System.out.println("HOLA" + valor.get(i).kindExp());
            valor.get(i).checkType();
    
            if(!valor.get(i).getTipo().toString().equals(tipo.getTipo().toString())){
            
                System.out.println("La expresion con la que se inicializa un array debe ser homogénea");
               // System.out.println(e.getTipo().toString());
                //System.out.println(tipo.toString());
                this.tipo = new BasicTypes(KindTypes.ERROR);
                break;
            }
        }
    }

    public String toString(){
        return this.valor.toString() + this.kindExp().toString();
    }

    @Override
    public void vincular() {
        for(E e: valor){
            e.vincular();
        }
    }

    
    
}
