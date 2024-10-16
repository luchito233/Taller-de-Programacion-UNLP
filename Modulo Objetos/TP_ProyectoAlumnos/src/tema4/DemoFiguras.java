/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/* E- Realizar un programa que instancie un triángulo y un círculo. Muestre en consola la
representación String de cada uno. Pruebe el funcionamiento del método despintar. */

public class DemoFiguras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cuadrado cuad = new Cuadrado(10,"Rojo", "Negro");
        System.out.println("Color linea: " + cuad.getColorLinea()); 
        System.out.println("Area: " + cuad.calcularArea()); 
        System.out.println("Representacion del cuadrado: " + cuad.toString()); 
        cuad.despintar();
        System.out.println("Representacion del cuadrado: " + cuad.toString());
        System.out.println("---------------------------------");
        Triangulo triangulo = new Triangulo(10,5,3,"verde","azul");
        Circulo circulo = new Circulo(10,"azul","violeta");
        System.out.println("Color linea: " + triangulo.getColorLinea());
        System.out.println("Area: " + triangulo.calcularArea());
        System.out.println("Representacion del cuadrado: " + triangulo.toString());
        System.out.println("---------------------------------");
        System.out.println("Color linea: " + circulo.getColorLinea());
        System.out.println("Area: " + circulo.calcularArea());
        System.out.println("Representacion del cuadrado: " + circulo.toString());
        System.out.println("---------------------------------");
        circulo.despintar();
        triangulo.despintar();
        System.out.println("Representacion del cuadrado: " + triangulo.toString());
        System.out.println("Representacion del cuadrado: " + circulo.toString());      
    }  
}
