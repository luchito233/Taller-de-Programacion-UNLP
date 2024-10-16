/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_15;

/**
 *
 * @author lucia
 */
public class Estacionamiento {
    private String direccion;
    private double costoXhora;
    private int cantSectores;
    private int cantVehiculosXsector;
    private Vehiculo[][] estacionamiento;
    public Estacionamiento(String unaDireccion, double unCostoXhora, int cantidadDeSectores, int cantidadDeVehiculos) {
        this.direccion = unaDireccion;
        this.costoXhora = unCostoXhora;
        this.cantSectores = cantidadDeSectores;
        this.cantVehiculosXsector = cantidadDeVehiculos;
        this.estacionamiento = new Vehiculo[cantidadDeSectores][cantidadDeVehiculos];
        this.inicializarEstacionamiento();
    }
    
    private void inicializarEstacionamiento() {
        for(int i=0; i<this.cantSectores ;i++) {
            for(int j=0; j<this.cantVehiculosXsector ;j++) {
                this.estacionamiento[i][j] = null;
            }
        }
    }
    
    public void agregarVehiculo(Vehiculo unVehiculo, int X, int Y) {
        this.estacionamiento[X-1][Y-1] = unVehiculo;
    }
    
    public String liberarSector(String M, int unSector) { 
        String aux = "";
        for(int i=0; i<this.cantVehiculosXsector ;i++) {
            if(this.estacionamiento[unSector-1][i] != null) {
                if(this.estacionamiento[unSector-1][i].getModelo().equals(M)) {
                    aux += this.estacionamiento[unSector-1][i].toString() + "\n";
                    this.estacionamiento[unSector-1][i] = null;
                }
            }
        }
        return aux;
    }
    
    public int mayorRecaudo() {
        double max = -1;
        double sumaTotal;
        int mayorSector = -1;
        for(int i=0; i<this.cantSectores ;i++) {
            sumaTotal = 0.0;
            for(int j=0; j<this.cantVehiculosXsector ;j++) {
                if(this.estacionamiento[i][j] != null)
                    sumaTotal += this.estacionamiento[i][j].getCantHoraEst() * this.costoXhora;
            }
            if(max < sumaTotal) {
                max = sumaTotal;
                mayorSector = (i+1);
            }
        }
        
        return mayorSector;
    }
    
    @Override
    public String toString() {
        String aux = "Estacionamiento: " + this.direccion + "; Costo por hora " + this.costoXhora + "\n";
        for(int i=0; i<this.cantSectores ;i++) {
            aux += "Sector " + (i+1) + ":" + "\n";
            for(int j=0; j<this.cantVehiculosXsector ;j++) {
                if(this.estacionamiento[i][j] != null) 
                    aux += "Lugar " + (j+1) + "; " + this.estacionamiento[i][j].toString() + "\n";
            }  
        }
        return aux;
    }
    
}
