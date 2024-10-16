/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_22;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Parcial22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estanteria estanteria = new Estanteria(5,3);
        
        Libro libro1 = new Libro(GeneradorAleatorio.generarString(10),"Borges",GeneradorAleatorio.generarDouble(1)+6);
        estanteria.agregarLibro(libro1, 5, 2);
        Libro libro2 = new Libro(GeneradorAleatorio.generarString(10),"Lucho",GeneradorAleatorio.generarDouble(1)+6);
        estanteria.agregarLibro(libro2, 2, 3);
        Libro libro3 = new Libro(GeneradorAleatorio.generarString(10),"Borges",GeneradorAleatorio.generarDouble(1)+6);
        estanteria.agregarLibro(libro3, 1, 2);
        Libro libro4 = new Libro(GeneradorAleatorio.generarString(10),"Borges",GeneradorAleatorio.generarDouble(1)+6);
        estanteria.agregarLibro(libro4, 3, 1);
        Libro libro5 = new Libro(GeneradorAleatorio.generarString(10),"Maxi",GeneradorAleatorio.generarDouble(1)+6);
        estanteria.agregarLibro(libro5, 1, 3);
        Libro libro6 = new Libro(GeneradorAleatorio.generarString(10),"Borges",GeneradorAleatorio.generarDouble(1)+6);
        estanteria.agregarLibro(libro6, 5, 1);
        Libro libro7 = new Libro(GeneradorAleatorio.generarString(10),"Franco",GeneradorAleatorio.generarDouble(1)+6);
        estanteria.agregarLibro(libro7, 4, 1);
        
        Libro libroAbuscar = estanteria.sacarLibro(1, 3);
        System.out.println(libroAbuscar.toString());
        
        System.out.println("La cantidad de libros en la estanteria de Borges es de :" + estanteria.calcular("Borges"));
    }
    
}
