package ast.Instructions;

import java.util.List;

public class Bloque extends Instruccion{
    public List<Instruccion> instList;

    public Bloque(){}
    public Bloque(List<Instruccion> inst){
        this.instList = inst;
    }
    
    public String toString() {
        return "Bloque {" + instList + "}";
    }

    @Override
    public KindInstruction kind() {
        return KindInstruction.BLOCK;
    }
    public void vincular() {}

}
