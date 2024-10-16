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
public class Encargado extends Trabajador {
    private int cantEmpleados;
    public Encargado(String unNombre, int unDni, int unAnioDeIngreso, double unSueldoBasico, int cantidadDeEmpleados) {
        super(unNombre,unDni,unAnioDeIngreso,unSueldoBasico);
        this.cantEmpleados = cantidadDeEmpleados;
    }
    
    @Override
    public double sueldoAdicional() {
        return (1000 * this.cantEmpleados);
    }
    
}

