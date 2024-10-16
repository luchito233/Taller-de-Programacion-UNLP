/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial9;

/**
 *
 * @author lucia
 */
public class Butaca {
    private String descriptor;
    private double precio;
    private boolean estado;
    public Butaca(String unDescriptor, double unPrecio, int unaFila, int unaButacaXfila) {
        
        this.descriptor = "Butaca " + unaFila + "." + unaButacaXfila;
        this.precio = 800+100*unaFila;
        this.estado = false;
        
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }
    
    @Override
    public String toString () {
        return "Descriptor: " + this.descriptor + ", Precio: " + this.precio + ", Esta Ocupado? " + this.estado;
    }
    
}
