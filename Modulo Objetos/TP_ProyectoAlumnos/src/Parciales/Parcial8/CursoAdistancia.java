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
public class CursoAdistancia extends Curso{
	private int nroAula;
	public CursoAdistancia(int unAño, int cantMaxima, int unNumero) {
		super(unAño,cantMaxima);
		this.nroAula = unNumero;
	}
        
        @Override
        public boolean puedeRendir(Alumno unAlumno) {
            return unAlumno.getAsistencias() <= 3;
        }
        
}