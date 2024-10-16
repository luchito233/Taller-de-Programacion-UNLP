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
public abstract class Banco {
    private String nombre;
    private int cantEmpleados;
    private int cantMaxima;
    private int cantCuentas;
    private Cuenta[] cuentas;

    public Banco(String nombre, int cantEmpleados, int cantMaxima) {
        this.nombre = nombre;
        this.cantEmpleados = cantEmpleados;
        this.cantMaxima = cantMaxima;
        this.cantCuentas = 0;
        this.cuentas = new Cuenta[cantMaxima];
    }
    
    private boolean sePuede() {
        return this.cantCuentas <this.cantMaxima;
    }
    
    public boolean agregarCuenta(Cuenta unaCuenta) {
        boolean aux = false;
        if(this.sePuede()) {
            this.cuentas[this.cantCuentas] = unaCuenta;
            this.cantCuentas++;
            aux = true;
        }
        return aux;
    }
    
    public Cuenta obtenerCuenta(int unCbu) {
        Cuenta aux = null;
        boolean esta = false;
        int indice = 0;
        while(indice < this.cantCuentas && !esta) {
            if(this.cuentas[indice].getCbu() == unCbu) {
                aux = this.cuentas[indice];
                esta = true;
            }
            indice++;
        }
        return aux;
    }
    
    public void depositarDinero(int unCbu, double unMonto) {
        Cuenta aux = this.obtenerCuenta(unCbu);
        if(aux != null) {
            aux.setMonto(unMonto);
        }
        else
            System.out.println("la cuanta a la que se le quiere depositar el monto no existe");
    }
    
    public abstract boolean puedeRecibirTarjeta(int unCbu);
    
}
