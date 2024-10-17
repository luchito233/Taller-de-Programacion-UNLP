/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_25;

/**
 *
 * @author lucia
 */
public class Supermercado {
    private String nombre;
    private String direccion;
    private int cantGondolas;
    private int cantEstantes;
    private Producto[][] supermercado;
    private int gondolaAnterior;
    private int estanteAnterior;

    public Supermercado(String nombre, String direccion, int cantGondolas, int cantEstantes) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cantGondolas = cantGondolas;
        this.cantEstantes = cantEstantes;
        this.supermercado = new Producto[cantEstantes][cantGondolas];
        this.gondolaAnterior = 0;
        this.estanteAnterior = 0;
    }
    
    public void agregarProducto(Producto unProducto) {
        if(this.gondolaAnterior < this.cantGondolas) {
            if(this.estanteAnterior < this.cantEstantes) {
                this.supermercado[this.estanteAnterior][this.gondolaAnterior] = unProducto;
            }
            this.estanteAnterior++;
            if(this.estanteAnterior == this.cantEstantes){
                this.estanteAnterior = 0;
                this.gondolaAnterior++;
            }
        }
    }
    
    public String productosExhibidos(String unaMarca, int gondolaX) {
        String aux = "";
        for(int i=0; i<this.cantGondolas ;i++) {
            if(this.supermercado[gondolaX-1][i].getMarca().equals(unaMarca))
                aux += this.supermercado[gondolaX-1][i].toString() + "\n";
        }
        return aux;
    }
    
    public int mayorCantTotalUniExhibidas() {
        int max = -1;
        int gondolaMax = -1;
        int cantTotal;
        for(int i=0; i<this.cantGondolas ;i++) {
            cantTotal = 0;
            for(int j=0; j<this.cantEstantes ;j++) {
                cantTotal += this.supermercado[j][i].getCantUniExhibidas();
            }
            System.out.println("Gondola " + (i+1) + ": " + cantTotal + "\n");
            if(max < cantTotal) {
                max = cantTotal;
                gondolaMax = (i+1);
            }
        }
        return gondolaMax;
    }
    
    @Override
    public String toString() {
        String aux = "Supermercado: " + this.nombre + "; " + this.direccion + "\n";
         for(int i=0; i<this.cantGondolas ;i++) {
            aux += "Gondola " + (i+1) + ":  \n";
            for(int j=0; j<this.cantEstantes ;j++) {
                aux += "Estante " + (j+1) + ": " + this.supermercado[j][i].toString() + "\n";
            }
        }
        return aux;
    }
    
}
