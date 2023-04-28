# Practica de Procesadores del Lenguaje (PL)

Creación de un compilador de Ñ++ (lenguaje basado en C++) creado por Alejandro Paz, Lucas Vukotic y Enrique Queipo de Llano para la asignatura de Procesadores del Lenguaje (UCM) 
creado con Java, JLex, CUP y webassembly.

---
Por el momento solo contamos con la generación completa del AST. En la carpeta `ast` se pueden encontrar todos los ficheros Java para la generación de dicho ast. El fichero Tiny.cup se encuentra en la carpeta raíz.
Tambien se incluye un script `scriptCUP.sh` para poder probar el analizador pasando los ficheros de ejemplo.

Para ello, desde la carpeta del proyecto ejecutamos ./scriptCUP.sh ./ejemplos/input.txt
