/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package debug;

import modelo.cuentasbancarias.CuentaBancaria;
import modelo.cuentasbancarias.DecoratorCuentaBancariaAhorro;
import modelo.cuentasbancarias.DecoratorCuentaBancariaCorriente;
import modelo.cuentasbancarias.DecoratorCuentaBancariaPrestamo;
import debug.GeneracionAtributosAleatorios;

public class GeneraCuentaBancaria {
    
    public static CuentaBancaria generaCuenta(int idTrabajador){
        CuentaBancaria cuenta = new CuentaBancaria(idTrabajador, GeneracionAtributosAleatorios.getIban());
        CuentaBancaria[] cuentas = {cuenta = new DecoratorCuentaBancariaAhorro(cuenta)
                , cuenta = new DecoratorCuentaBancariaCorriente(cuenta)
                , cuenta = new DecoratorCuentaBancariaPrestamo(cuenta)};
        return cuentas[(int)Math.floor(Math.random()*cuentas.length)];
        
    }
    
    //metodo para cuenta estudiante, que no hace falta
    public static CuentaBancaria generaCuentaEstudiante(int idTrabajador){
        CuentaBancaria cuentaEstudiante = new CuentaBancaria(idTrabajador, GeneracionAtributosAleatorios.getIbanEstudiante());
        return cuentaEstudiante;
    }
}
