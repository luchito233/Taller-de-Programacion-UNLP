/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_24;

/**
 *
 * @author lucia
 */
public class Sistema {
    private String nombre;
    private String facultad;
    private int anioCreacion;

    public Sistema(String nombre, String facultad, int anioCreacion) {
        this.nombre = nombre;
        this.facultad = facultad;
        this.anioCreacion = anioCreacion;
    }

    public int getAnioCreacion() {
        return anioCreacion;
    }
    
    @Override
    public String toString() {
        return this.nombre + ". " + this.facultad + ". Anio de creacion: " + this.anioCreacion + "\n";
    }
    
}
