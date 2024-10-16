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
public class SistemaAnual extends Sistema {
    public SistemaAnual(Estacion unaEstacion, int unAnioInicial, int unAnioN) {
        super(unaEstacion,unAnioInicial,unAnioN);
    }
    
    @Override
    public String retornarPromedio() {
        double total;
        String aux = "";
        for(int i=0; i < this.getAnioN() ;i++) {
            total = 0;
            for(int j=0; j < 12; j++) {
                total += this.getTemperaturas(i, j);
            }
            aux += "Anio: " + (i+this.getAnioIni()) + ", la tempertura promedio es: " + (total/12) * 100 + " °C " + "\n ";
        }
        return aux;
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
    
}
