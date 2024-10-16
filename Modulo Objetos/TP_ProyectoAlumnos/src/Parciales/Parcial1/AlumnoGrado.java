/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial1;

/**
 *
 * @author Alumno
 */
public class AlumnoGrado extends Alumno {
    private String carrera;
    public AlumnoGrado(int unDni, String unNombre, int cantMaterias, String unaCarrera) {
        super(unDni,unNombre,cantMaterias);
        this.carrera = unaCarrera;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", carrera: " + this.carrera;
    }
    
}
