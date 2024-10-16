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
public class Sala {
    private int cantMaxima;
    private int cantPcs;
    private Pc[] sala;
    public Sala(int cantMaximaDePcs) {
        this.cantMaxima = cantMaximaDePcs;
        this.cantPcs = 0;
        this.sala = new Pc[this.cantMaxima];
        
    }
    
    private void incializarSala() {
        for(int i=0; i<this.cantMaxima ;i++) {
            this.sala[i] = null;
        }
    }
    
    private boolean sePuede() {
        return this.cantPcs < this.cantMaxima;
    }
    
    public void agregarPc(Pc unaPc, int unNroSala) {
        if(sePuede() && unNroSala < this.cantMaxima) {
            this.sala[unNroSala] = unaPc;
            this.cantPcs++;
        }
    }
    
    public void prenderPcMinConsumo() {
        double minConsumo = 9999.9;
        Pc aux = new Pc(0.0);
        for(int j=0; j<this.cantPcs ;j++) {
            if(this.sala[j].getConsumoXhora() < minConsumo && this.sala[j].getEstado() != true) {
                minConsumo = this.sala[j].getConsumoXhora();
                aux = this.sala[j];
            }
        }
        aux.setEstado(true);
    }
    
    public String informarPrendidas() {
        String aux = "";
        for(int i=0; i<this.cantPcs ;i++) {
            if(this.sala[i].getEstado() == true)
                aux+= "Pc " + (i+1) + "\n";
        }
        return aux;
    }
    
    @Override
     public String toString() {
        String aux = "";
        for(int i=0; i<this.cantPcs ;i++) {
                aux+= "Pc " + (i+1) + " " + this.sala[i].toString() + "\n";
        }
        return aux;
    }
    
}
