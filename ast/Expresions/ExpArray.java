package ast.Expresions;

import java.util.ArrayList;
import java.util.Collections;
import ast.Types.ArrayType;
import ast.Types.BasicTypes;
import ast.Types.KindTypes;

public class ExpArray  extends E{

    public ArrayList<E> valor;

    public ExpArray( ArrayList<E> valor){
        this.valor = valor;    
        Collections.reverse(valor);

    }

    @Override
    public KindE kindExp() {
        return KindE.ARRAY;
    }

    public ArrayList<E> getListaConst(){

    
        
        ArrayList <E> aux = new ArrayList<E>();
        for(E e: valor){
            if(e.kindExp().toString().equals("ARRAY"))
                aux.addAll(((ExpArray)e).getListaConst());
            else return valor;
        }
        return aux;
        
    }

 
    public ArrayList<E> getValor(){
        return valor;
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

    /* 

    public String getValor() {
        // se debería cambiar a int o float segun corresponda
        if (valor.equals("verdad")) {
          return "1";
        } else if (valor.equals("mentira")) {
          return "0";
        } else{
          return valor;
        }
      }
    
  
    
      @Override
      public void generaCodigo() {
          Programa.codigo.println("i32.const " + getValor());
      }
    
      */

    
    
}
