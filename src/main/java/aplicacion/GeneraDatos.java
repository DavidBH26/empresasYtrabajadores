/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import datos.GestorDatosFicheros;
import debug.GeneraEmpresa;
import debug.GeneracionDeEmpleados;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import modelo.empresas.Empresa;
import modelo.trabajadores.Trabajador;

/**
 *
 * @author David
 */
public class GeneraDatos {

    public static void main(String[] args) {
        
        Map<String,Empresa> listaEmpresas = GeneraEmpresa.generaEmpresas();
        
        GestorDatosFicheros.delete();
        
        try{
       GestorDatosFicheros gestorProxy = GestorDatosFicheros.inicializaGestorSingleton();
       gestorProxy.write(listaEmpresas);
        }catch (IOException e){
            e.printStackTrace();
        }
        
    }   
}
