/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package debug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import modelo.empresas.Empresa;
import modelo.trabajadores.Trabajador;

/**
 *
 * @author David
 */
public class GeneraEmpresa {
    
    public static Empresa alphabet;
    private static Empresa deepMind;
    private static Empresa google;
    private static Empresa googleFiber;
    
    public static Empresa BlackRock;
    private static Empresa FutureAdvisor;
    private static Empresa AperioGroup;
    private static Empresa BRRealEtate;
    
    
    public static void generaAlphabet(){
        alphabet = Empresa.creaEmpresa(1, "Alphabet inc", 0.0, "2100 N Lyon Ave, Springfield", "237489237", 0.0, false, Optional.empty());
        
        List<Trabajador> trabajadoresDeepMind = GeneracionDeEmpleados.generaEmpleados(20);
        deepMind = Empresa.creaEmpresa(2, "DeepMind", 5000000.0, "67 8th St, San Francisco", "4352348237", 2.0e6, true, Optional.of(trabajadoresDeepMind));
        alphabet.addSubsidiaria(deepMind);
        deepMind.addTrabajadores(trabajadoresDeepMind);
        
        List<Trabajador> trabajadoresGoogle = GeneracionDeEmpleados.generaEmpleados(40);
        google = Empresa.creaEmpresa(3, "Google", 3000000.0, "Mountain View", "3453437234", 4.0e9, true, Optional.of(trabajadoresGoogle));
        alphabet.addSubsidiaria(google);
        google.addTrabajadores(trabajadoresGoogle);
        
        List<Trabajador> trabajadoresGoogleFiber = GeneracionDeEmpleados.generaEmpleados(25);
        googleFiber = Empresa.creaEmpresa(4, "Google Fiber", 8000000.0, "Mountain View", "82374987239", 3.0e6, true, Optional.of(trabajadoresGoogleFiber));
        alphabet.addSubsidiaria(googleFiber);
        googleFiber.addTrabajadores(trabajadoresGoogleFiber);
    }
    
    public static void generaBlackRock(){
        BlackRock = Empresa.creaEmpresa(0, "Black Rock", 0.0, "Park Avenue Plaza, 55 East 52nd Street, New York, New York, 10055-0002", "+1-212-8105300", 0.0, false, Optional.empty());
        
        List<Trabajador> trabajadoresFuture = GeneracionDeEmpleados.generaEmpleados(125);
        FutureAdvisor = Empresa.creaEmpresa(1, "Xs Future Advisor Sl.", 20000000.0, "San Francisco, California 94105, US", "237489274324", 2.0e8, true, Optional.of(trabajadoresFuture));
        FutureAdvisor.addTrabajadores(trabajadoresFuture);
        BlackRock.addSubsidiaria(FutureAdvisor);
       
        List<Trabajador> trabajadoresAperio = GeneracionDeEmpleados.generaEmpleados(110);
        AperioGroup = Empresa.creaEmpresa(2 , "Aperio Group, LLC", 1000000000.0, "3 Harbor Dr Suite 204, Sausalito, CA 94965, Estados Unidos", "(415) 339-4300", 5.0e4, true, Optional.of(trabajadoresAperio));
        BlackRock.addSubsidiaria(AperioGroup);
        AperioGroup.addTrabajadores(trabajadoresAperio);
        
        List<Trabajador> trabajadoresRealEstate = GeneracionDeEmpleados.generaEmpleados(65);
        BRRealEtate = Empresa.creaEmpresa(3, "Black Rock Real Estate", 500000000.0, "295 Madison Ave 12th floor, New York, NY 10017, Estados Unidos", "+1 212-810-5300", 3.0e5, true, Optional.of(trabajadoresRealEstate));
        BlackRock.addSubsidiaria(BRRealEtate);
        BRRealEtate.addTrabajadores(trabajadoresRealEstate);
    }
    
    public static void listarEmpresa(){
        System.out.println(alphabet.getRazonSocial());
        alphabet.getListaSubsidiarias().stream().map(x -> x.getRazonSocial()).forEach(x ->System.out.println(x));
    }
    
    public static void imprimeEmpresa(){
        System.out.println(alphabet.toString());
    }
    
    public static void imprimeEmpresaResumen(){
        //System.out.println(alphabet.toString());
        System.out.println(alphabet.toString() + alphabet.getListaSubsidiarias());
    }
    
    public static void imprimeTrabajadores(){
        System.out.println(deepMind.getListaTotalTrabajadores());
        System.out.println(google.getListaTotalTrabajadores());
        System.out.println(googleFiber.getListaTotalTrabajadores());
    }
    
    public static List<Trabajador> listaTrab(){
        List<Trabajador> a =deepMind.getListaTotalTrabajadores();
        List<Trabajador> b =google.getListaTotalTrabajadores(); 
        List<Trabajador> c =googleFiber.getListaTotalTrabajadores();
        List<Trabajador> todas = new ArrayList<Trabajador>();
        todas.addAll(a);
        todas.addAll(b);
        todas.addAll(b);
        
        return todas;
    }
    
    public static List<Trabajador> listaBlackRock(){
        List<Trabajador> a =FutureAdvisor.getListaTotalTrabajadores();
        List<Trabajador> b =AperioGroup.getListaTotalTrabajadores(); 
        List<Trabajador> c =BRRealEtate.getListaTotalTrabajadores();
        List<Trabajador> todas = new ArrayList<Trabajador>();
        todas.addAll(a);
        todas.addAll(b);
        todas.addAll(b);
        
        return todas;
    }
    
