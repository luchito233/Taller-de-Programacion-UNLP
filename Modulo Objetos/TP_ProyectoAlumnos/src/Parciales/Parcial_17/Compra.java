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
public class Compra {
    private int numero;
    private Fecha fecha;
    private int cantMaxima;
    private int cantProductos;
    private Producto[] productos;

    public Compra(int numero, Fecha fecha, int cantMaxima) {
        this.numero = numero;
        this.fecha = fecha;
        this.cantMaxima = cantMaxima;
        this.cantProductos = 0;
        this.productos = new Producto[this.cantMaxima];
    }
    
    private boolean sePuede() {
        return this.cantProductos <this.cantMaxima;
    }
    
    public void agregarProducto(Producto unProducto) {
        if(this.sePuede()) {
            this.productos[this.cantProductos] = unProducto;
            this.cantProductos++;
        }
    }
    
    public double sumaTotal() {
        double aux = 0.0;
        for(int i=0; i<this.cantProductos ;i++) 
            aux += this.productos[i].precioFinal();
        return aux;
    }
    
    @Override
    public String toString() {
        String aux = "Numero: " + this.numero + ", fecha: " + this.fecha.toString() + "\n";
        for(int i=0; i<this.cantProductos ;i++) {
            aux += this.productos[i].toString() + "\n";
        }
        aux += "precio final de la compra: " + this.sumaTotal();
        return aux;
    }
    
    public boolean abonableEnCuotas() {
        return this.sumaTotal() > 100000;
    }
    
}
