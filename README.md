# Practica de Procesadores del Lenguaje (PL)

Creación de un compilador de Ñ++ (lenguaje basado en C++) creado por Alejandro Paz, Lucas Vukotic y Enrique Queipo de Llano para la asignatura de Procesadores del Lenguaje (UCM) 
creado con Java, JLex, CUP y webassembly.

---
En la carpeta `alex` se encuentran los ficheros Java necesarios para el análisis léxico. En la carpeta `asint` ocurre lo mismo para el análisis sintáctico. Además se encuentra el fichero `Main.java`. En la carpeta `ast` se pueden encontrar todos los ficheros Java para la generación de dicho ast. Los ficheros `AnalizadorLexicoTiny.l` `Tiny.cup` se encuentra en la carpeta raíz.

Para compilar y ejecutar un ejemplo en concreto contamos con dos scrpits de Shell. En primer lugar se debe ejecutar el script `compilarCodigo.sh` seguido del archivo de ejemplo (en dirección relativa, esto es, ejemplos/archivo.txt) o con la opción -t para compilar todos. Una vez compilado, el script `ejecutarCodigo.sh` ejecutará el código webassembly generado por la última ejecución satisfactoria de `compilarCodigo.sh`

Tambien es posible compilar y ejecutar todos los ejemplos con el script `ejecutarEjemplos.sh`

En la carpeta `ejemplos` incluimos varios ficheros de prueba para las distintas funcionalidades. Las explicamos a continuación.

- `alias.txt` Funcionalidad de los alias en Ñ++. Alias definidos en términos de otros alias. Funciones definidas con tipos que son alias.
- `arrays3d.txt` Inicialización y recorrido de arrays multidimensionales.
- `bloques.txt` Uso de bloques anidados y ocultación de variables.
- `combinacionTipos.txt` Combinación de tipos definidos por el usuario. Se tiene un array de una estructura cuyos campos son enum.
- `declaraciones.txt` Uso básico de declaraciones y tipos básicos.
- `erroresSintacticos.txt` Recuperación y print de distintos errores sintácticos en definiciones e instrucciones.
- `erroresTipado.txt` Detección de errores de tipado. Recuperación y muestra de los errores en asignaciones y expresiones.
- `erroresVinculacion.txt` Detección de errores de vinculacion. Recuperación y muestra de los errores.
- `factorialIterativo.txt` Ejemplo clásico de cálculo del factorial iterativo.
- `insercionBusquedaList.txt` Paso de array a funciones por referencia. Implementación de funciones buscar e insertar sobre listas.
- `llamadasFunciones.txt` Función recursiva y llamada a una función que recibe lo que devuelve otra.
- `memDinamica.txt` Se incluye a continuación. Uso de reserva de memoria dinámica para un puntero a una estructura. Paso de punteros a funciones.
- `parametrosValorRef.txt` Paso de parámetros a funciones por valor y por referencia.
- `pointer.txt` Intercambio de valores mediante punteros. Declaracion de punteros a partir de direcciones de variables.
- `punterosStructFuncs.txt` Uso de punteros y structs sin memoria dinámica.
- `stdio.txt` Prueba de entrada/salida. Ver sección 5.8 de `Lexico y Sintaxis de Ñ++`.
- `switch.txt` Prueba del switch con y sin breaks y con y sin casos por defecto.
