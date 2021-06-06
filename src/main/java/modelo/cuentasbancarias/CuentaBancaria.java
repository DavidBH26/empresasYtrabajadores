
package modelo.cuentasbancarias;

import java.io.Serializable;

public class CuentaBancaria implements Serializable{//Component
    private int titular;
    private String iban;
    private double comisionMantenimiento = 0;
    private double tipoInteres = 0;
    private String funcion = " cobrar ingresos";
    
    public CuentaBancaria(){

    }
    
    public CuentaBancaria(int titular, String iban){
        super();
        this.titular = titular;
        this.iban = iban;
    }

    public int getTitular() {
        return titular;
    }

    public void setTitular(int titular) {
        this.titular = titular;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getComisionMantenimiento() {
        return comisionMantenimiento;
    }

    public double getTipoInteres() {
        return tipoInteres;
    }

    public String getFuncion() {
        return funcion;
    }
    
    @Override
    public String toString(){
        return "Cuenta Bancaria [titular = " + this.titular + " , IBAN = " + this.iban + " ,comision de mantenimiento = " 
                + getComisionMantenimiento() + ", tipo de interes = " + getTipoInteres() + ", funcion = " + getFuncion() + "]";
    }
}
