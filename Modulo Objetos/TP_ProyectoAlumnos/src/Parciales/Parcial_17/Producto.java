/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_17;

/**
 *
 * @author lucia
 */
public class Producto {
    private int codigo;
    private String descripcion;
    private double precioUnitario;
    private int cantUniVendidas;

    public Producto(int codigo, String descripcion, double precioUnitario, int cantUniVendidas) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.cantUniVendidas = cantUniVendidas;
    }

    public int getCantUniVendidas() {
        return cantUniVendidas;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }
    
    public double precioFinal() {
        return this.cantUniVendidas * this.precioUnitario;
    }
    
    @Override
    public String toString() {
        return "codigo: " + this.codigo + ", descripcion: " + this.descripcion + ", precio final: " + this.precioFinal();
    }
}
