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
public class Alumno {
	private int dni;
	private String nombre;
	private int asistencias;
	private int cantAprobados;
	public Alumno(int unDni, String unNombre) {
		this.dni = unDni;
		this.nombre = unNombre;
		this.asistencias = 0;
		this.cantAprobados = 0;
	}

	public void incrementarAsistencias() {
		this.asistencias++;
	}

	public void incrementarCantAprobados() {
		this.cantAprobados++;
	}

	public int getDni() {
		return dni;
	}

	public int getAsistencias() {
		return asistencias;
	}

	public int getCantAprobados() {
		return cantAprobados;
	}
	
	
	
}
