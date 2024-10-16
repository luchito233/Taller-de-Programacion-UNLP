/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial6;

/**
 *
 * @author lucia
 */
public class Paciente {
    private String nombre;
    private boolean obraSocial;
    private double costoAabonar;

    public Paciente(String nombre, boolean obraSocial, double costoAabonar) {
        this.nombre = nombre;
        this.obraSocial = obraSocial;
        this.costoAabonar = costoAabonar;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "nombre=" + this.nombre + ", obraSocial=" + this.obraSocial + ", costoAabonar=" + this.costoAabonar;
    }
    
}
