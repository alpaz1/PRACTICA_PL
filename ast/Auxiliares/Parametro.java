package ast.Auxiliares;

import ast.Programa;
import ast.Instructions.Declaracion;
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

    public boolean isAmpersand() {
        return ampersand;
    }

    @Override
    public void calcularDirRelativa() {
        // Accede a la posion de memoria en la que se guarda el delta de la variable a la que hace referencia
        super.calcularDirRelativa();
        if (ampersand){
            Programa.codigo.println("i32.load"); 
        }
    }
}
