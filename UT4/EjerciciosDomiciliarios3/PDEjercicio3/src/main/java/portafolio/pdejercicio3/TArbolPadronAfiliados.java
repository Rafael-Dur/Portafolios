package portafolio.pdejercicio3;

import java.time.LocalDate;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bernardo Rychtenberg
 */
public class TArbolPadronAfiliados extends TArbolBB<Afiliado> implements IArbolPadronAfiliados {

    @Override
    public TArbolBB<Afiliado> cargarDesdeLista(Lista<Afiliado> listaAfiliados) {
        TArbolBB<Afiliado> resultado=new TArbolBB<>();
        Nodo<Afiliado>aux=listaAfiliados.getPrimero();
        while(aux!=null)
        {
            TElementoAB<Afiliado>unElemento=new TElementoAB<>(aux.getEtiqueta(),aux.getDato());
            resultado.insertar(unElemento);
            unElemento=new TElementoAB<>(aux.getEtiqueta(),aux.getDato());
            insertar(unElemento);
            aux=aux.getSiguiente();
        }
        return resultado;
        
    }

    @Override
    public TArbolBB<Afiliado> obtenerConsultasDelDia(String fecha) {

        TArbolBB<Afiliado> resultado = new TArbolBB<>();

        Lista<Afiliado> listaAfiliados = this.inorden();

        if (!listaAfiliados.esVacia()) {
            Nodo<Afiliado> nodoAfiliados = listaAfiliados.getPrimero();

            while (nodoAfiliados != null) {
                Afiliado afiliado = nodoAfiliados.getDato();
                if (!afiliado.pendientes.esVacia()) {
                    Nodo<Consulta> nodoConsulta = afiliado.pendientes.getPrimero();
                    boolean encontre = false;
                    while (nodoConsulta != null && !encontre) {
                        Consulta consulta = nodoConsulta.getDato();
                        if (consulta.getFecha().equals(fecha)) {
                            TElementoAB<Afiliado> elementoAfiliado = new TElementoAB(afiliado.getCedula(), afiliado);
                            resultado.insertar(elementoAfiliado);
                            encontre = true;
                        }
                        nodoConsulta = nodoConsulta.getSiguiente();
                    }
                }
                nodoAfiliados = nodoAfiliados.getSiguiente();
            }
        }
        return resultado;
    }

    @Override
    public Integer cantidadConsultasdelDia() {
        
        LocalDate hoy=LocalDate.now();
        int dia=hoy.getMonthValue();
        int mes=hoy.getDayOfMonth();
        int anio=hoy.getYear();
        String numeroDia=dia<=9?"0"+dia:dia+"";
        String numeroMes=mes<=9?"0"+mes:mes+"";
        String numeroAnio=anio<=9?"0"+anio:anio+"";
        String fecha=numeroAnio+numeroMes+numeroDia;
        Lista<Afiliado> listaAfiliados = this.inorden();
        Integer cantidad = 0;
        Nodo<Afiliado> nodoAfiliados = listaAfiliados.getPrimero();
        while (nodoAfiliados != null) {
            Afiliado afiliado = nodoAfiliados.getDato();
            Nodo<Consulta> nodoConsulta = afiliado.pendientes.getPrimero();
            while (nodoConsulta != null) {
                Consulta consulta = nodoConsulta.getDato();
                if (consulta.getFecha().equals(fecha)) {
                    cantidad++;
                }
                nodoConsulta = nodoConsulta.getSiguiente();
            }

            nodoAfiliados = nodoAfiliados.getSiguiente();
        }

        return cantidad;
    }
}
