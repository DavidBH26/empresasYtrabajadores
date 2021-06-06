/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package debug;

import debug.GeneraCuentaBancaria;
import java.util.stream.IntStream;

public class ProbarCuenta {

    public static void main(String[] args) {
        IntStream.range(0, 100).mapToObj(i->GeneraCuentaBancaria.generaCuenta(i))
                .forEach((c)->System.out.println(c + "Funcion: " + c.getFuncion()));
    }
    
}
