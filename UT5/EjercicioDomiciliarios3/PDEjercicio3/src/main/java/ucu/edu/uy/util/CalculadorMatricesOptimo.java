package ucu.edu.uy.util;

import static java.sql.JDBCType.INTEGER;
import ucu.edu.uy.tda.IArbolBB;
import java.util.*;
import ucu.edu.uy.tda.IElementoAB;
import ucu.edu.uy.tda.TArbolBB;
import ucu.edu.uy.tda.TElementoAB;

/**
 *
 * @author Ernesto
 */
public class CalculadorMatricesOptimo  {

    public final int[][] W;
    public final int[][] P;
    public final int[][] R;
    public int[]frecExito;
    public int[]frecNoExito;
    

    public CalculadorMatricesOptimo(int cantElem) {
        W = new int[cantElem + 1][cantElem + 1];
        P = new int[cantElem + 1][cantElem + 1];
        R = new int[cantElem + 1][cantElem + 1];
        
    }

   
    public void encontrarOptimo(int cantElem, int[] frecExito, int[] frecNoExito) {
        this.frecExito=frecExito;
        this.frecNoExito=frecNoExito;
        int kraiz = 0;
        
        for (int i = 0; i <= cantElem + 1; i++) {
            W[i][i] = frecNoExito[i];
            P[i][i] = W[i][i];
            
        }

        for (int i = 0; i <= cantElem; i++) {
            for (int j = i + 1; j < cantElem + 1; j++) {
                W[i][j] = W[i][j - 1] + frecNoExito[j] + frecExito[j];

            }
        }

        for (int i = 0; i <= cantElem; i++) {
            int j = i + 1;
            P[i][j] = W[i][j] + P[i][i] + P[j][j];
            R[i][j] = j;

        }

        for (int h = 2; h < cantElem + 1; h++) {
            for (int i = 0; i < cantElem - h + 1; i++) {
                int j = h + i;
                int min = Integer.MAX_VALUE;

                for (int k = i + 1; k < j + 1; k++) {
                    int peso = P[i][k - 1] + P[k][j];
                    if(peso <= min){
                        min = peso;
                        kraiz = k;
                    }
                }
                
                P[i][j] = min + W[i][j];
                R[i][j] = kraiz;
            }

        }
    }
    
        //int i, j, k, kraiz, h;
        //int min, PesoSubArboles;
        // wii = bii y pii = wii
        // wij = wii+ aj + bj
        // h = 1 pij = wij + pii + pjj
        // h = 2 hasta h = n
        //kraiz = 0;

    /**
     *
     * @param i
     * @param j
     * @param Claves
     * @param elArbolBB
     */

    public void armarArbolBinario(int i, int j, String[] Claves,TArbolBB elArbolBB,long[] valor) {
        
        if(i < j){
            int indiceRaiz = R[i][j];
            TElementoAB elementoAB= new TElementoAB(Claves[indiceRaiz], Claves[indiceRaiz]);
            elArbolBB.insertar(elementoAB);
            this.armarArbolBinario(i, indiceRaiz-1, Claves, elArbolBB,valor);
            this.armarArbolBinario(indiceRaiz, j, Claves, elArbolBB,valor);
           // valor[0]=elementoAB.calcularCosto(frecExito, frecNoExito, indiceFE, indiceFNE, i);
        }
    }

    public static void imprimirMatriz(int[][] matriz) {
        System.out.println();

        for (int[] matriz1 : matriz) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz1[j] + " ");
            }
            System.out.println();
        }
    }

    public void printR() {
        imprimirMatriz(R);
    }

    public void printW() {
        imprimirMatriz(W);
    }

    public void printP() {
        imprimirMatriz(P);
    }
}
