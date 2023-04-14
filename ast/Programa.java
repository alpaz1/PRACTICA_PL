package ast;


import ast.Estructuras.DefinitionsList;
import ast.Estructuras.FMain;


public class Programa extends ASTNode {

    // ATRIBUTOS CONSTRUCTOR -----------------------------------------------------------------
    private DefinitionsList definiciones; // Structs, enums y funciones
    private FMain fmain; // Funcion main del programa
    public static PilaTablaSimbolos pila;
    
    public static boolean okTipos;
    public static boolean okVinculacion;

    public Programa(DefinitionsList l, FMain fmain) {
        this.definiciones = l;
        this.fmain = fmain;
        this.pila = new PilaTablaSimbolos();
    }
    

    public void vincular() {
        pila.abreBloque();
        definiciones.vincular();
        fmain.vincular();
        pila.cierraBloque();
    }

    // AST ToString -----------------------------------------------------------------
    public String toString() {
        return definiciones.toString() + "\nFuncion Main: " + fmain.toString();
    }

}