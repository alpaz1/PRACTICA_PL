package ast.Estructuras;

import java.util.ArrayList;
import java.util.List;

import ast.Programa;
import ast.Auxiliares.Parametro;
import ast.Instructions.Instruccion;
import ast.Types.BasicTypes;
import ast.Types.KindTypes;

public class FMain extends Funcion{

    public FMain(List<Instruccion> instList) {
        super(new BasicTypes(KindTypes.VOID), "principal", new ArrayList<Parametro>(), instList);
    }

    @Override
    public void generaCodigo() {
        int tam = 200; // TODO: cambiar esto a lo que ocupa la funcion
        Programa.codigo.println("(func $main (type $_sig_void)");
        Programa.codigo.println(" (local $localsStart i32)");
        Programa.codigo.println(" (local $temp i32)");
        Programa.codigo.println(" i32.const " + tam); //  ;; let this be the stack size needed (params+locals+2)*4");
        Programa.codigo.println(" call $reserveStack"); // ;; returns old MP (dynamic link)");
        
        Programa.codigo.println(" set_local $temp");
        Programa.codigo.println(" get_global $MP");
        Programa.codigo.println(" get_local $temp");
        Programa.codigo.println(" i32.store"); // Guardo el MP antiguo en mp
        Programa.codigo.println(" get_global $MP");
        Programa.codigo.println(" get_global $SP"); 
        Programa.codigo.println(" i32.store offset=4"); // Guardo el SP en mp + 4
        Programa.codigo.println(" get_global $MP");
        Programa.codigo.println(" i32.const 8"); // salto el mp antiguo y el sp
        Programa.codigo.println(" i32.add");
        Programa.codigo.println(" set_local $localsStart"); // La funcion empieza aqui
        
        Programa.definiciones.generaCodigo();

        for (Instruccion instruccion: instList){
            instruccion.generaCodigo(); 
        }
        Programa.codigo.println(" call $freeStack");
        Programa.codigo.println(")");
    }
}
