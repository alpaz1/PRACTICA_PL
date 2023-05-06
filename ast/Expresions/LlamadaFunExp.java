package ast.Expresions;

import java.util.Collections;
import java.util.List;

import ast.ASTNode;
import ast.Programa;
import ast.Estructuras.Funcion;

public class LlamadaFunExp extends E {
    protected String nombre;
    protected List<E> argumentos;

    public LlamadaFunExp(String nombre, List<E> argumentos) {
        Collections.reverse(argumentos);
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
            if(!argumentos.get(i).tipo.toString().equals(f.getParams().get(i).tipo.toString())){
                System.out.println("Error Tipos: Funcion " + f.getName() + " espera otro parametro en la posicion  " + i + ". "
                + "El parametro esperado es de tipo: " + f.getParams().get(i).tipo.toString() + 
                " , el parametro  recibido es de tipo: " + argumentos.get(i).tipo.toString());
                Programa.okTipos = false;
            }
        }
    }

    @Override
    public void generaCodigo() {

        // Copia los argumentos aqui a memoria
        Programa.codigo.println("get_global $SP"); // Posicion memoria
        Programa.codigo.println("i32.const " + 8); //  + lo que ocupa mp y sp
        Programa.codigo.println("i32.add");
        Programa.codigo.println("set_local $temp"); // temp guarda el comienzo de memoria de la funcion
        int delta = 0;
        for (E argumento: argumentos){
            Programa.codigo.println(";; Copiando argumento: " + argumento); 
            if (argumento.isBasica()){ // para a = 3 + 2;
                Programa.codigo.println("i32.const " + delta); 
                Programa.codigo.println("get_local $temp"); 
                Programa.codigo.println("i32.add");
                argumento.generaCodigo();
                Programa.codigo.println("i32.store");
            } else {
                // Para a = t; (t es un struct)
                argumento.calcularDirRelativa();
                Programa.codigo.println("i32.const " + delta);
                Programa.codigo.println("get_local $temp");
                Programa.codigo.println("i32.add");
                Programa.codigo.println("i32.const " + argumento.getTipo().getTam());
                Programa.codigo.println("call $copyn"); // src dest tam
            }

            delta += argumento.getTipo().getTam();
        }
        // for (E argumento: argumentos){
        //     argumento.generaCodigo();
        // }
        Programa.codigo.println("call $" + nombre);
    }
}
