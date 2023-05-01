package ast.Accesos;

import ast.ASTNode;
import ast.Programa;
import ast.Estructuras.Declaracion;
import ast.Expresions.Const;
import ast.Types.BasicTypes;
import ast.Types.EnumTypes;
import ast.Types.KindTypes;
import ast.Estructuras.EnumClass;

public class AccesoVar extends Acceso {
    private String direccionInicial;
    private String nombreEnum;

    public AccesoVar(String nombreVar) {
        this.direccionInicial = nombreVar;
    }

    public String getNombreEnum() {
        return this.nombreEnum;
    }

    public void vincular() {
        ASTNode nodo = Programa.pila.buscaId(direccionInicial);
        if (nodo == null) {
            System.out.println("Error vinculacion: Intento de acceso sin declaracion: " + direccionInicial);
            Programa.okVinculacion = false;
        } else{
            this.nodoVinculo = nodo;
        }
    }

    public String toString() {
        return direccionInicial;
    }

    @Override
    public void generaCodigo() {
        // Accedemos a la posicion
        Programa.codigo.println("get_local $localsStart");//deja el valor de localsStart en la cima de la pila
        Programa.codigo.println("i32.const " + nodoVinculo.delta); //cte de valor el delta asociado al nodo
        Programa.codigo.println("i32.add"); //sumamos el valor de comienzo del bloque más el valor delta del nodo
        Programa.codigo.println("i32.load"); //deja el valor en la pila
        
    }

   

    @Override
    public void checkType() {
        if (this.nodoVinculo instanceof Declaracion) {
            this.tipo = nodoVinculo.getTipo();
        } else if (this.nodoVinculo instanceof Const) { // Si esta vinculado a un campo de un enum (Lunes), en vez de a una variable
            for (EnumClass enum_ : Programa.definiciones.getEnumList()) {
                for (Const c : enum_.getCampos()) {
                    if (c.getValor().equals(nodoVinculo.toString())) {
                        // c.setTipo(new EnumTypes(enum_.getName()));
                        nodoVinculo = c;
                    }
                }
            }
            this.tipo = nodoVinculo.getTipo();
        } else {
            boolean ok = false;
            for (EnumClass enum_ : Programa.definiciones.getEnumList()) {
                for (Const c : enum_.getCampos()) {
                    if (c.getValor().equals(direccionInicial)) {
                        ok = true;
                        nombreEnum = enum_.getName();
                        this.tipo = new BasicTypes(KindTypes.ENUM);
                        break;
                    }
                }
                if (ok)
                    break;
            }
            if (!ok) {
                System.out.println("Error tipos: acceso a variable  " + direccionInicial);
                Programa.okTipos = false;
            }
        }

    }
}
