/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica_5;

/**
. agregarFecha que recibe una “fecha” y la agrega adecuadamente.
. La gira debe responder al mensaje actuar de manera distinta. Imprime la leyenda
“Buenas noches ...” seguido del nombre de la ciudad de la fecha “actual”. Luego
debe imprimir el listado de temas como lo hace cualquier recital. Además debe
establecer la siguiente fecha de la gira como la nueva “actual”.
 */
public class RecitalGira extends Recital {
    private String nombre;
    private Fecha[] fechas;
    private int cantFechas;
    private int cantMaxima;
    private int actual;
    public RecitalGira(String unNombre, int cantFechas, String unNombreRecital, int cantMax) {
        super(unNombreRecital,cantMax);
        this.nombre = unNombre;
        this.cantMaxima = cantFechas;
        this.actual = 0;
        fechas = new Fecha[this.cantMaxima];
        for(int i=0; i<this.cantMaxima ;i++) {
            fechas[i] = null;
        }
    }
    
    public boolean puedoAgregar() {
        return this.cantFechas < this.cantMaxima;
    }
    
    public void agregarFecha(Fecha unaFecha) {
        if(puedoAgregar()) {
            this.fechas[this.cantFechas] = unaFecha;
            this.cantFechas++;
        }
    }
    
    @Override
    public String actuar() {
        String aux = "Buenas noches... ";
        aux += this.fechas[this.actual].getCiudad() + " " + super.actuar();
        if(this.actual < this.cantFechas)
            this.actual++;
        return aux;
    }
    
    @Override
    public double calcularCosto() {
        return (30000.0 * this.cantFechas);
    }
    
}
