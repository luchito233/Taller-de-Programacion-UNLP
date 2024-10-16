/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica_5;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Ej03 {

    /**
    d) Realice un programa que instancie un evento ocasional y una gira, cargando la
    información necesaria. Luego, para ambos, imprima el costo e invoque al mensaje actuar.
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        RecitalGira gira = new RecitalGira("LinkinPark",10,"Luna Park",17);
        for(int i=0; i<11 ;i++) {
            gira.agregarTema(GeneradorAleatorio.generarString(10)); 
        }
        RecitalOcasional ocasional = new RecitalOcasional("show privado","Lucho",20,"Rata Blanca",20);
        for(int i=0; i<10 ;i++) {
            ocasional.agregarTema(GeneradorAleatorio.generarString(10));           
        }
        for(int i=0; i<7 ;i++) {
            Fecha fecha = new Fecha(GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarInt(31));
            gira.agregarFecha(fecha);
        }
        
        System.out.println("costo de la gira: " + gira.calcularCosto());
        System.out.println("costo del recital ocasional: " + ocasional.calcularCosto());
        System.out.println(ocasional.actuar());
        System.out.println(gira.actuar());
        
    }
    
}
