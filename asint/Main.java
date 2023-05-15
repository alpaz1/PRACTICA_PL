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

		try {
			p.simplifyAlias();
			System.out.println("------------------------ AST ------------------------");
			System.out.println(p);
			System.out.println("------------------------ VINCULACIÓN ------------------------");
			p.vincular(); // vinculacion
			if (! Programa.okVinculacion) {
				System.out.println("Ha ocurrido algún error en vinculación");
				System.exit(0);
			}
			System.out.println("------------------------ TIPADO ------------------------");
			p.checkType(); // tipado
			if (Programa.okVinculacion && Programa.okTipos){
				System.out.println("------------------------ GENERACION DE CODIGO ------------------------");
				p.generaCodigo();
			} 	else{
				System.out.println("Demasiados errores, no se puede generar codigo.");
			}
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Se han detectado errores sintácticos, debe corregirlos para poder compilar el código");
		}
		
	}
}
