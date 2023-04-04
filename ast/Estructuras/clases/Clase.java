package ast.Estructuras.clases;

import java.util.ArrayList;
import java.util.List;

public class Clase {
    private String nombre;
    private PrivacyMode modo;
    private List<Atributo> atributos;
    private List<Metodo> metodos;
    private List<Constructor> constructores;

    public Clase() {
        atributos = new ArrayList<Atributo>();
        metodos = new ArrayList<Metodo>();
        constructores = new ArrayList<Constructor>();
    }
    public void setName(String name){
        this.nombre = name;
    }
    public void setModo(PrivacyMode modo){
        this.modo = modo;
    }
    public void addAtrib(Atributo a) {
        atributos.add(a);
    }
    public void addMetodo(Metodo m) {
        metodos.add(m);
    }
    public void addConstr(Constructor c) {
        constructores.add(c);
    }

    public String toString() {
        return "Clase: " + this.nombre +"(" +this.modo.toString() +")" +"{Atributos: " + atributos.toString() + 
        ", Constructores: "+ constructores.toString() + ", Metodos: " + metodos.toString()+"}";
    }
}
