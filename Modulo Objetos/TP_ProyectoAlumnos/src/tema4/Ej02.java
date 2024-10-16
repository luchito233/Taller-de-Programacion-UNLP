/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author alumnos
 */
public class Ej02 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Entrenador entrenador = new Entrenador(30,"Nico",1000000,10);
		Jugador jugador = new Jugador(10, 4, "Lucho", 10000, 4);
		System.out.println(entrenador.toString());
		System.out.println(jugador.toString());
	}
	
}
