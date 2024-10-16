/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_21;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Parcial21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Estacion estacion = new Estacion("31 y 52",5);
        for(int i=0; i<5; i++) {
            Surtidor unSurtidor = new Surtidor(GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarDouble(1000)+2500,GeneradorAleatorio.generarInt(16)+1);
            estacion.agregarSurtidor(unSurtidor);
            
        }
        
        for(int j=0; j<20 ;j++) {
            estacion.validarVenta(GeneradorAleatorio.generarInt(4)+1, GeneradorAleatorio.generarInt(10), GeneradorAleatorio.generarInt(10), GeneradorAleatorio.generarString(10));
        }
        
        System.out.println(estacion.toString());
        
        estacion.recorrerSurtidores();
        
        System.out.println(estacion.toString());
        
    }
    
}
