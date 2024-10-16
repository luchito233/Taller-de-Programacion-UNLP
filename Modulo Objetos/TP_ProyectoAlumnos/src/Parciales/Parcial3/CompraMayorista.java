/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial3;

/**
 *
 * @author lucia
 */
public class CompraMayorista extends Compra{
    private int cuit;
    public CompraMayorista(int unNumero, int cantMaxima, int unCuit) {
        super(unNumero,cantMaxima);
        this.cuit = unCuit;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Cuit: " + this.cuit;
    }
    
}
