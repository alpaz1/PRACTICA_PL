package ast.Types;

import java.util.List;

import ast.ASTNode;
import ast.Programa;
import ast.Estructuras.Declaracion;
import ast.Estructuras.StructClass;

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

    public List<Declaracion> getSusCampos() {
        for (StructClass nodo : Programa.definiciones.lista_struct) {
            if (nombre_tipo.compareTo(nodo.getName()) == 0) {
                campos = nodo;
            }
        }
        return ( (StructClass) campos).getCampos();
    }
    
}
