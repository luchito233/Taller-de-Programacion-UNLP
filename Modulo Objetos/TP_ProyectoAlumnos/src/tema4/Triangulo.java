/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author lucia
 */
public class Triangulo extends Figura {
    private double lado1;
    private double lado2;
    private double lado3;
    public Triangulo(double lado1, double lado2, double lado3, String unColorR, String unColorL) {
        super(unColorR,unColorL);
        setLado1(lado1);
        setLado1(lado2);
        setLado1(lado3);
        
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }

    @Override
    public double calcularArea() {
        double s = (this.lado1 + this.lado2 + this.lado3) / 2;  
        return Math.sqrt(s * (s - this.lado1) * (s - this.lado2) * (s - this.lado3));
    } 

    @Override
    public double calcularPerimetro() {
        return this.lado1 + this.lado2 + this.lado3;
    }

    @Override
    public String toString() {
        String aux = super.toString() +
                     " lado1: " + this.getLado1() +
                     " lado2: " + this.getLado2() +
                     " lado3: " + this.getLado3();
        return aux;
    }
    
    
}
