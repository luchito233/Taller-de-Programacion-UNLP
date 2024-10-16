/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_23;

/**
 *
 * @author lucia
 */
public abstract class Libro {
    private String titulo;
    private double precioBase;
    private int cantMaxima;
    private int cantAutores;
    private String[] nombresDeLosAutores;

    public Libro(String titulo, double precioBase, int cantidadDeAutores) {
        this.titulo = titulo;
        this.precioBase = precioBase;
        this.cantMaxima = cantidadDeAutores;
        this.cantAutores = 0;
        this.nombresDeLosAutores = new String[this.cantMaxima];
    }
    
    public void agregarAutor(String unAutor) {
        this.nombresDeLosAutores[this.cantAutores] = unAutor;
        this.cantAutores++;
    }
    
    public double precioFinal() {
        double aux = this.precioBase * 0.21;
        return this.precioBase + aux;
    }
    
    @Override
    public String toString() {
        return "Titulo: " + this.titulo + ", Precio Final: " + this.precioFinal() + ", Primer Autor: " + this.nombresDeLosAutores[0];
        
        
    }
    
}
