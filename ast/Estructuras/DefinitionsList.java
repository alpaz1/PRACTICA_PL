package ast.Estructuras;

import java.util.*;

import ast.Estructuras.clases.*;
import ast.Instructions.Alias;
import ast.Auxiliares.Modulo;

public class DefinitionsList {


    private List<Declaracion> lista_basica;
    private List<StructClass> lista_struct;
    private List<EnumClass> lista_enum;
    private List<Funcion> lista_funcion;
    private List<Clase> lista_clases;
    private List<Modulo> lista_modulos;
    private List<Alias> lista_alias;
    
    List<EnumClass> getEnumList(){
        return this.lista_enum;
    }

    public DefinitionsList(){
        lista_basica = new ArrayList<Declaracion>();
        lista_struct = new ArrayList<StructClass>();
        lista_enum = new ArrayList<EnumClass>();
        lista_funcion = new ArrayList<Funcion>();
        lista_clases = new ArrayList<Clase>();
        lista_modulos = new ArrayList<Modulo>();
        lista_alias = new ArrayList<Alias>();
    }   

    public void vincular() {
        for (Declaracion d: lista_basica)
            d.vincular();
        for (StructClass s: lista_struct)
            s.vincular();
        for (EnumClass e: lista_enum)
            e.vincular();
        for (Funcion f: lista_funcion)
            f.vincular();
        for (Clase c: lista_clases)
            c.vincular();
        for (Alias a: lista_alias)
            a.vincular();
        for (Modulo m: lista_modulos)
            m.vincular();
    }

    // AST TOSTRING -----------------------------------------------------------------
    public String toString() {
        return  "Modulos: " + lista_modulos.toString() + "\n" +
                "Basicos: " + lista_basica.toString() + "\n" +
                "Alias: " + lista_alias.toString() + "\n" +
                "Enumerados: " + lista_enum + "\n" +
                "Struct: " + lista_struct.toString() + "\n" +
                "Funciones: "  + lista_funcion + "\n" +
                "Clases: " + lista_clases.toString();
    }

    // AUXILIARES -----------------------------------------------------------------

    public void addBasic(Declaracion s){
        lista_basica.add(0,s);
    }

    public void addAlias(Alias a){
        lista_alias.add(0,a);
    }

    public void addStruct(StructClass s){
        lista_struct.add(0,s);
    }
    
    public void addEnum(EnumClass e){
        lista_enum.add(0,e);
    }
    
    public void addFuncion(Funcion f){
        lista_funcion.add(0,f);
    }
    public void addClase(Clase c){
        lista_clases.add(0,c);
    }
    public void addModulo(Modulo m){
        lista_modulos.add(0,m);
    }

}