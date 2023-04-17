package ast.Expresions;

import java.util.ArrayList;

public class Lee extends LlamadaFunExp {
    
    public Lee() {
        super("lee", new ArrayList<E>());
    }

    public String toString() {
        return "Leer";
    }

    public void vincular() {}
}
