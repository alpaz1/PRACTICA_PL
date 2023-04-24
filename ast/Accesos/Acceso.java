package ast.Accesos;

import ast.Expresions.E;
import ast.Expresions.KindE;

public abstract class Acceso extends E{

    public Acceso() {}

    public KindE kindExp() {
       return KindE.ACCESS;
    }

    public abstract void vincular();
    
}
