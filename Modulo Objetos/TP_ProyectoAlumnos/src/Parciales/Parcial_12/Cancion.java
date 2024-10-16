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
public class Cancion {
    private String nombre;
    private String compositor;
    private int indentificador;
    private Estudiante ganador;
    private double puntaje;
    public Cancion(String unNombre, String unCompositor, int unIdentificador) {
        this.nombre = unNombre;
        this.compositor = unCompositor;
        this.indentificador = unIdentificador;
        this.puntaje = 0.0;
    }

    public int getIndentificador() {
        return indentificador;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public void setGanador(Estudiante ganador) {
        this.ganador = ganador;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

    public Estudiante getGanador() {
        return ganador;
    }
    
    @Override
    public String toString() {
        return "Nombre de la cancion: " + this.nombre + ", Compositor: " + this.compositor;
    }
    
}
