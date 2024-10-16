/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_14;

/**
 *
 * @author lucia
 */
public abstract class Trabajador {
    private String nombre;
    private int dni;
    private int anioDeIngreso;
    private double sueldoBasico;
    public Trabajador(String unNombre, int unDni, int unAnioDeIngreso, double unSueldoBasico) {
        this.nombre = unNombre;
        this.dni = unDni;
        this.anioDeIngreso = unAnioDeIngreso;
        this.sueldoBasico = unSueldoBasico;
    }
    
    public double sueldoAcobrar() {
        double aux = this.sueldoBasico;
        if((2023 - this.anioDeIngreso) > 20)
            aux += (aux * 0.10);
        return aux + this.sueldoAdicional();
    }
    
    public abstract double sueldoAdicional();
    
    @Override
    public String toString() {
        return "Nombre: " + this.nombre + ", DNI: " + this.dni + ", Sueldo a Cobrar " + this.sueldoAcobrar();
    }
    
    
}
