/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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


package tema3;

/**
 *
 * @author lucia
 */
public class Triangulo {
    private double a;
    private double b;
    private double c;
    private String colorRelleno;
    private String colorLinea;
   
    public Triangulo(double lado1, double lado2, double lado3, String colorR, String colorL) {
        a = lado1;
        b = lado2;
        c = lado3;
        colorRelleno = colorR;
        colorLinea = colorL;        
    }

    public double getLado1() {
        return a;
    }

    public double getLado2() {
        return b;
    }

    public double getLado3() {
        return c;
    }

    public String getColorLinea() {
        return colorLinea;
    }

    public void setLado1(double lado1) {
        a = lado1;
    }

    public void setLado2(double lado2) {
        b = lado2;
    }

    public void setLado3(double lado3) {
        c = lado3;
    }

    public void setColorRelleno(String colorR) {
        colorRelleno = colorR;
    }

    public void setColorLinea(String colorL) {
        colorLinea = colorL;
    }
    
    public double calcularPerimetro() {
        return a + b + c;
    }
    
    public double calcularArea () {
        double s = (a + b + c) / 2;  
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

            
}
