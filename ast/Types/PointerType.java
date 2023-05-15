package ast.Types;

public class PointerType extends Types{

    public PointerType(Types tipo) {
        this.tipo = tipo;
    }

    public KindTypes kind() {
        return KindTypes.POINTER;
    }

    public String toString(){
        return tipo.toString() + "*";
    }

    @Override
    public int getTam() {
        return 4;
    }    
}
