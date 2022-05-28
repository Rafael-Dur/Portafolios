/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosDomiciliarios2;

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
    
    public int altura() {

        int alturaIzquierda = 0;
        int alturaDerecha = 0;

        if (this.izq == null && this.der == null) {
            return 0;
        } else {
            if (this.izq != null) {
                alturaIzquierda = izq.altura();
            }
            if (this.der != null) {
                alturaDerecha = der.altura();
            }
        }
        return max(alturaIzquierda, alturaDerecha) + 1;
    }

    //Parte 1:
    public TNodoABB claveMenor() {
        TNodoABB resultado = this;
        if (this.izq != null) {
            resultado = this.izq.claveMenor();
        }
        return resultado;
    }

    //Parte 2:
    TNodoABB claveMayor() {
        TNodoABB resultado = this;
        if (this.der != null) {
            resultado = this.der.claveMayor();
        }
        return resultado;
    }

    //Parte 3:
    public void listaDeHojas(int nivel, Lista<String> resultado) {
        INodo<String> nodo = new Nodo<String>(etiqueta, etiqueta + "-" + nivel);
        resultado.insertar((Nodo<String>) nodo);
        if (izq != null) {
            izq.listaDeHojas(nivel - 1, resultado);
        }

        if (der != null) {
            der.listaDeHojas(nivel - 1, resultado);
        }

    }

    //Parte 4:
    public boolean esABB() {
        boolean verificadorIzq = true;
        boolean verificadorDer = true;
        if (izq != null) {
            if (this.etiqueta.compareTo(izq.getEtiqueta()) < 0) {
                verificadorIzq = false;
            } else {
                verificadorIzq = izq.esABB();
            }
        }
        if (der != null) {
            if (this.etiqueta.compareTo(der.getEtiqueta()) > 0) {
                verificadorDer = false;
            } else {
                verificadorDer = der.esABB();
            }
        }
        return verificadorDer && verificadorIzq;
    }

    //Parte 5:
    public TNodoABB anterior(Comparable comparable) {

        TNodoABB resultado = null;
        if (this.etiqueta.compareTo(comparable) > 0) {
            if (this.izq != null) {
                if (this.izq.getEtiqueta().equals(comparable)) {
                    resultado = this;
                } else {
                    resultado = this.izq.anterior(comparable);
                }
            }
        } else {

            if (this.der != null) {
                if (this.der.getEtiqueta().equals(comparable)) {
                    resultado = this;
                } else {
                    resultado = this.der.anterior(comparable);
                }
            }
        }
        return resultado;
    }
}
