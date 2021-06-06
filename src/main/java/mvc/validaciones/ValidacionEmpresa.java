/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.validaciones;

import java.util.List;
import java.util.regex.Pattern;
import modelo.empresas.Empresa;
import mvc.controlador.ControladorPrincipal;
import mvc.dialogos.DialogoErrorValidacion;

/**
 *
 * @author David
 */
public class ValidacionEmpresa {
    
    private static List<Empresa> listaEmpresas = ControladorPrincipal.getListaEmpresa();
    
    public static boolean validarRazonSocial(String razonSocial){
        
        if((razonSocial.isEmpty()) || (listaEmpresas.stream().anyMatch(e -> e.getRazonSocial().equals(razonSocial)))){
            DialogoErrorValidacion.errorRazonSocial();
            return false;
        }else
            return true;
        
    }
    public static boolean validarDireccion(String direccion){
        
        if(direccion.isEmpty()){
            DialogoErrorValidacion.errorDireccion();
            return false;
        } else
            return true;
        
    }
    /*
    public static boolean validarCapitalSocial(String capitalSocial){
        
    }
    public static boolean validarGanancias(String ganancias){
        
    }
    */
    
    public static boolean validarTelefono(String telefono){
        if (Pattern.matches("\\d{9}|[+]\\d\\s\\d{9}|[+]\\d\\d\\s\\d{9}", telefono))
            return true;
        else{
            DialogoErrorValidacion.errorTelefono();
            return false;
        }
            
    }
    
    
    
}
