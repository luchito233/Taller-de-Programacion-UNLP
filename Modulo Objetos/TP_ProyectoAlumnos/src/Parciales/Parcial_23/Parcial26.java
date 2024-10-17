/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_26;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Parcial26 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MembresiaVip membresia1 = new MembresiaVip(6000,"ultra VIP","23/03/2023",10);
        MembresiaProfesional membresia2 = new MembresiaProfesional("ultra Profesional","10/12/2022",12);
        
        //Membresia 1
       
        Jugador jugador1 = new Jugador("Luciano Varalli");
        membresia1.agregarJugador(jugador1);

        Jugador jugador2 = new Jugador("María López");
        membresia1.agregarJugador(jugador2);

        Jugador jugador3 = new Jugador("Carlos Pérez");
        membresia1.agregarJugador(jugador3);

        Jugador jugador4 = new Jugador("Ana García");
        membresia1.agregarJugador(jugador4);

        Jugador jugador5 = new Jugador("Joaquín Gómez");
        membresia1.agregarJugador(jugador5);
        
        membresia1.asignarPuntaje(10.2, "Luciano Varalli");
        membresia1.asignarPuntaje(10.2, "Luciano Varalli");
        membresia1.asignarPuntaje(100.2, "Carlos Pérez");
        
        //Membresia 2
       
        Jugador jugador6 = new Jugador("Lucas Fernández");
        membresia2.agregarJugador(jugador6);

        Jugador jugador7 = new Jugador("Sofía Martínez");
        membresia2.agregarJugador(jugador7);

        Jugador jugador8 = new Jugador("Andrés Ramírez");
        membresia2.agregarJugador(jugador8);

        Jugador jugador9 = new Jugador("Valentina Torres");
        membresia2.agregarJugador(jugador9);

        Jugador jugador10 = new Jugador("Mateo Sánchez");
        membresia2.agregarJugador(jugador10);

        Jugador jugador11 = new Jugador("Isabella Gómez");
        membresia2.agregarJugador(jugador11);

        Jugador jugador12 = new Jugador("Emilio Díaz");
        membresia2.agregarJugador(jugador12);
       
        membresia2.asignarPuntaje(14.1, "Andrés Ramírez");
        membresia2.asignarPuntaje(14.1, "Andrés Ramírez");
        membresia2.asignarPuntaje(140.1, "Valentina Torres");
        
        System.out.println(membresia1.toString());
        
        System.out.println(membresia2.toString());
    }
    
}
