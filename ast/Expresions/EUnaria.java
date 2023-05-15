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
