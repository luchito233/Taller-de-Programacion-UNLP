/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica_5;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Proyecto {
    private String nombre;
    private int codigo;
    private String nombreDirector;
    private int cantInvestigadores = 0;
    private Investigador[] investigadores;
    
    public Proyecto(String unNombre, int unCodigo, String unNombreDir) {
        nombre = unNombre;
        codigo = unCodigo;
        nombreDirector = unNombreDir;
        investigadores = new Investigador[50];
    }

    public Investigador[] getInvestigadores() {
        return investigadores;
    }
    
    public boolean estaLleno() {
        return this.cantInvestigadores == 50;
    } 
    
    public void agregarInvestigador(Investigador unInvestigador) {
        if(!this.estaLleno()) {
            this.investigadores[this.cantInvestigadores] = unInvestigador;
            this.cantInvestigadores++;
        }
    }
    
    public double dineroTotalOtorgado() {
        double aux = 0;
        for(int i=0; i<this.cantInvestigadores ;i++) {
            aux += investigadores[i].devolverMonto();
        }
        return aux;
    }
    
    public int buscar(String nombre) {
        int indice = 0;
        while(indice < this.cantInvestigadores && !nombre.equals(this.investigadores[indice].getNombre())) {
            indice++;
        }
        if(indice < this.cantInvestigadores) {
            return indice;
        }
        else
            return -1;
    }
    
    public void otorgarTodos(String nombre_completo) {
        GeneradorAleatorio.iniciar();
        int aux = this.buscar(nombre_completo);
        if(aux != -1) {
            while(this.investigadores[aux].sePuede()) {
                Subsidio sub = new Subsidio(GeneradorAleatorio.generarDouble(1000),GeneradorAleatorio.generarString(12));
                this.investigadores[aux].agregarSubsidio(sub);
            }
        }
        else
            System.out.println("no se encuentra el investigador");
    }
    
    public String concatenar() {
        String aux = "";
        for(int i=0; i<this.cantInvestigadores ;i++) {
            aux += this.investigadores[i].toString();
        }
        return aux;
    }
    
    @Override
    public String toString() {
        String aux = "Nombre: " + this.nombre + ", Codigo: " +
                     this.codigo + ", Nombre del Director: " +
                     this.nombreDirector + ", dinero otorgano: " +
                     this.dineroTotalOtorgado() + concatenar() ;
        return aux;
    }
    
}
