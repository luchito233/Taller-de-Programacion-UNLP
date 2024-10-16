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
public class Circulo extends Figura {
    private double radio;
    public Circulo(double unRadio, String unColorR, String unColorL) {
        super(unColorR,unColorL);
        setRadio(unRadio);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    @Override
    public double calcularPerimetro() {
        return this.getRadio() * 2 * Math.PI;
    }
            
    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(this.getRadio(), 2.0);
    }
    
    @Override
    public String toString() {
        String aux = super.toString() + " radio: " + this.getRadio();
        return aux;
    }
}
