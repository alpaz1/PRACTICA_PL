package ast;

public class EBin extends E {
   private E opnd1;
   private E opnd2;
   private KindE tipo;
   public EBin(E opnd1, E opnd2, KindE tipo) {
     this.opnd1 = opnd1;
     this.opnd2 = opnd2;
     this.tipo = tipo;
   }
   public E opnd1() {return opnd1;}
   public E opnd2() {return opnd2;}
   public KindE kind() {return tipo;}
   public String toString() {return tipo.toString()+"("+opnd1().toString()+","+opnd2().toString()+")";}
}
