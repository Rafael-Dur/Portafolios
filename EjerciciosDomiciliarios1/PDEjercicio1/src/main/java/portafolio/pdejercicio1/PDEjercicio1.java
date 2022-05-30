/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package portafolio.pdejercicio1;


/**
 *
 * @author Administrador
 */
public class PDEjercicio1 {

    public static void main(String[] args) {
//Ejercicio domiciliario 1:

        TArbolBB<String> abb = new TArbolBB<>();
        abb.insertar("15", "Raíz");
        abb.insertar("13", "Hijo izquierdo de 15");
        abb.insertar("11", "Hijo izquierdo de 13");
        abb.insertar("14", "Hijo derecho de 13");
        abb.insertar("20", "Hijo derecho de 15");
        abb.insertar("16", "Hijo izquierdo de 20");
        abb.insertar("21", "Hijo derecho de 20");
        abb.insertar("22", "Hijo derecho de 20");
        
        boolean respuesta=abb.insertar("11", "nodo");
        if(!respuesta)
        {
            System.out.println("Funciona");
        }
        System.out.println("Altura: "+ abb.altura());
        System.out.println("Tamaño: "+ abb.tamanio());
        System.out.println("Hojas: "+ abb.hojas());
        System.out.println("Nodos internos: " + abb.internos());
        System.out.println("Nodos internos completos: " + abb.completos());
        System.out.println("Nodos en nivel 2: " + abb.enNivel(2));    
    }
}
