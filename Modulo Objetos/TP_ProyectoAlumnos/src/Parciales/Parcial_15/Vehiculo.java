/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_15;

/**
 *
 * @author lucia
 */
public class Vehiculo {
    private String patente;
    private int cantHoraEst;
    private String marca;
    private String modelo;
    public Vehiculo(String unaPatente, int unaCantHorasEst, String unaMarca, String unModelo) {
        this.patente = unaPatente;
        this.cantHoraEst = unaCantHorasEst;
        this.marca = unaMarca;
        this.modelo = unModelo;
    }

    public String getModelo() {
        return modelo;
    }
    
    @Override
    public String toString() {
        return "Patente: " + this.patente + ", Marca: " + this.marca + ", Modelo: " + this.modelo + ", Horas estacionado: " + this.cantHoraEst;
    }

    public int getCantHoraEst() {
        return cantHoraEst;
    }
    
    
    
}
