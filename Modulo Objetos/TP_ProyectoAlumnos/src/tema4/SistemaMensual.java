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
public class SistemaMensual extends Sistema {
    private String[] meses = new String[]{"Enero", "Febrero", "Marzo",
        "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
        "Octubre", "Noviembre", "Diciembre"};
    public SistemaMensual(Estacion unaEstacion, int unAnioInicial, int unAnioN) {
        super(unaEstacion,unAnioInicial,unAnioN);
    }
    
    @Override
    public String retornarPromedio() {
        double total;
        String aux =  "";
        int anios =this.getAnioN();
        for(int i=0; i < 12 ;i++) {
            total = 0;
            for(int j=0; j < anios ;j++) {
                total += this.getTemperaturas(j, i);
            }
            aux += "Mes: " + meses[i] + ", la tempertura promedio es: " + (total/anios) * 100 + " °C \n";
        }
        return aux;
    }
    
    public String toString() {
        return super.toString();
    }
    
}
