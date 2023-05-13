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
import ast.Expresions.E;
import ast.Types.Types;


public class Programa extends ASTNode {

    // ATRIBUTOS CONSTRUCTOR -----------------------------------------------------------------
    public static DefinitionsList definiciones; // Structs, enums y funciones
    private static FMain fmain; // Funcion main del programa
    public static PilaTablaSimbolos pila;
    public static PrintWriter codigo;
    
    public static boolean okTipos = true;
    public static boolean okVinculacion = true;

    public static List<EnumClass> enumList = new ArrayList<EnumClass>();

    public static List<String> lista_tipos = new ArrayList<String>();

    public Programa(DefinitionsList l, FMain fmain) {
        Programa.definiciones = l;
        Programa.fmain = fmain;
        Programa.pila = new PilaTablaSimbolos();

        lista_tipos.add("INT");
        lista_tipos.add("BOOL");
        lista_tipos.add("FLOAT");
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

            definiciones.generaFunc();
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


    //devuelve la posicion que ocupa el valor de un enum dentro de la declaracion del enum
    public static int buscarPosEnum(Types tipoEnum, E exp) {

        for (EnumClass e: enumList){
            if(e.getName().toString().equals(tipoEnum.toString())){
                for(E valor: e.getCampos()){
                    if(valor.toString().equals(exp.toString()))
                        return e.getCampos().indexOf(valor);

                }
     
            }

        }
        return -1;
    }

    public static int comprobarSiEsValorEnum(String nombre){
        for (EnumClass e: enumList){
            for(E valor: e.getCampos()){
                if(valor.toString().equals(nombre))
                    return e.getCampos().indexOf(valor);
            }
        }
        return -1;
    }

    public void simplifyAlias(){
        Programa.definiciones.simplifyAlias();
        Programa.fmain.simplifyAlias(definiciones.getAliasList());
    }


}