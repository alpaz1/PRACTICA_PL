package ast;

import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class PilaTablaSimbolos {
    
    private Stack<HashMap<String,ASTNode>> pilaTabla;
    private Stack<Integer> deltaBloques;
    private int totalDelta;

    public PilaTablaSimbolos() {
        this.pilaTabla = new Stack<HashMap<String,ASTNode>>();
        this.deltaBloques = new Stack<Integer>();
        this.totalDelta = 0;
    }

     // Cada vez que entro en un nuevo ambito 
    public void abreBloque(){
        // que empieza un nuevo bloque apilando una nueva tabla vacía
        pilaTabla.push(new HashMap<String,ASTNode>());
        deltaBloques.push(totalDelta); // El delta antes del bloque
    }

    // Cada vez que salgo de un ambito 
    public void cierraBloque(){
        // que desapila la tabla de la cima.
        if (!pilaTabla.empty()){ 
            pilaTabla.pop(); 
        }
        totalDelta = deltaBloques.pop();
    }

    public int getDelta() {
        return totalDelta;
    }

    public void updateDelta(int size) {
        totalDelta += size;
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

    public ASTNode buscaIdFuncionActual (){
        // Usado por returns para saber a quien corresponden
        ASTNode node = null;
        Stack<HashMap<String, ASTNode>> pilaTabla_aux = new Stack<HashMap<String, ASTNode>>();
        if(!pilaTabla.empty()){
            HashMap<String,ASTNode> cima = pilaTabla.pop();
            pilaTabla_aux.push(cima);
            // vaciamos la tabla
            while (!pilaTabla.empty()){
                cima = pilaTabla.pop();
                pilaTabla_aux.push(cima);
            }
            // al final del todo esta la funcion
            for (ASTNode globalNode: cima.values()){
                if (globalNode.tipoNodo == NodeKind.FUNCION){
                    node = globalNode;
                }
            }

            //volver a guardar todo en la pila
            while(!pilaTabla_aux.empty()){
                pilaTabla.push(pilaTabla_aux.pop());
            }
        }
        return node;
    }

    private void printAmbito(HashMap<String,ASTNode> ambito){
        for (Map.Entry<String, ASTNode> entry : ambito.entrySet()) {
            String key = entry.getKey();
            ASTNode value = entry.getValue();
            System.out.println(key + " -> " + value);
        }
    }

    public void print(){
        Stack<HashMap<String, ASTNode>> pilaTabla_aux = new Stack<HashMap<String, ASTNode>>();
        if(!pilaTabla.empty()){
            HashMap<String,ASTNode> cima = pilaTabla.pop();
            System.out.println("Ambito Global: ");
            printAmbito(cima);
            pilaTabla_aux.push(cima);
            while (!pilaTabla.empty()){
                // Print cima
                cima = pilaTabla.pop();
                System.out.println("Ambito: ");
                printAmbito(cima);
                pilaTabla_aux.push(cima);
            }
            //volver a guardar todo en la pila
            while(!pilaTabla_aux.empty()){
                pilaTabla.push(pilaTabla_aux.pop());
            }
        } else {
            System.out.println("Pila vacia");
        }
    }

}
