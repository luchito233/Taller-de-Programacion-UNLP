/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_16;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Parcial16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BancoTradicional banco1 = new BancoTradicional("7 e 47 y 48","La Plata","Banco Nacion",100,120);
        BancoDigital banco2 = new BancoDigital("alguna","Banco Santander",110,15);
        for(int i=0; i<5 ;i++) {
            Cuenta unaCuenta = new Cuenta(GeneradorAleatorio.generarInt(20),GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarString(10),"dolares");
            System.out.println("su puedo agregar la cuenta al banco 1? " + banco1.agregarCuenta(unaCuenta));
            System.out.println("su puedo agregar la cuenta al banco 2? " + banco2.agregarCuenta(unaCuenta));
        }
        
        Cuenta unaCuenta2 = new Cuenta(21312,GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarString(10),"dolares");
        System.out.println("su puedo agregar la cuenta al banco 1? " + banco1.agregarCuenta(unaCuenta2));
        
        for(int i=0; i<5 ;i++) {
            Cuenta unaCuenta = new Cuenta(GeneradorAleatorio.generarInt(20),GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarString(10),"pesos");
            System.out.println("su puedo agregar la cuenta al banco 1? " + banco1.agregarCuenta(unaCuenta));
            System.out.println("su puedo agregar la cuenta al banco 2? " + banco2.agregarCuenta(unaCuenta));
        }
        
        Cuenta unaCuenta3 = new Cuenta(23,GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarString(10),"pesos");
        System.out.println("su puedo agregar la cuenta al banco 2? " + banco2.agregarCuenta(unaCuenta3));
        
        for(int i=0; i<5 ;i++) {
            Cuenta unaCuenta = new Cuenta(GeneradorAleatorio.generarInt(20),GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarString(10),"euros");
            System.out.println("su puedo agregar la cuenta al banco 1? " + banco1.agregarCuenta(unaCuenta));
            System.out.println("su puedo agregar la cuenta al banco 2? " + banco2.agregarCuenta(unaCuenta));
        }
        
        
        banco1.depositarDinero(21312, 10000);
        
        banco2.depositarDinero(23, 100001);
        
        System.out.println(banco1.puedeRecibirTarjeta(21312));
        
        System.out.println(banco2.puedeRecibirTarjeta(23));
       
        
    }
    
}
