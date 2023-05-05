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

		System.out.println("------------------------ VINCULACIÓN ------------------------");
		p.vincular(); // vinculacion
		System.out.println("------------------------ TIPADO ------------------------");
		p.checkType();//tipado
		if (Programa.okVinculacion && Programa.okTipos){
			System.out.println("------------------------ GENERACION DE CODIGO ------------------------");
			p.generaCodigo();
		} else{
			System.out.println("Demasiados errores, no se puede generar codigo.");
		}
		// System.out.println(p);
	}
}
