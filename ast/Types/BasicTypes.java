package ast.Types;

import ast.Programa;

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
    public String respresentacionWasm() {
        String wasmTipe;
        switch (tipo) {
            case INT:
                wasmTipe = "i32";
                break;
            case FLOAT:
                wasmTipe = "f32";
                break;
            case BOOL:
                wasmTipe = "i32";
                break;
            default:
                wasmTipe = "";
                break;
        }
        return wasmTipe;
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
            default:
                tam = 0;
                break;
        }
        return tam;
    }

}
