/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenes;

public enum CategoriaEnum {
    CATEGORIA_EMPLEADO("EMPLEADO", 0, 0.15), CATEGORIA_ENCARGADO("ENCARGADO", 1, 0.35),
    CATEGORIA_DIRECTIVO("DIRECTIVO", 2, 0.60), CATEGORIA_TECNICO("TECNICO", 3, 0.40),
    CATEGORIA_FREE_LANCE("FREE LANCE", 4, 0.0), CATEGORIA_ANONIMO("ANONIMO", 5, 0.0),
    CATEGORIA_ESTUDIANTE("ESTUDIANTE", 6, 0.0);
    
    private final String nombre;
    private final int numero;
    private final double porcentaje;

    private CategoriaEnum(String nombre, int numero, double porcentaje) {
        this.nombre = nombre;
        this.numero = numero;
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }
    
    public double getPorcentaje(){
        return porcentaje;
    }
    public static CategoriaEnum getCategoria(int num){
        CategoriaEnum catEnum;
        switch(num){
            case 0: catEnum=CategoriaEnum.CATEGORIA_EMPLEADO;
            break;
            case 1: catEnum=CategoriaEnum.CATEGORIA_ENCARGADO;
            break;
            case 2: catEnum=CategoriaEnum.CATEGORIA_DIRECTIVO;
            break;
            case 3: catEnum=CategoriaEnum.CATEGORIA_TECNICO;
            break;
            case 4: catEnum=CategoriaEnum.CATEGORIA_FREE_LANCE;
            break;
            case 5: catEnum=CategoriaEnum.CATEGORIA_ANONIMO;
            break;
            case 6: catEnum = CategoriaEnum.CATEGORIA_ESTUDIANTE;
            break;
            default: catEnum=CategoriaEnum.CATEGORIA_EMPLEADO/*CATEGORIA_ERRONEA*/;
        }
        return catEnum;
    }
}
