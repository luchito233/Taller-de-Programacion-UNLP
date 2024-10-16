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
public class ClaseVirtual extends Curso { 
        private String link;
	public ClaseVirtual(int unAño, int cantMaxima, String unLink) {
		super(unAño, cantMaxima);
                this.link = unLink;
	}
	
	@Override
	public boolean puedeRendir(Alumno unAlumno) {
		
		return ((unAlumno.getCantAprobados() <= 3) && (unAlumno.getAsistencias() >= 1));
	} 
}
