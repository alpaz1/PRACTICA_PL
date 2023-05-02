package ast.Instructions;

import java.util.List;

import ast.Programa;
import ast.Accesos.Acceso;
import ast.Expresions.E;

public class Switch extends Bloque{
    private E exp;
    private List<CasoSwitch> casos;
    private CasoSwitch porDefecto;
    private boolean hayPorDefecto = false;

    public Switch(E var, List<CasoSwitch> casos){
        super();
        this.exp = var;
        this.casos = casos;
        this.instList = casos;
    }
    public Switch(E var, List<CasoSwitch> casos, CasoSwitch def){
        super();
        this.hayPorDefecto = true;
        this.exp = var;
        this.casos = casos;
        this.instList = casos;
        this.porDefecto = def;
    }

    public void generaCodigo(){
        exp.generaCodigo(); // evaluo la condicion 
        if(exp instanceof Acceso){
            Programa.codigo.println("i32.load"); // si es acceso, obtengo su valor
        }
        Programa.codigo.println("set_local $temp"); // guardo la condicion en temp

        Programa.codigo.println("block $break"); // block etiqueta en end para saltar cuando entre en un caso con break
        for (CasoSwitch caso : casos){
            Programa.codigo.println("block ;; un caso");
        }
        if (hayPorDefecto)
            Programa.codigo.println("block ;; caso default");
        for (CasoSwitch caso : casos){
            caso.generaCodigo(); // lo primero que haré despues de end es dejar en la cima de la pila el valor de la exp
            Programa.codigo.println("set_local $temp"); // guardo la condicion en temp que dejé en la cima para recuperar
        }
        if (hayPorDefecto){
            porDefecto.generaCodigo();
            Programa.codigo.println("set_local $temp");
        }

        Programa.codigo.println("end ;; para salir del switch con break");
        //Programa.escribir.println("drop"); // para quitar de la cima el valor
    }

    public void vincular(){
        exp.vincular();
        Programa.pila.abreBloque();
        
        for(CasoSwitch caso : casos){
            caso.vincular();
        }
        
        if(hayPorDefecto) porDefecto.vincular();
        Programa.pila.cierraBloque();
    }

    public void checkType(){
        exp.checkType();
       // System.out.println(exp + exp.kindExp().toString());
        for(CasoSwitch caso:casos){
            caso.checkType();  
            if(caso.getTipo()!=null && !caso.getTipo().toString().equals(exp.tipo.toString())){
                System.out.println("Error tipo: caso switch " + exp + "(condicion: "+ exp.tipo + ", caso: " + caso.getTipo()+")"); 
                Programa.okTipos = false;
            }         
        }
        if(hayPorDefecto) porDefecto.checkType();
    }

    public KindInstruction kind() {
        return KindInstruction.SWITCH;
    }
    
    public String toString() {
        return "Switch (Condición: " + exp.toString() + ", Casos:" +casos.toString()+ ")";
    }

}
