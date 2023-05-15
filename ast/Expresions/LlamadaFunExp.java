package ast.Expresions;

import java.util.Collections;
import java.util.List;

import ast.ASTNode;
import ast.NodeKind;
import ast.Programa;
import ast.Auxiliares.Parametro;
import ast.Estructuras.Funcion;

public class LlamadaFunExp extends E {
    protected String nombre;
    protected List<E> argumentos;
    private Funcion funcion;

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
        } else if (nodo.tipoNodo != NodeKind.FUNCION){
            System.out.println("Error vinculacion: Intento hacer llamada a identificador que no es una funcion");
            Programa.okVinculacion = false;
        }
        for(E argumento: argumentos){
            argumento.vincular();
        }
        this.nodoVinculo = nodo;
        funcion = (Funcion) nodo;
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
        if (funcion.getParams().size() != this.argumentos.size()){ // Error, != nº argumentos
            System.out.println("Error vinculación: Distinto nº de argumentos");
            Programa.okTipos = false;
        }
        for (int i = 0; i < argumentos.size(); ++i){ // el nº argumentos esta ok por vinculacion
            E argumento = argumentos.get(i);
            argumento.checkType();
            Parametro parametro = funcion.getParams().get(i);
            if(argumento.tipo.kind() != parametro.tipo.kind()){
                System.out.println("Error Tipos: Funcion " + funcion.getName() + " espera otro argumento en la posicion  " + i + ". "
                + "El argumento esperado es de tipo: " + parametro.tipo + 
                " , el argumento  recibido es de tipo: " + argumento.tipo);
                Programa.okTipos = false;
            } else if (parametro.isAmpersand() && !argumento.isInMemory()){
                System.out.println("Error Tipos: Funcion " + funcion.getName() + " espera un argumento por referencia en la posicion  " + i +
                ", el argumento recibido es de tipo: " + argumento.tipo);
                Programa.okTipos = false;
            }
        }
    }

    private void calculaPosicion(int delta){
        Programa.codigo.println("i32.const " + delta); 
        Programa.codigo.println("get_local $temp"); 
        Programa.codigo.println("i32.add");
    }

    @Override
    public void generaCodigo() {
        // Copia los argumentos aqui a memoria
        Programa.codigo.println("get_global $SP"); // Posicion memoria
        Programa.codigo.println("i32.const " + 8); //  + lo que ocupa mp y sp
        Programa.codigo.println("i32.add");
        Programa.codigo.println("set_local $temp"); // temp guarda el comienzo de memoria de la funcion
        int delta = 0;
        for (int i = 0; i < argumentos.size(); i++){
            Parametro parametro = funcion.getParams().get(i);
            E argumento = argumentos.get(i);
            Programa.codigo.println(";; Copiando argumento: " + argumento); 
            if (! argumento.isInMemory()){ 
                // Para int, bool...
                calculaPosicion(delta);
                argumento.generaCodigo();
                Programa.codigo.println("i32.store");
            } else if (parametro.isAmpersand()){
                // Argumentos por referencia
                calculaPosicion(delta);
                argumento.calcularDirRelativa();
                Programa.codigo.println("i32.store");
            }
            else {
                // Para argumentos por valor
                argumento.calcularDirRelativa();
                calculaPosicion(delta);
                Programa.codigo.println("i32.const " + (argumento.getTipo().getTam() / 4)); // getTam está en bytes no en bloques de 32 bits
                Programa.codigo.println("call $copyn"); // src dest tam
            }

            delta += argumento.getTipo().getTam();
        }
        Programa.codigo.println("call $" + nombre);
    }
}

