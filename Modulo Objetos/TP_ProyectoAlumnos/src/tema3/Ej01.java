/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;
import PaqueteLectura.Lector;
/*  1-A- Definir una clase para representar triángulos. Un triángulo se caracteriza por el
tamaño de sus 3 lados (double), el color de relleno (String) y el color de línea (String).
Provea un constructor que reciba todos los datos necesarios para iniciar el objeto.
Provea métodos para:
- Devolver/modificar el valor de cada uno de sus atributos (métodos get y set)
- Calcular el perímetro y devolverlo (método calcularPerimetro)
- Calcular el área y devolverla (método calcularArea)
B- Realizar un programa que instancie un triángulo, le cargue información leída desde
teclado e informe en consola el perímetro y el área.
NOTA: Calcular el área con la fórmula Área = √s(s − a)(s − b)(s − c) , donde a, b y c son
los lados y s =a+b+c/2
. La función raíz cuadrada es Math.sqrt(#)  */

public class Ej01 {

    
    public static void main(String[] args) {
        System.out.println("ingrese el lado 1: ");
        double lado1 = Lector.leerInt();
        System.out.println("ingrese el lado 2: ");
        double lado2 = Lector.leerInt();
        System.out.println("ingrese el lado 3: ");
        double lado3 = Lector.leerInt();
        System.out.println("ingrese el color de relleno: ");
        String colorRelle = Lector.leerString();
        System.out.println("ingrese el color del perimetro: ");
        String colorPeri = Lector.leerString();
        Triangulo triangulo = new Triangulo(lado1,lado2,lado3,colorRelle,colorPeri);
        
        System.out.println("Area del triangulo: " + triangulo.calcularArea() + " Perimetro del triangulo: " + triangulo.calcularPerimetro());
                
    }
    
}
