/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_19;

/**
 *
 * @author lucia
 */
public class ProgramadorLider extends Programador {
    private int antiguedad;
    private int cantProyectosDiri;
    public ProgramadorLider(String unNombre, int unDni, double unSueldoBasico, int cantLxH, String unLenguajeP, int unaAntiguedad, int cantProyectosDirigidos) {
        super(unNombre,unDni,unSueldoBasico,cantLxH,unLenguajeP);
        this.antiguedad = unaAntiguedad;
        this.cantProyectosDiri = cantProyectosDirigidos;
    }
    
    @Override
    public double sueldoFinal() {
        return (super.getSueldoBasico() + (10000.0 * this.antiguedad) + (20000.0 * this.cantProyectosDiri));
    }
    
}
