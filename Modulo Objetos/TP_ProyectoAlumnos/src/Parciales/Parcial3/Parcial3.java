/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial3;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Parcial3 {

    /**
      2) Realice un programa que instancie una compra mayorista y una minorista.Cargue 3 productos a cada compra. Para finalizar, muestre la representación String de cada compra.
     * @param args
     */
    public static void main(String[] args) {
        CompraMayorista cMayorista = new CompraMayorista(23,10,2324124);
        CompraMinorista cMinorista = new CompraMinorista(54,15,GeneradorAleatorio.generarBoolean());
        
        for(int i=0; i<3 ;i++) {
            Producto compra1 = new Producto(GeneradorAleatorio.generarInt(23),GeneradorAleatorio.generarDouble(2800),GeneradorAleatorio.generarString(15));
            Producto compra2 = new Producto(GeneradorAleatorio.generarInt(23),GeneradorAleatorio.generarDouble(2700),GeneradorAleatorio.generarString(15));
            
            cMayorista.agregarProducto(compra1);
            cMinorista.agregarProducto(compra2);
        }
        System.out.println("//////Mayorista//////");
        System.out.println(cMayorista.toString());
        System.out.println("//////Minorista//////");
        System.out.println(cMinorista.toString());
        
    }
    
}
