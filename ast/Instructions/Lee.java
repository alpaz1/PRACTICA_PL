package ast.Instructions;

public class Lee extends Instruccion {
    
    public Lee() {}

    public KindInstruction kind() {
        return KindInstruction.READ;
    }
    public String toString() {
        return "Leer";
    }
}
