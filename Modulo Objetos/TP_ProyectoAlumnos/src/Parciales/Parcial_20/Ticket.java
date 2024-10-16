/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_20;

/**
 *
 * @author lucia
 */
public class Ticket {
    private int nroTicket;
    private int cuit;
    private int cantProductosC;
    private double montoAbonado;
    private String medioDePago;
    public Ticket(int unNro, int unCuit, int cantProdComprados, double unMontoAbonado, String unMedioDePago) {
        this.nroTicket = unNro;
        this.cuit = unCuit;
        this.cantProductosC = cantProdComprados;
        this.montoAbonado = unMontoAbonado;
        this.medioDePago = unMedioDePago;
    }

    public String getMedioDePago() {
        return medioDePago;
    }
    
    
    
    @Override
    public String toString() {
        return "Numero de ticket: " + this.nroTicket + ", Cuit del cliente: " + this.cuit + ", cantidad de productos: " + this.cantProductosC + ", medio de pago: " + this.medioDePago + "\n";
    }
    
    
}
