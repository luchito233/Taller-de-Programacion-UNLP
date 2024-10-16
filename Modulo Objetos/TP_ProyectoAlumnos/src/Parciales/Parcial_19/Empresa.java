/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_19;

/**
 *
 * @author lucia
 */
public class Empresa {
    private String nombre;
    private ProgramadorLider lider;
    private int cantMaxima;
    private int cantProgramadores;
    private Programador[] programadores;
    public Empresa(String unNombre, ProgramadorLider unLider, int cantMax) {
        this.nombre = unNombre;
        this.lider = unLider;
        this.cantMaxima = cantMax;
        this.cantProgramadores = 0;
        this.programadores = new Programador[cantMax];
    }
    
    private boolean sePuede() {
        return this.cantProgramadores < this.cantMaxima;
    }
    
    public void agregarProgramador(Programador unProgramador) {
        if(sePuede()) {
            this.programadores[this.cantProgramadores] = unProgramador;
            this.cantProgramadores++;
        }
    }
    
    public double montoTotal() {
        double aux = this.lider.sueldoFinal();
        for(int i=0; i<this.cantProgramadores ;i++) {
            aux += this.programadores[i].sueldoFinal();
        }
        return aux;
    }
    
    public void aumentarSueldoBasico(double M) {
        this.lider.aumentarSueldo(M);
        for(int i=0; i<this.cantProgramadores ;i++) {
            this.programadores[i].aumentarSueldo(M);
        }
    }
    
    public String toString() {
        String aux = "Empresa: " + this.nombre + "\n";
        aux += this.lider.toString() + ", sueldo final: " + this.lider.sueldoFinal() + "\n";
        for(int j=0; j<this.cantProgramadores ;j++) {
            aux += "Programador " + (j+1) + ": " + this.programadores[j].toString() + ", sueldo final: " + this.programadores[j].sueldoFinal() + "\n";
        }
        aux += "Monto total en sueldos a abonar por la empresa: " + this.montoTotal();
        return aux;
    }
    
}
