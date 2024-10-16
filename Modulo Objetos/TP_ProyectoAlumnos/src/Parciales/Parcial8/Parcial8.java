/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial8;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Parcial8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClaseVirtual claseV = new ClaseVirtual(2010,10,"https/asdas");
        CursoAdistancia claseD = new CursoAdistancia(2009,14,2);
        
        for(int i=0; i<6 ;i++) {
            Alumno alumno1 = new Alumno(GeneradorAleatorio.generarInt(10),GeneradorAleatorio.generarString(10));
            claseV.agregarAlumno(alumno1);
        }
        
        for(int i=0; i<10 ;i++) {
            Alumno alumno2 = new Alumno(GeneradorAleatorio.generarInt(17),GeneradorAleatorio.generarString(12));
            claseD.agregarAlumno(alumno2);
        }
        
        for(int i=0; i<6 ;i++) {
            claseV.incrementarAsistencia(claseV.getPosicion(i).getDni());
            claseV.aprobarAutoevaluacion(claseV.getPosicion(i).getDni());
        }
        
        for(int i=0; i<10 ;i++) {
            claseD.incrementarAsistencia(claseD.getPosicion(i).getDni());
            claseD.aprobarAutoevaluacion(claseD.getPosicion(i).getDni());
        }
        
        System.out.println(claseD.canitidadDeAlumnosQuePuedenRendir());
        System.out.println(claseV.canitidadDeAlumnosQuePuedenRendir());
        
        System.out.println("la cantidad de alumnos a rendir es: " + (claseD.canitidadDeAlumnosQuePuedenRendir() + claseV.canitidadDeAlumnosQuePuedenRendir()));
        
    }
    
}
