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
public class MembresiaProfesional extends Membresia{

    public MembresiaProfesional(String nombre, String fechaDeCreacion, int cantMaxima) {
        super(nombre, fechaDeCreacion, cantMaxima);
    }
    
    @Override
    public String mejorJugador() {
        double max = -1;
        double cantApuestasActual;
        String mejorJugador = "nadie";
        for(int i=0; i<super.getCantJugadores() ;i++) {
            cantApuestasActual = super.obtenerJugador(i).getCantApuestasGanadas();
            if(cantApuestasActual > max) {
                max = cantApuestasActual;
                mejorJugador = super.obtenerJugador(i).toString();
            }
        }
        return mejorJugador;
    }
    
}
