/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial1;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Codigo {

    /**
 Representar alumnos de una facultad.De cualquier alumno se conoce: DNI, nombre y sus materias aprobadas (como
 máximo N). De las materias aprobadas se registra: nombre, nota y fecha. Además de los alumnos de grado se tiene la
 carrera, mientras que de los alumnos de doctorado el título universitario y universidad de origen.
 
 1- Genere las clases necesarias. Provea constructores para iniciar las materias aprobadas y los alumnos a partir de la
 información necesaria (estos para un máximo de N materias aprobadas y sin materias aprobadas inicialmente).
 
 2- Implemente los métodos necesarios, en las clases que corresponda, para:
 a) Dada una materia aprobada, agregarla a las materias aprobadas del alumno.
 
 b) Determinar si el alumno está graduado, teniendo en cuenta que para ello deben tener un total de N materias
 aprobadas y deben tener aprobada la materia “Tesis”.
 
 c) Obtener un String que represente al alumno siguiendo el ejemplo:
 
 Ej. alumnos de grado  “DNI; Nombre; Materias aprobadas: nombre, nota y  fecha de c/u; Está graduado: …; Carrera”
 Ej. alumnos de doctorado “DNI; Nombre; Materias aprobadas: nombre, nota y fecha de c/u; Está graduado: …; Título;
 Universidad de Origen”
 
 3- Realice un programa que instancie un alumno de cada tipo. Cargue información de materias aprobadas a cada
 uno. Informe en consola el resultado del inciso c)
     * @param args
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        AlumnoDoctorado alumno1 = new AlumnoDoctorado(46400123,"Maxi",30,"Ingeniero civil","La Plata");
        for(int i=0; i<14 ;i++) {
            Nota nota1 = new Nota(GeneradorAleatorio.generarString(15),GeneradorAleatorio.generarInt(11),GeneradorAleatorio.generarInt(32));
            alumno1.agregarMateria(nota1);
        }
        Nota nota1 = new Nota("Tesis",GeneradorAleatorio.generarInt(11),GeneradorAleatorio.generarInt(32));
        alumno1.agregarMateria(nota1);
        AlumnoGrado alumno2 = new AlumnoGrado(46415346,"Lucho",20,"Apu");
        for(int i=0; i<10 ;i++) {
            Nota nota2 = new Nota(GeneradorAleatorio.generarString(15),GeneradorAleatorio.generarInt(11),GeneradorAleatorio.generarInt(32));
            alumno2.agregarMateria(nota2);
        }
        System.out.println("informar alumnos:");
        System.out.println(alumno1.toString());
        System.out.println(alumno2.toString());
    }
    
}
