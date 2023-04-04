package ast.Estructuras.clases;
import ast.Estructuras.Declaracion;

public class Atributo {
    
    private PrivacyMode modo;
    private Declaracion dec;

    public Atributo(PrivacyMode modo, Declaracion dec) {
        this.modo = modo;
        this.dec = dec;
    }

    public String toString() {
        return "("+ modo.toString() +")"+ dec.toString();
    }
}
