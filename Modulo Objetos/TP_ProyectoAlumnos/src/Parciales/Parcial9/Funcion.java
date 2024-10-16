/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial9;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Funcion {
    private String titulo;
    private String fecha;
    private String hora;
    private int maxFilas;
    private int maxButacas;
    private Butaca[][] teatro;
    public Funcion(String unTitulo, String unaFecha, String unaHora, int cantFilas, int cantButacas) {
        this.titulo = unTitulo;
        this.fecha = unaFecha;
        this.hora = unaHora;
        this.maxFilas = cantFilas;
        this.maxButacas = cantButacas;
        this.teatro = new Butaca[cantFilas][cantButacas];
        this.inicializarTeatro();
    }
    
    private void inicializarTeatro() {
        for(int i=0; i<this.maxFilas ;i++) {
            for(int j=0; j<this.maxButacas ;j++) {
                this.teatro[i][j] = new Butaca(GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarDouble(10000),i,j);
            }
        }
    }
    
    public double ocuparButaca(int numFila, int numButaca) {
        this.teatro[numFila][numButaca].setEstado(true);
        return this.teatro[numFila][numButaca].getPrecio();
    }
    
    public void desocuparFila(int unaFila) {
        for(int i=0; i<this.maxButacas ;i++) {
            this.teatro[unaFila][i].setEstado(false);
        }
    }
    
    public String informarButacas(int numButaca) {
        String aux = "";
        for(int i=0; i<this.maxFilas ;i++) {
            aux +=this.teatro[i][numButaca].toString() + "\n";
        }
        return aux;
    }
    
    @Override
    public String toString() {
        String aux= "Titulo: " + this.titulo + ", Fecha: " + this.fecha + ", Hora: " + this.hora + "\n";
        for(int j=0; j<this.maxButacas ;j++) {
            aux +=this.informarButacas(j);
        }
        return aux;
    }
}
