/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;
import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */

/* 3- Se realizará un casting para un programa de TV. El casting durará a lo sumo 5 días y en
cada día se entrevistarán a 8 personas en distinto turno.

a) Simular el proceso de inscripción de personas al casting. A cada persona se le pide
nombre, DNI y edad y se la debe asignar en un día y turno de la siguiente manera: las
personas primero completan el primer día en turnos sucesivos, luego el segundo día y así
siguiendo. La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los
40 cupos de casting.

Una vez finalizada la inscripción:

b) Informar para cada día y turno asignado, el nombre de la persona a entrevistar.
NOTA: utilizar la clase Persona. Pensar en la estructura de datos a utilizar. Para comparar
Strings use el método equals. */

public class Ej03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona casting[][] = new Persona[5][8];
        int dia=0, entrevista= 0, persona = 0;
        System.out.println("ingrese un nombre: ");
        String nombre = Lector.leerString();
        while(persona < 40 && !nombre.equals("ZZZ")){
            int dni = GeneradorAleatorio.generarInt(1000);
            System.out.println("ingrese un dni: " +  dni );
            int edad = GeneradorAleatorio.generarInt(100);
            System.out.println("ingrese un edad: " + edad);
            
            System.out.println("-----------------------");
            casting[dia][entrevista] = new  Persona(nombre,dni,edad);
            persona++;
            entrevista++;
            
            if(entrevista == 8){
                entrevista = 0;
                dia++;
            }
            
            System.out.println("ingrese un nombre: ");
            nombre = Lector.leerString();
            
        }
        int y = 0;
        for(int x = 0; x < dia+1 ;x++) {
            while( y != 8  &&  casting[x][y] != null ) {
                System.out.println("dia:  " + (x+1) + " entrevista: " + (y+1));
                System.out.println(casting[x][y].getNombre());
                y++;
            }
            y = 0;
        }
    }
    
}
