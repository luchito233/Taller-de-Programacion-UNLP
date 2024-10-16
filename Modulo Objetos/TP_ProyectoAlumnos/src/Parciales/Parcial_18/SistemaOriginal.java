/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_18;

/**
 *
 * @author lucia
 */
public abstract class SistemaOriginal {
    private int cantMaxima;
    private int cantSubsidios;
    private Subsidio[] sistema;

    public SistemaOriginal(int cantMaxima) {
        this.cantMaxima = cantMaxima;
        this.cantSubsidios = 0;
        this.sistema = new Subsidio[this.cantMaxima];
    }
    
    private boolean sePuede() {
        return this.cantSubsidios < this.cantMaxima;
    }
    
    public void agregaraSolicitud(Subsidio unaSolicitud) {
        if(this.sePuede()) {
            this.sistema[this.cantSubsidios] = unaSolicitud;
            this.cantSubsidios++;
        }
    }
    
    public Subsidio retornarSubsidio(int i) {
        return this.sistema[i-1];
    }
    
    public void otorgarSubsidios(double X) {
        for(int i=0; i<this.cantSubsidios ;i++)
            if(this.verificarSolicitud(X,this.sistema[i])) {
                this.sistema[i].setOtorgado(true);
            }
    }
    
    public abstract boolean verificarSolicitud(double X, Subsidio unaSolicitud);
    
    @Override
    public String toString() {
        String aux = "";
        for(int i=0; i<this.cantSubsidios ;i++) {
            if(this.sistema[i].isOtorgado())
                aux +="Subsidio " + (i+1) + ":" + this.sistema[i].toString() + "\n";
        }
        return aux;
    }
    
}
