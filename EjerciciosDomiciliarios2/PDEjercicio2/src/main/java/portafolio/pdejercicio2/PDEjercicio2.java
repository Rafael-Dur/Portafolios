/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package portafolio.pdejercicio2;

/**
 *
 * @author Administrador
 */
public class PDEjercicio2 {

    public static void main(String[] args) {
        
        TArbolBB<String> arbolBB = new TArbolBB<>();
        
        arbolBB.insertar("30", "Raíz");
        arbolBB.insertar("15", "Hijo izquierdo de 30");
        arbolBB.insertar("11", "Hijo izquierdo de 15");
        arbolBB.insertar("16", "Hijo derecho de 15");
        arbolBB.insertar("35", "Hijo derecho de 30");
        arbolBB.insertar("36", "Hijo derecho de 35");
        arbolBB.insertar("34", "Hijo izquierdo de 35");
        arbolBB.insertar("37", "Hijo derecho de 36");
        
        System.out.println("Clave menor: " + arbolBB.claveMenor().getEtiqueta());
        System.out.println("Clave mayor: " + arbolBB.claveMayor().getEtiqueta());
        System.out.println("¿Es un árbol binario de búsqueda? " + arbolBB.esABB());
        System.out.println("Clave anterior: " + arbolBB.anterior("15").getEtiqueta());
        //System.out.println("Lista de hojas: " + arbolBB.listaDeHojas().toString());
        INodo actual = arbolBB.listaDeHojas().getPrimero();
        StringBuilder builder = new StringBuilder();
        while(actual != null) {
            builder.append(actual.getEtiqueta());
            builder.append("-");
            actual = actual.getSiguiente();
        }
        String s = builder.toString();
        System.out.println("Lista de hojas: " + s);
    }
}
