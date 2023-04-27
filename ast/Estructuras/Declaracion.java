
package ast.Estructuras;

import ast.Expresions.Const;
import ast.Expresions.E;
import ast.Expresions.ExpArray;
import ast.Instructions.Instruccion;
import ast.Instructions.KindInstruction;
import ast.Types.BasicTypes;
import ast.Types.KindTypes;
import ast.Types.Types;
import ast.ASTNode;
import ast.Programa;
import ast.Accesos.AccesoVar;

public class Declaracion extends Instruccion {

    protected String name;
    private E exp = null;

    public Declaracion(Types tipo, String name) {
        this.name = name;
        this.tipo = tipo;
    }

    public Declaracion(Types tipo, String name, E valor) {
        this.name = name;
        this.exp = valor;
        this.tipo = tipo;
    }

    public Types getTipo() {
        return this.tipo;
    }

    public String getName() {
        return this.name;
    }

    public void vincular() {
        // Tenemos un buscaId particular para este caso
        // Va a permitir de declarar con un mismo identificador siempre y cuado no se
        // haya declarado uno con el
        // mismo name en ese bloque
        ASTNode nodo = Programa.pila.buscaIdCima(name);
        if (nodo == null) { // devuelve null cuando no esta
            // System.out.println("Vinculando " + name);
            Programa.pila.insertaId(name, this);
            if (exp != null)
                exp.vincular();
        } else {
            System.out.println("Error vinculacion: Este identificador ya esta usado: " + name);
            Programa.okVinculacion = false;
        }
    }

    public String toString() {
        String out;
        if (exp != null) {
            out = tipo.toString() + " " + name + " = " + exp.toString();
        } else {
            out = tipo.toString() + " " + name;
        }
        return out;
    }

    public void checkType() {
        // El tipo de la parte izquierda es this.tipo
        // tipo.chequea();

        // ESTO ES SOLO PARA TRATAR LOS ENUMERADOS
        Types t = this.tipo;

        while (exp != null && t != null) {

            if (t.kind().toString().equals("STRUCT")) {
                boolean ok = false;
                boolean isEnum = false;
                for (ASTNode nodo : Programa.definiciones.getEnumList()) {
                    // System.out.println(((EnumClass)nodo).getName());
                    // System.out.println(this.tipo.toString());
                    if (((EnumClass) nodo).getName().equals(t.toString())) {
                        // System.out.println("AQUI");

                        isEnum = true;

                        for (Const c : ((EnumClass) nodo).getCampos()) {

                            if (c.getValor().equals(exp.toString())) {
                                ok = true;
                                exp.setTipo(new BasicTypes(KindTypes.ENUM));
                                // System.out.println("tipo OK");
                                return;
                            }

                        }

                    }
                }

                if (isEnum && !ok) {
                    // System.out.println(t.kind().toString());

                    if (t.kind().toString().equals("STRUCT")) {
                        // System.out.println(t);
                        exp.checkType();
                        if (!this.tipo.toString().equals(exp.tipo.toString())) {
                            System.out.println("Error tipo: Declaracion " + tipo + " " + name + "=" + exp + "("
                                    + this.tipo + "," + exp.tipo + ")");
                            Programa.okTipos = false;
                        }
                        // System.out.println(exp);
                    } else {

                        System.out.println("Error tipo: Declaracion " + tipo + " " + name + "=" + exp + "(" + this.tipo
                                + "," + exp.tipo + ")");
                        Programa.okTipos = false;
                    }
                    return;
                }
            }

            t = t.getTipo();

        }

        if (exp != null) {
            exp.checkType();

            if (!this.tipo.toString().equals(exp.tipo.toString())) { // tipos básicos
                System.out.println("Error tipo: Declaracion " + tipo + " " + name + "=" + exp + "(" + this.tipo + ","
                        + exp.tipo + ")");
                Programa.okTipos = false;
            }
            // else System.out.println("tipo OK");

        }

    }

    @Override
    public KindInstruction kind() {
        return KindInstruction.DECLARACION;
    }

}
