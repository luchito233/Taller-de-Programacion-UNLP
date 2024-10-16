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
public class AlumnoDoctorado extends Alumno {
    private String titulaUni;
    private String uniOrigen;
    public AlumnoDoctorado(int unDni, String unNombre, int cantMaterias, String unTitulaUniversita, String unUniversidadOrigen) {
        super(unDni,unNombre,cantMaterias);
        this.titulaUni = unTitulaUniversita;
        this.uniOrigen = unUniversidadOrigen;
       
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Titulo universitario: " + this.titulaUni + ", universidad de Origen: " + this.uniOrigen;
    }
}
