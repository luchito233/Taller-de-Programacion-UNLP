/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_16;

/**
 *
 * @author lucia
 */
public class BancoDigital extends Banco{
    private String direWeb;

    public BancoDigital(String direWeb, String nombre, int cantEmpleados, int cantMaxima) {
        super(nombre, cantEmpleados, cantMaxima);
        this.direWeb = direWeb;
    }
    
    @Override
    public boolean puedeRecibirTarjeta(int unCbu) {
        boolean aux = false;
        Cuenta unaCuenta = super.obtenerCuenta(unCbu);
        if(unaCuenta.getMoneda().equals("pesos") && unaCuenta.getMonto() > 100000)
            aux = true;
        return aux;
    }
    
}
