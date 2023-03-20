#!/bin/bash

# Creamos el analizador lexico
java -cp lib/jflex.jar jflex.Main AnalizadorLexicoTiny.l

# Movemos el analizador lexico a alex
mv -f AnalizadorLexicoTiny.java alex/AnalizadorLexicoTiny.java

# Generamos el analizador sintáctico con CUP
java -cp lib/cup.jar java_cup.Main -parser AnalizadorSintacticoTiny -symbols ClaseLexica -nopositions Tiny.cup 2> /dev/null

# Movemos el analizador sintáctico a asint
mv -f AnalizadorSintacticoTiny.java asint/AnalizadorSintacticoTiny.java

# Compilamos todo
javac -cp lib/cup.jar */*.java

# A partir de aquí es output del analizador sintáctico
echo -e "\n------------------ Analizador Sintactico ------------------\n"

# Ejecutamos el analizador sintáctico con el archivo de entrada input.txt
java -cp ".:lib/cup.jar" asint.Main input.txt