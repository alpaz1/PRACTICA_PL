package ast.Expresions;

import java.util.List;

import ast.ASTNode;
import ast.Programa;
import ast.Estructuras.Funcion;

public class LlamadaFunExp extends E {
    protected String nombre;
    protected List<E> argumentos;

    public LlamadaFunExp(String nombre, List<E> argumentos) {
        this.nombre = nombre;
        this.argumentos = argumentos;
    }

    public void vincular() {
        ASTNode nodo = Programa.pila.buscaId(nombre);
        if(nodo == null){
            System.out.println("Error vinculacion: Intento hacer llamada sin declarar");
            Programa.okVinculacion = false;
        }
        for(E argumento: argumentos){
            argumento.vincular();
        }
        this.nodoVinculo = nodo;
    }


    public KindE kindExp() {
        return KindE.LLAMADAFUN;
    }

    public String toString(){
        return "Llamada " + nombre + " (" + argumentos.toString() + ")";
    }

    @Override
    public void checkType() {
         
        this.tipo = nodoVinculo.tipo;
        // Chequeamos que hay el mismo nº argumentos
        Funcion f = (Funcion) this.nodoVinculo;
        if (f.getParams().size() != this.argumentos.size()){ // Error, != nº argumentos
            System.out.println("Error vinculación: Distinto nº de argumentos");
            Programa.okTipos = false;
        }
        for (int i = 0; i < argumentos.size(); ++i){ // el nº argumentos esta ok por vinculacion
            argumentos.get(i).checkType();
            int j = argumentos.size() -i-1;
            if(!argumentos.get(i).tipo.toString().equals(f.getParams().get(j).tipo.toString())){
                System.out.println("Error Tipos: Funcion " + f.getName() + " espera otro parametro en la posicion  " + i + ". "
                + "El parametro esperado es de tipo: " + f.getParams().get(i).tipo.toString() + 
                " , el parametro  recibido es de tipo: " + argumentos.get(i).tipo.toString());
                Programa.okTipos = false;
            }
        }  
        
    }
}
