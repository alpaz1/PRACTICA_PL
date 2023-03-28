package asint;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import alex.AnalizadorLexicoTiny;
import ast.Programa;

public class Main {
   public static void main(String[] args) throws Exception {
     Reader input = new InputStreamReader(new FileInputStream(args[0]));
	 AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
	 AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(alex);
	 Programa p = (Programa) asint.parse().value;

	 System.out.println(asint.parse().value);
	/*
	 p.vincular(); // vinculamos
	  if (Programa.okVinculacion){
		  System.out.println(" -> Vinculacion correcta :)");
		 p.chequea(); // chequeamos tipos
		 if(Programa.okTipos){
			 System.out.println(" -> Comprobacion de tipos correcto :)");
			 p.calculos(); // colocamos etiquetas
			 p.maxMemoria(); // calculamos maxMem de la funcion
			 p.generaCodigo(); // generamos el codigo
			 System.out.println(" -> Codigo generado correctamente :)");
		 }
		 else System.out.println(" -> Error en comprobacion de tipos :(");
	  }
	  else{
		 System.out.println(" -> Error en vinculacion :/");
	  }
  }
	  // Funcion para sacar los lexemas de la parte lexica
	  public static void sacaLexemas(AnalizadorLexicoTiny alex) throws IOException{
		 UnidadLexica unidad;
		 do {
			unidad = (UnidadLexica) alex.next_token();
			System.out.println(unidad + " " + unidad.lexema());
		  }
		  while (unidad.clase() != ClaseLexica.EOF);
	  }
	  */
 }
}   
   

