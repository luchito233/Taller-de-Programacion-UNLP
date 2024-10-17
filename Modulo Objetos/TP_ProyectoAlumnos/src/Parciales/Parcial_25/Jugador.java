/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_26;

/**
 *
 * @author lucia
 */
public class Jugador {
    private String nombreYapellido;
    private int cantApuestasGanadas;
    private double puntajeObtenido;

    public Jugador(String nombreYapellido) {
        this.nombreYapellido = nombreYapellido;
        this.cantApuestasGanadas = 0;
        this.puntajeObtenido = 0;
    }

    public void aumentarPuntaje(double puntajeObtenido) {
        this.puntajeObtenido += puntajeObtenido;
    }

    public String getNombreYapellido() {
        return nombreYapellido;
    }

    public int getCantApuestasGanadas() {
        return cantApuestasGanadas;
    }

    public double getPuntajeObtenido() {
        return puntajeObtenido;
    }
    
    public void aumentarApuestasGanadas() {
        this.cantApuestasGanadas++;
    }
    
    @Override
    public String toString() {
        return "Nombre y Apellido: " + this.nombreYapellido + ", cantidadd de apuestas ganadas: " + this.cantApuestasGanadas + ", puntaje obtenido: " + this.puntajeObtenido;
    }
    
}
