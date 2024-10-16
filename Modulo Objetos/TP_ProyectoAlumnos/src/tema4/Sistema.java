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
public abstract class Sistema {
    private Estacion estacion;
    private int anioIni;
    private int anioN;
    private double[][] temperaturas;
    public Sistema(Estacion unaEstacion, int unAnioInicial, int unAnioN) {
        estacion = unaEstacion;
        anioIni = unAnioInicial;
        anioN = unAnioN;
        temperaturas = new double[this.anioN][12];
        for(int i=0; i<this.anioN ;i++) {
            for(int j=0; j<12 ;j++) {
                temperaturas[i][j] = 100.0;
            }
        }
        
        
        
    }

    public Estacion getEstacion() {
        return estacion;
    }

    public void setEstacion(Estacion estacion) {
        this.estacion = estacion;
    }

    public int getAnioIni() {
        return anioIni;
    }

    public void setAnioIni(int anioIni) {
        this.anioIni = anioIni;
    }

    public int getAnioN() {
        return anioN;
    }

    public void setAnioN(int anioN) {
        this.anioN = anioN;
    }

    public double getTemperaturas(int unAnio, int unMes) {
        return this.temperaturas[unAnio][unMes];
    }

    public void setTemperaturas(int unAnio, int unMes, double unaTemperatura) {
        this.temperaturas[unAnio-this.anioIni][unMes] = unaTemperatura;
    }
    
    public String mayorTemperatura() {
        double mayorTemp = -1;
        int mayorAnio = 0;
        int mayorMes = 0;
        for(int i=0; i < this.anioN ;i++) {
            for(int j=0; j < 12 ;j++) {
                if(mayorTemp < this.temperaturas[i][j]) {
                    mayorTemp = this.temperaturas[i][j];
                    mayorAnio = i;
                    mayorMes = j;
                }
            }
        }
        return "el anio de la mayor temperatura: " + (mayorAnio + this.anioIni) + ", mes: " + (mayorMes+1);
    }
    
    public abstract String retornarPromedio();
    
    @Override
    public String toString() {
        return this.estacion + "/n" + this.retornarPromedio();
    }
}
