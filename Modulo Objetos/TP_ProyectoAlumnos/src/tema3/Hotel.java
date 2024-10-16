/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

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
import PaqueteLectura.GeneradorAleatorio;
public class Hotel {
   
    private int cantMaximo;
    private Habitacion[] habitacion;
    
    public Hotel(int n){
        this.cantMaximo = n;
        this.habitacion = new Habitacion[cantMaximo];
        GeneradorAleatorio.iniciar();
        for(int i=0; i < this.cantMaximo; i++) {
            this.habitacion[i] = new Habitacion(GeneradorAleatorio.generarInt(6001) + 2000);
        }
    }

    public int getCantMaximo() {
        return cantMaximo;
    }
    
    
    
    public void aumentarPrecio(double x) {
        for(int i=0; i<this.cantMaximo ;i++) {
            double costoActual = this.habitacion[i].getCosto() + x;
            this.habitacion[i].setCosto(costoActual);
        }
    }
    
    public void agregarCliente(Cliente unCliente, int x){
        this.habitacion[x-1].setCliente(unCliente);
        this.habitacion[x-1].setOcupada(true);
    }
    
    @Override
    public String toString() {
        String devolver = "";
        
        for(int i =0; i<this.cantMaximo;i++) {
            
            devolver += "Habitacion " + (i+1) + "  " + habitacion[i].toString() + "\n";
        }
        
        return devolver;
    } 
}