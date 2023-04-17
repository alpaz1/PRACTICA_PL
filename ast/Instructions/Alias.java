package ast.Instructions;

import ast.ASTNode;
import ast.Types.Types;

public class Alias extends ASTNode{

    private Types tipo;
    private String nombre;

    public Alias(String nombre, Types t){
        this.nombre = nombre;
        this.tipo = t;
    }

    public KindInstruction kind() {
        return KindInstruction.ALIAS;
    }

    public String toString() {
        return "ALIAS: " + nombre + " - " + tipo.toString();
    }

    @Override
    public void vincular() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'vincular'");
    }
    
}
