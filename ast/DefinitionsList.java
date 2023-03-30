package ast;

import java.util.*;

import ast.Estructuras.*;



public class DefinitionsList {


    private List<Definition> lista_basica;
    private List<StructClass> lista_struct;
    private List<EnumClass> lista_enum;
    private List<Funcion> lista_funcion;
    
    public DefinitionsList(){
        lista_basica = new ArrayList<Definition>();
        lista_struct = new ArrayList<StructClass>();
        lista_enum = new ArrayList<EnumClass>();
        lista_funcion = new ArrayList<Funcion>();
    }   

    // AST TOSTRING -----------------------------------------------------------------
    public String toString() {
        return  "Basicos: " + lista_basica.toString() + "\n" +
                "Enumerados: " + lista_enum + "\n" +
                "Struct: " + lista_struct.toString() + "\n" +
                "Funciones: "  + lista_funcion.toString();
    }

    // AUXILIARES -----------------------------------------------------------------


    public void addBasic(Definition s){
        lista_basica.add(s);
    }

    public void addStruct(StructClass s){
        lista_struct.add(s);
    }
    
    public void addEnum(EnumClass e){
        lista_enum.add(e);
    }
    

    public void addFuncion(Funcion f){
        lista_funcion.add(f);
    }
}