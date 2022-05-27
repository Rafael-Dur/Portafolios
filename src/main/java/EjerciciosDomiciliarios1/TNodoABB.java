/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosDomiciliarios1;

import static java.lang.Integer.max;

/**
 *
 * @author Administrador
 */
public class TNodoABB<T> {

    private TNodoABB izq;
    private TNodoABB der;
    private Comparable etiqueta;
    private T dato;

    public TNodoABB(Comparable etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.dato = dato;
        izq = null;
        der = null;

    }

    public TNodoABB getIzq() {
        return izq;
    }

    public void setIzq(TNodoABB izq) {
        this.izq = izq;
    }

    public TNodoABB getDer() {
        return der;
    }

    public void setDer(TNodoABB der) {
        this.der = der;
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Comparable etiqueta) {
        this.etiqueta = etiqueta;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public boolean insertar(Comparable comparable, T dato) {
        boolean correcto = true;
        if (this.etiqueta.compareTo(comparable) > 0) {
            if (this.izq != null) {
                correcto = this.izq.insertar(comparable, dato);
            } else {
                izq = new TNodoABB(comparable, dato);
            }
        } else {
            if (this.etiqueta.compareTo(comparable) < 0) {
                if (this.der != null) {
                    correcto = this.der.insertar(comparable, dato);
                } else {
                    der = new TNodoABB(comparable, dato);
                }
            } else {
                correcto = false;
            }
        }
        return correcto;
    }

    //Parte 1:
    public int altura() {

        int alturaIzquierda = 0;
        int alturaDerecha = 0;

        if(this.izq == null && this.der == null){
            return 0;
        }
        else{
            if (this.izq != null) {
                alturaIzquierda = izq.altura();
            }
            if (this.der != null) {
                alturaDerecha = der.altura();
            }            
        }
        return max(alturaIzquierda, alturaDerecha) + 1;
    }
    
    //Parte 2:
    public int tamanio() {

        int cantIzq = 0;
        if (izq != null) {
            cantIzq = izq.tamanio();
        }
        int cantDer = 0;
        if (der != null) {
            cantDer = der.tamanio();
        }
        return cantDer + cantIzq + 1;
    }

    //Parte 3:
    public int hojas() {
        int cantIzq = 0;
        if (izq != null) {
            cantIzq = izq.hojas();
        }
        int cantDer = 0;
        if (der != null) {
            cantDer = der.hojas();
        }
        int cantidad = cantDer + cantIzq;
        if (esHoja()) {
            cantidad++;
        }
        return cantidad;
    }

    private boolean esHoja() {
        return izq == null && der == null;
    }

    //Parte 4:
    int internos() {
        int cantIzq = 0;
        int cantDer = 0;

        if (izq != null) {
            cantIzq = izq.internos();
        }
        if (der != null) {
            cantDer = der.internos();
        }
        int cantidadInternos = cantIzq + cantDer;
        if (!esHoja()) {
            cantidadInternos ++;
        }
        return cantidadInternos;

    }

    //Parte 5:
    int completos() {
        int cantIzq = 0;
        int cantDer = 0;

        if (izq != null) {
               cantIzq = izq.completos();
        }
        
        if (der != null) {
               cantDer = der.completos();
        }
        int cantidadCompletos = cantIzq + cantDer;
        if (izq != null && der != null){
            cantidadCompletos ++;
        }
        return cantidadCompletos;
    }

    //Parte 6:
    int enNivel(int nivel) {
        int cantIzq = 0;
        int cantDer = 0;
        
        if(nivel == 0){
            return 1;
        } 
        else{  
            if(izq != null){
                cantIzq = izq.enNivel(nivel - 1);
            }

            if(der != null){
                cantDer = der.enNivel(nivel -1);
            }   
        }
        int cantidad = cantIzq + cantDer;
        return cantidad;
    }
}
