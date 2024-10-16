/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial2;

/**
 *
 * @author lucia
 */
public class Alumno {
    private String nombre;
    private int edad;
    private String instrumento;
    private int puntaje;
    public Alumno(String unNombre, int unaEdad, String unInstrumento) {
        this.nombre = unNombre;
        this.edad = unaEdad;
        this.instrumento = unInstrumento;
        this.puntaje = -1;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + ", Edad: " + this.edad + ", Instrumento: " + this.instrumento + ", Puntaje: " + this.puntaje;
    }
    
    
    
}
