package ast.Instructions;

import java.util.List;

import ast.Programa;
import ast.Expresions.E;

public class Switch extends Bloque{
    private E exp;
    private List<CasoSwitch> casos;
    private CasoSwitch porDefecto;

    public Switch(E var, List<CasoSwitch> casos){
        super();
        this.exp = var;
        this.casos = casos;
        this.porDefecto = null;
    }
    public Switch(E var, List<CasoSwitch> casos, CasoSwitch def){
        super();
        this.exp = var;
        this.casos = casos;
        this.porDefecto = def;
        this.casos.add(def);
    }

    public void checkType(){
        exp.checkType();
        // los casos tienen que ser del mismo tipo que la condicion

        for(CasoSwitch caso:casos){
            caso.checkType();  
            if(caso.getTipo()!=null && !caso.getTipo().toString().equals(exp.tipo.toString())){
                System.out.println("Error tipo: caso switch " + exp + "(condicion: "+ exp.tipo + ", caso: " + caso.getTipo()+")"); 
                Programa.okTipos = false;
            }         
        }
    }

    public KindInstruction kind() {
        return KindInstruction.SWITCH;
    }
    
    public String toString() {
        return "Switch (Condición: " + exp.toString() + ", Casos:" +casos.toString()+ ")";
    }

}
