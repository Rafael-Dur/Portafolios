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
public interface IAfiliado {
    
    int getCedula();
    String getNombre();
    String getApellido();
    String imprimir();
    void cargarConsultaHistorica(Consulta unaConsulta);
    void cargarConsultaPendiente(Consulta unaConsulta);
    boolean inactivo();
    boolean faltador();
    boolean hayQueCobrarle();
    void actualizar();
    
}
