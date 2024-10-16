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
public class Supermercado {
    private String direccion;
    private int nroVentaActual;
    private int cantMaxCajas;
    private int cantCajas;
    private Caja[] cajas;
    public Supermercado(String unaDireccion,int cantMaximaCajas) {
        this.direccion = unaDireccion;
        this.nroVentaActual = 0;
        this.cantMaxCajas = cantMaximaCajas;
        this.cantCajas = 0;
        this.cajas = new Caja[cantMaximaCajas];
    }
    
    private boolean sePuede() {
        return this.cantCajas < this.cantMaxCajas;
    }
    
    public void agregarCaja(Caja unaCaja) {
        if(sePuede()) {
            this.cajas[this.cantCajas] = unaCaja;
            this.cantCajas++;
        }
    }
    
    public void validarCompra(int unNroCaja, int unCuit, int unCantidadDeProd,
                              double unMontoAbonar, String unaFormaDePago ) {
        this.nroVentaActual++;
        Ticket unTicket = new Ticket(this.nroVentaActual,unCuit,unCantidadDeProd,unMontoAbonar,unaFormaDePago);
        this.cajas[unNroCaja-1].agregarTicket(unTicket);
    }
    
    public int menorCantTickets() {
        int Min = 9999;
        int codMin = -1;
        for(int i=0; i<this.cantCajas ;i++) {
            if(Min >= this.cajas[i].retornarPagoCredito()) {
                Min = this.cajas[i].retornarPagoCredito();
                codMin = (i+1);
            }
        }
        return codMin;
    }
    
    @Override
    public String toString() {
        String aux = "Supermercado: " + this.direccion + ", Cantidad de cajas: " + this.cantCajas + "\n";
        for(int j=0; j<this.cantCajas ;j++) {
            aux += "Caja " + (j+1) + ": " + this.cajas[j].toString();
        }
        return aux;
    }
    
}
