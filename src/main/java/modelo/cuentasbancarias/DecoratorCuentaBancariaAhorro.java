/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.cuentasbancarias;

public class DecoratorCuentaBancariaAhorro extends DecoratorCuentaBancaria {
    
    public DecoratorCuentaBancariaAhorro(CuentaBancaria cuenta){
        this.cuenta = cuenta;
        this.setIban(cuenta.getIban());
        this.setTitular(cuenta.getTitular());
    }

    @Override
    public String getFuncion() {
        return cuenta.getFuncion() + " AHORRO";
    }

    @Override
    public double getTipoInteres() {
        return cuenta.getTipoInteres() + 0.02;
    }

    @Override
    public double getComisionMantenimiento() {
        return cuenta.getComisionMantenimiento() + 1;
    }
    
}
