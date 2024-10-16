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
public class Ej01 {

    /*
iii) Escriba un programa que instancie un proyecto con tres investigadores. Agregue dos
subsidios a cada investigador y otorgue los subsidios de uno de ellos. Luego imprima
todos los datos del proyecto en pantalla.
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        Proyecto proyecto = new Proyecto("ELON",12324,"Lucho");
        
        Investigador inv1 = new Investigador("Maxi",4,"cientifico");
        Investigador inv2 = new Investigador("Franco",1,"medico");
        Investigador inv3 = new Investigador("Joaco",3,"mecanico");
        
        proyecto.agregarInvestigador(inv1);
        proyecto.agregarInvestigador(inv2);
        proyecto.agregarInvestigador(inv3);
        
       for(int i=0; i<3 ;i++) {
           Subsidio sub1 = new Subsidio(GeneradorAleatorio.generarDouble(1000),GeneradorAleatorio.generarString(10));
           Subsidio sub2 = new Subsidio(GeneradorAleatorio.generarDouble(1500),GeneradorAleatorio.generarString(5));
           proyecto.getInvestigadores()[i].agregarSubsidio(sub1);
           proyecto.getInvestigadores()[i].agregarSubsidio(sub2);
       }
       System.out.println(proyecto.toString());
       proyecto.otorgarTodos("Maxi");
       System.out.println(proyecto.toString());
    }
    
}
