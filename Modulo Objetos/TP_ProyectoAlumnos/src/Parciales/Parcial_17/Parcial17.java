/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_17;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Parcial17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Fecha fecha1 = new Fecha(19,03,2010);
        Compra compraNormal = new Compra(543,fecha1,10);
        Fecha fecha2 = new Fecha(31,10,2015);
        CompraMayorista compraMayo = new CompraMayorista(20123124,"Luciano",673,fecha2,10);
        
        for(int i=0; i<7 ;i++) {
            Producto producto1 = new Producto(GeneradorAleatorio.generarInt(10),GeneradorAleatorio.generarString(23),GeneradorAleatorio.generarDouble(3000),GeneradorAleatorio.generarInt(40));
            compraNormal.agregarProducto(producto1);
        }
        
        for(int i=0; i<5 ;i++) {
            Producto producto2 = new Producto(GeneradorAleatorio.generarInt(10),GeneradorAleatorio.generarString(23),GeneradorAleatorio.generarDouble(3000),GeneradorAleatorio.generarInt(30));
            compraMayo.agregarProducto(producto2);
        }
        
        System.out.println(compraNormal.toString());
        
        System.out.println(compraMayo.toString());
        
        
        System.out.println("la compra normal se puede abonar en cuotas? " + compraNormal.abonableEnCuotas());
        System.out.println("la compra matorista se puede abonar en cuotas? " + compraMayo.abonableEnCuotas()); 
       
    }
    
}
