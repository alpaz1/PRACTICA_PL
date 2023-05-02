package ast.Accesos;

import ast.Programa;
import ast.Expresions.E;
import ast.Types.ArrayType;

public class AccesoArray extends Acceso{
    public Acceso acceso;
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

    public void calcularDirRelativa(AccesoArray a){

        Programa.codigo.println(";;AQUI ACCESO ARRAY " + a);//deja el valor de localsStart en la cima de la pila


      
        //int tam_elem = tipo.getTam();
        Programa.codigo.println(";;AQUI COMIENZO EXP " + a.exp);//deja el valor de localsStart en la cima de la pila

        a.exp.generaCodigo(); // indice

        Programa.codigo.println(";;AQUI FIN EXP " + a.exp) ;//deja el valor de localsStart en la cima de la pila
        int tam_elem = a.tipo.getTam();

        Programa.codigo.println("i32.const " + tam_elem ); // tam un elemento
        Programa.codigo.println("i32.mul");
        Programa.codigo.println("i32.add");
        Programa.codigo.println(";;AQUI FIN ARRAY " + a);//deja el valor de localsStart en la cima de la pila

    }





    public void generaCodigo() {

        Acceso aux = this.acceso;
        Programa.codigo.println("get_local $localsStart");//deja el valor de localsStart en la cima de la pila

            while( aux instanceof AccesoArray){
                Programa.codigo.println(";;AQUI ACCESO ARRAY");//deja el valor de localsStart en la cima de la pila

                
                calcularDirRelativa(((AccesoArray)aux));
                
                aux = ((AccesoArray)aux).acceso;                

            }
            calcularDirRelativa(this);
            Programa.codigo.println("i32.load");

        
    }

    /*get_local $localsStart
i32.const 0
i32.add
i32.load
;;AQUI COMIENZO EXP 9
i32.const 9
;;AQUI FIN EXP 9
i32.const 48
i32.mul
i32.load
i32.add
;;AQUI FIN ARRAY l
;;AQUI ACCESO ARRAY AccArr(l[9])
i32.const 0
i32.add
i32.load
;;AQUI COMIENZO EXP 10
i32.const 10
;;AQUI FIN EXP 10
i32.const 4
i32.mul
i32.load
i32.add
;;AQUI FIN ARRAY AccArr(l[9]) */
}
