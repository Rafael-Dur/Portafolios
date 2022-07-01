/*
 * NO LICENCE 
 * Author: Ing. Nicolás Navarro Gutérrez
 */
package ucu.edu.uy.ut5abo;

import ucu.edu.uy.tda.IArbolBB;
import ucu.edu.uy.tda.INodo;
import ucu.edu.uy.tda.Lista;
import ucu.edu.uy.tda.TArbolBB;
import ucu.edu.uy.tda.TElementoAB;
import ucu.edu.uy.util.CalculadorMatricesOptimo;
import ucu.edu.uy.util.ManejadorArchivosGenerico;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author nnavarro
 */
public class Main {

    public static void main(String[] args) {
        TArbolBB arbolBBExitos = new TArbolBB();
        TArbolBB arbolBBNoExitos = new TArbolBB();
        String[] vector = ManejadorArchivosGenerico.leerArchivo("palabras.txt");
        //vector=ManejadorArchivosGenerico.leerArchivo("nopalabras.txt");
        int[] vectorbetas = new int[vector.length];
        for (int i = 0; i < vector.length; i++) {
            String[] separado = vector[i].split(" ");

            if (separado.length > 1) {
                String palabra = separado[0];
                int frecuencia = Integer.parseInt(separado[1]);
                TElementoAB<Integer> nuevo = new TElementoAB<>(palabra, frecuencia);
                arbolBBExitos.insertar(nuevo);
                nuevo = new TElementoAB<>(palabra, vectorbetas[i]);
                arbolBBNoExitos.insertar(nuevo);
            }
        }
        
        for (int i = 0; i < vector.length; i++) {
           
            String[] parte2 = vector[i].split(" ");
            int num = Integer.parseInt(parte2[1]);
            vectorbetas[i] = num;
        }

        aleatorio(vector);
        for (String s : vector) {
            arbolBBExitos.insertar(new TElementoAB(s, s));
        }
        
        Lista<String> arbolImprimir1 = arbolBBExitos.inOrden();
        System.out.println("Claves en InOrden: ");
        System.out.println(arbolImprimir1.imprimir());

        String arbolImprimir2 = arbolBBExitos.preOrden();
        System.out.println("Claves en Pre Orden: ");
        System.out.println(arbolImprimir2);
        
        String arbolImprimir3 = arbolBBExitos.postOrden();
        System.out.println("Claves en Post Orden: ");
        System.out.println(arbolImprimir3);
        
    }

    private static void aleatorio(String[] vector) {
        Random azar = new Random();
        for (int i = 0; i < vector.length; i++) {
            int pos = azar.nextInt(vector.length);
            String aux = vector[pos];
            vector[pos] = vector[i];
            vector[i] = aux;
        }
    }
}
