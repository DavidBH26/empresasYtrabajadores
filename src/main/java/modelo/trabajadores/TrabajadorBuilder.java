
package modelo.trabajadores;

import almacenes.AntiguedadEnum;
import almacenes.CategoriaEnum;
import java.util.function.Function;
import modelo.cuentasbancarias.CuentaBancaria;

public class TrabajadorBuilder {
    private String nombre;
    private int edad, antiguedad,categoria;
    private Fecha fecha_alta;
    private CategoriaEnum  categoriaE;
    private AntiguedadEnum antiguedadE;
    private double sueldo;
    private Function sueldoFuncion;
    private int id;
    private String direccion;
    private String iban;
    private EstudianteEnPracticas estudiante;
    private CuentaBancaria cuenta;
    
    public TrabajadorBuilder() {
    }
    
    public Function getSueldoFuncion(){
        return sueldoFuncion;
    }
    
    public CuentaBancaria getCuenta(){
        return cuenta;
    }
    //numero de cuenta
    public String getIban(){
        return iban;
    }
    public String getDireccion(){
        return direccion;
    }
    
    public int getId(){
        return id;
    }
    
    public double getSueldo() {
        return sueldo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getEdad() {
        return this.edad;
    }
    
    public int getAntiguedad() {
        return antiguedad;
    }
    
    public int getCategoria() {
        return categoria;
    }
    
    public Fecha getFecha_alta() {
        return fecha_alta;
    }
    
    public TrabajadorBuilder sueldoFuncion(Function sueldoFuncion){
        this.sueldoFuncion = sueldoFuncion;
        return this;
    }
   
    public CategoriaEnum getCategoria(int categoria) {
        return categoriaE;
    }
    
    public AntiguedadEnum getAntiguedad(int antiguedad) {
        return antiguedadE;
    }
    
    public TrabajadorBuilder cuenta(CuentaBancaria cuenta){
        this.cuenta = cuenta;
        return this;
    }
     //numero de cuenta
    public TrabajadorBuilder iban(String iban){
        this.iban = iban;
        return this;
    }
    
    public TrabajadorBuilder direccion(String direccion){
        this.direccion = direccion;
        return this;
    }
    
    public TrabajadorBuilder id(int id){
        this.id = id;
        return this;
    }
    
    public TrabajadorBuilder nombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    
    public TrabajadorBuilder edad(int edad){
        this.edad = edad;
        return this;
    }
    
    public TrabajadorBuilder categoria(int categoria){
        this.categoria = categoria;
        return this;
    }
       
    public TrabajadorBuilder antiguedad(int antiguedad){
        this.antiguedad = antiguedad;
        return this;
    }
    
    public TrabajadorBuilder fecha_alta(Fecha fecha_alta){
        this.fecha_alta = fecha_alta;
        return this;
    }
    
    public TrabajadorBuilder categoria(CategoriaEnum categoriaE){
        this.categoriaE = categoriaE;
        return this;
    }
    
    public TrabajadorBuilder antiguedad(AntiguedadEnum antiguedadE){
        this.antiguedadE = antiguedadE;
        return this;
    }
    
    public TrabajadorBuilder sueldo(double sueldo){
        this.sueldo = sueldo;
        return this;
    }
    //metodos buildAdaprer y estudiante en practicas
    
    public Trabajador build(){
        if (this.categoriaE==CategoriaEnum.CATEGORIA_ESTUDIANTE)
            return new EstudianteAdapter(this, estudiante);
        else
        return new Trabajador(this);
    }
    
}
