package ast.Expresions;

import ast.Programa;
import ast.Types.Types;

public class EUnaria extends E {
    protected E exp;
    private KindE tipoExp;

    public EUnaria(E exp, KindE tipoExp, Types tipo) {
      this.exp = exp;
      this.tipoExp = tipoExp;
      this.tipo = tipo;
    }

    public KindE kindExp() {
        return this.tipoExp;
    }

    public String toString() {
        return this.tipoExp.toString() + "("+ this.exp.toString() + ")";
    }

  
    public void vincular() {
        this.exp.vincular();
    }

    @Override
    public void checkType() {
        this.exp.checkType();
        switch (this.tipoExp.toString()){
            case "NEG":
                if (this.exp.getTipo().toString() != "BOOL"){
                    System.out.println("Error de tipos: Negación de un no buleano");
                    Programa.okTipos = false;
                }
                break;
            case "MENOS":
                if (this.exp.getTipo().toString() != "INT"){
                    System.out.println("Error de tipos: Opuesto de un no entero");
                    Programa.okTipos = false;
                }
        }
    }

    @Override
    public void generaCodigo() {
     
     
      switch (tipoExp) {
        case NEG:
         exp.generaCodigo();
          Programa.codigo.println("i32.eqz");
          break;
        case MENOS:
          Programa.codigo.println("i32.const 0");
          exp.generaCodigo(); 
          Programa.codigo.println("i32.sub");

          break;
        default:
      }
    }
}