    public static List<Trabajador> listaBlackRockMap(Map<String, Empresa> optEmpresa){
        List<Trabajador> a =optEmpresa.getOrDefault("Xs Future Advisor Sl.", FutureAdvisor).getListaTotalTrabajadores();
        List<Trabajador> b =optEmpresa.getOrDefault("Aperio Group, LLC", AperioGroup).getListaTotalTrabajadores(); 
        List<Trabajador> c =optEmpresa.getOrDefault("Black Rock Real Estate", BRRealEtate).getListaTotalTrabajadores();
        List<Trabajador> todas = new ArrayList<Trabajador>();
        todas.addAll(a);
        todas.addAll(b);
        todas.addAll(b);
        
        return todas;
    }
    
    public static List<Trabajador> listaTrabAlp(Map<String, Empresa> optEmpresa){
        List<Trabajador> a =optEmpresa.getOrDefault("DeepMind", deepMind).getListaTotalTrabajadores();
        List<Trabajador> b =optEmpresa.getOrDefault("Google", google).getListaTotalTrabajadores();
        List<Trabajador> c =optEmpresa.getOrDefault("Google Fiber", googleFiber).getListaTotalTrabajadores();
        List<Trabajador> todas = new ArrayList<Trabajador>();
        todas.addAll(a);
        todas.addAll(b);
        todas.addAll(b);
        
        return todas;
    }
    
    public static Map<String, Empresa> generaEmpresas(){
        generaAlphabet();
        generaBlackRock();
        List<Empresa> alp = new ArrayList<Empresa>();
        alp.add(alphabet );
        alp.addAll(alphabet.getListaSubsidiarias());
        alp.add(BlackRock);
        alp.addAll(BlackRock.getListaSubsidiarias());
        
        return alp.stream().collect(Collectors.toMap( t -> t.getRazonSocial(), e -> e));    
    }
    
    //estadisticas
    public static String maxGanancias(Map<String, Empresa> empresa){
       Empresa empresaMaxGanancias = empresa.values().stream().collect(Collectors.maxBy(Comparator.comparingDouble(Empresa::getGananciasBruto))).get();
       String empresaToStringFormat = " Razon Social: " + empresaMaxGanancias.getRazonSocial() +"       Telefono:"+ empresaMaxGanancias.getTelefono() 
               +"\n Direccion: "+ empresaMaxGanancias.getDireccion() + "\n Ganancias Brutas: "+ empresaMaxGanancias.getGananciasBruto() ;
      String patron = "\nEmpresa:\n %s";
       
       return String.format(patron, empresaToStringFormat);
    }
    public static String minGanancias(Map<String, Empresa> empresa){
        
       Empresa empresaMinGanancias = empresa.values().stream().filter(e -> e.isEsSubsidiaria()==false).collect(Collectors.minBy(Comparator.comparingDouble(Empresa::getGananciasBruto))).get();
    
       String empresaToStringFormat = " Razon Social: " + empresaMinGanancias.getRazonSocial() +"       Telefono:"+ empresaMinGanancias.getTelefono() 
               +"\n Direccion: "+ empresaMinGanancias.getDireccion() + "\n Ganancias Brutas: "+ empresaMinGanancias.getGananciasBruto() ;
      String patron = "\nEmpresa:\n %s";
       
       return String.format(patron, empresaToStringFormat);
        
    }
    
    public static String mediaGanancias(Map<String, Empresa> empresa){
       double mediaGananciasE = empresa.values().stream().mapToDouble(e -> e.getGananciasBruto()).average().getAsDouble();
       return "\nMedia de Ganancias de todas las Empresas: " + mediaGananciasE ;
    }
    
    //estadisticas subsidiarias
    public static String maxGananciasSubsidiaris(Empresa empresa){
        Empresa subsidiariaMax = empresa.getListaSubsidiarias().stream().collect(Collectors.maxBy(Comparator.comparing(Empresa::getGananciasBruto))).get();
        String empresaToStringFormat = " Razon Social: " + subsidiariaMax.getRazonSocial() +"       Telefono:"+ subsidiariaMax.getTelefono() 
               +"\n Direccion: "+ subsidiariaMax.getDireccion() + "\n Ganancias Brutas: "+ subsidiariaMax.getGananciasBruto() ;
      String patron = "\nEmpresa:\n %s";
       
       return String.format(patron, empresaToStringFormat);
    }
    
    public static String minGananciasSubsidiaris(Empresa empresa){
        Empresa subsidiariaMin = empresa.getListaSubsidiarias().stream().collect(Collectors.minBy(Comparator.comparing(Empresa::getGananciasBruto))).get();
        String empresaToStringFormat = " Razon Social: " + subsidiariaMin.getRazonSocial() +"       Telefono:"+ subsidiariaMin.getTelefono() 
               +"\n Direccion: "+ subsidiariaMin.getDireccion() + "\n Ganancias Brutas: "+ subsidiariaMin.getGananciasBruto() ;
      String patron = "\nEmpresa:\n %s";
       
       return String.format(patron, empresaToStringFormat);
    }
    
    public static String mediaGananciasSubsidiarias(Empresa empresa){
        double mediaGananciasSub = empresa.getListaSubsidiarias().stream().mapToDouble(e -> e.getGananciasBruto()).average().getAsDouble();
        return "\n Media de ganancias por subsidiarias: " + mediaGananciasSub;
    }
}
