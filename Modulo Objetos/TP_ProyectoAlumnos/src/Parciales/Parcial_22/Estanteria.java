/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_22;

/**
 *
 * @author lucia
 */
public class Estanteria {
    private int cantEstantes;
    private int cantLibro;
    private Libro[][] estanteria;

    public Estanteria(int cantEstantes, int cantLibro) {
        this.cantEstantes = cantEstantes;
        this.cantLibro = cantLibro;
        this.estanteria = new Libro[this.cantEstantes][this.cantLibro];
        this.inicializarEstanteria();
    }
    
    private void inicializarEstanteria() {
        for(int i=0; i<this.cantEstantes ;i++) {
            for(int j=0; j<this.cantLibro ;j++) {
                this.estanteria[i][j] = null;
            }
        }
    }
    
    public void agregarLibro(Libro unLibro, int X, int Y) {
        this.estanteria[X-1][Y-1] = unLibro;
    }
    
    public Libro sacarLibro(int X, int Y) {
        Libro aux = this.estanteria[X-1][Y-1];
        this.estanteria[X-1][Y-1] = null;
        return aux;
    }
    
    public int calcular(String unAutor) {
        int aux = 0;
        for(int i=0; i<this.cantEstantes ;i++) {
            for(int j=0; j<this.cantLibro ;j++) {
                if(this.estanteria[i][j] != null) {
                    if(this.estanteria[i][j].getPrimerAutor().equals(unAutor))
                        aux++;
                }
            }
        }
        return aux;
    }
    
}
