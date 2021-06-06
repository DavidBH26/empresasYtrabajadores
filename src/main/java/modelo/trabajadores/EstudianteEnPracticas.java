/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.trabajadores;

import debug.GeneracionAtributosAleatorios;
import java.io.Serializable;

public class EstudianteEnPracticas implements Serializable{
    private String nombre;
    private String centroDeEstudios;
    private String direccion = "";
    private int edad;
    private Fecha fecha_alta;
    
    //constructor privado para no hacer new
    private EstudianteEnPracticas(){
        
    }
    
   private EstudianteEnPracticas(String nombre, String centroDeEstudios, String direccion, int edad, Fecha fecha_alta){
        this.nombre = nombre;
        this.centroDeEstudios = centroDeEstudios;
        this.direccion = direccion;
        this.edad = edad;
        this.fecha_alta = fecha_alta;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getCentroDeEstudios() {
        return centroDeEstudios;
    }

    public void setCentroDeEstudios(String centroDeEstudios) {
        this.centroDeEstudios = centroDeEstudios;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Fecha getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Fecha fecha_alta) {
        this.fecha_alta = fecha_alta;
    }
    
    //modificador protected para no hacer new desde fuera del paquete
    protected static EstudianteEnPracticas of(){
        return new EstudianteEnPracticas(GeneracionAtributosAleatorios.getNombres(),
                GeneracionAtributosAleatorios.getCentros(), GeneracionAtributosAleatorios.getDirecciones(),
                GeneracionAtributosAleatorios.getEdad(), GeneracionAtributosAleatorios.getFecha());
    }
    
    public String toString(){
        return "Estudiante en Practicas { nombre = " + this.nombre + ", edad = " + this.edad + ", centro de estudios = "
                + this.centroDeEstudios + ", direccion = " + this.direccion + /*", categoria"*/ ", fecha de alta = " + this.fecha_alta;
    }
}
