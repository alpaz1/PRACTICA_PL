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


        for (Constructor c: constructores){
            c.setName(nombre);
          
        }

        for (Atributo a: atributos){
            if (a.getPrivacyMode().equals(PrivacyMode.PUBLIC))
                a.vincular();
            else{
                for (Constructor c: constructores){
                    c.addAtr(a);
                    //System.out.println("AÑADIDO");
                    //System.out.println(a.toString());
                }
                for (Metodo m: metodos) {
                    if (m.getPrivacyMode().equals(PrivacyMode.PUBLIC))
                        m.addAtr(a);
                }
            }
        }
        for (Metodo m: metodos) {
            if (m.getPrivacyMode().equals(PrivacyMode.PUBLIC))
                m.vincular();
        }
        for (Constructor c: constructores){
            if (c.getPrivacyMode().equals(PrivacyMode.PUBLIC))
                c.vincular();
        }
            

        Programa.pila.abreBloque();
        for (Atributo a: atributos){
            if (a.getPrivacyMode().equals(PrivacyMode.PRIVATE))
                a.vincular();
        }
        for (Metodo m: metodos) {
            if (m.getPrivacyMode().equals(PrivacyMode.PRIVATE))
                m.vincular();
        }
        for (Constructor c: constructores){
            if (c.getPrivacyMode().equals(PrivacyMode.PRIVATE))
                c.vincular();
        }
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
