
package ast.Estructuras;

import ast.Expresions.Const;
import ast.Expresions.E;
import ast.Expresions.ExpArray;
import ast.Instructions.Instruccion;
import ast.Instructions.KindInstruction;
import ast.Types.BasicTypes;
import ast.Types.KindTypes;
import ast.Types.Types;

import java.util.ArrayList;
import java.util.List;

import ast.ASTNode;
import ast.Programa;

public class Declaracion extends Instruccion {

    protected String nombre;
    private E exp = null;

    public Declaracion(Types tipo, String nombre) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Declaracion(Types tipo, String nombre, E valor) {
        this.nombre = nombre;
        this.exp = valor;
        this.tipo = tipo;
    }

    public Types getTipo() {
        return this.tipo;
    }

    public String getName() {
        return this.nombre;
    }

    public void vincular() {
        // Tenemos un buscaId particular para este caso
        // Va a permitir de declarar con un mismo identificador siempre y cuado no se
        // haya declarado uno con el
        // mismo name en ese bloque
        ASTNode nodo = Programa.pila.buscaIdCima(nombre);
        if (nodo == null) { // devuelve null cuando no esta
            Programa.pila.insertaId(nombre, this);
            setDelta(); // posicion relativa al bloque
            if (exp != null)
                exp.vincular();
        } else {
            System.out.println("Error vinculacion: Este identificador ya esta usado: " + nombre);
            Programa.okVinculacion = false;
        }
    }

    public String toString() {
        String out;
        if (exp != null) {
            out = tipo.toString() + " " + nombre + " = " + exp.toString();
        } else {
            out = tipo.toString() + " " + nombre;
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
                            System.out.println("Error tipo: Declaracion " + tipo + " " + nombre + " = " + exp + "("
                                    + this.tipo + "," + exp.tipo + ")");
                            Programa.okTipos = false;
                        }
                        // System.out.println(exp);
                    } else {

                        System.out.println("Error tipo: Declaracion " + tipo + " " + nombre + " = " + exp + "(" + this.tipo
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
                System.out.println("Error tipo: Declaracion " + tipo + " " + nombre + " = " + exp + "(" + this.tipo + ","
                        + exp.tipo + ")");
                Programa.okTipos = false;
            }
            // else System.out.println("tipo OK");
        }
    }

    @Override
    public void generaCodigo() {

        if(exp instanceof ExpArray){
            int i = 0;
            for(E e: ((ExpArray)exp).getListaConst()){
                Programa.codigo.println(";;Inicio declaracion " + nombre);

                Programa.codigo.println("i32.const " + delta);
                Programa.codigo.println("get_local $localsStart");
                Programa.codigo.println("i32.add");
                Programa.codigo.println("i32.const " + i*e.tipo.getTam());
                ++i;
                Programa.codigo.println("i32.add");

                
                e.generaCodigo();
                
                Programa.codigo.println("i32.store"); // Guarda exp en la posicion localsStart + delta
                Programa.codigo.println(";;Fin declaracion " + nombre);
            }
        }
        else if (exp != null) {
            Programa.codigo.println(";;Inicio declaracion " + nombre);

            Programa.codigo.println("i32.const " + delta);
            Programa.codigo.println("get_local $localsStart");
            Programa.codigo.println("i32.add");

            exp.generaCodigo();
            // if (exp instanceof Acceso) {
            //     Programa.codigo.println("i32.load"); // devuelve direccion
            // }
            Programa.codigo.println("i32.store"); // Guarda exp en la posicion localsStart + delta
            Programa.codigo.println(";;Fin declaracion " + nombre);
        }
    }

    @Override
    public int maxMemoria() {
        return tipo.getTam(); // (sizeof int = 4) arrays de enteros y enteros
    }

    @Override
    public KindInstruction kind() {
        return KindInstruction.DECLARACION;
    }

}
