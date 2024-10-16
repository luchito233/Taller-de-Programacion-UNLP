/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_14;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Parcial14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Director unDirector = new Director(GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarInt(10),GeneradorAleatorio.generarInt(24)+2000,GeneradorAleatorio.generarDouble(200000),GeneradorAleatorio.generarDouble(50000));
        Empresa empresa = new Empresa(GeneradorAleatorio.generarString(10),"24 y 64",unDirector,20);
        int pos ;
        for(int i=0; i<10 ;i++) {
            Encargado encargado = new Encargado(GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarInt(100),(GeneradorAleatorio.generarInt(70) + 1930),GeneradorAleatorio.generarDouble(10000),GeneradorAleatorio.generarInt(1000));
            pos = GeneradorAleatorio.generarInt(20);
            empresa.agregarEncargado(pos, encargado);
            System.out.println(pos);
        }
        
        System.out.println(empresa.toString());
        
    }
    
}
