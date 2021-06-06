/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controlador;

import java.util.List;
import java.util.Optional;
import modelo.empresas.Empresa;
import modelo.trabajadores.Trabajador;
import mvc.vistas.VentanaTrabajador;
import mvc.vistas.VentanaTrabajadores;

/**
 *
 * @author David
 */
public class ControladorTrabajador {
    
    private static VentanaTrabajador ventana;
    private static Optional<Trabajador> trabajador;
    private static List<Trabajador> listaTrabajadores;
    private static VentanaTrabajadores vTrabajadores;
    
    
    public static void initTrabajador(Optional<Trabajador> trab){
        trabajador = trab;
        ventana = new VentanaTrabajador();
        ventana.setVisible(true);
        
    }
    
   public static Optional<Trabajador> getTrabajador(){
     return trabajador;
    }
   
   public static void initTrabajadores(Optional<Empresa> empresa){
       listaTrabajadores = empresa.get().getListaTotalTrabajadores();
       vTrabajadores = new VentanaTrabajadores();
       vTrabajadores.setVisible(true);
   }
    
   public static Optional<List<Trabajador>> getListaTrabajadores(){
       return Optional.of(listaTrabajadores);
   } 

   public static void busqueda(List<String> nuevaLista,String busqueda){
      
       if(nuevaLista.stream().anyMatch(n -> n.toLowerCase().contains(busqueda.toLowerCase())))//filter(n ->n.contains(busqueda))
//if( nuevaLista.contains(busqueda))
           System.out.println(nuevaLista);
      else
           System.out.println("algo pasa");
   }
   
   public static Optional<Trabajador> setTrabajador(String nombre){
       //return Optional.of(
               return listaTrabajadores.stream().filter(t -> t.getNombre().equals(nombre)).findAny();
               
   } 
}
