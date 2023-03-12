#!/bin/bash

# Run jflex to generate the lexer
java -cp jflex.jar jflex.Main ejemplo.l

# Move analizadorLexicoTiny.java into the alex folder
mv analizadorLexicoTiny.java alex/

# Compile the generated Java files
javac alex/*.java

# Run the Main class with input.txt as the argument
java alex.Main input.txt