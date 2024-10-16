/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial8;

/**
 *
 * @author alumnos
 */
public abstract class Curso {
	private int añoCursada;
	private int dl;
	private int df;
	private Alumno [] cursada;
	public Curso(int unAño, int cantMaxima) {
		this.añoCursada = unAño;
		this.df = cantMaxima;
		this.dl = 0;
		this.cursada = new Alumno[this.df];
	}
	
        public Alumno getPosicion(int i) {
            return this.cursada[i];
        }
        
	private boolean sePuede() {
		return this.dl < this.df;
	}
	
	public boolean agregarAlumno(Alumno unAlumno) {
		boolean aux = this.sePuede();
		if(aux) {
			this.cursada[dl] = unAlumno;
			this.dl++;
		}
		return aux;
	}
	
	public void incrementarAsistencia(int unDni) {
		int i = 0;
		boolean aux = false;
		while(i < this.dl && !aux) {
			if(this.cursada[i].getDni() == unDni ) {
				this.cursada[i].incrementarAsistencias();
				aux = true;
			}
			i++;
		}
	}
	
	public void aprobarAutoevaluacion(int unDni) {
            int i = 0;
            boolean aux = false;
            while(i < this.dl && !aux) {
		if(this.cursada[i].getDni() == unDni ) {
		this.cursada[i].incrementarCantAprobados();
		aux = true;
                }
            i++;
            }
	}
        public abstract boolean puedeRendir(Alumno unAlumno);
        
        public int canitidadDeAlumnosQuePuedenRendir() {
            int aux = 0;
            for(int i=0; i<this.dl ;i++) {
                if(this.puedeRendir(this.cursada[i])) 
                    aux++;
            }
            return aux;
        }
        
}
