/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portafolio.pdejercicio3;

/**
 *
 * @author Bernardo Rychtenberg
 */
public class Principal {
    
    public static void main(String[] args){
        
        // 1) Instanciar y cargar los afiliados a un árbol de afiliados desde padron.txt. 
        
        ManejadorArchivosGenerico manejador = new ManejadorArchivosGenerico();
        
        String[] lineas=manejador.leerArchivo("padron.txt");
        
        Lista<Afiliado>listaAfiliado=new Lista<>();
        for(String linea:lineas)
        {
            String[]partes=linea.split(",");
            int cedula=Integer.parseInt(partes[0]);
            String nombre=partes[1];
            String apellido=partes[2];
            Afiliado afiliado=new Afiliado(cedula,nombre,apellido);
            Nodo<Afiliado>unNodo=new Nodo<>(afiliado.getCedula(), afiliado);
            listaAfiliado.insertar(unNodo);
            
        }
        
        
        // 2) Instanciar y cargar las consultas a partir de los archivos historicos.txt y agendadas.txt
        
       lineas=manejador.leerArchivo("historicas.txt");
        for(String linea:lineas)
        {
            String[]partes=linea.split(",");
            Nodo<Afiliado> nodo=listaAfiliado.buscar(partes[3]);
            if(nodo!=null && nodo.getDato()!=null)
            {
                Afiliado afiliado=nodo.getDato();
                Consulta consulta=new Consulta(partes[0], partes[1], Integer.parseInt(partes[2]), Integer.parseInt(partes[3]));
                afiliado.cargarConsultaHistorica(consulta);
            }
        }
        
        lineas=manejador.leerArchivo("agendadas.txt");
        for(String linea:lineas)
        {
            String[]partes=linea.split(",");
           Nodo<Afiliado> nodo=listaAfiliado.buscar(partes[3]);
            if(nodo!=null && nodo.getDato()!=null)
            {
                Afiliado afiliado=nodo.getDato();
                Consulta consulta=new Consulta(partes[0], partes[1], Integer.parseInt(partes[2]), Integer.parseInt(partes[3]));
                afiliado.cargarConsultaPendiente(consulta);
            }
        }
        
        // 3) Aplicar el método de carga de afiliados a partir de una lista (invocando el método cargarDesdeLista)
       
        IArbolPadronAfiliados abb=new TArbolPadronAfiliados();
        TArbolBB afiliadosABB=abb.cargarDesdeLista(listaAfiliado);
        
        // 4) Aplicar el método obtenerConsultasDelDia para obtener las consultas del día de la fecha. |
        TArbolBB abbAux=abb.obtenerConsultasDelDia("20190903");
        System.out.println(abbAux.inOrden());
        // 5) Obtener la cantidad de consultas en el día.
        int cantidad=abb.cantidadConsultasdelDia();
        System.out.println("Cantidad de dias :"+cantidad);
        
    }
    
}
