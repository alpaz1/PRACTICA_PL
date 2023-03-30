package ast.Estructuras;

public class StructClass {
    private String name;
    private KindTypes tipo;

    public Definition(String name, KindTypes tipo){
        this.name = name;
        this.tipo = tipo;
    }

    public String toString(){
        return "(" + tipo.toString() + " " + name + ")";
    }
}
