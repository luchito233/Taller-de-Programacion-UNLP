/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_19;

/**
 *
 * @author lucia
 */
public class Programador {
    private String nombre;
    private int dni;
    private double sueldoBasico;
    private int lineasXhora;
    private String lenguajePref;
    public Programador(String unNombre, int unDni, double unSueldoBasico, int cantLxH, String unLenguajeP) {
        this.nombre = unNombre;
        this.dni = unDni;
        this.sueldoBasico = unSueldoBasico;
        this.lineasXhora = cantLxH;
        this.lenguajePref = unLenguajeP;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }
    
    public void aumentarSueldo(double M) {
        this.sueldoBasico = this.sueldoBasico + M;
    }
    
    public double sueldoFinal() {
        double aux = this.sueldoBasico;
        if(this.lineasXhora > 200)
            aux += 50000.0; 
        return aux;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + this.nombre + ", Dni: " + this.dni + ", Lenguaje de Preferencia: " + this.lenguajePref;
    }
    
}
