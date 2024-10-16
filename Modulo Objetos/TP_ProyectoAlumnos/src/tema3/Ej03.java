/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;
import PaqueteLectura.GeneradorAleatorio;
/*

3-A- Defina una clase para representar estantes. Un estante almacena a lo sumo 20 libros.
Implemente un constructor que permita iniciar el estante sin libros. Provea métodos para:

(i) devolver la cantidad de libros que almacenados 

(ii) devolver si el estante está lleno

(iii) agregar un libro al estante 

(iv) devolver el libro con un título particular que se recibe.

B- Realice un programa que instancie un estante. Cargue varios libros. A partir del estante,
busque e informe el autor del libro “Mujercitas”.

C- Piense: ¿Qué modificaría en la clase definida para ahora permitir estantes que
almacenen como máximo N libros? ¿Cómo instanciaría el estante?

*/
public class Ej03 {

    
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        Estanteria estanteria = new Estanteria();
        
        int df = estanteria.getMaxLibros();
        System.out.println(df);
        
        /* public Libro(  String unTitulo,  String unaEditorial, int unAñoEdicion,  Autor unPrimerAutor, String unISBN, double unPrecio)
           public Autor( String unNombre, String unaBiografia, String unOrigen) {
        */
        
        for(int i=0; i < df; i++) {
            Autor autor = new Autor(GeneradorAleatorio.generarString(8),GeneradorAleatorio.generarString(8),GeneradorAleatorio.generarString(8));
            Libro libro = new Libro(GeneradorAleatorio.generarString(8),GeneradorAleatorio.generarString(8),GeneradorAleatorio.generarInt(2000),
                                    autor,GeneradorAleatorio.generarString(8),GeneradorAleatorio.generarDouble(100));
            if(i == 10)
                libro.setTitulo("Mujercitas");
            
            estanteria.agregarLibro(libro, i);
        }
        Libro unLibroAbuscar = estanteria.getLibroPartucular("Mujercitas");
        if (unLibroAbuscar != null) 
            System.out.println(unLibroAbuscar.getPrimerAutor().getNombre());
        else
            System.out.println("no se encuentra");
       
        
        
    }
    
}
