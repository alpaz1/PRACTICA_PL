package ast.Estructuras;
import java.util.List;

import ast.ASTNode;
import ast.Util;

public class EnumClass extends ASTNode{
    private String name;
    private List<String> campos;

    public EnumClass(String name, List<String> campos){
        this.name = name;
        this.campos = campos;
    }

    public String toString(){ // enum{a,b,c}
        return name + '{' + Util.prettify(campos) + '}';
    }
}
