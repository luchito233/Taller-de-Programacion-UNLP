/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_18;

/**
 *
 * @author lucia
 */
public class Sistema1 extends SistemaOriginal{

    public Sistema1(int cantMaxima) {
        super(cantMaxima);
    }
    
    @Override
    public boolean verificarSolicitud(double X, Subsidio unSubsidio) {
        boolean aux = false;
        double montoTotal = unSubsidio.getPasajeDeIda() + unSubsidio.getPasajeDeVuelta() + unSubsidio.getTasaEmbarque();
        if(montoTotal < X)
            aux = true;
        return aux;
    }
    
}
