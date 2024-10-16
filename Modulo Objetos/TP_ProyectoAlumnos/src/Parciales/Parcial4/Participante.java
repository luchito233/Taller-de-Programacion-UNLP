/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial4;

/**
 *
 * @author lucia
 */
public class Participante {
    private int dni;
    private String nombre;
    private int edad;
    public Participante(int unDni, String unNombre, int unaEdad) {
        this.dni = unDni;
        this.nombre = unNombre;
        this.edad = unaEdad;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Participante{" + "dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + '}';
    }
    
    
    
}
