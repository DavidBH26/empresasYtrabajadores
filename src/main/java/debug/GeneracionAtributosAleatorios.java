
package debug;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import modelo.trabajadores.Fecha;

public class GeneracionAtributosAleatorios {
    
    public static final List <String> nombres = Arrays.asList("ANTONIO", "MANUEL", "JOSE",
        "FRANCISCO", "DAVID", "JUAN", "JOSE ANTONIO", "JAVIER", "DANIEL",
        "JOSE LUIS", "FRANCISCO JAVIER","CARLOS", "JESUS", "ALEJANDRO",
        "FRANCISCA", "LUCIA", "MARIA ISABEL", "MARIA JOSE", "ANTONIA",
        "DOLORES","SARA","PAULA", "ELENA", "MARIA LUISA", "RAQUEL");
    
    public static final List <String> apellidos = Arrays.asList("García", "González", "Rodríguez",
        "Fernández", "López", "Martínez", "Sánchez", "Pérez", "Gómez","Martin",
        "Jiménez", "Ruiz", "Hernández", "Diaz", "Moreno", "Muñoz", "Álvarez",
        "Romero", "Alonso", "Gutiérrez", "Navarro","Torres", "Domínguez",
        "Vázquez", "Ramos", "Gil", "Ramírez", "Serrano", "Blanco", "Molina",
        "Morales", "Suarez", "Ortega","Delgado", "Castro", "Ortiz", "Rubio",
        "Marín", "Sanz", "Núñez", "Iglesias", "Medina", "Garrido", "Cortes",
        "Castillo", "Santos");
    
    public static final List <String> direcciones  =Arrays.asList("Alfonso López de Haro",
        "Calle de Alvarfáñez de Minaya", "Calle de Arcipreste de Hita",
        "Calle de Arrabal del Agua", "Plaza de Beladíez",
        "Plaza de Caídos en la Guerra civil", "Calle Minaya",
        "Calle Hermanos Galiano");
    
    public static final List <String> centros = Arrays.asList("IES Brianda de Mendoza", "IES Buero Vallejo",
        "IES Ribera del Tajo", "IES Castilla", "IES Jose Luis Sampedro", "IES Leonardo Da Vinci",
        "IES Virrey Morcillo", "IES Valdehierro", "IES Maestre de Calatrava", "CIFP Virgen de Gracia" , 
        "IES Maestre de Calatrava", "IES Azarquiel", "IES Pedro Mercedes");
    
    //funcion numero aleatorio
    public static BiFunction <Integer, Integer, Integer> numeroAleatorio =
            (min, max) -> new Random().nextInt(max - min) + min;
    
    public static double numHoras(){
        return (double)numeroAleatorio.apply(160, 180);
    }
    
    public static double sueldoHora(){
        return (double)numeroAleatorio.apply(15, 30);
    }
    
    public static String getCentros(){
        return centros.get(numeroAleatorio.apply(0, centros.size()));
        /*String centro = GeneracionAtributosAleatorios.centros[(int)Math.floor(Math.random()*(centros.length))];
        return centro;*/
    }
     
    public static String getNombres() {
        return nombres.get(numeroAleatorio.apply(0, nombres.size())) + " "+
                apellidos.get(numeroAleatorio.apply(0, apellidos.size()))+ " "+
                apellidos.get(numeroAleatorio.apply(0, apellidos.size()));
        /*String nomb = GeneracionAtributosAleatorios.nombres
                [(int)Math.floor(Math.random()*(nombres.length))];
        nomb+= " "+GeneracionAtributosAleatorios.apellidos
                [(int)Math.floor(Math.random()*(apellidos.length))]+" "
                + GeneracionAtributosAleatorios.apellidos
                [(int)Math.floor(Math.random()*(apellidos.length))];            
        return nomb;*/                        
    }

    public static String getDirecciones() {
        return direcciones.get(numeroAleatorio.apply(0, direcciones.size()));
        /*String direccion = GeneracionAtributosAleatorios.direcciones
                [(int)Math.floor(Math.random()*(direcciones.length))];
        return direccion;*/
    }

    public static int getEdad(){
        Supplier<Integer> edadAleatoria = ()-> 
                (int)Math.floor(Math.random()*(67-18+1)+18);
        return edadAleatoria.get();
    }
    
    public static int getCategoria(){
        Supplier <Integer> categoriaAleatoria = () -> 
                (int)Math.floor(Math.random()*(6-0+1)+0);
        return categoriaAleatoria.get();
    }
    
    public static int getAntiguedad(){
        Supplier <Integer> antiguedadAleatoria = () -> 
                (int)Math.floor(Math.random()*(2-0+1)+0);
        return antiguedadAleatoria.get();
    }
    
    public static Fecha getFecha(){
        Supplier <Integer> diaAleatorio = () -> 
                (int)Math.floor(Math.random()*(30-1+1)+1);
        Supplier <Integer> mesAleatorio = () -> 
                (int)Math.floor(Math.random()*(12-1+1)+1);
        Supplier <Integer> anioAleatorio = () -> 
                (int)Math.floor(Math.random()*(2020-2000+1)+2000);
        Fecha fec = new Fecha(diaAleatorio.get(),mesAleatorio.get()
                ,anioAleatorio.get());
        return fec;
    }
    
    public static double getSueldo(){
        Supplier <Double> sueldoAleatorio = () -> 
                (Double)Math.random()*(3000-1000+1)+1000;
        return sueldoAleatorio.get();
    }
    
    public static String getIban(){
        String []banco = {"0" ,"1" ,"2", "3", "4", "5", "6", "7", "8", "9" };
       Supplier <String> cuatro = ()->  banco[(int)Math.floor(Math.random()*banco.length)] 
                + banco[(int)Math.floor(Math.random()*banco.length)]
                + banco[(int)Math.floor(Math.random()*banco.length)]
                + banco[(int)Math.floor(Math.random()*banco.length)];
       Supplier <String> dos = ()-> banco[(int)Math.floor(Math.random()*banco.length)] 
                + banco[(int)Math.floor(Math.random()*banco.length)];
       return "IBAN  ES" + dos.get() + "  " + cuatro.get() + " "+ cuatro.get() + " "+ cuatro.get() + " "+ cuatro.get() + " "+ cuatro.get() + " ";
    }
    
    public static String getIbanEstudiante(){
        String []banco = {"0" ,"1" ,"2", "3", "4", "5", "6", "7", "8", "9" };
        Supplier <String> dos = ()-> banco[(int)Math.floor(Math.random()*banco.length)] 
                + banco[(int)Math.floor(Math.random()*banco.length)];
        return "IBAN  ES"+dos.get()+"  0000 0000 0000 0000 0000";
    }
}
