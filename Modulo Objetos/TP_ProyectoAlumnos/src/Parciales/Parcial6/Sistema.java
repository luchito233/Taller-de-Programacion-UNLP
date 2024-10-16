/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial6;

/**
 *
 * @author lucia
 */
public class Sistema {
    private int cantDias;
    private int cantTurnosXdia;
    private Paciente[][] agenda;

    public Sistema(int cantDias, int cantTurnosXdia) {
        this.cantDias = cantDias;
        this.cantTurnosXdia = cantTurnosXdia;
        this.agenda = new Paciente[this.cantDias][this.cantTurnosXdia];
        this.inicializarSistema();
    }
    
    private void inicializarSistema() {
        for(int i=0; i<this.cantDias ;i++) {
            for(int j=0; j<this.cantTurnosXdia ;j++)
                this.agenda[i][j] = null;
        }
    }
    
    public void agregarPaciente(Paciente unPaciente, int unDia, int unTurno) {
        this.agenda[unDia-1][unTurno-1] = unPaciente;
    }
    
    public void liberarTurno(String unNombre) {
        for(int i=0; i<this.cantDias ;i++) {
            for(int j=0; j<this.cantTurnosXdia ;j++)
                if(this.agenda[i][j] != null) {
                    if(this.agenda[i][j].getNombre().equals(unNombre))
                        this.agenda[i][j] = null;
                }
        }
    }
    
    public boolean estaAgendado(int unDia, String unNombre) {
        boolean esta = false;
        int indice = 0;
        while(indice < this.cantTurnosXdia && !esta) {
            if(this.agenda[unDia-1][indice] != null) {
                if(this.agenda[unDia-1][indice].getNombre().equals(unNombre))
                       esta = true; 
            }
        indice++;
        }  
        return esta;
    }
    
    @Override
    public String toString() {
        String aux = "";
        for(int i=0; i<this.cantDias ;i++) {
            aux += "Dia " + (i+1) + ": \n";
            for(int j=0; j<this.cantTurnosXdia ;j++) {
                if(this.agenda[i][j] != null) 
                    aux += "turno " + (j+1) + ":" + this.agenda[i][j].toString() + "\n";
            }
        }
        return aux;
    }
    
}
