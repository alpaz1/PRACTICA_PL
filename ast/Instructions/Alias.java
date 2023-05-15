package ast.Instructions;

import ast.ASTNode;
import ast.Programa;
import ast.Types.Types;

public class Alias extends ASTNode{

    private Types tipo;
    private String nombre;

    public Alias(String nombre, Types t){
        this.nombre = nombre;
        this.tipo = t;
        Programa.lista_tipos.add(this.nombre);
    }

    public KindInstruction kind() {
        return KindInstruction.ALIAS;
    }

    public String toString() {
        return "ALIAS: " + nombre + " - " + tipo.toString();
    }

    public void vincular() {
        ASTNode nodo = Programa.pila.buscaIdCima(nombre);
        if (nodo == null) { // devuelve null cuando no esta
            // System.out.println("Vinculando " + name);
            Programa.pila.insertaId(nombre, this);
            // Ahora me tengo que ir al tipo más profundo del lado izquierdo y comprobar que es un tipo válido
            Types aux = this.tipo;
            while (aux.getTipo() != null)
                aux = aux.getTipo();
            boolean encontrado = false;
            for (String s: Programa.lista_tipos) {
                if (aux.toString().equals(s) || aux.toString().equals(s + "*"))
                    encontrado = true;
            }
            // SI NO HEMOS ENCONTRADO ES UN IDENTIFICADOR NO RECONOCIDO
            if (!encontrado){
                System.out.println("Error vinculacion: Identificador no reconocido: " + aux.toString());
                Programa.okVinculacion = false;
            }
        } else {
            System.out.println("Error vinculacion: Este identificador ya esta usado: " + nombre);
            Programa.okVinculacion = false;
        }
    }

    public Types getTipo() {
        return this.tipo;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setTipo(Types tipo){
        this.tipo = tipo;
    }

    
}
