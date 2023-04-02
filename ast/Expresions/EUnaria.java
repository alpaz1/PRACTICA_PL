package ast.Expresions;

public class EUnaria extends E {
    protected E exp;
    private KindE tipo;

    public EUnaria(E exp, KindE tipo) {
      this.exp = exp;
      this.tipo = tipo;
    }

    public KindE kind() {
        return this.tipo;
    }

    public String toString() {
        return this.tipo.toString() + "("+ this.exp.toString() + ")";
    }
}
