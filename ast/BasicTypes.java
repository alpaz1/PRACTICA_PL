package ast;

public class BasicTypes  extends Types{

    private KindTypes tipo;

    public BasicTypes(KindTypes tipo){
        this.tipo = tipo;
    }

    @Override
    public KindTypes kind() {
        return this.tipo;
    }
    
    public String toString() {
        return tipo.toString();

    }
}
