package ast.Expresions;

import ast.Programa;
import ast.Types.Types;

public class Const extends E {

  private String valor;

  public Const(String valor, Types tipo) {
    this.tipo = tipo;
    this.valor = valor;
  }

  public String toString() {
    return valor;
  }

  public void vincular() {}

  public String getValor() {
    // se debería de cambiar a int o float segun corresponda
    return valor;
  }

  @Override
  public KindE kindExp() {
    return KindE.CONST;
  }

  @Override
  public void checkType() {
  }

  @Override
  public void generaCodigo() {
      Programa.codigo.println("i32.const " + valor);
  }
}
