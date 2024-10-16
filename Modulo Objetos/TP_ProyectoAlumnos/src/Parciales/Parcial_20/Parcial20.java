/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_20;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Parcial20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Supermercado supermercado = new Supermercado("56 esq 30",5);
        for(int i=0; i<4 ;i++) {
            Caja unaCaja = new Caja(GeneradorAleatorio.generarString(10),10);
            supermercado.agregarCaja(unaCaja);
        }
        
        System.out.println(supermercado.toString());
        
        for(int j=0; j<5 ;j++) {
            supermercado.validarCompra(GeneradorAleatorio.generarInt(4)+1,GeneradorAleatorio.generarInt(1323),GeneradorAleatorio.generarInt(15),GeneradorAleatorio.generarDouble(50000), "debito");
        }
        
        for(int j=0; j<5 ;j++) {
            supermercado.validarCompra(GeneradorAleatorio.generarInt(4)+1,GeneradorAleatorio.generarInt(1323),GeneradorAleatorio.generarInt(15),GeneradorAleatorio.generarDouble(50000), "credito");
        }
        
        for(int j=0; j<5 ;j++) {
            supermercado.validarCompra(GeneradorAleatorio.generarInt(4)+1,GeneradorAleatorio.generarInt(1323),GeneradorAleatorio.generarInt(15),GeneradorAleatorio.generarDouble(50000), "efectivo");
        }
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println(supermercado.toString());
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("La caja con menor cantidad de compras de credito es: " +supermercado.menorCantTickets());
        
    }
    
}
