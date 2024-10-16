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
public class BancoTradicional extends Banco{
    private String direccion;
    private String localidad;
    private int cuentasEnDolares;

    public BancoTradicional(String direccion, String localidad, String nombre, int cantEmpleados, int cantMaxima) {
        super(nombre,cantEmpleados,cantMaxima);
        this.direccion = direccion;
        this.localidad = localidad;
        this.cuentasEnDolares = 0;
    }
    
    @Override
    public boolean agregarCuenta(Cuenta unaCuenta) {
        boolean aux = false;
        System.out.println(this.cuentasEnDolares);
        if(unaCuenta.getMoneda().equals("dolares")) {
            if(this.cuentasEnDolares < 100) {
                aux = super.agregarCuenta(unaCuenta);
                this.cuentasEnDolares++;
            }
        }
        else
            aux = super.agregarCuenta(unaCuenta);
        return aux;
    }
    
     @Override
    public boolean puedeRecibirTarjeta(int unCbu) {
        boolean aux = false;
        Cuenta unaCuenta = super.obtenerCuenta(unCbu);
        if(unaCuenta.getMoneda().equals("dolares") && unaCuenta.getMonto() > 500)
            aux = true;
        if(unaCuenta.getMoneda().equals("pesos") && unaCuenta.getMonto() > 70000)
            aux = true;
        return aux;
    }
    
}
