package ast;

import java.util.*;
import java.io.*;

public class Programa extends ASTNode {

    // ATRIBUTOS CONSTRUCTOR -----------------------------------------------------------------
    private DefinitionsList definiciones; // Structs, enums y funciones
    //private Fmain fmain; // Funcion main del programa

    
    public static Boolean okTipos;

    

    public Programa(DefinitionsList l){//, Fmain fmain) {
        this.definiciones = l;
        //this.fmain = fmain;
        
    }
    
    

    // AST ToString -----------------------------------------------------------------
    public String toString() {
        return definiciones.toString(); //+ "\nFuncion Main: " + fmain.toString();
    }

}