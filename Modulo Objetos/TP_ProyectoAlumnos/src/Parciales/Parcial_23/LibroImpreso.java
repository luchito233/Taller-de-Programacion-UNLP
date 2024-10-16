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
public class LibroImpreso extends Libro{
    private boolean tapaDura;

    public LibroImpreso(boolean tapaDura, String titulo, double precioBase, int cantidadDeAutores) {
        super(titulo, precioBase, cantidadDeAutores);
        this.tapaDura = tapaDura;
    }
    
    
}
