/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author lucia
 */

/* 4- Sobre un nuevo programa, modifique el ejercicio anterior para considerar que:
a) Durante el proceso de inscripción se pida a cada persona sus datos (nombre, DNI, edad)
y el día en que se quiere presentar al casting. La persona debe ser inscripta en ese día, en el
siguiente turno disponible. En caso de no existir un turno en ese día, informe la situación.
La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los 40 cupos
de casting.

Una vez finalizada la inscripción:

b) Informar para cada día: la cantidad de inscriptos al casting ese día y el nombre de la
persona a entrevistar en cada turno asignado. */

public class Ej04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona casting[][] = new Persona[5][8];
        int vDias[] = new int[5];
        int persona = 0;
        GeneradorAleatorio.iniciar();
        System.out.println("ingrese un nombre: ");
        String nombre = Lector.leerString();
        while(persona < 40 && !nombre.equals("ZZZ")){
            int dni = GeneradorAleatorio.generarInt(1000);
            System.out.println("ingrese un dni: " +  dni );
            int edad = GeneradorAleatorio.generarInt(100);
            System.out.println("ingrese un edad: " + edad);
            int dia = GeneradorAleatorio.generarInt(5);
            System.out.println("dia: " + (dia+1));
            System.out.println("-----------------------");
            
            if(vDias[dia] < 8) {
                casting[dia][vDias[dia]] = new Persona(nombre, dni, edad);
                vDias[dia]++;
                persona++;
                System.out.println("Persona asignada al día " + (dia + 1) + " en el turno " + vDias[dia]);
            } else {
                System.out.println("El día " + (dia + 1) + " está completo. Elija otro día.");
            }
            
            System.out.println("ingrese un nombre: ");
            nombre = Lector.leerString();
            
        }
        System.out.println("perosnas: "+ persona);
        int a,b;
        for(a=0;a < 5;a++) {
            int cant = vDias[a];
            System.out.println("la cantidad de entrevistados para el dia: " + (a+1) + " es de: " + cant);  
            for(b=0;b < 8;b++) {
                if(casting[a][b] != null) {
                    cant++;
                    System.out.println(casting[a][b].toString());
                }
            }
        }   
    }
    
}
