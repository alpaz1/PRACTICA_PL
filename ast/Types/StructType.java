package ast.Types;

public class StructType extends Types{

    private String nombre_tipo;

    public StructType(String nombre){
        this.nombre_tipo = nombre;
    }
    public KindTypes kind() {
        return KindTypes.STRUCT;
    }

    public String toString() {
        return nombre_tipo;
    }
    
}
