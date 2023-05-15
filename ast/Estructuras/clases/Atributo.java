package ast.Estructuras.clases;
import java.util.List;

import ast.ASTNode;
import ast.Instructions.Alias;
import ast.Instructions.Declaracion;

public class Atributo extends ASTNode {
    
    private PrivacyMode modo;
    private Declaracion dec;

    public Atributo(PrivacyMode modo, Declaracion dec) {
        this.modo = modo;
        this.dec = dec;
    }
    
    public PrivacyMode getPrivacyMode() {
        return this.modo;
    }

    @Override
    public String toString() {
        return "("+ modo.toString() +")"+ dec.toString();
    }

    @Override
    public void vincular() {
        dec.vincular();
    }

    @Override
    public void checkType() {
        dec.checkType();
    }

    public void simplifyAlias(List<Alias> lista_alias){
        dec.simplifyAlias(lista_alias);
    }
}
