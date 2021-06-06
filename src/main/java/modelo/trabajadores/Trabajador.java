
package modelo.trabajadores;

import almacenes.AntiguedadEnum;
import almacenes.CategoriaEnum;
import java.io.Serializable;
import modelo.cuentasbancarias.CuentaBancaria;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Function;


public class Trabajador implements Antiguedad, Serializable{
    private String nombre;
    private int edad, antiguedad,categoria;
    private Fecha fecha_alta;
    private CategoriaEnum categoriaE;
    private AntiguedadEnum antiE;
    private double sueldo;
    private Function sueldoFuncion;
    private int id;
    private String direccion;
    private CuentaBancaria cuenta;
    private String iban;
    
    //no se puede hacer new de trabajador
    private Trabajador() {
    }
    
    public Trabajador(TrabajadorBuilder builder){
        this.nombre= builder.getNombre();
        this.edad= builder.getEdad();
        this.categoria= builder.getCategoria();
        this.antiguedad= builder.getAntiguedad();
        this.fecha_alta= builder.getFecha_alta();
        this.categoriaE= builder.getCategoria(categoria);
        this.antiE=builder.getAntiguedad(antiguedad);
        this.sueldo=builder.getSueldo();
        this.sueldoFuncion = builder.getSueldoFuncion();
        this.id=builder.getId();
        this.direccion=builder.getDireccion();
        this.cuenta = builder.getCuenta();
        this.iban = builder.getIban();
    }

    public double getSueldoFuncion(){
        return (double) sueldoFuncion.apply(this);
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getEdad(){
        return this.edad;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public double getSueldo(){
        return this.sueldo;
    }
    
    public int getCategoria(){
        return this.categoriaE.getNumero();
    }
    
    public String getDireccion(){
        return this.direccion;
    }
    
    public Fecha getFecha(){
        return this.fecha_alta;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Fecha getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Fecha fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public CategoriaEnum getCategoriaE() {
        return categoriaE;
    }

    public void setCategoriaE(CategoriaEnum categoriaE) {
        this.categoriaE = categoriaE;
    }

    public AntiguedadEnum getAntiE() {
        return antiE;
    }

    public void setAntiE(AntiguedadEnum antiE) {
        this.antiE = antiE;
    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }
    
    public String nombreCategoria(){
        return this.categoriaE.getNombre();
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
  
    public void pagoMensual(){
        Calendar fechaActual = Calendar.getInstance();
        if (fechaActual.DATE==28)
            System.out.println("El sueldo a sido enviado");
    }
    
    //private Function <Trabajador, Double> sueldoFunction = (t) -> (t.getAntiE().getPlus() + getSueldo()) +
        //    (t.getCategoriaE().getPorcentaje() * getSueldo());
    /*@Override
    public boolean antiguedadCorrecta(){
        boolean antiguedadCorrecta=(antiguedad<=2&&antiguedad>=0);
        return antiguedadCorrecta;
    }*/
    @Override
    public String nombreAntiguedad(int nA){
        String nAnt;
        switch (nA){
            case 0: nAnt=AntiguedadEnum.ANTIGUEDAD_NOVATO.getNombre();
                    break;
            case 1: nAnt=AntiguedadEnum.ANTIGUEDAD_MADURO.getNombre();
                    break;
            case 2: nAnt=AntiguedadEnum.ANTIGUEDAD_EXPERTO.getNombre();
                    break;
            
            default: nAnt=AntiguedadEnum.ANTIGUEDAD_NOVATO/*ANTIGUEDAD_ERRONEA*/.getNombre();    
        }
        return nAnt;   
    }
    
    @Override
    public String toString(){
        String result="Trabador { trabajador_id = " + this.id +", nombre= "+this.nombre+", edad= "+this.edad
                +", Antigüedad= "+this.antiE.getNombre()
                +", Direccion= "+this.direccion+", Categoria= "
                +this.categoriaE.getNombre()+", Fecha de Alta= "
                +this.fecha_alta.laFechaES()+", Sueldo base= "+Math.round(this.sueldo*100.0)/100.0+ ", Sueldo= "
                +sueldoFuncion.apply(this)+"}\n" + " cuenta: "+this.cuenta;
        return result;
    }
}
