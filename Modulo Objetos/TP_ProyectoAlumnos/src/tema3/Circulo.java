/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/*
5-A- Definir una clase para representar círculos. Los círculos se caracterizan por su radio
(double), el color de relleno (String) y el color de línea (String).
Provea un constructor que reciba todos los datos necesarios para iniciar el objeto.
Provea métodos para:
- Devolver/modificar el valor de cada uno de sus atributos (métodos get y set)
- Calcular el perímetro y devolverlo (método calcularPerimetro)
- Calcular el área y devolverla (método calcularArea)
B- Realizar un programa que instancie un círculo, le cargue información leída de teclado e
informe en consola el perímetro y el área.
NOTA: la constante PI es Math.PI

Area = pi x radio^2
perimetro = 2pi x radio

 */
public class Circulo {
    private double radio;
    private String colorRelleno;
    private String colorLinea;
    
    public Circulo(double unRadio, String unColorR, String unColorL) {
        this.radio = unRadio;
        this.colorRelleno = unColorR;
        this.colorLinea = unColorL;
    }

    public double getRadio() {
        return radio;
    }

    public String getColorRelleno() {
        return colorRelleno;
    }

    public String getColorLinea() {
        return colorLinea;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public void setColorLinea(String colorLinea) {
        this.colorLinea = colorLinea;
    }
    
    public double perimetro() {
        double peri = this.radio * 2 * Math.PI;
        return peri;
    }
            
    public double area() {
        double Area =  Math.PI * Math.pow(this.radio, 2.0);
        return Area;
    }
    
    
    @Override
    public String toString() {
        String devolver = "perimetro: " + perimetro() + " area: " + area() ;
        return devolver;
    }
}
