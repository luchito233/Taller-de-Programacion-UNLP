/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial1;
import PaqueteLectura.Lector;
/**
 *
 * @author Alumno
 */
public class Alumno {
    private int dni;
    private String nombre;
    private int df;
    private int dl;
    private Nota[] materias; 
    public Alumno(int unDni, String unNombre, int cantMaterias) {
        this.dni = unDni;
        this.nombre = unNombre;
        this.df = cantMaterias;
        this.dl = 0;
        this.materias = new Nota[this.df]; 
    }
    
    public boolean sePuede() {
        return this.dl < this.df;
    }
    
    public void agregarMateria(Nota unaMateria) {
        if(this.sePuede()) {
            this.materias[this.dl] = unaMateria;
            this.dl++;
        }
    }
    
    public boolean tesis() {
        int i = 0;
        while(i < this.dl) {
            if(this.materias[i].getNombre().equals("Tesis"))
                return true;
            i++;
        }
        return false;
    }
    
    public boolean graduado() {
        System.out.println("ingrese la cantidad de materias necesarias para terminar la carrera: ");
        int cantidadMateriasAprob = Lector.leerInt();
        return cantidadMateriasAprob <= this.dl && this.tesis();
    }
    
    public String informarMaterias() {
        String aux = "";
        for(int i=0; i<this.dl ;i++) {
            aux += this.materias[i].toString() + "\n";
        }
        return aux;
    }
    
    @Override
    public String toString() {
        String aux = "Dni: " + this.dni + ", Nombre: " + this.nombre + ", Materias = " + this.informarMaterias() + "Graduado: " + this.graduado();
        return aux;
    }
    
}
