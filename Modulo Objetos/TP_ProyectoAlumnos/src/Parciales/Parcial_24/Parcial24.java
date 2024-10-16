/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_24;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Parcial24 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        Sistema sis1 = new Sistema("Licenciatura en Sistemas","Facultad de Informatica",2015);
        Sistema sis2 = new Sistema("Ingenieria en Computacion","Facultad de Informatica",2013);
        
        EstadisticoAnual estaAnual = new EstadisticoAnual(sis1,9);
        EstadisticoTrimestral estaTrimestral = new EstadisticoTrimestral(sis2,12);
        
        for(int i=0; i<9 ;i++) {
            for(int j=1; j<5 ;j++) {
                estaAnual.registrarCantEgresados(GeneradorAleatorio.generarInt(22), j, i+2015);
                System.out.println("pos " + j + "," +  i + ":" + estaAnual.getEstadistico(j, i+1));
            }
        }
        System.out.println("/////////////////////////");
        for(int i=1; i<5 ;i++) {
            for(int j=0; j<12 ;j++) {
                estaTrimestral.registrarCantEgresados(GeneradorAleatorio.generarInt(22), i, j+2013);
                System.out.println("pos " + j + "," +  i + ":" + estaTrimestral.getEstadistico(i, j+1));
            }
        }
        
        System.out.println(estaAnual.toString());
        System.out.println(estaTrimestral.toString());
    }
    
}
