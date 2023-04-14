package ast;

import java.util.Stack;
import java.util.HashMap;

public class PilaTablaSimbolos {
    
    private Stack<HashMap<String,ASTNode>> pilaTabla;

    public PilaTablaSimbolos() {
        this.pilaTabla = new Stack<HashMap<String,ASTNode>>();
    }

     // Cada vez que entro en un nuevo ambito 
     public void abreBloque(){
        // que empieza un nuevo bloque apilando una nueva tabla vacía
        pilaTabla.push(new HashMap<String,ASTNode>());
    }

    // Cada vez que salgo de un ambito 
    public void cierraBloque(){
        // que desapila la tabla de la cima.
        if (!pilaTabla.empty()){ 
            pilaTabla.pop(); 
        }
    }

    // Insertamos en la tabla de la cima de la pila un nuevo identificador
    public void insertaId (String id, ASTNode puntero){
        // que inserta id con su referencia al AST en la tabla de la cima.
        if(!pilaTabla.empty()){
            HashMap<String,ASTNode> cima = pilaTabla.peek();
            cima.put(id, puntero);
        }
    }

    // Buscamos el identificador en la pila
    public ASTNode buscaId (String id){
        // busca la primera aparición de id en la pila de tablas empezando por la cima y devuelve su referencia.
        Stack<HashMap<String, ASTNode>> pilaTabla_aux = new Stack<HashMap<String, ASTNode>>();
        ASTNode puntero = null;
        if(!pilaTabla.empty()){
            HashMap<String,ASTNode> cima = pilaTabla.pop();
            puntero = cima.get(id);
            pilaTabla_aux.push(cima);
            while (puntero == null && !pilaTabla.empty()){
                cima = pilaTabla.pop();
                puntero = cima.get(id);
                pilaTabla_aux.push(cima);
            }

            //volver a guardar todo en la pila
            while(!pilaTabla_aux.empty()){
                pilaTabla.push(pilaTabla_aux.pop());
            }
        }
        return puntero;
    }

    // Buscamos el identificador solo en la tabla de la cima
    public ASTNode buscaIdCima (String id){
        ASTNode puntero = null;
        if(!pilaTabla.empty()){
            HashMap<String,ASTNode> cima = pilaTabla.peek();
            puntero = cima.get(id);
        }
        return puntero;
    }



}
