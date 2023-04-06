package ast;


import ast.Estructuras.DefinitionsList;
import ast.Estructuras.FMain;


public class Programa extends ASTNode {

    // ATRIBUTOS CONSTRUCTOR -----------------------------------------------------------------
    private DefinitionsList definiciones; // Structs, enums y funciones
    private FMain fmain; // Funcion main del programa

    
    public static Boolean okTipos;

    public Programa(DefinitionsList l, FMain fmain) {
        this.definiciones = l;
        this.fmain = fmain;
    }
    
    // AST ToString -----------------------------------------------------------------
    public String toString() {
        return definiciones.toString() + "\nFuncion Main: " + fmain.toString();
    }

}