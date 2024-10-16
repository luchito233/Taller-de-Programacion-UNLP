/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;
/**
 *
 * @author Alumno
 */
public class Habitacion {
     
     private double costo;
     private boolean ocupada;
     private Cliente cliente;
     
     public Habitacion(double unCosto) {
         this.costo = unCosto;
         this.ocupada = false;
     }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
    
    
    
    @Override
    public String toString() {
        String devolver = "costo: " +  this.costo + " esta ocupada? ,  " + this.ocupada; 
        if(this.ocupada) {
            devolver += this.cliente.toString();
        
        }
        return devolver;
    }
     
}