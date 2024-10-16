/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_21;

/**
 *
 * @author lucia
 */
public class Venta {
    private int dni;
    private int cantLitrosCargados;
    private double montoAbonado;
    private String medioDePago;

    public Venta(int dni, int cantLitrosCargados, String medioDePago) {
        this.dni = dni;
        this.cantLitrosCargados = cantLitrosCargados;
        this.medioDePago = medioDePago;
    }

    public int getCantLitrosCargados() {
        return cantLitrosCargados;
    }

    public void setMontoAbonado(double montoAbonado) {
        this.montoAbonado = montoAbonado;
    }
    
    @Override
    public String toString() {
        return "Dni: " + this.dni + ", Cantidad de litros cargados: " + this.cantLitrosCargados + ", monto abonado: " + this.montoAbonado;
    }
    
 
    
}
