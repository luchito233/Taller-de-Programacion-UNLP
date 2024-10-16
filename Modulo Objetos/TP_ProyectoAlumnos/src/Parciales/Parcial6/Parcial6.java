/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial6;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Parcial6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        Sistema sistema = new Sistema(5,6);
        for(int i=0; i<10 ;i++) {
            Paciente paciente = new Paciente(GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarBoolean(),GeneradorAleatorio.generarDouble(30000));
            sistema.agregarPaciente(paciente, GeneradorAleatorio.generarInt(5)+1, GeneradorAleatorio.generarInt(6)+1);
        }
        
        Paciente paciente1 = new Paciente("Lucho",GeneradorAleatorio.generarBoolean(),GeneradorAleatorio.generarDouble(30000));
        sistema.agregarPaciente(paciente1, 3, 2);
        
        Paciente paciente2 = new Paciente("Lucho",GeneradorAleatorio.generarBoolean(),GeneradorAleatorio.generarDouble(30000));
        sistema.agregarPaciente(paciente2, 1, 5);
        
        System.out.println(sistema.toString());
        
        System.out.println("la persona esta agendada? " + sistema.estaAgendado(3, "Lucho"));
        
        System.out.println(sistema.toString());
        
        sistema.liberarTurno("Lucho");
        
        System.out.println(sistema.toString());
        
    }
    
}
