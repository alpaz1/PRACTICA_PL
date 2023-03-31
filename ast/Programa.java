package ast;

import java.util.*;

import ast.Estructuras.DefinitionsList;
import ast.Estructuras.Funcion;

import java.io.*;

public class Programa extends ASTNode {

    // ATRIBUTOS CONSTRUCTOR -----------------------------------------------------------------
    private DefinitionsList definiciones; // Structs, enums y funciones
    private Funcion fmain; // Funcion main del programa

    
    public static Boolean okTipos;

    public Programa(DefinitionsList l, Funcion fmain) {
        this.definiciones = l;
        this.fmain = fmain;
    }
    
    // AST ToString -----------------------------------------------------------------
    public String toString() {
        return definiciones.toString() + "\nFuncion Main: " + fmain.toString();
    }

}