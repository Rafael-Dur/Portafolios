# Portafolio

## UT4:


### Árboles binarios:

Un árbol binario es una estructura de datos en la cual cada nodo puede tener un hijo izquierdo y un hijo derecho. No pueden tener más de dos hijos (de ahí el nombre "binario"). Si algún hijo tiene como referencia a null, es decir que no almacena ningún dato, entonces este es llamado un nodo externo. En el caso contrario el hijo es llamado un nodo interno. 

Ejemplo: ![image](https://user-images.githubusercontent.com/69222919/170954489-cd745a73-744b-459a-8725-47b7d3bc16bd.png)


### Árboles binarios de búsqueda:

Sea A un árbol binario de raíz R e hijos izquierdo y derecho (posiblemente nulos) HI y HD , respectivamente.

Decimos que A es un árbol binario de búsqueda (ABB) si y solo si se satisfacen las dos condiciones al mismo tiempo:

"HI es vacío" {\displaystyle \lor }\lor ("R es mayor que todo elemento de HI" {\displaystyle \land }\land "HI es un ABB").
"HD es vacío" {\displaystyle \lor }\lor ("R es menor que todo elemento de HD" {\displaystyle \land }\land "HD es un ABB").
Donde "{\displaystyle \land }\land" es la conjunción lógica "y", y "{\displaystyle \lor }\lor" es la disyunción lógica "o".


* **Ejercicios domiciliarios 1:**

Desarrollé algoritmos para calcular la altura, el tamaño, la cantidad de hojas, la cantidad de nodos internos, cantidad de nodos completos y los nodos por nivel de un árbol binario de búsqueda.
Se realizaron casos de prueba en el main que coinciden con el boceto del árbol binario realizado en un archivo txt.

