package ast.Accesos;

import ast.Expresions.E;
import ast.Expresions.KindE;

public class Acceso extends E{

    public Acceso() {}

    public KindE kind() {
       return KindE.ACCESS;
    }
    
}
