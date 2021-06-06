
package aplicacion;
import datos.GestorDatosFicheros;
import debug.GeneraEmpresa;
import modelo.trabajadores.Fecha;
import modelo.trabajadores.Trabajador;
import debug.GeneracionDeEmpleados;
import informes.GeneraInformes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import modelo.empresas.Empresa;
import mvc.controlador.ControladorPrincipal;


public class App {

    public static void main(String[] args) {
        
        ControladorPrincipal.inicializarControladorPrincipal();
    /*    
        Scanner sc = new Scanner(System.in);
        GestorDatosFicheros gestorProxy = GestorDatosFicheros.inicializaGestorSingleton();
        Optional<Map<String, Empresa>> optmapEmpresas = gestorProxy.read();
        
        if (optmapEmpresas.isEmpty()){
            System.out.println("Los datos no se han podido recuperar");
        } else {
            optmapEmpresas.get().values().stream().forEach(System.out::println);
             
        }
        
        Map<String,Empresa> empresas = optmapEmpresas.get();
        
        try{
       GeneraInformes.informeEmpresas(empresas);
    }catch(IOException e){
            e.printStackTrace();
            }
        
        System.out.println("Teclee el número adecuado para seleccionar la empresa\n 0 para Alphabet \n 1 para Black Rock");
        Map<String,Empresa> seleccionEmpresas = empresas.values().stream().filter(e -> e.isEsSubsidiaria()==false).collect(Collectors.toMap( t -> t.getRazonSocial(), e -> e));
        Empresa seleccionEmpresa = seleccionEmpresas.getOrDefault("Alphabet inc", GeneraEmpresa.alphabet);
        String numeroEmpresa = sc.next();
        if(Pattern.matches("0", numeroEmpresa)){
            System.out.println("Vamos a manejar la empresa Alphabet Inc\nSu listado de trabajadores es:");
            System.out.println(GeneraEmpresa.listaTrabAlp(empresas));
            seleccionEmpresa = seleccionEmpresas.getOrDefault("Alphabet inc", GeneraEmpresa.alphabet);
        }
        if(Pattern.matches("1", numeroEmpresa)){
            System.out.println("Vamos a manejar la empresa Blak Roch Inc\nSu listado de trabajadores es:");
            System.out.println(GeneraEmpresa.listaBlackRockMap(empresas));
            seleccionEmpresa = seleccionEmpresas.getOrDefault("Black Rock", GeneraEmpresa.BlackRock);
        }
        
         try{
           GeneraInformes.informeEmpresa(seleccionEmpresa);
           GeneraInformes.informeTrabajadores(seleccionEmpresa);
       }catch (IOException e){
           e.printStackTrace();
       }
       
        List <Trabajador> listaAlphabet = GeneraEmpresa.listaTrabAlp(empresas);
        List <Trabajador> listaBlackRock = GeneraEmpresa.listaBlackRockMap(empresas);
        List <Trabajador> listaTrabajadores = new ArrayList();
        listaTrabajadores.addAll(listaBlackRock);
        listaTrabajadores.addAll(listaAlphabet);
        
        
        /*
        int numTrabajadores;
        System.out.println("Cuantos trabajadores desea generar de manera aleatoria. Escriba un entero.");
        numTrabajadores=sc.nextInt();
        List <Trabajador> listaTrabajadores = GeneracionDeEmpleados.generaEmpleados(numTrabajadores);
       */
        //Trabajador[] arrayT=GeneracionDeEmpleados.generaEmpleados(numTrabajadores);
        
        //GeneraEmpresa em = new GeneraEmpresa();
        //System.out.println("generando empresa");
        //GeneraEmpresa.generaAlphabet();
        //GeneraEmpresa.listarEmpresa();
        //GeneraEmpresa.
        //GeneraEmpresa.imprimeEmpresa();
        //System.out.println("res");
         //List <Trabajador> listaTrabajadores = GeneraEmpresa.listaTrab();
        
        /*
           
        System.out.println("MENÚ PRINCIPAL *****************************************************\n" +
            "OPCIONES:\n" +
            "Escriba F para finalizar\n" +
            "Escriba P para imprimir el listado de trabajadores\n" +
            "Escriba N para ordenar por nombre\n" +
            "Escriba E para ordenar por edad\n" +
            "Escriba C para ordenar por Categoria\n" +
            "Escriba D para ordenar por Direccion\n" +
            "Escriba FE para ordenar por Fecha\n" +
            "Escriba Co para Obtener el número Total de trabajadores\n" +
            "Escriba ME para obtener la media de Edad de Empleados\n" +
            "Escriba MAXE para obtener el máximo de Edad de Empleados\n" +
            "Escriba MINE para obtener el mínimo de Edad de Empleados\n" +
            "Escriba MS para obtener la media de Sueldo de Empleados\n" +
            "Escriba MAXS para obtener el máximo de Sueldo de Empleados\n" + 
                "Escriba MAXSTRAB para obtener el trabajador con el sueldo maximo\n" + 
                "Escriba MAXSTRAB para obtener el trabajador con el sueldo maximo\n" + 
                "Escriba TRABCAT para agrupar los trabajadores por categoria\n" + 
                "Esctiba TRABANT para agrupar los trabajadores por antiguedad ");
        
        String finalizar="F", imprimir="P",ordenarPorNombre="N", ordenarPorEdad="E", ordenarPorCategoria="C";
        String numeroTrabajadores="Co", minEdad="MINE", maxEdad="MAXE", ordenarPorFecha="FE";
        String mediaEdad="ME", mediaSueldo="MS", minimoSueldo="MINS", maximoSueldo="MAXS",ordenarPorDireccion="D";
        String trabajadorMaximoSueldo ="MAXSTRAB", trabajadorMinimoSueldo = "MINSTRAB";
        String trabajadoresAgrupadosCategoria ="TRABCAT", trabajadoresAgrupadosAntiguedad = "TRABANT" ;
        int contador=0;
        while (contador<5){
            String entradaTeclado = sc.next();
            if(Pattern.matches(imprimir, entradaTeclado)){//imprimir
                GeneracionDeEmpleados.imprimeEmpleados(listaTrabajadores);
                continue;    
            }
            
            if(Pattern.matches(finalizar, entradaTeclado)){//finalizar
                System.exit(0);
            }
            
            if(Pattern.matches(numeroTrabajadores, entradaTeclado)){//numero trabajadores
                System.out.println(GeneracionDeEmpleados.numeroTrabajadores(listaTrabajadores));
                continue;
            }
            
            if(Pattern.matches(ordenarPorNombre, entradaTeclado)){//ordena por nombre
                Comparator<Trabajador> ordenaNombre= (n1,n2)-> n1.getNombre().compareTo(n2.getNombre());
                GeneracionDeEmpleados.ordenaEmpleados(ordenaNombre, listaTrabajadores).forEach(System.out::println);
                continue;
            }
            
            if (Pattern.matches(ordenarPorEdad, entradaTeclado)){//ordena por edad
                Comparator<Trabajador> ordenaPorEdad = (e1, e2)-> Integer.compare(e1.getEdad(), e2.getEdad());
                GeneracionDeEmpleados.ordenaEmpleados(ordenaPorEdad, listaTrabajadores).forEach(System.out::println);
                continue;
            }
            
            if (Pattern.matches(ordenarPorCategoria, entradaTeclado)){//ordena por categoria
                Comparator<Trabajador>ordenaCategoria = (c1, c2)-> Integer.compare(c1.getCategoria(), c2.getCategoria());
                //System.out.println(GeneracionDeEmpleados.ordenaEmpleados(ordenaCategoria, listaTrabajadores));
                GeneracionDeEmpleados.ordenaEmpleados(ordenaCategoria, listaTrabajadores).forEach(System.out::println);
                continue;
            }
            
            if (Pattern.matches(ordenarPorDireccion, entradaTeclado)){//ordena por direccion
                Comparator<Trabajador>ordenaDireccion = (d1, d2)-> d1.getDireccion().compareTo(d2.getDireccion());
                GeneracionDeEmpleados.ordenaEmpleados(ordenaDireccion, listaTrabajadores).forEach(System.out::println);
                continue;
            }
            
            if (Pattern.matches(ordenarPorFecha, entradaTeclado)){//ordena por fecha
                GeneracionDeEmpleados.ordenaEmpleados(Fecha.comparadorFechas(), listaTrabajadores).forEach(System.out::println);
                continue;
            }
            
            if(Pattern.matches(minimoSueldo, entradaTeclado)){
                System.out.println(GeneracionDeEmpleados.minimoSueldo(listaTrabajadores));
                continue;
            }
            
            if(Pattern.matches(maximoSueldo, entradaTeclado)){
                System.out.println(GeneracionDeEmpleados.maximoSueldo(listaTrabajadores));
                continue;
            }
            
            if(Pattern.matches(mediaSueldo, entradaTeclado)){
                System.out.println(GeneracionDeEmpleados.mediaSueldo(listaTrabajadores));
                continue;
            }
            
            if(Pattern.matches(mediaEdad, entradaTeclado)){
                System.out.println(GeneracionDeEmpleados.mediaEdad(listaTrabajadores));
                continue;
            }
            
            if(Pattern.matches(maxEdad, entradaTeclado)){
                System.out.println(GeneracionDeEmpleados.maximaEdad(listaTrabajadores));
                continue;
                }
            
            if (Pattern.matches(trabajadorMaximoSueldo, entradaTeclado)){
                System.out.println("---Trabajador con maximo sueldo---");
                System.out.println(GeneracionDeEmpleados.trabajadorMaximoSueldo(listaTrabajadores));
                continue;
            }
            
            if (Pattern.matches(trabajadorMinimoSueldo, entradaTeclado)){
                System.out.println("---Trabajador con minimo sueldo---");
                System.out.println(GeneracionDeEmpleados.trabajadorMinimoSueldo(listaTrabajadores));
                continue;
            }
            
            if (Pattern.matches(trabajadoresAgrupadosCategoria, entradaTeclado)){
                GeneracionDeEmpleados.imprimirEmpleadosAgrupados(GeneracionDeEmpleados.agrupaPorCategoria(listaTrabajadores));
                continue;
            }
            
            if (Pattern.matches(trabajadoresAgrupadosAntiguedad, entradaTeclado)){
                GeneracionDeEmpleados.imprimirEmpleadosAgrupados(GeneracionDeEmpleados.agrupaPorAntiguedad(listaTrabajadores));
                continue;
            }
            if (Pattern.matches("INFEMP", entradaTeclado)) {
                GeneraEmpresa.imprimeEmpresa();
                continue;
            }
            if (Pattern.matches("INFEMPS", entradaTeclado)) {
                GeneraEmpresa.imprimeEmpresaResumen();
                continue;
            }
            
            if(Pattern.matches(minEdad, entradaTeclado)){
                System.out.println(GeneracionDeEmpleados.minimaEdad(listaTrabajadores));
             
            }else{
                System.out.println("entrada erronea");
                continue;
            }
            contador++;
        }
        */
    }
}
