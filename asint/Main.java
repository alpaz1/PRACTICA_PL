package asint;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import alex.AnalizadorLexicoTiny;
import ast.Programa;

public class Main {
	private static String getNameFromPath(String path){
		File archivo = new File(path);

		String nombreArchivo = archivo.getName(); // Obtiene el nombre del archivo

		// Elimina la extensión del archivo
		int posExtension = nombreArchivo.lastIndexOf(".");
		if (posExtension > 0) {
			nombreArchivo = nombreArchivo.substring(0, posExtension);
		}
		return nombreArchivo;
	}

	public static void main(String[] args) throws Exception {
		String nombreArchivo = getNameFromPath(args[0]);
		Reader input = new InputStreamReader(new FileInputStream(args[0]));
		AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
		AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(alex);
		

		Programa p = (Programa) asint.parse().value;
		p.setFilename(nombreArchivo);

		try {
			p.simplifyAlias();
			System.out.println("------------------------ AST ------------------------");
			System.out.println(p);
			System.out.println("------------------------ VINCULACIÓN ------------------------");
			p.vincular(); // vinculacion
			if (! Programa.okVinculacion) {
				System.out.println("Ha ocurrido algún error en vinculación");
				System.exit(1);
			}
			System.out.println("------------------------ TIPADO ------------------------");
			p.checkType(); // tipado
			if (! Programa.okTipos){
				System.out.println("Demasiados errores, no se puede generar codigo.");
				System.exit(2);
			} 
			System.out.println("------------------------ GENERACION DE CODIGO ------------------------");
			p.generaCodigo();
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Se han detectado errores sintácticos, debe corregirlos para poder compilar el código");
			System.exit(3);
		}
		
	}
}
