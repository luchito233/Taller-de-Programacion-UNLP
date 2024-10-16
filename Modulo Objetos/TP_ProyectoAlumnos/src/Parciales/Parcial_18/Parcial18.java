/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_18;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Parcial18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sistema1 sis1 = new Sistema1(10);
        Sistema2 sis2 = new Sistema2(14);
        // agregar solicitudes en el sistema 1
        for(int i=0; i<10 ;i++) {
            Subsidio unSubsidio = new Subsidio(GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarString(10)
                                               ,GeneradorAleatorio.generarDouble(1000)+10000,GeneradorAleatorio.generarDouble(2000)+10000,
                                               GeneradorAleatorio.generarDouble(30)+1000,GeneradorAleatorio.generarInt(12) +1,GeneradorAleatorio.generarDouble(5000)+2301);
            sis1.agregaraSolicitud(unSubsidio);
        }
        // agregar solicitudes en el sistema 2
        for(int i=0; i<12 ;i++) {
            Subsidio unSubsidio = new Subsidio(GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarString(10)
                                               ,GeneradorAleatorio.generarDouble(1000)+10000,GeneradorAleatorio.generarDouble(2000)+10000,
                                               GeneradorAleatorio.generarDouble(30)+1000,GeneradorAleatorio.generarInt(12)+ 1,GeneradorAleatorio.generarDouble(5000)+2301);
            sis2.agregaraSolicitud(unSubsidio);
        }
        
        // otorgar los subsidios el sistema 1
        sis1.otorgarSubsidios(22000);
        // otorgar los subsidios el sistema 2
        sis2.otorgarSubsidios(12000);
        
        System.out.println(sis1.toString());
        
        System.out.println("////////////////////////////////////////////////////////////////////////////");
        
        System.out.println(sis2.toString());
        
    }
    
}
