/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosDomiciliarios2;

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
    
    public int altura() {
        int alt = 0;
        if (!esVacio()) {
            alt = raiz.altura();
        }
        return alt;
    }

    //Parte 1:
    public TNodoABB claveMenor() {
        TNodoABB resultado=null;
        if (!esVacio()) {
            resultado= raiz.claveMenor();
        } 
        return resultado;
    }
    
    //Parte 2:
    public TNodoABB claveMayor(){
        TNodoABB resultado = null;
        if(!esVacio()){
            resultado = raiz.claveMayor();
        }
        return resultado;
    }
    
    //Parte 3:
    public Lista<String> listaDeHojas()
    {
        Lista<String> resultado=null;
        if(!esVacio())
        {
            int nivel=altura()+1;
            
            raiz.listaDeHojas(nivel,resultado);
        }
        return resultado;
    }
    
    //Parte 4:
    public boolean esABB(){
        boolean verificador = true;
        if(!esVacio())
        {
            verificador = raiz.esABB();
        }
        return verificador;
    }
    
    //Parte 5:
    public TNodoABB  anterior(Comparable etiqueta)
    {
        TNodoABB resultado=null;
        if(!esVacio() && !raiz.getEtiqueta().equals(etiqueta))
        {
            resultado=raiz.anterior(etiqueta);
        }
        return resultado;
    }
}
