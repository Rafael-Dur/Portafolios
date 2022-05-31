package portafolio.pdejercicio3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bernardo Rychtenberg
 */
public interface IArbolPadronAfiliados {

    
    public TArbolBB obtenerConsultasDelDia(String fecha);
    public TArbolBB<Afiliado> cargarDesdeLista(Lista<Afiliado> listaAfiliados);
    public Integer cantidadConsultasdelDia();
    
}
