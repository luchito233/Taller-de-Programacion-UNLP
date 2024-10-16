/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_12;
import PaqueteLectura.*;
/**
 *
 * @author lucia
 */
public class Parcial12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Concurso concurso = new Concurso(3,5);
        for(int i=0; i<5 ;i++) {
            Cancion cancion = new Cancion(GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarString(10),(i+1));
            concurso.agregarCancion(cancion, GeneradorAleatorio.generarInt(3));
        }
        
        System.out.println("ingrese una identificacion: ");
        int id = Lector.leerInt();
        while(id != 0) {
            System.out.println("ingrese un nombre: ");
            String nombre = Lector.leerString();
            System.out.println("ingrese un apellido: ");
            String apellido = Lector.leerString();
            System.out.println("ingrese un dni: ");
            int dni = Lector.leerInt();
            System.out.println("ingrese un puntaje: ");
            double puntaje = Lector.leerDouble();
            Estudiante unEstudiante = new Estudiante(nombre,apellido,dni);
            concurso.interpretarCancion(id, unEstudiante, puntaje);
            System.out.println("ingrese una identificacion: ");
            id = Lector.leerInt();
        }
        
        System.out.println("ingrese una identificacion: ");
        int id2 = Lector.leerInt();
        
        
        Estudiante ganador = concurso.retornarGanador(id2);
        if(ganador != null) 
            System.out.println("Ganador= "+ganador.toString());
        else
            System.out.println("Nadie");
        
        for(int i=0; i<3 ;i++) {
            Cancion unaCancion = concurso.mayorPuntaje(i);
            if(unaCancion != null)
                System.out.println(unaCancion.toString());
            else
                System.out.println("//////");
        }
        
    }
    
}
