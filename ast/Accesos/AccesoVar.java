package ast.Accesos;

public class AccesoVar extends Acceso{
    private String direccionInicial;
    
    public AccesoVar(String nombreVar){
        this.direccionInicial = nombreVar;
    }

    public String toString(){
        return direccionInicial;
    }
}
