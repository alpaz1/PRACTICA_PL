package ast.Types;

public class EnumTypes extends Types {
    private String nombre_tipo;

    public EnumTypes(String nombre) {
        this.nombre_tipo = nombre;
    }

    public String toString() {
        return nombre_tipo;
    }

    public String getName() {
        return this.nombre_tipo;
    }

    @Override
    public KindTypes kind() {
        return KindTypes.ENUM;
    }

    @Override
    public int getTam() {
        int tam = 0;

        return tam;
    }

}
