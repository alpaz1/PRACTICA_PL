package ast.Expresions;

public class Const extends E {
  private String valor;
  private KindE tipo;
  public Const(String valor, KindE tipo) {
    this.tipo = tipo;
    this.valor = valor;
  }
  public KindE kind() {return tipo;}   
  public String toString() {return valor;}  
}
