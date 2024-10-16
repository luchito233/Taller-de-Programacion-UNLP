/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial5;

/**
 *
 * @author lucia
 */
public class Agenda {
    private int cantDias;
    private int cantTurnosXdia;
    private Paciente [][] agenda;
    public Agenda(int cantidadD, int cantidadTxD) {
        this.cantDias = cantidadD;
        this.cantTurnosXdia = cantidadTxD;
        this.agenda = new Paciente [this.cantDias][this.cantTurnosXdia];
        this.inicializarMatriz();
    }
    
    public void inicializarMatriz() {
        for(int i=0; i<this.cantDias ;i++) {
            for(int j=0; j<this.cantTurnosXdia ;j++) {
                this.agenda[i][j] = null;
            }
        }
    }
    
    public void agregarPaciente(Paciente unPaciente, int dia, int turno) {
        this.agenda[dia][turno] = unPaciente;
    }
    
    public String liberarTurnos(int unDia) {
        String aux = "";
        for(int i=0; i<this.cantTurnosXdia ;i++) {
            if(this.agenda[unDia-1][i] != null) {
                aux += " Paciente " + i + ": " + this.agenda[unDia-1][i].getNombre();
                this.agenda[unDia-1][i] = null;
            }
        }
        return aux;
    }
    
    public double costoTotal() {
        double aux = 0.0;
        for(int i=0; i<this.cantDias ;i++) {
            for(int j=0; j<this.cantTurnosXdia ;j++) {
                if(this.agenda[i][j] != null) {
                    aux += this.agenda[i][j].getCostoSesion();
                }
            }
        }
        return aux;
    }
    
    @Override
    public String toString() {
        String aux = "";
        for(int i=0; i<this.cantDias ;i++) {
            aux += "Dia " + (i+1) + ": \n";
            for(int j=0; j<this.cantTurnosXdia ;j++) {
                if(this.agenda[i][j] != null) 
                    aux += this.agenda[i][j].toString() + "\n";
            }
        }
        return aux;
    }
    
    
}
