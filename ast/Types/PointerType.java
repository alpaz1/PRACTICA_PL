package ast.Types;

public class PointerType extends Types{

    protected Types tipo;

    public PointerType(Types tipo) {
        this.tipo = tipo;
    }

    public KindTypes kind() {
        return KindTypes.POINTER;
    }

    public String toString(){
        return tipo.toString() + "*";
    }    
    
}
