package ast.Estructuras.clases;

import java.util.ArrayList;
import java.util.List;

import ast.Estructuras.Funcion;

public class Metodo {
    private PrivacyMode modo;
    private Funcion fun;

    private List<Atributo> atributos = new ArrayList<Atributo>();

    public void addAtr(Atributo a){
        this.atributos.add(a);
    }

    public Metodo(PrivacyMode modo, Funcion fun){
        this.modo = modo;
        this.fun = fun;
    }

    public String toString() {
        return "("+ this.modo.toString()+")"+this.fun.toString();
    }

    public void vincular() {
      
        fun.vincular(atributos);

    }

    public PrivacyMode getPrivacyMode() {
        return this.modo;
    }
}
