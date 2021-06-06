/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informes;

import debug.GeneraEmpresa;
import debug.GeneracionDeEmpleados;
import java.awt.Desktop;
import java.io.File;
//import static debug.GeneraEmpresa.alphabet;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import modelo.empresas.Empresa;
import modelo.trabajadores.Trabajador;
import mvc.controlador.ControladorEmpresa;
import mvc.controlador.ControladorPrincipal;

/**
 *
 * @author David
 */
public class GeneraInformes {
    
    private static Path InformeEmpresaAlphabet = Path.of("C:\\empleadosaplicacion\\informes\\", "InformeEmpresaAlphabet.txt");
    private static Path informeEmpresaBlackRock = Path.of("C:\\empleadosaplicacion\\informes\\", "informeEmpresaBlackRock.txt");;
    private static Path informeEmpresas = Path.of("C:\\empleadosaplicacion\\informes\\", "informeEmpresas.txt");;
    private static Path informeEmpleadosAlphabet = Path.of("C:\\empleadosaplicacion\\informes", "informeEmpleadosAlphabet.txt");;
    private static Path informeEmpleadosBlackRock = Path.of("C:\\empleadosaplicacion\\informes", "informeEmpleadosBlackRock.txt");;
    
    public static void informeEmpresas(Map<String, Empresa> listarEmpresas) throws IOException{
        String Aplhabet = "Razon Social: "+listarEmpresas.getOrDefault("Alphabet inc", GeneraEmpresa.alphabet).getRazonSocial()  
                + "                   Telefono:" + listarEmpresas.getOrDefault("Alphabet inc", GeneraEmpresa.alphabet).getTelefono() + "\n"
                + " Direccion: " +listarEmpresas.getOrDefault("Alphabet inc", GeneraEmpresa.alphabet).getDireccion() +"\n"
                + " Ganancias Brutas: " +listarEmpresas.getOrDefault("Alphabet inc", GeneraEmpresa.alphabet).getGananciasBruto();
        
        String BlackRock = "Razon Social: "+listarEmpresas.getOrDefault("Black Rock", GeneraEmpresa.BlackRock).getRazonSocial()
                + "                   Telefono:" + listarEmpresas.getOrDefault("Black Rock", GeneraEmpresa.BlackRock).getTelefono() + "\n"
                + " Direccion: " +listarEmpresas.getOrDefault("Black Rock", GeneraEmpresa.BlackRock).getDireccion() +"\n"
                + " Ganancias Brutas: " +listarEmpresas.getOrDefault("Black Rock", GeneraEmpresa.BlackRock).getGananciasBruto();
        
        String patron = "\nEmpresa:\n %s";
        
        System.out.println("informe de Empresas Generado");
        Files.writeString(informeEmpresas, "**************INFORME EMPRESAS**************\n"
                + "**************LISTADO EMPRESAS**************", Charset.forName("UTF-8"), StandardOpenOption.CREATE);
        Files.writeString(informeEmpresas, String.format(patron, Aplhabet), Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        Files.writeString(informeEmpresas, String.format(patron, BlackRock), Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        
        Files.writeString(informeEmpresas, "\n**************Estadisticas**************\n"
                + "**************Empresa con mas ganancias**************", Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        String emMaxGanancias = GeneraEmpresa.maxGanancias(listarEmpresas);
        Files.writeString( informeEmpresas ,emMaxGanancias, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        
        Files.writeString(informeEmpresas, "\n**************Empresa con menos ganancias**************", 
                Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        String emMinGanancias = GeneraEmpresa.minGanancias(listarEmpresas);
        Files.writeString(informeEmpresas, emMinGanancias, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        
        Files.writeString(informeEmpresas, "\n**************Media de ganancias de todas las empresas**************", 
                Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        String mediaGananciasEmpresas = GeneraEmpresa.mediaGanancias(listarEmpresas);
        Files.writeString(informeEmpresas, mediaGananciasEmpresas, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        
        
        
    }
    
    public static boolean existeFichero() throws IOException{
        if (Files.exists(informeEmpresas)){
            Files.delete(informeEmpresas);
            return true;
        }else {
            return false;
        }
            
            
      
    }
    
    public static void borrarInformeEmpresas() throws IOException{
        //if (Files.exists(informeEmpresas))
            Files.deleteIfExists(informeEmpresas);
            
    }
    
    public static void informeEmpresas1(Map<String, Empresa> listarEmpresas) throws IOException{
        //List<Empresa> empresasMatriz = listarEmpresas.values().stream().filter(e -> e.isEsSubsidiaria() == false).collect(Collectors.toList());
        listarEmpresas = listarEmpresas.values().stream().filter(e -> e.isEsSubsidiaria() == false).collect(Collectors.toMap(e -> e.getRazonSocial(), e -> e));
        //if (listarEmpresas.values().stream().allMatch(e -> e.isEsSubsidiaria() == false)){
        String toString = "Razon Social: "+listarEmpresas.values().stream().map(e  -> e.getRazonSocial()).toString()//.getRazonSocial()  
                + "                   Telefono:" + listarEmpresas.values().stream().map(e  -> e.getTelefono()).toString() + "\n"
                + " Direccion: " +listarEmpresas.values().stream().map(e  -> e.getDireccion()).toString() +"\n"
                + " Ganancias Brutas: " +listarEmpresas.values().stream().map(e  -> e.getGananciasBruto()).toString();
        

        
        String patron = "\nEmpresa:\n %s";
        
        System.out.println("informe de Empresas Generado");
        Files.writeString(informeEmpresas, "**************INFORME EMPRESAS**************\n"
                + "**************LISTADO EMPRESAS**************", Charset.forName("UTF-8"), StandardOpenOption.CREATE);
        Files.writeString(informeEmpresas, String.format(patron, toString), Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        //Files.writeString(informeEmpresas, String.format(patron, BlackRock), Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        
        Files.writeString(informeEmpresas, "\n**************Estadisticas**************\n"
                + "**************Empresa con mas ganancias**************", Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        String emMaxGanancias = GeneraEmpresa.maxGanancias(listarEmpresas);
        Files.writeString( informeEmpresas ,emMaxGanancias, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        
        Files.writeString(informeEmpresas, "\n**************Empresa con menos ganancias**************", 
                Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        String emMinGanancias = GeneraEmpresa.minGanancias(listarEmpresas);
        Files.writeString(informeEmpresas, emMinGanancias, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        
        Files.writeString(informeEmpresas, "\n**************Media de ganancias de todas las empresas**************", 
                Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        String mediaGananciasEmpresas = GeneraEmpresa.mediaGanancias(listarEmpresas);
        Files.writeString(informeEmpresas, mediaGananciasEmpresas, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        
        //} else 
          //  System.out.println("no hay empresas matriz");
        
    }
    
    
    
    public static void abrirInformeEmpresas() throws IOException{
        
        Desktop.getDesktop().open(informeEmpresas.toFile());
    }
    public static void borrarInformeEmpresa(Empresa e) throws IOException{
        
         if(Pattern.matches("Alphabet inc", e.getRazonSocial())){

                  Files.deleteIfExists(InformeEmpresaAlphabet);
         }
         if (Pattern.matches("Black Rock", e.getRazonSocial())){

                  Files.deleteIfExists(informeEmpresaBlackRock);
         }
        
        
    }
    public static void informeEmpresa(Empresa empresa) throws IOException{
        Set<Empresa> listaSublidiarias = new TreeSet<Empresa>();
        Path seleccionInforme = Path.of("C:\\empleadosaplicacion\\informes\\");
        if(Pattern.matches("Alphabet inc", empresa.getRazonSocial())){
            //System.out.println(empresa.getRazonSocial());
            listaSublidiarias = empresa.getListaSubsidiarias();
            seleccionInforme = InformeEmpresaAlphabet;
        }
        if (Pattern.matches("Black Rock", empresa.getRazonSocial())){
            listaSublidiarias = empresa.getListaSubsidiarias();
            seleccionInforme = informeEmpresaBlackRock;
        }
        /*if (empresa.isEsSubsidiaria() == false){
            seleccionInforme = Path.of("C:\\empleadosaplicacion\\informes\\informeEmpresa"+empresa.getRazonSocial()+".txt");
            listaSublidiarias  = empresa.getListaSubsidiarias();
        }*/
        
        Files.writeString(seleccionInforme, "**************INFORME EMPRESAS**************"
                + "\n**************Listado de subsidiarias**************", Charset.forName("UTF-8"), StandardOpenOption.CREATE);
        
        for (Empresa subsidiaria : listaSublidiarias){
            String sub = "Razon Social: " + subsidiaria.getRazonSocial() + "     Telefono" + subsidiaria.getTelefono() 
                    + "\nDireccion: " + subsidiaria.getDireccion() + "\nGanancias Brutas: " + subsidiaria.getGananciasBruto();
            String patron = "\nEmpresa:\n %s";
            Files.writeString(seleccionInforme, String.format(patron, sub), Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        }
        
        Files.writeString(seleccionInforme, "\n*******Subsidiaria con mas ganancias*******", Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        String maxGanancias = GeneraEmpresa.maxGananciasSubsidiaris(empresa);
        Files.writeString(seleccionInforme, maxGanancias, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        
        Files.writeString(seleccionInforme, "\n*******Subsidiaria con menos ganancias*******", Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        String minGanancias = GeneraEmpresa.minGananciasSubsidiaris(empresa);
        Files.writeString(seleccionInforme, minGanancias, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        
        Files.writeString(seleccionInforme, "\n*******Media de ganancias por subsidiaria*******", Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        String mediaGanancias = GeneraEmpresa.mediaGananciasSubsidiarias(empresa);
        Files.writeString(seleccionInforme, mediaGanancias, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
    }
    
    public static void abrirInformeEmpresa(Empresa empresa) throws IOException{
        
         if(Pattern.matches("Alphabet inc", empresa.getRazonSocial())){

                     //File informe = new File ("C:\\empleadosaplicacion\\informes\\InformeEmpresasAlphabet.txt");
                     Desktop.getDesktop().open(InformeEmpresaAlphabet.toFile());
        }
        if (Pattern.matches("Black Rock", empresa.getRazonSocial())){

                    //File informe = new File ("C:\\empleadosaplicacion\\informes\\informeEmpresaBlackRock.txt");
                    Desktop.getDesktop().open(informeEmpresaBlackRock.toFile());
        }
        if(empresa.isEsSubsidiaria()==true){
            
            Path informeEmpresa = Path.of("C:\\empleadosaplicacion\\informes\\informeEmpreados"+empresa.getRazonSocial()+".txt");
            //File informe = new File("C:\\empleadosaplicacion\\informes\\informeEmpreados"+empresa.getRazonSocial()+".txt");
            Desktop.getDesktop().open(informeEmpresa.toFile());
        }
        
    }
    
    public static void borrarInformeTrabajadores(Empresa e) throws IOException{
        Path informeEmpresa = Path.of("C:\\empleadosaplicacion\\informes\\informeEmpreados"+e.getRazonSocial()+".txt");
        if (Files.exists(informeEmpresa)){
        
        Files.deleteIfExists(informeEmpresa);
        }
    }
    
    public static void informeTrabajadores(Empresa empresa) throws IOException{
        List<Trabajador> trabajadores = new ArrayList<Trabajador>();
        Path seleccionInforme = Path.of("C:\\empleadosaplicacion\\informes\\");
        if(Pattern.matches("Alphabet inc", empresa.getRazonSocial())){
             
             List<Trabajador> trab0 = empresa.getListaSubsidiarias().stream().map(e -> e.getListaTotalTrabajadores()).collect(Collectors.toList()).get(0);
             List<Trabajador> trab1 = empresa.getListaSubsidiarias().stream().map(e -> e.getListaTotalTrabajadores()).collect(Collectors.toList()).get(1);
             List<Trabajador> trab2 = empresa.getListaSubsidiarias().stream().map(e -> e.getListaTotalTrabajadores()).collect(Collectors.toList()).get(2);
             trabajadores.addAll(trab0);
             trabajadores.addAll(trab1);
             trabajadores.addAll(trab2);
             seleccionInforme = informeEmpleadosAlphabet;
        }
        if(Pattern.matches("Black Rock", empresa.getRazonSocial())){
             seleccionInforme = informeEmpleadosBlackRock;
             List<Trabajador> trab0 = empresa.getListaSubsidiarias().stream().map(e -> e.getListaTotalTrabajadores()).collect(Collectors.toList()).get(0);
             List<Trabajador> trab1 = empresa.getListaSubsidiarias().stream().map(e -> e.getListaTotalTrabajadores()).collect(Collectors.toList()).get(1);
             List<Trabajador> trab2 = empresa.getListaSubsidiarias().stream().map(e -> e.getListaTotalTrabajadores()).collect(Collectors.toList()).get(2);
             trabajadores.addAll(trab0);
             trabajadores.addAll(trab1);
             trabajadores.addAll(trab2);
        }
        if (empresa.isEsSubsidiaria()==true){
            seleccionInforme = Path.of("C:\\empleadosaplicacion\\informes\\", "informeEmpreados"+empresa.getRazonSocial()+".txt");
            trabajadores = empresa.getListaTotalTrabajadores();
        }
        
        Files.writeString(seleccionInforme, "**************INFORME DE EMPLEADOS**************"
                + "\nEPRESA: "+ empresa.getRazonSocial().toUpperCase(), Charset.forName("UTF-8"), StandardOpenOption.CREATE);
        
        Files.writeString(seleccionInforme, "\n************************Estadisticas************************", 
                Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        Files.writeString(seleccionInforme, "\n***********Trabajador con sueldo mas alto***************"
                + "\n***************Resumen del trabajador****************", Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        String TrabMaxSueldo = GeneracionDeEmpleados.trabajadorMaximoSueldoInforme(trabajadores);
        Files.writeString(seleccionInforme, TrabMaxSueldo, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        
        
        Files.writeString(seleccionInforme, "\n***********Trabajador con sueldo mas bajo***************"
                + "\n***************Resumen del trabajador****************", Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        String TrabMinSueldo = GeneracionDeEmpleados.trabajadorMinimoSueldoInforme(trabajadores);
        Files.writeString(seleccionInforme, TrabMinSueldo, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        
        Files.writeString(seleccionInforme, "\n*******Media de sueldo de Trabajadores*******", Charset.forName("UTF-8"), 
                StandardOpenOption.APPEND);
        double mediaSueldo = GeneracionDeEmpleados.mediaSueldo(trabajadores);
        Files.writeString(seleccionInforme, "\nMedia se dueldos de trabajadores "+empresa.getRazonSocial()+": "+mediaSueldo, 
                Charset.forName("utf-8"), StandardOpenOption.APPEND);
        
        Files.writeString(seleccionInforme, "\n*******Listado de empleados*******", Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        for (Trabajador trabajador : trabajadores){
            String trabajadorString = "Nombre: " + trabajador.getNombre() + "\nAntiguedad: " + trabajador.getAntiE().getNombre()
                + "\nCategoria: " + trabajador.getCategoriaE().getNombre() + "   Sueldo: " + trabajador.getSueldoFuncion();
            String formato = "\n***************Resumen de Trabajador*****************\n %s";
            Files.writeString(seleccionInforme, String.format(formato, trabajadorString), Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        }
        
        
    }
    
}
