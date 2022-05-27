package segundo_parcial;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aruib_000
 */
public class Afiliado implements IAfiliado {
    
    private int cedula; 
    private String nombre;
    private String apellido;
    Lista<Consulta> historia;
    Lista<Consulta> pendientes;
    
     public Afiliado (int unaCedula, String unNombre, String unApellido) {
        this.cedula = unaCedula;
        this.nombre = unNombre;
        this.apellido = unApellido;
        this.historia = new Lista();
        this.pendientes = new Lista();
    }

    @Override
    public int getCedula() {
        return cedula;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }
    
    @Override
    public String imprimir() {
        String losDatos = ("Cedula: " + cedula + ",    Nombre: " + nombre + ",    Apellido: " + apellido);
        return losDatos;
    }
    
    @Override
    public void cargarConsultaHistorica(Consulta unaConsulta){
        
        Nodo<Consulta> unNodo = new Nodo(unaConsulta.getFecha(), unaConsulta);
        this.historia.insertar(unNodo);
    }
    
    @Override
    public void cargarConsultaPendiente(Consulta unaConsulta){
        
        Nodo<Consulta> unNodo = new Nodo(unaConsulta.getFecha(), unaConsulta);
        this.pendientes.insertar(unNodo);
    }
    
    @Override
    public boolean inactivo(){
        return (this.historia.esVacia() && this.pendientes.esVacia());
    }
    
    @Override
    public boolean faltador() {
        int faltas = 0;    
        Nodo<Consulta> nodoConsultaActualH = this.historia.getPrimero();
        while (nodoConsultaActualH != null){
            Consulta consultaActualH = nodoConsultaActualH.getDato();
            if (consultaActualH.getResultado() == 2){
                faltas++;
            }
            nodoConsultaActualH = nodoConsultaActualH.getSiguiente();
        }
        Nodo<Consulta> nodoConsultaActualP = this.pendientes.getPrimero();
        while (nodoConsultaActualP != null){
            Consulta consultaActualP = nodoConsultaActualP.getDato();
            if (consultaActualP.getResultado() == 2){
                faltas++;
            }
            nodoConsultaActualP = nodoConsultaActualP.getSiguiente();
        }
        if (faltas > 1) {
            return true;
        }          
        return false;
}
    
    @Override
    public void actualizar(){
        Nodo<Consulta> nodoConsultaActualP = this.pendientes.getPrimero();
        while (nodoConsultaActualP != null){
            Consulta consultaActualP = nodoConsultaActualP.getDato();
            if (consultaActualP.getResultado() != 0){
                Nodo<Consulta> nodoConsultaActualH = new Nodo(consultaActualP.getFecha(),consultaActualP);
                this.historia.insertar(nodoConsultaActualH);
                this.pendientes.eliminar(consultaActualP.getFecha());
            }
            nodoConsultaActualP = nodoConsultaActualP.getSiguiente();
        }
    }
    
    @Override
    public boolean hayQueCobrarle(){
       boolean cobrar = false;
       Nodo<Consulta> nodoConsultaActualH = this.historia.getPrimero();
       while (nodoConsultaActualH != null){
            Consulta consultaActualH = nodoConsultaActualH.getDato();
            if (consultaActualH.getResultado() == 2){
                cobrar = true;
            }
            nodoConsultaActualH = nodoConsultaActualH.getSiguiente();
        }
        Nodo<Consulta> nodoConsultaActualP = this.pendientes.getPrimero();
        while (nodoConsultaActualP != null){
            Consulta consultaActualP = nodoConsultaActualP.getDato();
            if (consultaActualP.getResultado() == 2){
                cobrar = true;
            }
            nodoConsultaActualP = nodoConsultaActualP.getSiguiente();
        }
        return cobrar; 
    }
    
}    
