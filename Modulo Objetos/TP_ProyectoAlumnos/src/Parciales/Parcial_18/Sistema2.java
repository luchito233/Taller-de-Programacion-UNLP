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
public class Sistema2 extends SistemaOriginal{

    public Sistema2(int cantMaxima) {
        super(cantMaxima);
    }
    
    @Override
    public boolean verificarSolicitud(double X, Subsidio unSubsidio) {
        boolean aux = false;
        double montoTotal = unSubsidio.getDiasEnLaEstadia() * unSubsidio.getHotelPorDia();
        if(montoTotal < X)
            aux = true;
        return aux;
    }
    
}
