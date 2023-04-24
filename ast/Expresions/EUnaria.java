package ast.Expresions;

import ast.Types.KindTypes;

public class EUnaria extends E {
    protected E exp;
    private KindE tipoExp;

    public EUnaria(E exp, KindE tipoExp, KindTypes tipo) {
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
}
