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

}
