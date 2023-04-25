package ast.Accesos;

import java.util.List;

import ast.Programa;
import ast.Estructuras.Declaracion;
import ast.Types.StructType;

public class AccesoStruct extends Acceso{
    protected Acceso acceso;
    protected String campo; // aceso.campo

    public AccesoStruct(Acceso acceso, String campo) {
        this.campo = campo;
        this.acceso = acceso;
    }

    public void vincular() {
        acceso.vincular();
        this.nodoVinculo = acceso.nodoVinculo;
    }

    public String toString(){
        return "AccStr(" + acceso+ "." + this.campo + ")";
    }

    @Override
    public void checkType() {
        acceso.checkType();
        if(acceso.tipo != null){
            if(acceso.tipo instanceof StructType){
                List<Declaracion> declaraciones = ((StructType)acceso.tipo).getSusCampos();
                Declaracion m = null;
                for (Declaracion d : declaraciones) {
                    if (d.getName().compareTo(campo) == 0){
                        m = d;
                        break;
                    } 
                }
                if (m == null) {
                    System.out.println("Error tipos: campo inexistente en el struct " + ((StructType)acceso.tipo).getName() + ": " + campo);
                    Programa.okTipos = false;
                 }
                else {
                    this.tipo = m.tipo;
                } 
            }
        }
        else{
            System.out.println("Error tipos: Acceso Struct ");
            Programa.okTipos = false;
        }
    }
}
