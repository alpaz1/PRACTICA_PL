package ast.Types;

public class BasicTypes extends Types {

    private KindTypes tipo;

    public BasicTypes(KindTypes tipo) {
        this.tipo = tipo;
    }

    @Override
    public KindTypes kind() {
        return this.tipo;
    }

    @Override
    public String toString() {
        return tipo.toString();

    }

    @Override
    public int getTam() {
        int tam = 0;
        switch (tipo) {
            case INT:
                tam = 4;
                break;
            case FLOAT:
                tam = 4;
                break;
            case BOOL:
                tam =4;
                break;
            // case VOID:

            //     break;
            // case ARRAY:

            //     break;
            default:
                tam = 0;
                break;
            // case STRUCT:

            //     break;
            // case POINTER:

            //     break;
            // case CONSTRUCTOR:

            //     break;
            // case ENUM:

            //     break;
            // case ERROR:

            //     break;
            // case NULL:

            //     break;
        }

        return tam;
    }

}
