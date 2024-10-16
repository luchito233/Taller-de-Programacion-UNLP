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
public class CompraMayorista extends Compra {
    private int cuil;
    private String nombre;

    public CompraMayorista(int cuil, String nombre, int numero, Fecha fecha, int cantMaxima) {
        super(numero, fecha, cantMaxima);
        this.cuil = cuil;
        this.nombre = nombre;
    }
    
    @Override
    public void agregarProducto(Producto unProducto) {
        if(unProducto.getCantUniVendidas() > 6) 
            super.agregarProducto(unProducto);
    }
    
    @Override
    public double sumaTotal() {
        double aux = super.sumaTotal() * 0.21;
        return super.sumaTotal() - aux;
    }
    
}
