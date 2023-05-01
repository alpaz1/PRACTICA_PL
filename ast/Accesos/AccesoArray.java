package ast.Accesos;

import ast.Programa;
import ast.Expresions.E;
import ast.Types.ArrayType;

public class AccesoArray extends Acceso{
    protected Acceso acceso;
    protected E exp;

    public AccesoArray(Acceso acceso, E exp) {
        this.exp = exp;
        this.acceso = acceso;
    }

    public void vincular() {
        acceso.vincular();
        this.nodoVinculo = acceso.nodoVinculo;
        exp.vincular();
    }

    public String toString() {
        return "AccArr(" + acceso + "[" + exp + "])";
    }

    @Override
    public void checkType() {

            
            acceso.checkType();
            exp.checkType();
    
            if (acceso.tipo == null || exp.tipo == null) {
                this.tipo = null;
            } else if (acceso.tipo instanceof ArrayType  && acceso.tipo.getTipo().toString().equals(((ArrayType) acceso.tipo).getTipo().toString())) {
                //System.out.println(acceso.tipo.getTipo().toString());
                //System.out.println(((ArrayType) acceso.tipo).getTipo().toString());

                if (exp.tipo.toString().equals("INT")) {
                    this.tipo = ((ArrayType) acceso.tipo).getTipo();
                } else {
                    System.out.println("Error tipos: Array ");
                    Programa.okTipos = false;
                }
            } 
            else {
                System.out.println("Error tipos: Array ");
                Programa.okTipos = false;
            }
        
    }


    public void generaCodigoAux(){
        Programa.codigo.println(";;AQUI ACCESO ARRAY");//deja el valor de localsStart en la cima de la pila

        Programa.codigo.println("get_local $localsStart");//deja el valor de localsStart en la cima de la pila

        Programa.codigo.println("i32.const " + acceso.nodoVinculo.delta); //cte de valor el delta asociado al nodo
        Programa.codigo.println("i32.add"); //sumamos el valor de comienzo del bloque más el valor delta del nodo
        Programa.codigo.println("i32.load"); //deja el valor en la pila
        //hasta aqui acceso a la primera posición del array

        //int tam_elem = tipo.getTam();
        Programa.codigo.println(";;AQUI COMIENZO EXP");//deja el valor de localsStart en la cima de la pila

        exp.generaCodigo(); // indice

        Programa.codigo.println(";;AQUI FIN EXP");//deja el valor de localsStart en la cima de la pila
        
        Programa.codigo.println("i32.const " + 4); // tam un elemento
        Programa.codigo.println("i32.mul");
        Programa.codigo.println("i32.load");
        Programa.codigo.println("i32.add");
        
    }

    public void generaCodigo() {

        Programa.codigo.println(";;AQUI ACCESO ARRAY");//deja el valor de localsStart en la cima de la pila

        Programa.codigo.println("get_local $localsStart");//deja el valor de localsStart en la cima de la pila

        Programa.codigo.println("i32.const " + acceso.nodoVinculo.delta); //cte de valor el delta asociado al nodo
        Programa.codigo.println("i32.add"); //sumamos el valor de comienzo del bloque más el valor delta del nodo
        Programa.codigo.println("i32.load"); //deja el valor en la pila
        //hasta aqui acceso a la primera posición del array

        //int tam_elem = tipo.getTam();
        Programa.codigo.println(";;AQUI COMIENZO EXP");//deja el valor de localsStart en la cima de la pila

        exp.generaCodigo(); // indice

        Programa.codigo.println(";;AQUI FIN EXP");//deja el valor de localsStart en la cima de la pila
        
        Programa.codigo.println("i32.const " + 4); // tam un elemento
        Programa.codigo.println("i32.mul");
        Programa.codigo.println("i32.load");
        Programa.codigo.println("i32.add");
        
        Programa.codigo.println("i32.load");


       
        
    }

}
