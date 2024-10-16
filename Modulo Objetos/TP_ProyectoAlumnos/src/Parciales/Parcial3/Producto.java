/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial3;

/**
 *
 * @author lucia
 */
public class Producto {
    private int codigo;
    private double precio;
    private String descripcion;
    public Producto(int unCodigo, double unPrecio, String unDescripcion) {
        this.codigo = unCodigo;
        this.precio = unPrecio;
        this.descripcion = unDescripcion;
    }

    public double getPrecio() {
        return precio;
    }
    
    public String toString() {
        return "Codigo: " + this.codigo + ", Precio: " + this.precio + ", Descripcion: " + this.descripcion;
    }
    
}
