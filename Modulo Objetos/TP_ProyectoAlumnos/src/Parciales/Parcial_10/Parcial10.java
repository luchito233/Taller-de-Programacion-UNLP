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
public class Parcial10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fecha fecha = new Fecha(2,10);
        for(int i=0; i<2 ;i++) {
            for(int j=0; j<10 ;j++) {
                Alumno alumno = new Alumno(GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarInt(232));
                fecha.agregarAlumno(alumno, i);
            }
        }
        
        fecha.asignarTemas();
        
        System.out.println("los alumnos que se les asigno el tema 3 son: " + fecha.infoDeUnTema(3));
        
         System.out.println(fecha.toString());
        
    }
    
}
