package ast.Estructuras.clases;

import java.util.ArrayList;
import java.util.List;

import ast.ASTNode;
import ast.Estructuras.Funcion;
import ast.Instructions.Alias;

public class Metodo extends ASTNode {
    private PrivacyMode modo;
    private Funcion fun;

    private List<Atributo> atributos = new ArrayList<Atributo>();

    public void addAtr(Atributo a){
        this.atributos.add(a);
    }

    public Metodo(PrivacyMode modo, Funcion fun){
        this.modo = modo;
        this.fun = fun;
    }

    @Override
    public String toString() {
        return "("+ this.modo.toString()+")"+this.fun.toString();
    }

    @Override
    public void vincular() {
        fun.vincular(atributos);
    }

    @Override
    public void checkType() {
        fun.checkType();
    }

    public PrivacyMode getPrivacyMode() {
        return this.modo;
    }

    public void simplifyAlias(List<Alias> lista_alias){
        fun.simplifyAlias(lista_alias);
    }
}
