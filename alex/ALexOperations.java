package alex;

import asint.ClaseLexica;

public class ALexOperations {
  private AnalizadorLexicoTiny alex;
  public ALexOperations(AnalizadorLexicoTiny alex) {
   this.alex = alex;   
  }
  public UnidadLexica unidadId() {
   return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.IDEN,
                                       alex.lexema()); 
   } 
   public UnidadLexica unidadTipoInt() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.TIPOINT); 
   }
   public UnidadLexica unidadTipoBool() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.TIPOBOOL); 
   }
   public UnidadLexica unidadTipoFloat() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.TIPOFLOAT); 
   }
   public UnidadLexica unidadTipoVoid() {
   return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.VOID); 
   }
   public UnidadLexica unidadTipoEnum() {
   return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.ENUM); 
   } 
   public UnidadLexica unidadEnt() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.ENT,alex.lexema()); 
   } 
   public UnidadLexica unidadReal() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.REAL,alex.lexema()); 
   } 
   public UnidadLexica unidadTrue() {
      return new UnidadLexica(alex.fila(),alex.columna(), ClaseLexica.TRUE);
   }
   public UnidadLexica unidadFalse() {
      return new UnidadLexica(alex.fila(),alex.columna(), ClaseLexica.FALSE);
   }
   public UnidadLexica unidadSuma() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MAS); 
   } 
   public UnidadLexica unidadResta() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MENOS); 
   } 
   public UnidadLexica unidadMul() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.POR); 
   } 
   public UnidadLexica unidadDiv() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.DIV); 
   }
   public UnidadLexica unidadMod() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MOD); 
   }
   public UnidadLexica unidadMayor() {
   return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.MAYOR);
   }
   public UnidadLexica unidadMenor() {
   return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.MENOR);
   }
   public UnidadLexica unidadMayorIgual() {
   return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.MAYORIGUAL);
   }
   public UnidadLexica unidadMenorIgual() {
   return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.MENORIGUAL);
   }
   public UnidadLexica unidadDistinto() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.DISTINTO);
   }
   public UnidadLexica unidadIgualdad() {
   return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.IGUALDAD);
   }
   public UnidadLexica unidadAnd() {
   return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.AND);
   } 
   public UnidadLexica unidadOr() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.OR);
   }
   public UnidadLexica unidadNegacion() {
   return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.NEGACION);
   }
   public UnidadLexica unidadPAp() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PAP); 
   } 
   public UnidadLexica unidadPCierre() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PCIERRE); 
   }
   public UnidadLexica unidadCAp() {
   return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.CAP); 
   } 
   public UnidadLexica unidadCCierre() {
   return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.CCIERRE); 
   }
   public UnidadLexica unidadLLAp() {
   return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.LLAP); 
   } 
   public UnidadLexica unidadLLCierre() {
   return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.LLCIERRE); 
   }  
   public UnidadLexica unidadIgual() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.IGUAL); 
   } 
   public UnidadLexica unidadComa() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.COMA); 
   }
   public UnidadLexica unidadPuntoYComa() {
   return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PUNTOYCOMA); 
   }
   public UnidadLexica unidadNew() {
   return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.NEW);
   }
   public UnidadLexica unidadWhile() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.WHILE);
   }
   public UnidadLexica unidadFor() {
   return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.FOR);
   }
   public UnidadLexica unidadIf() {
   return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.IF);
   }
   public UnidadLexica unidadElse() {
   return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.ELSE);
   }
   public UnidadLexica unidadStruct() {
   return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.STRUCT);
   }
   public UnidadLexica unidadSwitch() {
   return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.SWITCH);
   }
   public UnidadLexica unidadCase() {
   return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.CASE);
   }
   public UnidadLexica unidadBreak() {
      return new UnidadLexica(alex.fila(),alex.columna(), ClaseLexica.BREAK);
   }
   public UnidadLexica unidadDefault() {
   return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.DEFAULT);
   }
   public UnidadLexica unidadReturn() {
   return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.RETURN);
   }
   public UnidadLexica unidadPrint() {
   return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.PRINT);
   }
   public UnidadLexica unidadRead() {
   return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.READ);
   }
   public UnidadLexica unidadMain() {
   return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.MAIN);
   }
   public UnidadLexica unidadEof() {
      return new UnidadLexica(alex.fila(),alex.columna(),ClaseLexica.EOF); 
   }

   public UnidadLexica unidadUnversand(){
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.UNVERSAND);
   }

   public UnidadLexica unidadAlmohadilla(){
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.ALMOHADILLA);
   }

   public UnidadLexica unidadInclude(){
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.INCLUDE);
   }

   public UnidadLexica unidadComillasDobles(){
      return new UnidadLexica(alex.fila(),  alex.columna(), ClaseLexica.COMILLASDOBLES);
   }

   public UnidadLexica unidadPunto(){
      return new UnidadLexica(alex.fila(),  alex.columna(), ClaseLexica.PUNTO);
   }

   public UnidadLexica unidadDosPuntos(){
      return new UnidadLexica(alex.fila(),  alex.columna(), ClaseLexica.DOSPUNTOS);
   }

   public void error() {
   System.err.println("***"+alex.fila()+", "+alex.columna()+" Caracter inesperado: "+alex.lexema());
   }
}
