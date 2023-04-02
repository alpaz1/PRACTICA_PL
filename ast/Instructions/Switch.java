package ast.Instructions;

import ast.Expresions.E;
import java.util.List;

public class Switch extends Bloque{
    private String nombre;
    private List<CasoSwitch> casos;
    private CasoSwitch porDefecto;

    public Switch(String nombre, List<CasoSwitch> casos){
        super();
        this.nombre = nombre;
        this.casos = casos;
        this.porDefecto = null;
    }
    public Switch(String nombre, List<CasoSwitch> casos, CasoSwitch def){
        super();
        this.nombre = nombre;
        this.casos = casos;
        this.porDefecto = def;
        this.casos.add(def);
    }

    public KindInstruction kind() {
        return KindInstruction.SWITCH;
    }
    
    public String toString() {
        return "Switch (Condición: " + nombre.toString() + ", Casos:" +casos.toString()+ ")";
    }

}
