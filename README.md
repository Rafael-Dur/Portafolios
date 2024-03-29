# Portafolio

## UT4:


### Árboles binarios:

Un árbol binario es una estructura de datos en la cual cada nodo puede tener un hijo izquierdo y un hijo derecho. No pueden tener más de dos hijos (de ahí el nombre "binario"). Si algún hijo tiene como referencia a null, es decir que no almacena ningún dato, entonces este es llamado un nodo externo. En el caso contrario el hijo es llamado un nodo interno. 

* Ejemplo:

![image](https://user-images.githubusercontent.com/69222919/170954489-cd745a73-744b-459a-8725-47b7d3bc16bd.png)


### Árboles binarios de búsqueda:

Sea A un árbol binario de raíz R e hijos izquierdo y derecho (posiblemente nulos) HI y HD , respectivamente.

Decimos que A es un árbol binario de búsqueda (ABB) si y solo si se satisfacen las dos condiciones al mismo tiempo:

* "HI es vacío" ó ("R es mayor que todo elemento de HI" y "HI es un ABB").
* "HD es vacío" ó ("R es menor que todo elemento de HD" y "HD es un ABB").

En otras palabras, un árbol binario de búsqueda es un árbol binario que cumple con la condición de que el subárbol izquierdo contiene valores menores al valor de la raíz, mientras que el subárbol derecho debe contener valores mayores al de la raíz.

* Ejemplo: 

![image](https://user-images.githubusercontent.com/69222919/170955780-de571f5a-616a-4a3d-b855-410bb68d2bac.png)

* **Ejercicios domiciliarios 1:**

Desarrollé algoritmos para calcular la altura, el tamaño, la cantidad de hojas, la cantidad de nodos internos, cantidad de nodos completos y los nodos por nivel de un árbol binario de búsqueda.
Se realizaron casos de prueba en el main que coinciden con el boceto del árbol binario realizado en un archivo txt.

* **Ejercicios domiciliarios 2:**

Desarrollé algoritmos para obtener nodos con la clave menor y la clave mayor de un árbol, para obtener una lista de todas las hojas del árbol (listadas con su nivel correspondiente), para verificar si un árbol es o no de búsqueda y finalmente para obtener la clave inmediata anterior a una clave pasada por parámetro. 


## UT5


### Árboles AVL:

Los árboles AVL están siempre equilibrados de tal modo que para todos los nodos, la altura de la rama izquierda no difiere en más de una unidad de la altura de la rama derecha o viceversa. Gracias a esta forma de equilibrio (o balanceo), la complejidad de una búsqueda en uno de estos árboles se mantiene siempre en orden de complejidad O(log n). El factor de equilibrio puede ser almacenado directamente en cada nodo o ser computado a partir de las alturas de los subárboles.

Para conseguir esta propiedad de equilibrio, la inserción y el borrado de los nodos se ha de realizar de una forma especial. Si al realizar una operación de inserción o borrado se rompe la condición de equilibrio, hay que realizar una serie de rotaciones de los nodos.


* Ejemplo de árbol no balanceado (no es un AVL):

![image](https://user-images.githubusercontent.com/69222919/175975236-1c4c6052-2390-4909-9697-997c070a9b2c.png)

* Ejemplo de árbol balanceado (este sí es un AVL)

![image](https://user-images.githubusercontent.com/69222919/175975265-0ddd7f8f-0b61-4842-9775-d16a4d763d5e.png)



