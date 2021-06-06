
package modelo.trabajadores;

import debug.GeneracionAtributosAleatorios;
import almacenes.AntiguedadEnum;
import almacenes.CategoriaEnum;
import modelo.cuentasbancarias.CuentaBancaria;
import debug.GeneraCuentaBancaria;
import java.io.Serializable;

public class EstudianteAdapter extends Trabajador implements Serializable{
    
    private EstudianteEnPracticas estudiante;
    private double sueldo = 0;
    private CategoriaEnum categoria = CategoriaEnum.CATEGORIA_ESTUDIANTE;
    private AntiguedadEnum antiguedad = AntiguedadEnum.ANTIGUEDAD_NOVATO;
    //Sueldo  sueldoStudient = ()->0.0;
    private int id ;
    private String nombre;
    private int edad;
    private Fecha fecha_alta;
    private String direccion;
    private CuentaBancaria cuenta;
    private String iban = GeneracionAtributosAleatorios.getIbanEstudiante();

    //no podremos hacer new desde fuera del paquete
    protected EstudianteAdapter(TrabajadorBuilder builder, EstudianteEnPracticas estudiante) {
         super(builder
                .categoria(CategoriaEnum.CATEGORIA_ESTUDIANTE)
                .antiguedad(AntiguedadEnum.ANTIGUEDAD_NOVATO)
                .sueldo(0.0)
                .cuenta(GeneraCuentaBancaria.generaCuentaEstudiante(builder.getId()))
                .iban(GeneracionAtributosAleatorios.getIbanEstudiante()));
         this.id = builder.getId();
         this.nombre = builder.getNombre();
         this.edad = builder.getEdad();
         this.direccion = builder.getDireccion();
         this.fecha_alta = builder.getFecha_alta();
        //this.estudiante = estudiante;
        this.estudiante = EstudianteEnPracticas.of();
    }
    
   public String toString(){
        String estudiaa = "Trabador { trabajador_id = " + this.id +", nombre= "+this.nombre+", edad= "+this.edad
                +", Antigüedad= "+this.antiguedad.getNombre()
                +", Direccion= "+this.direccion+", Categoria= "
                +this.categoria.getNombre()+", Fecha de Alta= "
                +this.fecha_alta.laFechaES()+", Sueldo= "+Math.round(this.sueldo*100.0)/100.0 + "}\n"
                +  " [cuenta = "+ this.cuenta+ ", IBAN = "+this.iban+"] ";
        return estudiaa;
    }
}
                