/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.cuentasbancarias;

public abstract class DecoratorCuentaBancaria extends CuentaBancaria {
    CuentaBancaria cuenta;
    @Override
    public abstract String getFuncion();
    @Override
    public abstract double getTipoInteres();
    @Override
    public abstract double getComisionMantenimiento();
}
