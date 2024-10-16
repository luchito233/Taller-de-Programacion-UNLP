/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial1;

/**
 *
 * @author Alumno
 */
public class Nota {
    private String nombre;
    private int nota;
    private int fecha;
    public Nota(String unNombre, int unNota, int unFecha) {
        this.nombre = unNombre;
        this.nota = unNota;
        this.fecha = unFecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }
    
    @Override
    public String toString() {
        return "Nombre de la materia: " + this.nombre + ", Nota: " + this.nota + ", Fecha: " + this.fecha;
    }
    
}
