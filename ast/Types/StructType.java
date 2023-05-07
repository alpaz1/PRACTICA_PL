package ast.Types;

import java.util.List;

import ast.ASTNode;
import ast.Programa;
import ast.Estructuras.EnumClass;
import ast.Estructuras.StructClass;
import ast.Instructions.Declaracion;

public class StructType extends Types{

    private String nombre_tipo;
    private ASTNode campos; // Campos del struct

    public StructType(String nombre){
        this.nombre_tipo = nombre;
    }
    public KindTypes kind() {
        return KindTypes.STRUCT;
    }

    public String toString() {
        return nombre_tipo;
    }

    public String getName(){
        return this.nombre_tipo;
    }

    public List<Declaracion> getCampos() {
        // TODO: WTF
        for (StructClass nodo : Programa.definiciones.lista_struct) {
            if (nombre_tipo.equals(nodo.getName())) {
                campos = nodo;
            }
        }
        return ( (StructClass) campos).getCampos();
    }

    @Override
    public int getTam() {

        for (EnumClass e: Programa.enumList){
            if(e.getName().toString().equals(nombre_tipo.toString())){
               return 4;
     
            }

        }
        int tam = 0;
        for (Declaracion declaracion: getCampos()){
            //System.out.println(declaracion.getTipo().kind()  + " "+ declaracion.maxMemoria());
            System.out.println("El campo " + declaracion.toString() +" ocupa " + declaracion.maxMemoria());
            tam += declaracion.maxMemoria();
            System.out.println("El tamaño actual de  " + nombre_tipo +" es " + tam);
        }


        return tam;
    }
    
}
