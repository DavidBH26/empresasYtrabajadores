
package modelo.trabajadores;

import java.io.Serializable;
import java.util.Comparator;

enum enumMes{Enero,Febrero,Marzo,Abril,Mayo,Junio,Julio,Agosto,Septiembre,
        Octubre,Noviembre,Diciembre;
    }
public class Fecha implements Serializable{
    int dia;
    int mes;
    int anio;
    
    public Fecha(){
        dia = 1;
        mes = 1;
        anio = 2020;
    }
    
    public Fecha(int dia, int mes, int anio){
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    public boolean mesCorrecto(){
        
        boolean resultado;
        resultado = (mes<=12)?true:false;
        return resultado;
    }
    public String nombreMes(){
        String nombreMes= (mes<=12)?enumMes.values()[mes-1].toString():"error";
        
        return nombreMes;
    }
    public String laFechaES(){
        
        String laFechaES = (dia+" del mes de "+nombreMes()+ " de " + anio);
        return laFechaES;
    }
    public static  Comparator<Trabajador> comparadorFechas(){
        Comparator<Trabajador> comparaAnio = (a1, a2)-> Integer.compare(a1.getFecha().getAnio(), a2.getFecha().getAnio());
        Comparator<Trabajador> comparaMes = (m1, m2)-> Integer.compare(m1.getFecha().getMes(), m2.getFecha().getMes());
        Comparator<Trabajador> comparaDia = (d1, d2)-> Integer.compare(d1.getFecha().getDia(), d2.getFecha().getDia());
        
        return  comparaAnio.thenComparing(comparaMes.thenComparing(comparaDia));
        
    }
    
}
