#!/bin/bash

# Run jflex to generate the lexer
java -cp lib/jflex.jar jflex.Main AnalizadorLexicoTiny.l

# Move analizadorLexicoTiny.java into the alex folder while forcing rewrite
mv -f AnalizadorLexicoTiny.java alex/AnalizadorLexicoTiny.java

# Compile the generated Java files
#javac alex/*.java
javac -cp lib/cup.jar */*.java

# Run the Main class with input.txt as the argument
#java alex.Main input.txt