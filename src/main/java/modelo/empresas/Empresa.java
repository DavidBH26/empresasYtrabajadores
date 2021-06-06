/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.empresas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import modelo.trabajadores.Trabajador;

/**
 *
 * @author David
 */
public class Empresa implements Comparable <Empresa>, Serializable {
        private Integer idEmpresa;
        private String razonSocial;
        private Double capitalSocial;
        private String Direccion;
        private String Telefono;
        private Double gananciasBruto = 0.0;
        private boolean esSubsidiaria = false;
        
        private List <Trabajador> trabajadores;
        private Set <Empresa> subsidiarias;

    public Empresa(Integer idEmpresa, String razonSocial, Double capitalSocial, String Direccion, String Telefono, Double gananciasBruto, boolean esSubsidiaria) {
        this.idEmpresa = idEmpresa;
        this.razonSocial = razonSocial;
        this.capitalSocial = capitalSocial;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.gananciasBruto = gananciasBruto;
        this.esSubsidiaria = esSubsidiaria;
        trabajadores = new ArrayList <Trabajador>();
        subsidiarias = new TreeSet <Empresa>();
    }
        
        

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Double getCapitalSocial() {//pasar a metodo calculaCapitalSocial?
        if (subsidiarias.size() > 0){
            return subsidiarias.stream().mapToDouble(es -> es.getCapitalSocial()).sum();
        }else{
            return capitalSocial;
        }
    }

    public void setCapitalSocial(Double capitalSocial) {
        this.capitalSocial = capitalSocial;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public Double getGananciasBruto() {
        if (subsidiarias.size() > 0){
            return subsidiarias.stream().mapToDouble(es -> es.getGananciasBruto()).sum();
        }else{
            return gananciasBruto;
        }       
    }

    public void setGananciasBruto(Double gananciasBruto) {
        this.gananciasBruto = gananciasBruto;
    }

    public boolean isEsSubsidiaria() {
        return esSubsidiaria;
    }

    public void setEsSubsidiaria(boolean esSubsidiaria) {
        this.esSubsidiaria = esSubsidiaria;
    }
    
    public List <Trabajador> getListaTotalTrabajadores(){//comprobar
        return trabajadores.stream().flatMap(e -> {
            List <Trabajador> totra = new ArrayList();
            totra.add(e);
            return totra.stream();
        }).collect(Collectors.toList());
    }
    
    public Set <Empresa> getListaSubsidiarias(){
        return subsidiarias.stream().flatMap(e -> {
            Set <Empresa> empS = new TreeSet();
            empS.add(e);
            return empS.stream();
        }).collect(Collectors.toSet());
    }

    @Override
    public int compareTo(Empresa o) {
        Empresa e2 = (Empresa) o;
        return this.idEmpresa > e2.idEmpresa ? 1 : (this.idEmpresa == e2.idEmpresa ? 0 : -1);
    }
    
    public void addTrabajador(Trabajador tr){
        if (esSubsidiaria == true){
            this.trabajadores.add(tr);
        }else{
            System.out.println("No se puede añadir trabajador a la empresa matriz");
        }
        
    }
    
    public void addTrabajadores(List<Trabajador> trab){
        
         if (esSubsidiaria == true){
            trab.stream().iterator().forEachRemaining(t -> trabajadores.add(t));
        }else{
            System.out.println("No se puede añadir trabajador a la empresa matriz");
        }
    }
    /*public List<Trabajador> addListaTrab(List<Trabajador> trab){
        trabajadores = trab; 
        return trabajadores;
        
    }*/
    
    //quita trabajador si esta en la lista
    public void removeTrabajador(Trabajador tr){
        if (this.trabajadores.stream().anyMatch((t) -> t.equals(tr)))this.trabajadores.remove(tr);
    }
    
    public void addSubsidiaria(Empresa es){
        if (esSubsidiaria == false){
            this.subsidiarias.add(es);
        }else{
            System.out.println("No se puede añadir una empresa subsidiaria a una subsidiaria");
        }
    }
    
    //quita subsidiaria si hay coincidencia
    public void removeSubsidiaria(Empresa es){
            if (this.subsidiarias.stream().anyMatch(e -> e.equals(es)))this.subsidiarias.remove(es);
        }
    
   public static Empresa creaEmpresa(Integer idEmpresa,String razonSocial, Double capitaSocial, String direccion, 
           String telefono, Double gananciasBruto, boolean esSubsidiaria, Optional<List<Trabajador>> optTrabajadores){
       return new Empresa(idEmpresa, razonSocial, capitaSocial, direccion, telefono, gananciasBruto, esSubsidiaria);
   }
   
        @Override
   public String toString(){
       return "Empresa { id: " + idEmpresa + ", Razon Social: " + razonSocial + ", Capital Social: " + getCapitalSocial() + 
               ", Direccion: " + Direccion + ", Telefono: " + Telefono + ", Ganancias bruto: " + getGananciasBruto() + "}";
   }
    
        
}
