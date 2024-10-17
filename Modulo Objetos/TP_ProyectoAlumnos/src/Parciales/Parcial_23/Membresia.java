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
public abstract class Membresia {
    private String nombre;
    private String fechaDeCreacion;
    private int cantMaxima;
    private int cantJugadores;
    private Jugador[] membresia;

    public Membresia(String nombre, String fechaDeCreacion, int cantMaxima) {
        this.nombre = nombre;
        this.fechaDeCreacion = fechaDeCreacion;
        this.cantMaxima = cantMaxima;
        this.cantJugadores = 0;
        this.membresia = new Jugador[this.cantMaxima];
    }

    public int getCantJugadores() {
        return cantJugadores;
    }
    
    private boolean sePuede() {
        return this.cantJugadores < this.cantMaxima;
    }
    
    public void agregarJugador(Jugador unJugador) {
        if(this.sePuede()) {
            this.membresia[this.cantJugadores] = unJugador;
            this.cantJugadores++;
        }
    }
    
    public Jugador obtenerJugador(int J) {
        return this.membresia[J];
    }
    
    public void asignarPuntaje(double unPuntaje, String unNombreYapellido) {
        boolean esta = false;
        int indice = 0;
        while(indice < this.cantJugadores && !esta) {
            if(this.membresia[indice].getNombreYapellido().equals(unNombreYapellido)) {
                esta = true;
                this.membresia[indice].aumentarPuntaje(unPuntaje);
                this.membresia[indice].aumentarApuestasGanadas();
            }
            else
                indice++;
        }
    }
    
    public abstract String mejorJugador();
    
    @Override
    public String toString() {
        return "Nombre de la membresia: " + this.nombre + ", fecha de crecion: " + this.fechaDeCreacion + "\n" + this.mejorJugador();
    }
    
}
