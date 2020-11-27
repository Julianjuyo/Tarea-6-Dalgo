Tarea 6 - ISIS 1105

Julián Oliveros - je.olvierosf
Camilo Rozo     - ce.rozob

Para poder ejecutar el proyecto debe seguir los siguientes pasos.

Para Ejecutar el punto 1

1. Ejecutar la clase MVC del paquete main del proyecto.
2. Seguir los pasos que aparecen en consola.(por defecto se cargan los 3 grafos que se encuentran en la carpeta data)
3. Una vez se ejecuta el proyecto en consola aparecerá la pregunta de si desea cargar otro archivo es caso de que si responder "si".
4. Después se pidiera por la ruta del archivo se debe escribir la ruta completa de donde se encuentra el archivo.

para ejecutar los algoritmos aparecerá un menú en la consola mediante el cual se debe especificar que algoritmo ejecutar dicho menú luce de la siguiente forma

Que algoritmo desea Implementar (escriba el numero)
1. Dijkstra
2. Bellman Ford
3. Floyd Warschall


PARA DIJKSTRA
1. Escribir el número 1 en consola.
2. Indicar con el número que grafo desea cargar (En caso de querer ejecutar el grafo que cargo elija la opción 4)
3. Ahora debe indicar el vértice de Origen tenga en cuenta que este debe estar dentro del grado y debe ser un numero entre 0 y V(la cantidad de vértices)
4. Se muestran las caminos de costos mínimos junto con el tiempo que tardo el algoritmo y se devuelve a el menú principal.


PARA BELLMAN FORD
1. Escribir el número 2 en consola.
2. Indicar con el número que grafo desea cargar (En caso de querer ejecutar el grafo que cargo elija la opción 4).
3. Ahora debe indicar el vértice de Origen tenga en cuenta que este debe estar dentro del grado y debe ser un numero entre 0 y V(la cantidad de vértices).
4. Se muestran las caminos de costos mínimos junto con el tiempo que tardo el algoritmo y se devuelve a el menú principal.

PARA FLOYD WARSCHALL
1. Escribir el número 3 en consola.
2. Indicar con el número que grafo desea cargar (En caso de querer ejecutar el grafo que cargo elija la opción 4).
3. Se muestran las caminos de costos mínimos junto con el tiempo que tardo el algoritmo y se devuelve a el menú principal.

Resultados de la ejecución:

Para el archivo distances5.txt los algoritmos tardaron:

Dijkstra: 3 milisegundos
Bellman Ford: 1036 milisegundos
Floyd Warschall: 1 milisegundos

Para el archivo distances100.txt los algoritmos tardaron:

Dijkstra: 8 milisegundos
Bellman Ford: 1500 milisegundos
Floyd Warschall: 58 milisegundos 

Para el archivo distances1000.txt los algoritmos tardaron:

Dijkstra: 53 milisegundos
Bellman Ford: 1420 milisegundos
Floyd Warschall: 3975 milisegundos

Se puede concluir que Dijkstra es el algoritmo mas eficiente depures vendría Bellman Ford y por ultimo Floyd Warschall, sin embargo con un numero menor a 1000 vértices (estimado) el algoritmo de Floyd Warschall es mas eficiente el algoritmo de Bellman Ford.


Parte 2

1.  La ruta del archivo que contiene la matriz se ingresa como argumento del programa, esto funciona por ejemplo ingresando "data/distances100.txt" 
    como único argumento del programa.

2.  El archivo parte2.java tiene su propio método Main, de manera que puede ejecutarse por separado, este fue compilado y probado usando Java 8.

3.  La matriz a cargar obligatoriamente es simétrica por lo que el grafo no es dirigdo, de manera que el método que carga la matriz sólo tiene
    en cuenta los valores por debajo de la diagonal de la matriz, de esa forma es posible usar las matrices de adyacencia de los grafos dirigidos
    como si fueran no dirigidos (descartando los ejes existentes en la diagonal superior de la matriz).

Suposiciones usadas en la implementación:

1.  La matriz de carga es simétrica.
2. Se permiten usar Estructuras de datos pertenecientes a Java.util (LinkedList, Queue)

Resultados de la ejecución

1.  En consola aprecerá el texto "Los componentes conectados son:". En las siguientes líneas se verá cada componente conectado listado (contando desde 0)
    de la siguiente forma:

    Componente Conectado #n
        a	b	c	d	e	    
    Componente Conectado #n+1
        f   g   h   i   j   k

        
Parte 3

1.  La ruta del archivo que contiene la matriz se ingresa como argumento del programa, esto funciona por ejemplo ingresando "data/distances100.txt" 
    como único argumento del programa.

2.  El archivo parte3.java tiene su propio método Main, de manera que puede ejecutarse por separado, este fue compilado y probado usando Java 8.

Suposiciones usadas en la implementación:

1.  Se supone que los vertices son implícitos, es decir, la fila n de la matriz (empezando a contar desde 0) corresponde a los caminos desde el vértice n 
    y la columna n (contando desde 0) corresponde a los caminos hacia el vértice n.

2.  Debido a que matriz[v][w] indica el peso del camino desde v hasta w, y que -1 indica que no hay camino de v a w, no hay caminos con peso de -1.

3.  matriz[v][v] indica el peso del camino desde v hasta v de nuevo, lo cual instantáneamente se podría considerar como un ciclo y la pregunta de
    "Hay un ciclo en este grafo dirigido?" no tiene sentido, por lo que todas las matriz[v][v] se ignoran para el orden topológico.
    Se ignoran directamente porque suponemos que sí puede haber un caso en el cual ir de un vértice a otro no tenga costo alguno,
    es decir, un caso donde matriz[v][w] = 0 con v != w.

3.  no es obligatorio hallar exactamente cual ciclo se halló, sólo indicar si existe uno.

4.  Se permiten usar Estructuras de datos pertenecientes a Java.util (Stack)

Resultados de la ejecución

Caso 1: Hay un ciclo en el grafo

    El programa mostrará en consola el texto "Se encontró un ciclo en el grafo", y se mostrará en consola el estado de la pila de vértices en ese momento.

Caso 2: No hay ciclos en el grafo

    El programa mostrará en consola el texto "El orden topológico es: " seguido de el orden topológico del grafo de izquierda a derecha.






