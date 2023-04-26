package ast.Expresions;

import ast.Programa;
import ast.Types.KindTypes;
import ast.Types.Types;

public class EBin extends E {
  private E opnd1;
  private E opnd2;
  private KindE tipoExp;

  public EBin(E opnd1, E opnd2, KindE tipoExp, Types tipo) {
    this.opnd1 = opnd1;
    this.opnd2 = opnd2;
    this.tipoExp = tipoExp;
    this.tipo = tipo;
  }

  public void vincular() {
    opnd1.vincular();
    opnd2.vincular();
  }

  public E opnd1() {
    return opnd1;
  }

  public E opnd2() {
    return opnd2;
  }

  public KindE kindExp() {
    return tipoExp;
  }

  public String toString() {
    return tipoExp.toString() + "(" + opnd1().toString() + "," + opnd2().toString() + ")";
  }

  @Override
  public void checkType() {
    opnd1.checkType();
    opnd2.checkType();
  
    if(this.tipo.toString().equals("NULL")){
      this.tipo = opnd1.tipo; //caso de la expresion == o !=){ 
    }

    if(((this.tipoExp.toString().equals("MENOR"))|| (this.tipoExp.toString().equals("MAYOR"))) || ((this.tipoExp.toString().equals("MENORIGUAL")) || (this.tipoExp.toString().equals("MAYORIGUAL")))){
      if(!opnd1.tipo.toString().equals("INT") || !opnd2.tipo.toString().equals("INT")){
        Programa.okTipos = false;
        System.out.println("Error tipo: expresion binaria con operadores de distinto tipo o operador no apto para los argumentos introducidos");
      }
    }

    else if(!opnd1.tipo.toString().equals(opnd2.tipo.toString()) || !opnd1.tipo.toString().equals(this.tipo.toString())){
      Programa.okTipos = false;
      System.out.println("Error tipo: expresion binaria con operadores de distinto tipo o operador no apto para los argumentos introducidos");
    }
  }

  
}
