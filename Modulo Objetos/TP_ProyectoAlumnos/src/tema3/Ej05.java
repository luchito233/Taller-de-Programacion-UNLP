/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package tema3;
import PaqueteLectura.Lector;
/**
 *
 * @author lucia
 */
public class Ej05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("ingrese el radio del circulo: ");
        double r = Lector.leerDouble();
        System.out.println("ingrese el color de relleno: ");
        String colorR = Lector.leerString();
        System.out.println("ingrese el color de linea: ");
        String colorL = Lector.leerString();
        Circulo circulo = new Circulo(r,colorR,colorL);
        System.out.println(circulo.toString());
    }
    
}
