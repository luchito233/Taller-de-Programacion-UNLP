/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_22;

/**
 *
 * @author lucia
 */
public class Libro {
    private String titulo;
    private String primerAutor;
    private double peso;

    public Libro(String titulo, String primerAutor, double peso) {
        this.titulo = titulo;
        this.primerAutor = primerAutor;
        this.peso = peso;
    }

    public String getPrimerAutor() {
        return primerAutor;
    }
    
    @Override
    public String toString() {
        return "Titulo: " + this.titulo + ", Primer Autor: " + this.primerAutor + ", Peso del Libro: " + this.peso;
    }
    
}
