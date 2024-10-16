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
public class LibroElectronico extends Libro {
    private String formato;
    private double tamanioMB;

    public LibroElectronico(String formato, double tamanioMB, String titulo, double precioBase, int cantidadDeAutores) {
        super(titulo, precioBase, cantidadDeAutores);
        this.formato = formato;
        this.tamanioMB = tamanioMB;
    }
    
    public double precioFinalElectro() {
        return super.precioFinal() * (this.tamanioMB * 2.5);
    }
    
}
