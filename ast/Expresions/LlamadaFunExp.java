package ast.Expresions;

import java.util.List;

import ast.ASTNode;
import ast.Programa;

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


    public KindE kind() {
        return KindE.LLAMADAFUN;
    }

    public String toString(){
        return "Llamada " + nombre + " (" + parametros.toString() + ")";
    }
}
