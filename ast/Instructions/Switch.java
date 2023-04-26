package ast.Instructions;

import java.util.List;

import ast.Programa;
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
    }
    public Switch(E var, List<CasoSwitch> casos, CasoSwitch def){
        super();
        this.hayPorDefecto = true;
        this.exp = var;
        this.casos = casos;
        this.porDefecto = def;
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
