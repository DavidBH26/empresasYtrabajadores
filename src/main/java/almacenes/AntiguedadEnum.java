/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenes;

public enum AntiguedadEnum {
    ANTIGUEDAD_NOVATO("NOVATO", 0, 150), ANTIGUEDAD_MADURO("MADURO", 1, 300),
    ANTIGUEDAD_EXPERTO("EXPERTO", 2, 600),/*ANTIGUEDAD_ERRONEA("ANTIGUEDAD ERRONEA",3)*/;
    
    private final String nombre;
    private final int numero;
    private final int plus;
    
    private AntiguedadEnum(String nombre, int numero, int plus){
        this.nombre = nombre;
        this.numero = numero;
        this.plus = plus;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }
    
    public int getPlus(){
        return plus;
    }
    
    public static AntiguedadEnum getAntiguedad(int num){
        AntiguedadEnum antE;
        switch(num){
            case 0: antE=AntiguedadEnum.ANTIGUEDAD_NOVATO;
                break;
            case 1: antE=AntiguedadEnum.ANTIGUEDAD_MADURO;
                break;
            case 2: antE=AntiguedadEnum.ANTIGUEDAD_EXPERTO;
                break;
            default : antE=AntiguedadEnum.ANTIGUEDAD_NOVATO/*ANTIGUEDAD_ERRONEA*/;
        }
        
        return antE;
    }
}
