package ast.Accesos;

public class AccesoPuntero extends Acceso{
    protected Acceso direccion;

    public AccesoPuntero(Acceso direccion) {
        this.direccion = direccion;
    }

    public String toString(){
        return "AccPtr(@" + direccion +")";
    }
}
