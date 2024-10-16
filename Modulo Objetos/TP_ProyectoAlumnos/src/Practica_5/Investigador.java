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
public class Investigador {
    private String nombre;
    private int categoria;
    private String especialidad;
    private int cantSubsidios = 0;
    private Subsidio[] subsidios;
    
    public Investigador(String unNombre, int categorias, String unaEspecialidad) {
        this.nombre = unNombre;
        this.categoria = categorias;
        this.especialidad = unaEspecialidad;
        this.subsidios = new Subsidio[5];
        this.inicializarSub(this.subsidios);
    }

    public String getNombre() {
        return nombre;
    }
    
    
    
    
    
    public void inicializarSub(Subsidio[] sub) {
        for(int i=0; i<5 ;i++)
            sub[i] = new Subsidio(0.0,"null");
    }
    
    public boolean sePuede() {
        return this.cantSubsidios < 5;
    }
    
    public void agregarSubsidio(Subsidio unSubsidio) {
        if(this.sePuede()) {
            subsidios[this.cantSubsidios] = unSubsidio;
            unSubsidio.setEstado();
            this.cantSubsidios++;
        }
    }
    
    public double devolverMonto() {
        double aux = 0.0;
        for(int i=0; i<this.cantSubsidios ;i++) {
            aux += this.subsidios[i].getMonto();
        }
        return aux;
    }
    
    public String toString() {
        String aux = "\n --- Nombre del investigador: " + this.nombre +
                     ", categoria: " + this.categoria + ", especialidad: " +
                     this.especialidad + ", dinero total: " + this.devolverMonto();
        return aux;
    }
    
}
