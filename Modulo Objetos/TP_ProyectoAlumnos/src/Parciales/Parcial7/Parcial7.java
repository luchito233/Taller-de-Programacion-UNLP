/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial7;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Parcial7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Torneo torneo = new Torneo("Copa America",10,20);
        for(int i=0; i<5 ;i++) {
            Goleador goleador = new Goleador(GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarString(12),GeneradorAleatorio.generarInt(15));
            torneo.agregarGoleador(goleador, GeneradorAleatorio.generarInt(10)+1);
        }
        
        System.out.println(torneo.toString());
        int unaFecha = GeneradorAleatorio.generarInt(9);
        System.out.println("el goleador con menos goles realizados en la fecha " + unaFecha + ": " + torneo.menosGoles(unaFecha));
        
        System.out.println("cantidad de goleadores del torneo:" + torneo.cantidadTotalDeGoleadores());
        
        Goleador goleador = new Goleador(GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarString(12),GeneradorAleatorio.generarInt(15));
        torneo.agregarGoleador(goleador, 10);
        
        System.out.println(torneo.toString());
        
        System.out.println("cantidad de goleadores del torneo:" + torneo.cantidadTotalDeGoleadores());
        
    }
    
}
