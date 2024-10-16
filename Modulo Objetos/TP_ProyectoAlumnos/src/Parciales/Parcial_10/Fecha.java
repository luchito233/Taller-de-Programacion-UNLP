/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_10;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Fecha {
    private int cantSalas;
    private int cantAlumnosXsala;
    private Alumno[][] fecha;
    private int[] cantAlumno;
    public Fecha(int nSalas, int mAlumnos) {
        this.cantSalas = nSalas;
        this.cantAlumnosXsala = mAlumnos;
        this.fecha = new Alumno[nSalas][mAlumnos];
        this.cantAlumno = new int[nSalas];
        for(int i=0; i<nSalas ;i++) {
            for(int j=0; j<mAlumnos ;j++) {
                this.fecha[i][j] = null;
            }
        }
        for(int k=0; k<nSalas ;k++)
            this.cantAlumno[k] = 0;
    }
    
    public void agregarAlumno(Alumno unAlumno, int unaSala) {
        this.fecha[unaSala][this.cantAlumno[unaSala]] = unAlumno;
        this.cantAlumno[unaSala]++;
    }
    
    public void asignarTemas() {
        for(int i=0; i<this.cantSalas ;i++) {
            for(int j=0; j<this.cantAlumno[i] ;j++) {
                this.fecha[i][j].setNroTema(GeneradorAleatorio.generarInt(this.cantAlumnosXsala)+1);
            }
        }
    }
    
    public String infoDeUnTema(int unNroDeTema) {
        String aux = "";
        for(int i=0; i<this.cantSalas ;i++) {
            for(int j=0; j<this.cantAlumno[i] ;j++) {
                if(this.fecha[i][j].getNroTema() == unNroDeTema)
                    aux += this.fecha[i][j].toString() + "\n";
            }
        }
        return aux;
    }
    
    public String toString() {
         String aux = "";
        for(int i=0; i<this.cantSalas ;i++) {
            for(int j=0; j<this.cantAlumno[i] ;j++) {
                aux += this.fecha[i][j].toString() + "\n";
            }
        }
        return aux;
    }
    
    
}
