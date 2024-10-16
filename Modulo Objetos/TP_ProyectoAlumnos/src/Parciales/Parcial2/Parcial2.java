/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial2;
import PaqueteLectura.GeneradorAleatorio;             
public class Parcial2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Concurso concurso = new Concurso(20);
        for(int i=0; i<5 ; i++) {
            for(int j=0; j<5 ;j++) {
                Alumno alumno1 = new Alumno(GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarInt(100),GeneradorAleatorio.generarString(15));
                concurso.agregarAlumno(alumno1, i);
                
            }
        }
        
        System.out.println(concurso.toString());
        
        for(int i=0; i<5 ; i++) {
            for(int j=0; j<5 ;j++) {
                System.out.println("ingrese un puntuaje a: " + concurso.getNombre(i, j));
                concurso.asignarPuntuaje(concurso.getNombre(i, j), GeneradorAleatorio.generarInt(11));
            }    
        } 
        
        System.out.println(concurso.toString());
        
    }
    
}
