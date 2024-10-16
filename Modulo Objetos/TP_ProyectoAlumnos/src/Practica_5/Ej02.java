/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica_5;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
Realice un programa que instancie un estacionamiento con 3 pisos y 3 plazas por piso.
Registre 6 autos en el estacionamiento en distintos lugares.
Muestre la representación String del estacionamiento en consola.
Muestre la cantidad de autos ubicados en la plaza 1.
Lea una patente por teclado e informe si dicho auto se encuentra en el
estacionamiento o no. En caso de encontrarse, la información a imprimir es el piso y
plaza que ocupa.
 */
public class Ej02 {

    /**
     * @param args the command line arguments
     * 
     * String unNombre, String unaDireccion, String unaHoraA, String unaHoraC, int N, int M
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Estacionamiento estacionamiento = new Estacionamiento("Carlos","54 y 22","8:00","20:30",3,3);
        for(int i=0; i<7 ;i++) {
            Auto auto = new Auto(GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarInt(100));
            estacionamiento.agregarAuto(auto, GeneradorAleatorio.generarInt(3), GeneradorAleatorio.generarInt(3));
        }
        System.out.println(estacionamiento.toString());
        System.out.println("----------------------------------");
        System.out.println("la cantidad de autos en la plaza 1 es: " + estacionamiento.contarPlazas(1));
        System.out.println("ingrese una patente a buscar en el estacionamiento: ");
        int patente = Lector.leerInt();
        System.out.println("el auto se encuentra en: " + estacionamiento.buscar(patente));
    }

    
}
