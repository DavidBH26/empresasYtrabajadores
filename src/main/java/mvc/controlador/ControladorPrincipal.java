/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controlador;

import datos.GestorDatosFicheros;
import informes.GeneraInformes;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import modelo.empresas.Empresa;
import mvc.dialogos.DialogoError;
import mvc.vistas.VentanaPrincipal;

/**
 *
 * @author David
 */
public class ControladorPrincipal {
    
    private static VentanaPrincipal ventana;
    private static Optional<Map<String, Empresa>> optmapEmpresas;
    
    
    public static void cargarDatos(){
        
        GestorDatosFicheros gestorProxy = GestorDatosFicheros.inicializaGestorSingleton();
        
                optmapEmpresas = gestorProxy.read();
        
        if (optmapEmpresas.isEmpty()){

            DialogoError.dialogoError();

        } else {
            optmapEmpresas.get();
             
            
        }
    }
    
    public static void inicializarControladorPrincipal(){
        
        cargarDatos();
        ventana = new VentanaPrincipal();
        ventana.setVisible(true);
        
    }
    
    public static List<Empresa> getListaEmpresa(){
       
        return optmapEmpresas.get()
                .values()
                .stream()
                .filter(e -> e.isEsSubsidiaria() == false)
                .collect(Collectors.toList());
    }
    
    public static String infoEmpresa(String stringBox){

        Optional empresa = optmapEmpresas.get().values().stream().filter(e -> e.getRazonSocial() == stringBox).findAny();

        String info = "";
         if (empresa.isPresent()){
             Empresa e = (Empresa) empresa.get();

        String sub = "Razon Social: " + e.getRazonSocial() + "     Telefono" + e.getTelefono() 
                    + "\nDireccion: " + e.getDireccion() + "\nGanancias Brutas: " + e.getGananciasBruto();
        
            String patron = "\nEmpresa:\n %s";
            
            info =String.format(patron, sub);
        }
        return info;
    }
    
    public static void nuevo(){
        ControladorEmpresa.initControladorEmpresa(Optional.empty());
    }
    
    public static void modificarEmpresa(String stringBox){
        
        ControladorEmpresa.initControladorEmpresa(
                Optional.of(optmapEmpresas.get()
                        .values()
                        .stream()
                        .filter(e -> e.getRazonSocial().equals(stringBox))
                        .findAny()
                        .get()));
        
    }
    
    public static void boorarSubsidiaria(String nombre){
        
        Optional<Empresa> subsidiaria = optmapEmpresas.get().values().stream().filter(e -> e.getRazonSocial().equals(nombre)).findAny();
        
        ControladorEmpresa.geetmatriz().removeSubsidiaria(subsidiaria.get());
        
        
        GestorDatosFicheros.delete();
        try{
            
       GestorDatosFicheros gestorProxy = GestorDatosFicheros.inicializaGestorSingleton();
       gestorProxy.write(optmapEmpresas.get());
       
        }catch (IOException e){
            e.printStackTrace();
            DialogoError.dialogoError();
        }
        
        inicializarControladorPrincipal();
        
    }
    
    public static void borrarEmpresa(String stringBox){
         
        optmapEmpresas.get().remove(stringBox);
        
        GestorDatosFicheros.delete();
        try{
            
       GestorDatosFicheros gestorProxy = GestorDatosFicheros.inicializaGestorSingleton();
       gestorProxy.write(optmapEmpresas.get());
       
        }catch (IOException e){
            e.printStackTrace();
            DialogoError.dialogoError();
        }
        
        inicializarControladorPrincipal();
        
        
    }
    
    public static void abrirArchivo(){// throws IOException
        try{

           if (GeneraInformes.existeFichero()){
                //GeneraInformes.borrarInformeEmpresas();
                GeneraInformes.informeEmpresas1(optmapEmpresas.get());
                GeneraInformes.abrirInformeEmpresas();
                
            } else {
                
                GeneraInformes.informeEmpresas1(optmapEmpresas.get());
                GeneraInformes.abrirInformeEmpresas();
            }
            
        } catch (IOException e){
           e.printStackTrace();
            
        }   
    }
    
    
    public static void guardarEmpresa(Optional<Empresa> empresa){
        //posible delete del fichero
        optmapEmpresas.get().put(empresa.get().getRazonSocial(), empresa.get());
        try{
        GestorDatosFicheros guardar = GestorDatosFicheros.inicializaGestorSingleton();
        guardar.write(optmapEmpresas.get());
        } catch (IOException e){
            e.printStackTrace();
            //JOptionPane.showMessageDialog(ventana, "No se ha podido guardar en fichero", "Error guardado", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static Map<String, Empresa> mapSubsidiarias(){
        return optmapEmpresas.get();
    }
    
    public static void abrirArchivoSubsidiarias(){
        
    }
    
    public static int getNuevoId(){
        if (optmapEmpresas.get().size() == 0)
            return 1;
        else 
            return 
                    optmapEmpresas
                            .get()
                            .values()
                            .stream()
                            .collect(Collectors.maxBy((e1, e2) -> e1.getIdEmpresa() > e2.getIdEmpresa()? 1 : (e1.getIdEmpresa() == e2.getIdEmpresa()? 0 : -1))).get().getIdEmpresa() + 1;
    }
    
    
    public static Empresa getEmpresaMatriz(Empresa e){
        return e;
    }
}
