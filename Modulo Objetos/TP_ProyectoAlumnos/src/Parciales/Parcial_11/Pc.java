/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_11;

/**
 *
 * @author lucia
 */
public class Pc {
    private boolean estado;
    private double consumoXhora;
    public Pc(double unConsumoXhora) {
        this.estado = false;
        this.consumoXhora = unConsumoXhora;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getConsumoXhora() {
        return consumoXhora;
    }

    public boolean getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Pc{" + "estado=" + estado + ", consumoXhora=" + consumoXhora + '}';
    }
    
    
    
}
