/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial7;

/**
 *
 * @author lucia
 */
public class Goleador {
    private String nombre;
    private String nomEquipo;
    private int cantGoles; 
    public Goleador(String unNombre, String unNombreDelEquipo, int cantidadGoles) {
        this.nombre = unNombre;
        this.nomEquipo = unNombreDelEquipo;
        this.cantGoles = cantidadGoles;
    }

    public int getCantGoles() {
        return cantGoles;
    }

    @Override
    public String toString() {
        return "{" + "nombre=" + this.nombre + ", nomEquipo=" + this.nomEquipo + ", cantGoles=" + this.cantGoles + '}';
    }

   
    
    
    
}
