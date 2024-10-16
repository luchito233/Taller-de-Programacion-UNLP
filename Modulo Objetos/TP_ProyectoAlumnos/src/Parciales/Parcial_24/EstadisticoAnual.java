/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_24;

/**
 *
 * @author lucia
 */
public class EstadisticoAnual extends Estadistico {

    public EstadisticoAnual(Sistema sistema, int cantAnios) {
        super(sistema, cantAnios);
    }
   
    @Override
    public String cantEgresados() {
        String aux = "";
        int cantEgresados;
        int anioActual;
        for(int i=0; i<super.getCantAnios() ;i++) {
            cantEgresados = 0;
            anioActual = super.getSistema().getAnioCreacion() + i;
            for(int j=1; j<5 ;j++) {
                cantEgresados += this.retornarCantEgresados(j, anioActual);
            }
            aux += "Anio " + (anioActual + i) + " - " + cantEgresados + " egresados; \n";
        }
        return aux;
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
    
    
}
