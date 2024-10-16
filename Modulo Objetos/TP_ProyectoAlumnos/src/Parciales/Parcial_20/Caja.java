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
public class Caja {
    private String nomCajero;
    private int cantMaxTickets;
    private int cantTickets;
    private Ticket[] tickets;
    public Caja(String unNombre, int cantidadMaxima) {
        this.nomCajero = unNombre;
        this.cantMaxTickets = cantidadMaxima;
        this.cantTickets = 0;
        this.tickets = new Ticket[cantidadMaxima];
    }
    
    private boolean sePuede() {
        return this.cantTickets < this.cantMaxTickets;
    }
    
    public void agregarTicket(Ticket unTicket) {
        if(this.sePuede()) {
            this.tickets[this.cantTickets] = unTicket;
            this.cantTickets++;
        }
    }

    public int getCantTickets() {
        return cantTickets;
    }
    
    public int retornarPagoCredito() {
        int aux =0;
        for(int i=0; i<this.cantTickets ;i++) { 
            if(this.tickets[i].getMedioDePago().equals("credito") )
                aux++;
        }
        return aux;
    }
    
    @Override
    public String toString() {
        String aux = "Nombre del cajero: " + this.nomCajero + "; Tickets emitidos: " + this.cantTickets + "\n";
        for(int i=0; i<this.cantTickets ;i++) {
            aux += this.tickets[i].toString() + "\n";
        }
        return aux;
    }
    
}
