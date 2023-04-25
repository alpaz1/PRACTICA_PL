package ast.Expresions;

import java.util.List;

import ast.ASTNode;
import ast.Programa;
import ast.Estructuras.Funcion;

public class LlamadaFunExp extends E {
    protected String nombre;
    protected List<E> parametros;

    public LlamadaFunExp(String nombre, List<E> parametros) {
        this.nombre = nombre;
        this.parametros = parametros;
    }

    public void vincular() {
        ASTNode nodo = Programa.pila.buscaId(nombre);
        if(nodo == null){
            System.out.println("Error vinculacion: Intento hacer llamada sin declarar");
            Programa.okVinculacion = false;
        }
        for(E param: parametros){
            param.vincular();
        }
        this.nodoVinculo = nodo;
    }


    public KindE kindExp() {
        return KindE.LLAMADAFUN;
    }

    public String toString(){
        return "Llamada " + nombre + " (" + parametros.toString() + ")";
    }

    @Override
    public void checkType() {
         
        this.tipo = nodoVinculo.tipo;
        // Chequeamos que hay el mismo nº parametros
        Funcion f = (Funcion) this.nodoVinculo;
        if (f.getParams().size() != this.parametros.size()){ // Error, != nº parametros
            System.out.println("Error vinculación: Distinto nº de parametros");
            Programa.okTipos = false;
        }
        for (int i = 0; i < parametros.size(); ++i){ // el nº parametros esta ok por vinculacion
            parametros.get(i).checkType();
            int j = parametros.size() -i-1;
            if(!parametros.get(i).tipo.toString().equals(f.getParams().get(j).tipo.toString())){
                System.out.println("Error Tipos: Funcion " + f.getName() + " espera otro parametro en la posicion  " + i + ". "
                + "El parametro esperado es de tipo: " + f.getParams().get(i).tipo.toString() + 
                " , el parametro  recibido es de tipo: " + parametros.get(i).tipo.toString());
                Programa.okTipos = false;
            }
        }  
        
    }
}
