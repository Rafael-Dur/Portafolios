package ucu.edu.uy.tda;

public class TArbolBB<T> {

    private TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    /**
     * @param unElemento
     * @return
     */
    public boolean insertar(TElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
//        if (esVacio())
//        {
//            return null;
//        }
//        else
//        {
//            return raiz.buscar(unaEtiqueta);
//        }

        return esVacio() ? null : raiz.buscar(unaEtiqueta);
    }

    /**
     * @return recorrida en inorden del arbol, null en caso de ser vacío
     */
    public Lista<T> inOrden() {
        Lista<T> unaLista = new Lista<>();
        if (!esVacio()) {
            raiz.inOrden(unaLista);
        }
        return unaLista;
    }

    /**
     * @return recorrida en preOrden del arbol, null en caso de ser vacío
     */
    public String preOrden() {
//        if (esVacio())
//        {
//            return null;
//        }
//        else
//        {
//            return raiz.preOrden();
//        }
        return esVacio() ? null : raiz.preOrden();
    }

    /**
     * @return recorrida en postOrden del arbol, null en caso de ser vacío
     */
    public String postOrden() {
//        if (esVacio())
//        {
//            return null;
//        }
//        else
//        {
//            return raiz.postOrden();
//        }
        return esVacio() ? null : raiz.postOrden();
    }

    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            this.raiz = this.raiz.eliminar(unaEtiqueta);
        }
    }

    /**
     * @return
     */
    public boolean esVacio() {
        return (raiz == null);
    }

    /**
     * @return True si habían elementos en el árbol, false en caso contrario
     */
    public boolean vaciar() {
        if (!esVacio()) {
            raiz = null;
            return true;
        }
        return false;
    }

    public int altura() {
//        if (esVacio())
//        {
//            return -1;
//        }
//        return raiz.altura();
        return esVacio() ? -1 : raiz.altura();
    }

    public int tamanio() {
//        if (esVacio())
//        {
//            return -1;
//        }
//        return raiz.tamanio();
        return esVacio() ? -1 : raiz.tamanio();
    }

    public int nivel(Comparable etiqueta) {
//        if (esVacio())
//        {
//            return -1;
//        }
//        return raiz.nivel(etiqueta, 0);
        return esVacio() ? -1 : raiz.nivel(etiqueta, 0);
    }

    public TElementoAB<T> getRaiz() {
        return this.raiz;
    }

    public long calcularCosto(int[] frecExito, int[] frecNoExito) {
        long resultado = -1;
        int indiceFNE[] = {0};
        int indiceFE[] = {1};
        if (this.getRaiz() != null) {
            resultado = this.getRaiz().calcularCosto(frecExito, frecNoExito, indiceFE, indiceFNE, 0);
        }
        return resultado;
    }
    
    public long obtenerCosto(int n,int[]frecuenciaExito,int[]frecuenciaNoExito,int[] h,int[] hprima) {
        long suma = 0;
        for(int i = 0; i < n; i++)
        {
           suma +=frecuenciaExito[i] * h[i];
        }
        for(int i = 0; i < n; i++)
        {
           suma += frecuenciaNoExito[i] * hprima[i];
        }
        return suma;
    }

    public void completarNodosExternos(int[] vectorBetas) {
        if (!esVacio()) {
            Integer[] contador = new Integer[1];
            contador[0] = 0;
            raiz.completarNodosExternos(vectorBetas, contador);
        }
    }
}
