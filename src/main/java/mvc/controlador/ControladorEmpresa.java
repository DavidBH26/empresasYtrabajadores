/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controlador;

import informes.GeneraInformes;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.empresas.Empresa;
import modelo.trabajadores.Trabajador;
import mvc.validaciones.ValidacionEmpresa;
import mvc.vistas.VentanaEmpresa;
import mvc.vistas.VentanaEmpresaSubsidiaria;

/**
 *
 * @author David
 */
public class ControladorEmpresa {
    
    private static VentanaEmpresa ventana;
    private static Optional<Empresa> empresa;
    private  static Empresa matriz;
    private static String probando;
    private static VentanaEmpresaSubsidiaria ventanaSubsidiaria;
    
    public static void initControladorEmpresa(Optional<Empresa> company){
        empresa = company;
        ventana = new VentanaEmpresa();
        ventana.setVisible(true);
        
    }
    
    public static Optional<Empresa> getDatosEmpresa(){
        
        if (empresa.isEmpty()){
            //JOptionPane.showMessageDialog(ventana, "Los datos de la empresa no se han podido recuperar", "Error carga datos", JOptionPane.ERROR_MESSAGE);
            return empresa;
        } else {
            return empresa;
        }
    }

    public static List<String> listaSubsidiarias(Empresa e){
        return e.getListaSubsidiarias().stream().map(es -> es.getRazonSocial()).collect(Collectors.toList());
    }
    
    public static void guardar(String nombre, String direccion, String telefono){
        
        if (ValidacionEmpresa.validarRazonSocial(nombre) && (ValidacionEmpresa.validarDireccion(direccion)) && (ValidacionEmpresa.validarTelefono(telefono))){
        
        if (empresa.isPresent()){
         empresa.get().setRazonSocial(nombre);
         empresa.get().setDireccion(direccion);
         empresa.get().setTelefono(telefono);
            
        ControladorPrincipal.guardarEmpresa(empresa);
        }else {
            Empresa nueva = Empresa.creaEmpresa(ControladorPrincipal.getNuevoId(), nombre, 0.0, direccion, telefono, 0.0, false, Optional.empty());
            
            ControladorPrincipal.guardarEmpresa(Optional.of(nueva));
        }
        }
    }
    
    public static void cancelar(){
        ventana.setVisible(false);
        ventana.dispose();
    }
    
    public static void nuevaEmpresa(String razonSocial, String direccion, String telefono){//provando validaciones
        if (ValidacionEmpresa.validarRazonSocial(razonSocial) && (ValidacionEmpresa.validarDireccion(direccion)) && (ValidacionEmpresa.validarTelefono(telefono))){
            
        
        Empresa nueva = Empresa.creaEmpresa(ControladorPrincipal.getNuevoId(), razonSocial, 0.0, direccion, telefono, 0.0, false, Optional.empty());
            System.out.println(nueva);
        
        }
    }
    
    public static void initVentanaSubsidiaria(Optional<Empresa> companySub){//añadir
        empresa = companySub;
        ventanaSubsidiaria = new VentanaEmpresaSubsidiaria();
        ventanaSubsidiaria.setVisible(true);
    }
    
    public static void nuevo(){
        initVentanaSubsidiaria(Optional.empty());
        //System.out.println("nuevo");
    }
    
    public static Optional<Empresa> modificar(String listaSubs){
        Map <String, Empresa> subsidiarias = ControladorPrincipal.mapSubsidiarias();
        return Optional.of(subsidiarias.values().stream().filter(e -> e.getRazonSocial().equals(listaSubs)).findAny().get());
    }
    
    public static List<String> listaTrabajadores(Empresa e){
        return e.getListaTotalTrabajadores().stream().map(t -> t.getNombre()).collect(Collectors.toList());
    }
    
    public static List<Trabajador> listaTrab(){
        return empresa.get().getListaTotalTrabajadores();
    }
    
    public static void abrirInformeEmpresa() throws IOException{

        GeneraInformes.borrarInformeEmpresa(empresa.get());
        GeneraInformes.informeEmpresa(empresa.get());
        GeneraInformes.abrirInformeEmpresa(empresa.get());
        
    }
    
    public static void agrirInformeTrabajadoresSubsidiaria() throws IOException{
        GeneraInformes.borrarInformeTrabajadores(empresa.get());
        GeneraInformes.informeTrabajadores(empresa.get());
        GeneraInformes.abrirInformeEmpresa(empresa.get());
   
    }
    
    public static Empresa getEmpresaMatriz(String rSMatriz){//set
        //System.out.println(rSMatriz+ "getEmpresaMatriz");
        Map <String, Empresa> ematriz = ControladorPrincipal.mapSubsidiarias();
        matriz = ematriz.values().stream().filter(e -> e.getRazonSocial().equals(rSMatriz)).findAny().get();
       
        return matriz;
        

    }
    
    public static Empresa geetmatriz(){
        return matriz;
    }
    
    public static void guardarSubsidiaria(String RazonSocial, String direccion, String telefono, Double capitalSocial, Double Ganancias){
        
        Empresa nuevaSubsidiaria = Empresa.creaEmpresa(ControladorPrincipal.getNuevoId(), RazonSocial, capitalSocial, direccion, telefono, Ganancias, true, Optional.empty());

        matriz.addSubsidiaria(nuevaSubsidiaria);
        
        ControladorPrincipal.guardarEmpresa(Optional.of(nuevaSubsidiaria));
        
    }
    
        public static Trabajador modificarTrabajador(String nombre){
           return empresa.get().getListaTotalTrabajadores().stream().filter(t -> t.getNombre().equals(nombre)).findAny().get();
            
            
        }
    
}
