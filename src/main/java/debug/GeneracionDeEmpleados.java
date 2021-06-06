
package debug;


import almacenes.AntiguedadEnum;
import almacenes.CategoriaEnum;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import modelo.empresas.Empresa;
import modelo.sueldos.EstrategiaSueldos;
import modelo.trabajadores.Trabajador;
import modelo.trabajadores.TrabajadorBuilder;

public class GeneracionDeEmpleados {
    
    public static int index;
    
    public GeneracionDeEmpleados(){
        
    }
    
   public static List <Trabajador> generaEmpleados(int numEmpleados){
         //TrabajadorBuilder builder = new TrabajadorBuilder();
         Stream tr =  IntStream
                .range(0, numEmpleados)
                .mapToObj( i -> {
                TrabajadorBuilder builder = new TrabajadorBuilder();
                CategoriaEnum cat = CategoriaEnum.getCategoria(GeneracionAtributosAleatorios.getCategoria());    
                builder
                .id(i)
                .nombre(GeneracionAtributosAleatorios.getNombres())
                .edad(GeneracionAtributosAleatorios.getEdad())
                .categoria(cat)
                .antiguedad(AntiguedadEnum.getAntiguedad(GeneracionAtributosAleatorios.getAntiguedad()))
                .fecha_alta(GeneracionAtributosAleatorios.getFecha())
                .direccion(GeneracionAtributosAleatorios.getDirecciones())
                .sueldo(GeneracionAtributosAleatorios.getSueldo())
                .cuenta(GeneraCuentaBancaria.generaCuenta(i));
                
                if (cat == CategoriaEnum.CATEGORIA_ESTUDIANTE) {
             builder.sueldoFuncion(EstrategiaSueldos.sueldoEstudiante);
             
        }
                 if (cat == CategoriaEnum.CATEGORIA_FREE_LANCE) {
             builder.sueldoFuncion(EstrategiaSueldos.sueldoFeelance);
        }
                 if (cat == CategoriaEnum.CATEGORIA_ANONIMO) {
            builder.sueldoFuncion(EstrategiaSueldos.sueldoAnonimo);
        } else {
                     builder.sueldoFuncion(EstrategiaSueldos.sueldoFunction);
                 }
                
                return builder.build();
                });
                        
                       return (List<Trabajador>) tr .collect(Collectors.toList());
   }
         
    public static List <Trabajador> ordenaEmpleados(Comparator<Trabajador> compara, List <Trabajador> listaTrabajadores){
        return listaTrabajadores
                .stream()
                .sorted(compara)
                .collect(Collectors.toList());
    }
    
    public static int numeroTrabajadores(List <Trabajador> listaTrabajadores){
        return (int) listaTrabajadores
                .stream()
                .count();
    }
    
    public static int mediaEdad(List <Trabajador> listaTrabajadores){
        return (int) listaTrabajadores
                .stream()
                .mapToInt(e -> e.getEdad())
                .average()
                .getAsDouble();
    }
    
    public static int minimaEdad(List <Trabajador> listaTrabajadores){
        return listaTrabajadores
                .stream()
                .map(e -> e.getEdad())
                .min((e1,e2) -> e1.compareTo(e2))
                .get();
    }
    
    public static int maximaEdad(List <Trabajador> listaTrabajadores){
        return listaTrabajadores
                .stream()
                .map(e -> e.getEdad())
                .max((e1, e2) -> e1.compareTo(e2))
                .get();
    }
    
    public static double mediaSueldo(List <Trabajador> listaTrabajadores){
        return listaTrabajadores
                .stream()
                .mapToDouble(x -> x.getSueldoFuncion())
                .average()
                .getAsDouble();
    }
    
    public static double minimoSueldo(List <Trabajador> listaTrabajadores){
        return listaTrabajadores
                .stream()
                .map(t -> t.getSueldoFuncion())
                .min((t1, t2) -> t1.compareTo(t2))
                .get();
    }
        
    public static double maximoSueldo(List <Trabajador> listaTrabajadores){
        return listaTrabajadores
                .stream()
                .map(t -> t.getSueldoFuncion())
                .min((t1, t2) -> t1.compareTo(t2))
                .get();
    }
    
    public static Trabajador trabajadorMaximoSueldo(List <Trabajador> listaTrabajadores){
        return listaTrabajadores
                .stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Trabajador::getSueldoFuncion)))
                .get();
    }
    
    public static Trabajador trabajadorMinimoSueldo(List <Trabajador> listaTrabajadores){
        return listaTrabajadores
                .stream()
                .collect(Collectors.minBy(Comparator.comparingDouble(Trabajador::getSueldoFuncion)))
                .get();
    }
    
    public static HashMap <String, List<Trabajador>> agrupaPorCategoria(List <Trabajador> listaTrabajadores){
         /*Map <String, List<Trabajador>> mT =listaTrabajadores.stream().collect(Collectors.groupingBy(t -> t.getCategoriaE().getNombre()));
        HashMap <String, List<Trabajador>> hmt = new HashMap <String, List<Trabajador>>(mT);
        return hmt;*/
       /*Map <String, List<Trabajador>> mT =listaTrabajadores.stream().collect(Collectors.groupingBy((t) -> t.getCategoriaE().getNombre()));
       return (HashMap<String, List<Trabajador>>) mT;*/
        return (HashMap<String, List<Trabajador>>)listaTrabajadores
                .stream()
                .collect(Collectors.groupingBy(t -> t.getCategoriaE().getNombre()));
        }
    public static HashMap <String, List<Trabajador>> agrupaPorAntiguedad(List <Trabajador> listaTrabajadores){
        return (HashMap<String, List<Trabajador>>) listaTrabajadores
                .stream()
                .collect(Collectors.groupingBy(t -> t.getAntiE().getNombre()));
    }
    
    public static void imprimirEmpleadosAgrupados(HashMap <String, List<Trabajador>> trabajadoresAgrupados){
        System.out.println(trabajadoresAgrupados);
    }
    
    public static void imprimeEmpleados(List <Trabajador> listaTrabajadores){
        listaTrabajadores.stream().forEach(System.out::println);   
    }
    
    //public static String trabajadorSueldomasAltoInforme(Empresa empresa){
      //  empresa.getListaTotalTrabajadores()
    //}
    
    //estadisticas informe
    
    public static String trabajadorMaximoSueldoInforme(List <Trabajador> listaTrabajadores){
        Trabajador trabajaInfo = listaTrabajadores
                .stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Trabajador::getSueldoFuncion)))
                .get();
        return "\nNombre: " + trabajaInfo.getNombre() + "\nAntiguedad: " + trabajaInfo.getAntiE().getNombre()
                + "\nCategoria: " + trabajaInfo.getCategoriaE().getNombre() + "   Sueldo: " + trabajaInfo.getSueldoFuncion();
    }
    
    public static String trabajadorMinimoSueldoInforme(List <Trabajador> listaTrabajadores){
        Trabajador trabajaInfo = listaTrabajadores
                .stream()
                .collect(Collectors.minBy(Comparator.comparingDouble(Trabajador::getSueldoFuncion)))
                .get();
        return "\nNombre: " + trabajaInfo.getNombre() + "\nAntiguedad: " + trabajaInfo.getAntiE().getNombre()
                + "\nCategoria: " + trabajaInfo.getCategoriaE().getNombre() + "   Sueldo: " + trabajaInfo.getSueldo();
    }
}
