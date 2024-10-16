/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial7;

/**
 *
 * @author lucia
 */
public class Torneo {
    private String nombre;
    private Goleador [][] torneo;
    private int cantMaximaF;
    private int cantMaximaG;
    private int [] cantGolesXfecha;
    public Torneo(String unNombre, int cantFechas, int cantGoleadores) {
        this.nombre = unNombre;
        this.cantMaximaF = cantFechas;
        this.cantMaximaG = cantGoleadores;
        this.torneo = new Goleador[cantFechas][cantGoleadores];
        inicializarTorneo();
        cantGolesXfecha = new int[cantFechas];
        for(int i=0; i<cantFechas ;i++) {
            cantGolesXfecha[i] = 0;
        }
    }
    
    public void inicializarTorneo() {
        for(int i=0; i<this.cantMaximaF ;i++) {
            for(int j=0; j<this.cantMaximaG ;j++) {
                this.torneo[i][j] = null;
            }
        }
    }
    
    private boolean sePuede(int fechaActual) {
        return this.cantGolesXfecha[fechaActual] < this.cantMaximaG;
    }
    
    public void agregarGoleador(Goleador unGoleador, int unaFecha) {
        if(sePuede(unaFecha-1)) {
            this.torneo[unaFecha-1][this.cantGolesXfecha[unaFecha-1]] = unGoleador;
            this.cantGolesXfecha[unaFecha-1]++;
        }
    }
    
    public Goleador menosGoles(int unaFecha) {
        Goleador goleadorMin = new Goleador("Ninguno","Ninguno",0);
        int Min = 9999;
        for(int i=0; i<this.cantGolesXfecha[unaFecha-1] ;i++) {
            if(this.torneo[unaFecha-1][i].getCantGoles() < Min) {
                Min = this.torneo[this.cantMaximaF-1][i].getCantGoles();
                goleadorMin = this.torneo[this.cantMaximaF-1][i];
            }    
        }
        return goleadorMin;
    }
    
    public int cantidadTotalDeGoleadores() {
        int aux = 0;
        for(int i=0; i<this.cantMaximaF ;i++) {
            aux += this.cantGolesXfecha[i];
        }
        return aux;
    }
    
    public String toString(){
        String aux = "Torneo 2022: " + this.nombre +"\n";
        for(int i=0; i<this.cantMaximaF ;i++) {
            aux += "Fecha # " + (i+1) + " / " + "Cantidad de goleadores de la fecha: " + this.cantGolesXfecha[i] + " / " + "\n";
            for(int j=0; j<this.cantGolesXfecha[i] ;j++) {
                aux +=  torneo[i][j].toString() + "\n";
            }
        }
        return aux;
    }
    
}
