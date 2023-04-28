#!/bin/bash

input="input.txt"
if [ $# -ge 1 ]; then
    input=$1
fi


# Creamos el analizador lexico
java -cp lib/jflex.jar jflex.Main AnalizadorLexicoTiny.l

# Movemos el analizador lexico a alex
mv -f AnalizadorLexicoTiny.java alex/AnalizadorLexicoTiny.java

# Generamos el analizador sintáctico con CUP
java -cp lib/cup.jar java_cup.Main -parser AnalizadorSintacticoTiny -symbols ClaseLexica -nopositions Tiny.cup #2> /dev/null

# Movemos el analizador sintáctico a asint
mv -f AnalizadorSintacticoTiny.java asint/AnalizadorSintacticoTiny.java
mv -f ClaseLexica.java asint/ClaseLexica.java

# Compilamos todo

#javac -cp lib/cup.jar */*.java 
#find . -name "*.java" -exec javac -cp lib/cup.jar {} \;
find . -name "*.java" -exec javac -cp lib/cup.jar {} +



# A partir de aquí es output del analizador sintáctico
echo -e "\n------------------ Analizador Sintactico ------------------\n"


while getopts ":t" opt; do
  case ${opt} in
    t ) # Si se especifica la opción "-t"
      i=0  
      for file in ejemplos/*; do
        i=$((i+1))
        echo -e "\n------------------ Archivo $file ------------------\n"
        if [[ -r "$file" ]]; then
          java -cp ".:lib/*" asint.Main $file # ejecutar CUP en el archivo 
        fi
      done
      exit 0
      ;;
    \? ) echo "Opción inválida: -$OPTARG" 1>&2; exit 1;;
    : ) echo "La opción -$OPTARG requiere un argumento." 1>&2; exit 1;;
  esac
done

# Si no se proporciona ninguna opción, se ejecuta el script con una opción predeterminada
if [ $OPTIND -eq 1 ]; then
  if [ -n "$1" ]; then
    java -cp ".:lib/*" asint.Main $1 
  else
    echo "No se ha proporcionado un archivo de entrada, compilando input.txt..."
    java -cp ".:lib/*" asint.Main ejemplos/input.txt
  fi
fi

# cd codigo
# ./wat2wasm codigo.wat
# node main.js
# cd ..
