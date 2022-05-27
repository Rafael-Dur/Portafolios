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
public class Consulta {
    
    private final String fecha;
    private String especialidad;
    private int cedula;
    private int resultado;
    
    public Consulta(String unaFecha, String unaEspecialidad, int unaCedula, int unResultado){
        fecha = unaFecha;
        especialidad = unaEspecialidad;
        cedula = unaCedula;
        resultado = unResultado;
    }
  
   public String getFecha(){
       return fecha;
   } 
   
   public int getResultado(){
       return resultado;
   }
    
}
