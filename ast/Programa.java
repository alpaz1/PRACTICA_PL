package ast;

import java.util.*;
import java.io.*;

public class Programa extends ASTNode {

    // ATRIBUTOS CONSTRUCTOR -----------------------------------------------------------------
    private DefinitionsList definiciones; // Structs, enums y funciones
    //private Fmain fmain; // Funcion main del programa

    
    public static Boolean okTipos;

    // Nombres Tipos
   // public static List<String> tipos_basicos = new ArrayList<String>();
    //public static List<EnumClass> tipos_enum = new ArrayList<EnumClass>();
    //public static List<StructClass> tipos_struct = new ArrayList<StructClass>();

    

    public Programa(DefinitionsList l){//, Fmain fmain) {
        this.definiciones = l;
        //this.fmain = fmain;
        
        /* 
        tipos_basicos.add("int");
        tipos_basicos.add("float");
        tipos_basicos.add("bool");
        tipos_basicos.add("void");
        tipos_basicos.add("char");
        tipos_basicos.add("string");
        */
    }
    
    

    // AST ToString -----------------------------------------------------------------
    public String toString() {
        return definiciones.toString(); //+ "\nFuncion Main: " + fmain.toString();
    }

}