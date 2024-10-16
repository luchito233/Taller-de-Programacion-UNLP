/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_23;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Parcial22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        LibroElectronico libro1 = new LibroElectronico(".pdf",50,"mil rosas",1300,5);
        LibroImpreso libro2 = new LibroImpreso(true,"el arbol de papas fritas",1600,6);
        
        for(int i=0; i<4 ;i++) {
            String autor1 = GeneradorAleatorio.generarString(10);
            libro1.agregarAutor(autor1);
            System.out.println(autor1);
        }
        
        System.out.println("_______________________________________");
        
        for(int i=0; i<5 ;i++) {
            String autor2 = GeneradorAleatorio.generarString(10);
            libro2.agregarAutor(autor2);
            System.out.println(autor2);
        }
        
        System.out.println(libro1.toString());
        
        System.out.println("_______________________________________");
        
        System.out.println(libro2.toString());
        
    }
    
}
