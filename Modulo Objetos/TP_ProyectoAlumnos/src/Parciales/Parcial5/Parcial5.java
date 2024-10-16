/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial5;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Parcial5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Agenda agenda = new Agenda(10,6); 
        for(int i=0; i<100 ;i++) {
            Paciente paciente = new Paciente(GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarBoolean(),GeneradorAleatorio.generarDouble(10000));
            agenda.agregarPaciente(paciente, GeneradorAleatorio.generarInt(10), GeneradorAleatorio.generarInt(6));
            
        }
        
        System.out.println(agenda.toString());
        
        System.out.println("costo total: "+agenda.costoTotal());
        
        System.out.println("los pacientes que se les cancelo el turno son: "+agenda.liberarTurnos(6));
        
        System.out.println(agenda.toString());
        
        System.out.println("costo total: "+agenda.costoTotal());
        
    }
}
