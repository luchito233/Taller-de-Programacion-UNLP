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
public class Cuenta {
    private int cbu;
    private String alias;
    private String dni;
    private String moneda;
    private double monto;

    public Cuenta(int cbu, String alias, String dni, String moneda) {
        this.cbu = cbu;
        this.alias = alias;
        this.dni = dni;
        this.moneda = moneda;
        this.monto = 0;
    }

    public String getMoneda() {
        return moneda;
    }

    public int getCbu() {
        return cbu;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }
    
    
    
}
