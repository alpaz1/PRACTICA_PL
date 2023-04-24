package ast.Expresions;

import ast.Types.KindTypes;

public class Const extends E {
  private String valor;
  public Const(String valor, KindTypes tipo) {
    this.tipo = tipo;
    this.valor = valor;
  }
  public KindTypes kind() {return tipo;}   
  public String toString() {return valor;}
  public void vincular() {}  

  public String getValor(){
    return valor;
  }
  @Override
  public KindE kindExp() {
    return KindE.CONST;
  }
  @Override
  public void checkType() {}
}
