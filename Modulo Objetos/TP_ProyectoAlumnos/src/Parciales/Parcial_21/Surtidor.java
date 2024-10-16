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
public class Surtidor {
    private String tipoDeCombustible;
    private double precioXlitro;
    private int cantMaxima;
    private int cantVentas;
    private Venta[] ventas;

    public Surtidor(String tipoDeCombustible, double precioXlitro, int cantMaxima) {
        this.tipoDeCombustible = tipoDeCombustible;
        this.precioXlitro = precioXlitro;
        this.cantMaxima = cantMaxima;
        this.cantVentas = 0;
        this.ventas = new Venta[this.cantMaxima];
    }
    
    private boolean sePuede() {
        return this.cantVentas < this.cantMaxima;
    }
    
    public void agregarVenta(Venta unaVenta) {
        if(this.sePuede()) {
            this.ventas[this.cantVentas] = unaVenta;
            this.cantVentas++;
        }
    }
    
    public void asignarMontos() {
        double aux;
        for(int j=0; j<this.cantVentas ;j++) {
            aux = this.precioXlitro * this.ventas[j].getCantLitrosCargados();
            this.ventas[j].setMontoAbonado(aux);
        }
    }
    
    @Override
    public String toString() {
        String aux = "Combustible dispensado: " + this.tipoDeCombustible + ", precio por litro: " + this.precioXlitro + "\n";
        for(int i=0; i<this.cantVentas ;i++) {
            aux += "venta " + (i+1) + ": " + this.ventas[i].toString() + "\n";
        }    
        return aux;
    }
    
}
