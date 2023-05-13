package ast.Estructuras;
import java.util.Collections;
import java.util.List;

import ast.ASTNode;
import ast.Programa;
import ast.Util;
import ast.Instructions.Alias;
import ast.Instructions.Declaracion;

public class StructClass extends ASTNode{
    private String name;
    private List<Declaracion> campos;

    public StructClass(String name, List<Declaracion> campos){
        this.name = name;
        this.campos = campos;
        Collections.reverse(this.campos);
        Programa.lista_tipos.add(this.name);
    }

    public String getName(){
        return this.name;
    }

    public String toString(){ // enum{a,b,c}
        return name + '{' + Util.prettify(campos) + '}';
    }

    @Override
    public void vincular() {
        // System.out.println("VOY A VINCULAR EL STRUCT " + name);
        ASTNode nodo = Programa.pila.buscaId(name);
        if (nodo == null) { //devuelve null cuando no esta
            Programa.pila.insertaId(name, this);
            // Para los campos de un struct, iniciamos la cuenta de 0 (pero no es un bloque)
            int structDelta = 0;
            for (Declaracion campo: campos){
                campo.delta = structDelta;
                structDelta += campo.getTipo().getTam();
            }
            // System.out.println("YA HE ACABADO, EL DELTA DE ESTE STRUCT ES: " +structDelta);

        } else {
            System.out.println("Error vinculacion: Este identificador ya esta usado: " + name);
            Programa.okVinculacion = false;
        }
    }

    public void checkType(){
        for(Declaracion dec:campos){
            dec.checkType();
        }
    }

    public List<Declaracion> getCampos(){
        return this.campos;
    }

    public void simplifyAlias(List<Alias> lista_alias){
        for (Declaracion d: campos)
            d.simplifyAlias(lista_alias);
    }

}
