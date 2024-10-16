/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial2;

/**
 *
 * @author lucia
 */
public class Concurso {
    private Alumno [][] concurso;
    private int [] cantAlumnos;
    public Concurso(int N) {
        this.concurso = new Alumno[5][N];
        this.cantAlumnos = new int[5];
        for(int i=0; i<5 ;i++) {
            for(int j=0; j<N ;j++) {
                this.concurso[i][j] = new Alumno("Ninguno",0,"Ninguno");
            }
        }
        for(int i=0; i<5 ;i++) {
            this.cantAlumnos[i] = 0;
        }
    }

    public String getNombre(int i, int j) {
        return this.concurso[i][j].getNombre();
    }
    
    
    
    public void agregarAlumno(Alumno unAlumno, int unGenero) {
        this.concurso[unGenero][this.cantAlumnos[unGenero]] = unAlumno;
        this.cantAlumnos[unGenero]++;
    }
    
    public void asignarPuntuaje(String unNombre, int unPuntaje) {
        int i = 0,j= 0;
        boolean encontre = false;
        while(i < 5 && !encontre) {
            while(j < this.cantAlumnos[i] && !encontre) {
                if(this.concurso[i][j].getNombre().equals(unNombre)) {
                    this.concurso[i][j].setPuntaje(unPuntaje);
                    encontre = true;
                }
                j++;
            }
            i++;
            j = 0;
        }
    }
    
    public int masIncripciones() {
        int cantMax = -1;
        int generoMax = 0;
        for(int i=0; i<5 ;i++) {
            if(this.cantAlumnos[i] > cantMax) {
                cantMax = this.cantAlumnos[i];
                generoMax = i;
            }   
            
        }
        return generoMax;
    }
    
    @Override
    public String toString() {
        String aux = "";
        for(int i=0; i<5 ;i++) {
            aux += "Genero " + i + ": \n";
            for(int j=0; j<this.cantAlumnos[i] ;j++) {
                aux += this.concurso[i][j].toString() + "\n";
            }
        }
        return aux;
    }
    
}
