/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica_5;

/**
 *
 * @author lucia
 */
public abstract class Recital {
    private String nombre;
    private int cantTemas = 0;
    private String[] listaTemas;
    private int cantMaxima;
    public Recital(String unNombre, int cantMax) {
        this.nombre = unNombre;
        this.cantMaxima = cantMax;
        this.listaTemas = new String[this.cantMaxima];
        for(int i=0; i<this.cantMaxima ;i++)
            this.listaTemas[i] = null;
    }
    
    public boolean sePuede() {
        return this.cantTemas < this.cantMaxima;
    }
    
    public void agregarTema(String unTema) {
        if(sePuede()) {
            this.listaTemas[this.cantTemas] = unTema;
            this.cantTemas++;
        }
    }
    
    public String actuar() {
        String aux = "";
        for(int i=0; i<this.cantTemas ;i++)
            aux += "y ahora tocaremos..." + this.listaTemas[i] + "\n";
        return aux;
    }
    
    public abstract double calcularCosto();
}
