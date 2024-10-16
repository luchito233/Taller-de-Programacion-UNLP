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
public class EstadisticoTrimestral extends Estadistico {

    public EstadisticoTrimestral(Sistema sistema, int cantAnios) {
        super(sistema, cantAnios);
    }
    
    @Override
    public String cantEgresados() {
        String aux = "";
        int cantEgresados;
        for(int i=1; i<5 ;i++) {
            cantEgresados = 0;
            for(int j=0; j<this.getCantAnios() ;j++) {
                cantEgresados += this.retornarCantEgresados(i, super.getSistema().getAnioCreacion()+j);
            }
            aux += "Triemestre " + (i) + ": " + cantEgresados + " egresados; \n";
        }
        return aux;
    }
    
    public String toString() {
        return super.toString();
    }
    
    
    
}
