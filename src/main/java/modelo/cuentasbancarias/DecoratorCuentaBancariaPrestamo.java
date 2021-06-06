/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.cuentasbancarias;

public class DecoratorCuentaBancariaPrestamo extends DecoratorCuentaBancaria {

    public DecoratorCuentaBancariaPrestamo(CuentaBancaria cuenta){
        this.cuenta = cuenta;
        this.setIban(cuenta.getIban());
        this.setTitular(cuenta.getTitular());
    }
    
    @Override
    public String getFuncion() {
        return cuenta.getFuncion() + " PRESTAMO";
    }

    @Override
    public double getTipoInteres() {
        return cuenta.getTipoInteres();
    }

    @Override
    public double getComisionMantenimiento() {
        return cuenta.getComisionMantenimiento() + 40;
    }
  
}
