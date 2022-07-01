package ucu.edu.uy.tda;

public class TElementoAB<T> {

    private  Comparable etiqueta;
    private TElementoAB hijoIzq;
    private TElementoAB hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

  
    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    /**
     * @param unElemento
     * @return
     */
    
    public boolean insertar(TElementoAB<T> unElemento) {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(unElemento);
            } else {
                hijoIzq = unElemento;
                return true;
            }
        } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(unElemento);
            } else {
                hijoDer = unElemento;
                return true;
            }
        } else {
            // ya existe un elemento con la misma etiqueta.-
            return false;
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {

        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        } else {
            return null;
        }
    }

    
    public void inOrden(Lista<T> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);
        }
        Nodo<T> unNodo = new Nodo<>(this.getEtiqueta(), this.getDatos());
        unaLista.insertar(unNodo);
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }
    }

    /**
     * @return recorrida en preOrden del subArbol que cuelga del elemento actual
     */
    
    public String preOrden() {
        StringBuilder tempStr = new StringBuilder();
        tempStr.append(imprimir());
        if (hijoIzq != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoIzq().preOrden());
        }
        if (hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().preOrden());
        }
        return tempStr.toString();
    }

    /**
     * @return recorrida en postOrden del subArbol que cuelga del elemento
     * actual
     */
    
    public String postOrden() {
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(getHijoIzq().postOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        if (hijoDer != null) {
            tempStr.append(getHijoDer().postOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(imprimir());
        return tempStr.toString();
    }

    
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

   
    public T getDatos() {
        return datos;
    }

    public void setDatos(T datos) {
        this.datos = datos;
    }


    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;

    }

  
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

   
    public TElementoAB<T> eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
            if (this.hijoIzq != null) {
                this.hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }

        if (unaEtiqueta.compareTo(this.getEtiqueta()) > 0) {
            if (this.hijoDer != null) {
                this.hijoDer = hijoDer.eliminar(unaEtiqueta);

            }
            return this;
        }

        return quitaElNodo();
    }

    private TElementoAB<T> quitaElNodo() {
        if (hijoIzq == null) {    // solo tiene un hijo o es hoja
            return hijoDer;
        }

        if (hijoDer == null) { // solo tiene un hijo o es hoja
            return hijoIzq;
        }
// tiene los dos hijos, buscamos el lexicograficamente anterior
        TElementoAB<T> elHijo = hijoIzq;
        TElementoAB<T> elPadre = this;

        while (elHijo.getHijoDer() != null) {
            elPadre = elHijo;
            elHijo = elHijo.getHijoDer();
        }

        if (elPadre != this) {
            elPadre.setHijoDer(elHijo.getHijoIzq());
            elHijo.setHijoIzq(hijoIzq);
        }

        elHijo.setHijoDer(hijoDer);
        setHijoIzq(null);  // para que no queden referencias y ayudar al collector
        setHijoDer(null);
        return elHijo;
    }

    
    public int altura() {
        int altIzq = -1;
        int altDer = -1;
        if (this.hijoIzq != null) {
            altIzq = this.hijoIzq.altura();
        }

        if (this.hijoDer != null) {
            altDer = this.hijoDer.altura();
        }

        return Math.max(altDer, altIzq) + 1;

    }

    
    public int tamanio() {
        int tamSubArboles = 0;
        if (this.hijoIzq != null) {
            tamSubArboles += this.hijoIzq.tamanio();
        }

        if (this.hijoDer != null) {
            tamSubArboles += this.hijoDer.tamanio();
        }
        return tamSubArboles + 1;
    }


    public int nivel(Comparable etiqueta, int nivel) {
        if (this.etiqueta.compareTo(etiqueta) == 0) {
            return nivel;
        }
        if (etiqueta.compareTo(this.etiqueta) < 0 && this.hijoIzq != null) {
            return this.hijoIzq.nivel(etiqueta, nivel + 1);
        }

        if (etiqueta.compareTo(this.etiqueta) > 0 && this.hijoDer != null) {
            return this.hijoDer.nivel(etiqueta, nivel + 1);
        }

        return -1;
    }

    
    public long calcularCosto(int[] frecExito, int[] frecNoExito, int[] indiceFE, int[] indiceFNE, int nivel) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void setEtiqueta(Comparable etiqueta)
    {
        this.etiqueta=etiqueta;
    }
    
    public void completarNodosExternos(int[] vector_betas, Integer[] contador) {
        if (hijoIzq != null) {
            hijoIzq.completarNodosExternos(vector_betas, contador);
        } else {
            TElementoAB elemento = new TElementoAB("hoja", null);
            elemento.setDatos(vector_betas[contador[0]]);
            elemento.setEtiqueta("hoja"+elemento.getEtiqueta());
            hijoIzq = elemento;
            contador[0]++;
        }
        if (hijoDer != null) {
            hijoDer.completarNodosExternos(vector_betas, contador);
        } else {
            TElementoAB elemento = new TElementoAB("hoja", null);
            elemento.setDatos(vector_betas[contador[0]]);
            elemento.setEtiqueta("hoja"+elemento.getEtiqueta());
            hijoDer = elemento;
            contador[0]++;
        }
    }
}
