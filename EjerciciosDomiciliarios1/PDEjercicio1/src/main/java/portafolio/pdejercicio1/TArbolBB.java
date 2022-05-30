/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portafolio.pdejercicio1;



/**
 *
 * @author Administrador
 */
public class TArbolBB<T> {
    
    private TNodoABB<T> raiz;

    public TArbolBB() {
        raiz = null;
    }

    public boolean esVacio() {
        return raiz == null;
    }

    public boolean insertar(Comparable comparable, T dato) {
        boolean valido = true;
        if (esVacio()) {
            raiz = new TNodoABB<>(comparable, dato);
        } else {
            valido = raiz.insertar(comparable, dato);
        }
        return valido;
    }

    // EJERCICIO DOMICILIARIO 1:
    //Parte 1:
    public int altura() {
        int alt = 0;
        if (!esVacio()) {
            alt = raiz.altura();
        }
        return alt;
    }

    //Parte 2:
    public int tamanio() {
        int cantidad = 0;
        if (!esVacio()) {
            cantidad = raiz.tamanio();
        }
        return cantidad;
    }

    //Parte 3:
    public int hojas() {
        int cantidad = 0;
        if (!esVacio()) {
            cantidad = raiz.hojas();
        }
        return cantidad;
    }

    //Parte 4:
    public int internos() {
        int cantidad = 0;
        if (!esVacio()) {
            cantidad = raiz.internos();
        }
        return cantidad;
    }

    //Parte 5:
    public int completos() {
        int cantidad = 0;
        if (!esVacio()) {
            cantidad = raiz.completos();
        }
        return cantidad;
    }

    //Parte 6:
    public int enNivel(int nivel) {
        int cantidad = 0;
        if (!esVacio()) {
            cantidad = raiz.enNivel(nivel);
        }
        return cantidad;
        
    }
    
}
