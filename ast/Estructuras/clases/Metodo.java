package ast.Estructuras.clases;

import ast.Estructuras.Funcion;

public class Metodo {
    private PrivacyMode modo;
    private Funcion fun;

    public Metodo(PrivacyMode modo, Funcion fun){
        this.modo = modo;
        this.fun = fun;
    }

    public String toString() {
        return "("+ this.modo.toString()+")"+this.fun.toString();
    }

    public void vincular() {
        fun.vincular();
    }

    public PrivacyMode getPrivacyMode() {
        return this.modo;
    }
}
