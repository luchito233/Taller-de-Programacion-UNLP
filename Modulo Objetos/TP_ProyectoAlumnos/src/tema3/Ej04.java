/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;
import PaqueteLectura.Lector;
/*
4-A- Un hotel posee N habitaciones. De cada habitación conoce costo por noche, si está
ocupada y, en caso de estarlo, guarda el cliente que la reservó (nombre, DNI y edad).
(i) Genere las clases necesarias. Para cada una provea métodos getters/setters adecuados.
(ii) Implemente los constructores necesarios para iniciar: los clientes a partir de nombre,
DNI, edad; el hotel para N habitaciones, cada una desocupada y con costo aleatorio e/
2000 y 8000.
(iii) Implemente en las clases que corresponda todos los métodos necesarios para:
- Ingresar un cliente C en la habitación número X. Asuma que X es válido (es decir, está
en el rango 1..N) y que la habitación está libre.
- Aumentar el precio de todas las habitaciones en un monto recibido.
- Obtener la representación String del hotel, siguiendo el formato:
{Habitación 1: costo, libre u ocupada, información del cliente si está ocupada}
…
{Habitación N: costo, libre u ocupada, información del cliente si está ocupada}
B- Realice un programa que instancie un hotel, ingrese clientes en distintas habitaciones,
muestre el hotel, aumente el precio de las habitaciones y vuelva a mostrar el hotel.
NOTAS: Reúse la clase Persona. Para cada método solicitado piense a qué clase debe
delegar la responsabilidad de la operación.
*/

public class Ej04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("ingrese la cantidad de habitaciones del hotel: ");
        int n = Lector.leerInt();
        Hotel hotel = new Hotel(n);
        for(int i=0; i<5; i++) {
            System.out.println("ingrese nombre, dni y edad");
            Cliente cliente = new Cliente(Lector.leerString(),Lector.leerInt(),Lector.leerInt());
            System.out.println("ingrese la posicion donde ingresar al cliente: " + "1.." + n);
            int pos = Lector.leerInt();
            hotel.agregarCliente(cliente, pos);
        }
        System.out.println(hotel.toString());
        System.out.println("ingrese un aumento");
        double aumento = Lector.leerDouble();
        hotel.aumentarPrecio(aumento);
        System.out.println(hotel.toString());
    }
    
}