/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial9;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Parcial9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();;
        Funcion teatro = new Funcion("10 Sombras de Grey","19/02/2005","19:15",10,5);
        for(int i=0; i<7 ;i++) {
            teatro.ocuparButaca(GeneradorAleatorio.generarInt(10), GeneradorAleatorio.generarInt(5));
        }
        System.out.println(teatro.toString());
    }
    
}
