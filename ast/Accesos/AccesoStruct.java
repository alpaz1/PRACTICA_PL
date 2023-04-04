package ast.Accesos;

public class AccesoStruct extends Acceso{
    protected Acceso acceso;
    protected String campo; // aceso.campo

    public AccesoStruct(Acceso acceso, String campo) {
        this.campo = campo;
        this.acceso = acceso;
    }

    public String toString(){
        return "AccStr(" + acceso+ "." + this.campo + ")";
    }
}
