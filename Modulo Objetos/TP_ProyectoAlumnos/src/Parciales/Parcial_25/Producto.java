/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_25;

/**
 *
 * @author lucia
 */
public class Producto {
    private int codigo;
    private String nombre;
    private String marca;
    private int cantUniExhibidas;
    private double precioXunidad;

    public Producto(int codigo, String nombre, String marca, int cantUniExhibidas, double precioXunidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.cantUniExhibidas = cantUniExhibidas;
        this.precioXunidad = precioXunidad;
    }

    public String getMarca() {
        return marca;
    }

    public int getCantUniExhibidas() {
        return cantUniExhibidas;
    }
    
    @Override
    public String toString() {
        return "Producto{" + this.codigo + " - " +this.nombre + " - " + this.marca + " - " + this.cantUniExhibidas + " - " + this.precioXunidad + "}";
    }
    
}
