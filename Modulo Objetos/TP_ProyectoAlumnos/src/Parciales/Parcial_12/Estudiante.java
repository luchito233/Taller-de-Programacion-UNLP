/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_12;

/**
 *
 * @author lucia
 */
public class Estudiante {
    private String nombre;
    private String apellido;
    private int dni;
    public Estudiante(String unNombre, String unApellido, int unDni) {
        this.nombre = unNombre;
        this.apellido = unApellido;
        this.dni = unDni;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + this.nombre + ", Apellido: " + this.apellido + ", Dni: " + this.dni;
    }
    
}
