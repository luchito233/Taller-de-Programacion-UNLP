/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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



package tema3;

/**
 *
 * @author lucia
 */
public class Estanteria {
    private int cantLibros = 0;
    private int maxLibros = 20;
    private Libro libros[];
    
    public Estanteria() {
        libros = new Libro[maxLibros];
        
    }
    
    
    public void setCantLibros(int x) {
        this.cantLibros = x;
    }
    
    public int getMaxLibros() {
        return maxLibros;
    }
    
    public int getLibros() {
        return cantLibros;
    }
    
    public boolean estaLleno() {
        return (cantLibros == maxLibros);
    }
    
    public void agregarLibro(Libro unLibro, int dl) {
        if(dl < maxLibros) {
            this.libros[dl] = unLibro;
            cantLibros++;
        }
    }
    public Libro getLibroPartucular(String unTitulo) {
        for (int i = 0; i < cantLibros; i++) {
            if (libros[i].getTitulo().equals(unTitulo)) {
                return libros[i];  // Devuelve el libro si lo encuentra
            }
        }
        return null; 
    }
}
    

