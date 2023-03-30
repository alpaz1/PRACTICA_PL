package ast.Estructuras;
import java.util.List;

import ast.Pair;
import ast.Util;
import ast.Types.KindTypes;

public class StructClass {
    private String name;
    private List<Pair<KindTypes, String>> campos;

    public StructClass(String name, List<Pair<KindTypes, String>> campos){
        this.name = name;
        this.campos = campos;
    }

    public String toString(){ // enum{a,b,c}
        return name + '{' + Util.prettify(campos) + '}';
    }
}
