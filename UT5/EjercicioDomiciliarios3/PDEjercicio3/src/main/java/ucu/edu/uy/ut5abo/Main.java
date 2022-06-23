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

/**
 *
 * @author nnavarro
 */
public class Main
{

    public static void main(String[] args)
    {
        TArbolBB arbolBBExitos = new TArbolBB();
        TArbolBB arbolBBNoExitos = new TArbolBB();
        String[] vector=ManejadorArchivosGenerico.leerArchivo("palabras.txt");
        vector=ManejadorArchivosGenerico.leerArchivo("nopalabras.txt");
        int[] vectorbetas=new int[vector.length];
        for(int i=0;i<vector.length;i++)
        {
            String[] separado=vector[i].split(" ");
            String palabra=separado[0];
            int frecuencia=Integer.parseInt(separado[1]);
            TElementoAB<Integer>nuevo=new TElementoAB<>(palabra,frecuencia);
            arbolBBExitos.insertar(nuevo);
            nuevo=new TElementoAB<>(palabra,vectorbetas[i]);
            arbolBBNoExitos.insertar(nuevo);
        }
       
        
        for(int i=0;i<vector.length;i++)
        {
           vectorbetas[i]=Integer.parseInt(vector[i]);
        }
        
        
    }
}
