/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_14;

/**
 *
 * @author lucia
 */
public class Director extends Trabajador {
    private double montoViaticos;
    public Director(String unNombre, int unDni, int unAnioDeIngreso, double unSueldoBasico, double unMontoAviaticos) {
        super(unNombre,unDni,unAnioDeIngreso,unSueldoBasico);
        this.montoViaticos = unMontoAviaticos;
    }
    
    @Override
    public double sueldoAdicional() {
        return  this.montoViaticos;
    }    
}
