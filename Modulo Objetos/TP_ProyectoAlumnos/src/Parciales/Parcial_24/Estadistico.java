/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_24;

/**
 *
 * @author lucia
 */
public abstract class Estadistico {
    private Sistema sistema;
    private int cantAnios;
    private int[][] estadistico;

    public Estadistico(Sistema sistema, int cantAnios) {
        this.sistema = sistema;
        this.cantAnios = cantAnios;
        this.estadistico = new int[4][this.cantAnios];
        this.inicializarEstadistico();
    }

    
    
    private void inicializarEstadistico() {
        for(int i=0; i<4 ;i++) {
            for(int j=0 ;j<this.cantAnios ;j++)
                this.estadistico[i][j] = -1;
        }
    }

    public int getEstadistico(int i, int j) {
        return estadistico[i-1][j-1];
    }
    
    public Sistema getSistema() {
        return sistema;
    }
    
    public int getCantAnios() {
        return cantAnios;
    }
    
    public void registrarCantEgresados(int cantidadDeEgresados, int Y, int X) {
        this.estadistico[Y-1][X - this.sistema.getAnioCreacion()] = cantidadDeEgresados;
    }
    
    public int retornarCantEgresados(int Y, int X) {
        return this.estadistico[Y-1][X-this.sistema.getAnioCreacion()];
    }
    
    public int exactamenteXegresados(int X) {
        int aux = 0;
        for(int i=0; i<this.cantAnios ;i++) {
            for(int j=0; j<4 ;j++) {
                if(this.estadistico[i][j] == X) 
                    aux++;
            }
        }
        return aux;
    }
    
    public abstract String cantEgresados();
    
    @Override
    public String toString() {
       return this.sistema.toString() + this.cantEgresados();
    }
    
}
