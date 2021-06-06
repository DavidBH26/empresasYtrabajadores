/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.sueldos;


import java.io.Serializable;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;
import modelo.trabajadores.Trabajador;

/**
 *
 * @author David
 */
public class EstrategiaSueldos {
    /*private static Function <Trabajador, Double> sueldoFunctionon = (t) -> (t.getAntiE().getPlus() + getSueldo()) +
            (t.getCategoriaE().getPorcentaje() * getSueldo());*/
    public static double sueldoFree= 0;
    
    public static Function <Trabajador, Double>  sueldoAnonimo = (Function <Trabajador, Double>  &Serializable) (t) -> t.getSueldo();//GeneracionAtributosAleatorios.getSueldo();
    
    public static Function <Trabajador, Double> sueldoEstudiante = (Function <Trabajador, Double>  &Serializable) (t) -> 0.0;
    
    public static Function <Trabajador, Double> sueldoFeelance = (Function <Trabajador, Double>  &Serializable) (t) -> sueldoFree;
    
    public static Function <Trabajador, Double> sueldoFunction = (Function <Trabajador, Double>  &Serializable) (t) -> (t.getAntiE().getPlus() + t.getSueldo()) + (t.getSueldo() * t.getCategoriaE().getPorcentaje());
    
    public static BiFunction <Double, Double, Double> calculoFreelance = (sH, nH) -> sH*nH;
     
        public static BiFunction <Integer, Integer, Integer> numeroAleatorio =
            (min, max) -> new Random().nextInt(max - min) + min;
    
    public static double sueldoTrabajador(Trabajador t){
        return sueldoFunction.apply(t);
    }
    
    public static double sueldoFreelance(Double horas, Double numHoras){
        
        sueldoFree = calculoFreelance.apply(horas, numHoras);
        return sueldoFree;
    }
}
