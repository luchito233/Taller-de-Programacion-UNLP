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
public class CompraMinorista extends Compra{
    private Boolean jubilado;
    public CompraMinorista(int unNumero, int cantMaxima, Boolean esJubilado) {
        super(unNumero,cantMaxima);
        this.jubilado = esJubilado;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", es jubilado? " + this.jubilado;
    }
    
}
