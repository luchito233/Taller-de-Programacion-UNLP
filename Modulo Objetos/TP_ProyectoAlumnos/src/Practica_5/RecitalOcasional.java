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
public class RecitalOcasional extends Recital {
    private String motivo;
    private String nombre;
    private int dia;
    public RecitalOcasional(String unMotivo, String unNombre, int unDia, String unNombreRecital, int cantMax) {
        super(unNombreRecital,cantMax);
        this.motivo = unMotivo;
        this.nombre = unNombre;
        this.dia = unDia;
    }
    
    @Override
    public String actuar() {
        String aux = "";
        if(this.motivo.equals("a beneficio")) {
            aux += "Recuerden colaborar con... " + this.nombre + "\n" + super.actuar();
        } 
        else {
            if(this.motivo.equals("show privado")) {
                aux += "Un feliz cumpleaños para... "+ this.nombre + "\n" + super.actuar();
            }
            else
                aux += "Saludos amigos televidentes " + "\n" + super.actuar();
        }      
        return aux;
    }
    
    @Override
    public double calcularCosto() {
        double aux = 0.0;
        if(this.motivo.equals("a beneficio")) {
            aux = 0;
        } 
        else {
            if(this.motivo.equals("show privado")) {
                aux = 150000.0;
            }
            else
                aux = 50000.0;
        }      
        return aux;
    }
}
