package ast.Estructuras;
import java.util.List;

import ast.Util;

public class StructClass {
    private String name;
    private List<Declaracion> campos;

    public StructClass(String name, List<Declaracion> campos){
        this.name = name;
        this.campos = campos;
    }

    public String toString(){ // enum{a,b,c}
        return name + '{' + Util.prettify(campos) + '}';
    }
}
