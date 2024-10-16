/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author lucia
 */
public class VisorFiguras {
    private int guardadas = 0;
    private int capacidadMaxima=5;
    private Figura [] vector;
    
    public VisorFiguras(){
        this.vector = new Figura[this.capacidadMaxima];
    }
    
    public void guardar(Figura f){
       if(this.guardadas < this.capacidadMaxima) {
           this.vector[this.guardadas] = f;
           this.guardadas++;
       } 
    }
    
    public boolean quedaEspacio(){
        return this.guardadas < (this.capacidadMaxima - 1);
    }
    
    public void mostrar(){
        for(int i=0; i < this.guardadas ;i++) {
            System.out.println(this.vector[i].toString());
        }
    }
    
    public int getGuardadas() {
        return guardadas;
    }
}   

