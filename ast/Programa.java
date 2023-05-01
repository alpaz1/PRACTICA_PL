package ast;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    public static PrintWriter codigo;
    
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

    public int maxMemoria(){
        int tam = 0;
        return tam;
    }

    public void generaCodigo() {
        try {
            codigo = new PrintWriter(new FileWriter("codigo/codigo.wat"));
            FileReader preludio = new FileReader("codigo/preludio.wat");
            preludio.transferTo(codigo);
            preludio.close();

            // definiciones.generaCodigo();
            fmain.generaCodigo();
            
            FileReader epilogo = new FileReader("codigo/epilogo.wat");
            epilogo.transferTo(codigo);
            epilogo.close();

            codigo.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // AST ToString -----------------------------------------------------------------
    public String toString() {
        return definiciones.toString() + "\nFuncion Main: " + fmain.toString();
    }

}