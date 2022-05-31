package portafolio.pdejercicio3;


public class TArbolBB<T> implements IArbolBB<T> {


    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";
    private TElementoAB<T> raiz;

    public TArbolBB() {
        raiz = null;
    }

    /**
     * @param unElemento
     * @return
     */
    public boolean insertar(TElementoAB<T> unElemento) {
        if (esVacio()) {
            setRaiz(unElemento);
            return true;
        } else {
            return getRaiz().insertar(unElemento);
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @SuppressWarnings("unchecked")
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return getRaiz().buscar(unaEtiqueta);
        }
    }
    
    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            this.raiz = this.getRaiz().eliminar(unaEtiqueta);
        }
    }

    /**
     * @return recorrida en inorden del arbol, null en caso de ser vacío
     */
    public String inOrden() {
        if (esVacio()) {
            return null;
        } else {
            return getRaiz().inOrden();
        }
    }

    /**
     * @return recorrida en preOrden del arbol, null en caso de ser vacío
     */
    /**
     * @return
     */
    public boolean esVacio() {
        return (getRaiz() == null);
    }

    /**
     * @return True si habían elementos en el árbol, false en caso contrario
     */
    public boolean vaciar() {
        if (!esVacio()) {
            setRaiz(null);
            return true;
        }
        return false;
    }

    @Override
    public Lista<T> inorden() {
        Lista<T> listaInorden = null;
        if (!esVacio()) {
            listaInorden = new Lista<T>();
            getRaiz().inOrden(listaInorden);
        }
        return listaInorden;

    }

    /**
     * @return the raiz
     */
    public TElementoAB<T> getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(TElementoAB<T> raiz) {
        this.raiz = raiz;
    }
    
}
