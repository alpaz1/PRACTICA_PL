package ast.Expresions;

import ast.Programa;
import ast.Types.PointerType;
import ast.Types.Types;

public class ExpNew extends E {

    Types tipoBase;

    public ExpNew(Types t){
        this.tipoBase = t;
        this.tipo = new PointerType(t);
    }


    public String toString() {
        return "new " + tipoBase.toString();
    }


    public KindE kindExp() {
        return KindE.NEW;
    }

    @Override
    public void generaCodigo(){
        Programa.codigo.println("i32.const " + tipoBase.getTam());
        Programa.codigo.println("call $reserveHeap");
        Programa.codigo.println("get_global $NP");
        
    }

    public void checkType() {

    }



    public void vincular() {
        Types aux = this.tipo;
        while (aux.getTipo() != null)
            aux = aux.getTipo();
        boolean encontrado = false;
        for (String s: Programa.lista_tipos) {
            if (aux.toString().equals(s) || aux.toString().equals(s + "*"))
                encontrado = true;
        }
        // SI NO HEMOS ENCONTRADO ES UN IDENTIFICADOR NO RECONOCIDO
        if (!encontrado){
            System.out.println("Error vinculacion: Identificador no reconocido: " + aux.toString());
            Programa.okVinculacion = false;
        }
    }
    
}
