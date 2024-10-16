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
public class Subsidio {
    private double monto;
    private String motivo;
    private boolean estado;
    
    public Subsidio(double unMonto, String unMotivo) {
        this.monto = unMonto;
        this.motivo = unMotivo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean getEstado() {
        return estado;
    }

  
    public void setEstado() {
        this.estado = true;
    }
    
    
    
}
