package ast.Types;

import java.util.List;

import ast.ASTNode;
import ast.Programa;
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
        int tam = 0;
        for (Declaracion declaracion: getCampos()){
            tam += declaracion.maxMemoria();
        }
        return tam;
    }
    
}
