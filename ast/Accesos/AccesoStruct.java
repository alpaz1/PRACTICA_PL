package ast.Accesos;

import java.util.List;

import ast.Programa;
import ast.Instructions.Declaracion;
import ast.Types.StructType;

public class AccesoStruct extends Acceso{
    protected Acceso acceso;
    protected String campo; // aceso.campo
    Declaracion campoVinculo;

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
                List<Declaracion> declaraciones = ((StructType)acceso.tipo).getCampos();
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
                    this.campoVinculo = m;
                } 
            }
        }
        else{
            System.out.println("Error tipos: Acceso Struct ");
            Programa.okTipos = false;
        }
    }

    @Override
    public void calcularDirRelativa() {
        Programa.codigo.println(";; Calculando dir relativa de " + this + " " + campoVinculo.delta);
        acceso.calcularDirRelativa();
        Programa.codigo.println("i32.const " + campoVinculo.delta );
        Programa.codigo.println("i32.add");
    }
}
