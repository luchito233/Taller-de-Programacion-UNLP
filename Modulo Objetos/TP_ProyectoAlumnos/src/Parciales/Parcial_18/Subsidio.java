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
public class Subsidio {
    private String nombreInvestigador;
    private String nombreDelPlanTrabajo;
    private String lugarDeDestino;
    private double pasajeDeIda;
    private double pasajeDeVuelta;
    private double tasaEmbarque;
    private int diasEnLaEstadia;
    private double hotelPorDia;
    private boolean otorgado;

    public Subsidio(String nombreInvestigador, String nombreDelPlanTrabajo, String lugarDeDestino, double pasajeDeIda, double pasajeDeVuelta, double tasaEmbarque, int diasEnLaEstadia, double hotelPorDia) {
        this.nombreInvestigador = nombreInvestigador;
        this.nombreDelPlanTrabajo = nombreDelPlanTrabajo;
        this.lugarDeDestino = lugarDeDestino;
        this.pasajeDeIda = pasajeDeIda;
        this.pasajeDeVuelta = pasajeDeVuelta;
        this.tasaEmbarque = tasaEmbarque;
        this.diasEnLaEstadia = diasEnLaEstadia;
        this.hotelPorDia = hotelPorDia;
        this.otorgado = false;
    }

    public void setOtorgado(boolean otorgado) {
        this.otorgado = otorgado;
    }

    public double getPasajeDeIda() {
        return pasajeDeIda;
    }

    public double getPasajeDeVuelta() {
        return pasajeDeVuelta;
    }

    public double getTasaEmbarque() {
        return tasaEmbarque;
    }

    public int getDiasEnLaEstadia() {
        return diasEnLaEstadia;
    }

    public double getHotelPorDia() {
        return hotelPorDia;
    }

    public boolean isOtorgado() {
        return otorgado;
    }
    
    @Override
    public String toString() {
        return "nombre del investigador: " + this.nombreInvestigador + ", nombre del plan de trabajo: " + this.nombreDelPlanTrabajo + ", lugar de destino: " + this.lugarDeDestino + "\n" + "Pasaje de ida: " + this.pasajeDeIda + ", pasaje de vuelta" + this.pasajeDeVuelta + ", tasa de embarque: " + this.tasaEmbarque + ", cantidad de dias en la estadia: " + this.diasEnLaEstadia + ", costo del hotel por dia: " + this.hotelPorDia;
    }
}
