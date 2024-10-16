/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author lucia
 */
public class Ej03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona persona = new Persona("Lucho",46415346,19);
        Trabajador trabajador = new Trabajador("joako",46413200,23,"chofer");
        System.out.println(persona.toString());
        System.out.println(trabajador.toString());
    }
    
}
