/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_25;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Parcial25 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado("super 44","44 e 28 y 27",10,5);
        
        for(int i=0; i<10 ;i++) {
            for(int j=0; j<5 ;j++) {
                Producto producto = new Producto(GeneradorAleatorio.generarInt(10),GeneradorAleatorio.generarString(12),GeneradorAleatorio.generarString(12),GeneradorAleatorio.generarInt(100),GeneradorAleatorio.generarDouble(200)+500);
                supermercado.agregarProducto(producto);
            }
        }
        
        Producto producto = new Producto(GeneradorAleatorio.generarInt(10),GeneradorAleatorio.generarString(12),"CocaCola",GeneradorAleatorio.generarInt(100),GeneradorAleatorio.generarDouble(200)+500);
        supermercado.agregarProducto(producto);
        
        Producto producto2 = new Producto(GeneradorAleatorio.generarInt(10),GeneradorAleatorio.generarString(12),"CocaCola",GeneradorAleatorio.generarInt(100),GeneradorAleatorio.generarDouble(200)+500);
        supermercado.agregarProducto(producto2);
        
        Producto producto3 = new Producto(GeneradorAleatorio.generarInt(10),GeneradorAleatorio.generarString(12),"CocaCola",GeneradorAleatorio.generarInt(100),GeneradorAleatorio.generarDouble(200)+500);
        supermercado.agregarProducto(producto3);
        
        Producto producto4 = new Producto(GeneradorAleatorio.generarInt(10),GeneradorAleatorio.generarString(12),"CocaCola",GeneradorAleatorio.generarInt(100),GeneradorAleatorio.generarDouble(200)+500);
        supermercado.agregarProducto(producto4);
        
        Producto producto5 = new Producto(GeneradorAleatorio.generarInt(10),GeneradorAleatorio.generarString(12),"CocaCola",GeneradorAleatorio.generarInt(100),GeneradorAleatorio.generarDouble(200)+500);
        supermercado.agregarProducto(producto5);
        
        System.out.println(supermercado.toString());
        
        System.out.println("cantidad de productos con esa marca en el estante 3 es: " + supermercado.productosExhibidos("EkH2nD4jZKxq", 3));
        
        System.out.println("la el numero de gondola con mayor cantidad de productos exhibidos es: " + supermercado.mayorCantTotalUniExhibidas());
        
    }
    
}
