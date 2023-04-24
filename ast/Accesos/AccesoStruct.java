package ast.Accesos;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkType'");
    }
}
