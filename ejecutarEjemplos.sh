#!/bin/bash

# Creamos el analizador lexico
java -cp lib/jflex.jar jflex.Main AnalizadorLexicoTiny.l -d alex -nobak

# Generamos el analizador sintáctico con CUP
java -cp lib/cup.jar java_cup.Main -parser AnalizadorSintacticoTiny -symbols ClaseLexica -destdir asint -nopositions Tiny.cup #2> /dev/null

# Compilamos todo
find . -name "*.java" -exec javac -cp lib/cup.jar -d bin/ {} +



# A partir de aquí es output del analizador sintáctico
echo -e "\n------------------ Analizador Sintactico ------------------\n"

mkdir -p codigo/bin
i=0  
for file in ejemplos/*; do
i=$((i+1))
if [[ -r "$file" ]]; then
    echo -e "\n------------------ Compilando archivo $file ------------------\n"
    java -cp "bin:lib/*" asint.Main $file # ejecutar CUP en el archivo
    if [ "$?" -eq 0 ]; then
        nombreArchivo=$(basename "$file" | cut -f 1 -d '.')
        echo -e "\n------------------ Ejecutando archivo $file ------------------\n"
        codigo/wat2wasm "codigo/bin/$nombreArchivo.wat" -o "codigo/bin/$nombreArchivo.wasm"
        node codigo/main.js "codigo/bin/$nombreArchivo.wasm"
    fi
fi
done
exit 0

# cd codigo
# codigo/wat2wasm codigo.wat
# node main.js
# cd ..
