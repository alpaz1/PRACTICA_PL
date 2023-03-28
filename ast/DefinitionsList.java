package ast;

import java.util.*;

import ast.Estructuras.BasicStructure;



public class DefinitionsList {


    private List<BasicStructure> lista_basica;
    //private List<StructClass> lista_struct;
    //private List<EnumClass> lista_enum;
    //private List<Funcion> lista_funcion;
    
    public DefinitionsList(){
        lista_basica = new ArrayList<BasicStructure>();
        //lista_struct = new ArrayList<StructClass>();
        //lista_enum = new ArrayList<EnumClass>();
        //lista_funcion = new ArrayList<Funcion>();
    }

    

    // AST TOSTRING -----------------------------------------------------------------
    public String toString() {
        //return "Enumerados: " + lista_enum.toString() + "\nStruct: " + lista_struct.toString() +"\nFunciones: "  + lista_funcion.toString();
        return "Basicos: " + lista_basica.toString();
    }

    // AUXILIARES -----------------------------------------------------------------


    public void addBasic(BasicStructure s){
        lista_basica.add(s);
    }

    /* 

    public void addStruct(StructClass s){
        lista_struct.add(s);
    }
    
    public void addEnum(EnumClass e){
        lista_enum.add(e);
    }
    

    public void addFuncion(Funcion f){
        lista_funcion.add(f);
    }
    */
}