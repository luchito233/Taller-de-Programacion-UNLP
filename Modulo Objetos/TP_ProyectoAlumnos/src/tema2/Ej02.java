/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
/* 2- Utilizando la clase Persona. Realice un programa que almacene en un vector a lo sumo
15 personas. La información (nombre, DNI, edad) se debe generar aleatoriamente hasta
obtener edad 0. Luego de almacenar la información:
- Informe la cantidad de personas mayores de 65 años.
- Muestre la representación de la persona con menor DNI. */

public class Ej02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona vPersonas[] = new Persona[15]; 
        int edad = GeneradorAleatorio.generarInt(100);
        System.out.println("edad: " + edad);
        int dl = 0;
        while(edad != 0 && dl < 15) {
            String nombre = GeneradorAleatorio.generarString(20);
            System.out.println("nombre: " + nombre);
            int dni = GeneradorAleatorio.generarInt(10000);
            System.out.println("dni: " + dni);
            vPersonas[dl] = new Persona(nombre,dni,edad);
            dl++;
            edad = GeneradorAleatorio.generarInt(100);
            System.out.println("edad: " + edad);
        }
        int cantMayores = 0;
        Persona menorDni = new Persona();
        menorDni.setDNI(99999);
        int i;
        for(i=0; i < dl ;i++) {
            if(vPersonas[i].getEdad() > 65)
                cantMayores++;
            if(vPersonas[i].getDNI() < menorDni.getDNI()) {
                menorDni = vPersonas[i];
            }
            
        }
        System.out.println("-------");
        System.out.println("la cantidad de personas mayores a 65 es: " + cantMayores);
        System.out.println(menorDni.toString());
    }
    
}
    