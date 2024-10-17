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
public class MembresiaVip extends Membresia{
    private double costoDePermanencia;

    public MembresiaVip(double costoDePermanencia, String nombre, String fechaDeCreacion, int cantMaxima) {
        super(nombre, fechaDeCreacion, cantMaxima);
        this.costoDePermanencia = costoDePermanencia;
    }
    
    @Override
    public String mejorJugador() {
        double max = -1;
        double puntajeActual;
        String mejorJugador = "nadie";
        for(int i=0; i<super.getCantJugadores() ;i++) {
            puntajeActual = super.obtenerJugador(i).getPuntajeObtenido();
            if(puntajeActual > max) {
                max = puntajeActual;
                mejorJugador = super.obtenerJugador(i).toString();
            }
        }
        return mejorJugador;
    }
}
