#!/bin/bash

java -cp ../jflex.jar jflex.Main ejemplo.l

# Compilamos el analizador sintáctico generado por CUP
java -cp ../cup.jar java_cup.Main -parser AnalizadorSintacticoTiny -symbols ClaseLexica -nopositions Tiny.cup

# Compilamos los archivos Java generados por JFlex
javac -cp "../cup.jar" ../*/*.java

# Ejecutamos el analizador sintáctico con el archivo de entrada input.txt
java -cp ".:../cup.jar" asint.Main ../input.txt