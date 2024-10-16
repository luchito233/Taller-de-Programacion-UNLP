/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica_5;

/**
 *
 * @author lucia
 */
public class Auto {
    private String nombre;
    private int patente;
    
    
    public Auto() {
        this.nombre = "Ninguna";
        this.patente = -1;
    }
    
    public Auto(String unNombre, int unaPatente) {
        nombre = unNombre;
        patente = unaPatente;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPatente() {
        return patente;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPatente(int patente) {
        this.patente = patente;
    }

    @Override
    public String toString() {
        return "nombre: " + this.nombre + ", patente:" + this.patente;
    }
    
    
    
}
