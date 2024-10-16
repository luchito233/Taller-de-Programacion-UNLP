/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial5;

/**
 *
 * @author lucia
 */
public class Paciente {
    private String nombre;
    private boolean obraSocial;
    private double costoSesion;
    public Paciente(String unNombre, boolean unaObraS, double unCostoSes) {
        this.nombre = unNombre;
        this.obraSocial = unaObraS;
        this.costoSesion = unCostoSes;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCostoSesion() {
        return costoSesion;
    }

    @Override
    public String toString() {
        return "Paciente{" + "nombre=" + nombre + ", obraSocial=" + obraSocial + ", costoSesion=" + costoSesion + '}';
    }
    
    
}
