/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_21;

/**
 *
 * @author lucia
 */
public class Estacion {
    private String direccion;
    private int cantMaxima;
    private int cantSurtidores;
    private Surtidor[] surtidores;

    public Estacion(String direccion, int cantMaxima) {
        this.direccion = direccion;
        this.cantMaxima = cantMaxima;
        this.cantSurtidores = 0;
        this.surtidores = new Surtidor[this.cantMaxima];
    }
    
    private boolean sePuede() {
        return this.cantSurtidores < this.cantMaxima;
    }
    
    public void agregarSurtidor(Surtidor unSurtidor) {
        if(this.sePuede()) {
            this.surtidores[this.cantSurtidores] = unSurtidor;
            this.cantSurtidores++;
        }
    }
    
    public void validarVenta(int unSurtidor, int unDni, int cantLitros, String unaFormaDePago) {
        Venta venta = new Venta(unDni,cantLitros,unaFormaDePago);
        this.surtidores[unSurtidor].agregarVenta(venta);
    }
    
    public void recorrerSurtidores() {
        for(int i=0; i<this.cantSurtidores ;i++) {
            this.surtidores[i].asignarMontos();
        }
    }
    
    @Override
    public String toString() {
        String aux = "Estacion de Servicio: " + this.direccion + "; Cantidad de Surtidores: " + this.cantSurtidores + "\n";
        for(int i=0; i<this.cantSurtidores; i++) {
            aux += "Surtidor " + (i+1) + ";" + this.surtidores[i].toString() + "\n";
        }        
        return aux;
    }
    
}
