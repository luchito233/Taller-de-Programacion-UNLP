/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_15;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Parcial15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estacionamiento estacionamiento = new Estacionamiento("24 y 54",2000,10,9);
        
        Vehiculo auto1 = new Vehiculo(GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarInt(20)+1,GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarString(10));
        Vehiculo auto2 = new Vehiculo(GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarInt(20)+1,GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarString(10));
        Vehiculo auto3 = new Vehiculo(GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarInt(20)+1,GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarString(10));
        Vehiculo auto4 = new Vehiculo(GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarInt(20)+1,GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarString(10));
        Vehiculo auto5 = new Vehiculo(GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarInt(20)+1,GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarString(10));
        
        estacionamiento.agregarVehiculo(auto1, 3, 5);
        estacionamiento.agregarVehiculo(auto2, 7, 2);
        estacionamiento.agregarVehiculo(auto3, 1, 2);
        estacionamiento.agregarVehiculo(auto4, 2, 4);
        estacionamiento.agregarVehiculo(auto5, 8, 1);
        
        System.out.println(estacionamiento.toString());
        
        System.out.println("el sector que mayor recaudo es: "+estacionamiento.mayorRecaudo());
        
        estacionamiento.liberarSector("oVdmY7wJ6q", 1);
        
        System.out.println(estacionamiento.toString());
    }
    
}
