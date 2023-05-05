package ast.Auxiliares;

import ast.Programa;
import ast.Instructions.Declaracion;
import ast.Types.KindTypes;
import ast.Types.Types;

public class Parametro extends Declaracion{
    private boolean ampersand;

    public Parametro(Types tipo, String nombre, boolean ampersand){
        super(tipo,nombre);
        this.ampersand = ampersand;
    }

    @Override
    public String toString() {
        return tipo.toString() + " " + (ampersand ? "&":"") + this.nombre;
    }

    public void respresentacionWasm() {
        if (! tipo.toString().equals("NULL")){
            Programa.codigo.print(" (param $" + nombre + " " + tipo.respresentacionWasm() +")");
        }
    }

    @Override
    public void generaCodigo() {
        Programa.codigo.println("i32.const " + delta);
        Programa.codigo.println("get_local $localsStart");
        Programa.codigo.println("i32.add");
        
        Programa.codigo.println("get_local " + "$" + nombre);
        // if (exp instanceof Acceso) {
        //     Programa.codigo.println("i32.load"); // devuelve direccion
        // }
        Programa.codigo.println("i32.store"); // Guarda exp en la posicion localsStart + delta
    }
}
