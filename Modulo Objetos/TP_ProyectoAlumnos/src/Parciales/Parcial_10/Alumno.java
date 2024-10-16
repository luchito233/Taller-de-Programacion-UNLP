/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_10;
/**
 *
 * @author lucia
 */
public class Alumno {
    private String nombre;
    private int dni;
    private int nroTema;
    public Alumno(String unNombre, int unDni) {
        this.nombre = unNombre;
        this.dni = unDni;
        this.nroTema = -1;
    }

    public void setNroTema(int nroTema) {
        this.nroTema = nroTema;
    }

    public int getNroTema() {
        return nroTema;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + this.nombre + ", Dni: " + this.dni;
    }
    
}
