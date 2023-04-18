package ast.Estructuras.clases;

import java.util.ArrayList;
import java.util.List;

import ast.ASTNode;
import ast.Programa;

public class Clase extends ASTNode{
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

    public void vincular() {
        Programa.pila.abreBloque();
        for (Atributo a: atributos)
            a.vincular();
        for (Metodo m: metodos)
            m.vincular();
        for (Constructor c: constructores)
            c.vincular();
        Programa.pila.cierraBloque();
    }

    public void setName(String name){
        this.nombre = name;
    }
    public void setModo(PrivacyMode modo){
        this.modo = modo;
    }
    public void addAtrib(Atributo a) {
        atributos.add(0,a);
    }
    public void addMetodo(Metodo m) {
        metodos.add(0,m);
    }
    public void addConstr(Constructor c) {
        constructores.add(0,c);
    }

    public String toString() {
        return "Clase: " + this.nombre +"(" +this.modo.toString() +")" +"{Atributos: " + atributos.toString() + 
        ", Constructores: "+ constructores.toString() + ", Metodos: " + metodos.toString()+"}";
    }
    
}
