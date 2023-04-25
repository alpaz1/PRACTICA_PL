package ast;


import java.util.ArrayList;
import java.util.List;

import ast.Estructuras.DefinitionsList;
import ast.Estructuras.EnumClass;
import ast.Estructuras.FMain;


public class Programa extends ASTNode {

    // ATRIBUTOS CONSTRUCTOR -----------------------------------------------------------------
    public static DefinitionsList definiciones; // Structs, enums y funciones
    private static FMain fmain; // Funcion main del programa
    public static PilaTablaSimbolos pila;
    
    public static boolean okTipos;
    public static boolean okVinculacion;

    public static List<EnumClass> enumList = new ArrayList<EnumClass>();


    public Programa(DefinitionsList l, FMain fmain) {
        Programa.definiciones = l;
        Programa.fmain = fmain;
        Programa.pila = new PilaTablaSimbolos();
    }
    

    public void vincular() {
        pila.abreBloque();
        definiciones.vincular();
        fmain.vincular();
        pila.print();
        pila.cierraBloque();
    }

    public void checkType(){
        definiciones.checkType();
        fmain.checkType();
    }

    // AST ToString -----------------------------------------------------------------
    public String toString() {
        return definiciones.toString() + "\nFuncion Main: " + fmain.toString();
    }

}