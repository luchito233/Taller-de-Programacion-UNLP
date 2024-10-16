/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial4;

/**
 *
 * @author lucia
 */
public class Concurso {
    private int dl;
    private int df;
    private Pareja [] concurso;
    public Concurso(int nParejas) {
        this.df = nParejas;
        this.dl = 0;
        this.concurso = new Pareja[this.df];
    }
    
    public Pareja retornarPos(int i) {
        return concurso[i];
    }
    
    private boolean sePuede() {
        return this.dl < this.df;
    }
    
    public void agregarPareja(Pareja unaPareja) {
        if(sePuede()) {
            this.concurso[dl] = unaPareja;
            dl++;
        }
    }
    
    public int diferenciaEdad(Pareja unaPareja) {
        int aux = 0;
        if(unaPareja.getPareja1().getEdad() > unaPareja.getPareja2().getEdad()) 
            aux = unaPareja.getPareja1().getEdad() - unaPareja.getPareja2().getEdad();
        else
            aux = unaPareja.getPareja2().getEdad() - unaPareja.getPareja1().getEdad();
        return aux;
    }
    
    public void mayorDiferencia() {
        int maxDife = -1;
        String nombre1 = "", nombre2 = "";
        for(int i=0; i<this.dl ;i++) {
            if(this.diferenciaEdad(this.concurso[i]) > maxDife) {
                maxDife = this.diferenciaEdad(this.concurso[i]);
                nombre1 = this.concurso[i].getPareja1().getNombre();
                nombre2 = this.concurso[i].getPareja2().getNombre();
            }
        }
        System.out.println("nombre 1: " + nombre1 + ", nombre2: " + nombre2);
    }            
}
