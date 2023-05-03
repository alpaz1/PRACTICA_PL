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

    @Override
    public void vincular() {
        acceso.vincular();
        this.nodoVinculo = acceso.nodoVinculo;
        exp.vincular();
    }

    @Override
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

    @Override
    public void calcularDirRelativa(){
        Programa.codigo.println(";;AQUI ACCESO ARRAY " + this);
        Programa.codigo.println(";;AQUI COMIENZO EXP " + exp);

        exp.generaCodigo(); // indice

        Programa.codigo.println(";;AQUI FIN EXP " + exp) ;

        Programa.codigo.println("i32.const " + tipo.getTam()); // tam un elemento
        Programa.codigo.println("i32.mul");

        acceso.calcularDirRelativa();

        Programa.codigo.println("i32.add");
        Programa.codigo.println(";;AQUI FIN ARRAY " + this);
    }

    public void generaCodigo() {
        calcularDirRelativa();                    
        Programa.codigo.println("i32.load");
    }
}
