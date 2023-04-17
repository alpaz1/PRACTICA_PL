package ast.Accesos;

import ast.ASTNode;
import ast.Programa;

public class AccesoVar extends Acceso{
    private String direccionInicial;
    
    public AccesoVar(String nombreVar){
        this.direccionInicial = nombreVar;
    }

    public void vincular() {
        ASTNode nodo = Programa.pila.buscaId(direccionInicial);
        if(nodo == null){
            System.out.println("Error vinculacion: Intento de acceso sin declaracion: " + direccionInicial);
            Programa.okVinculacion = false;
        }
        else
            this.nodoVinculo = nodo;
    }

    public String toString(){
        return direccionInicial;
    }
}
