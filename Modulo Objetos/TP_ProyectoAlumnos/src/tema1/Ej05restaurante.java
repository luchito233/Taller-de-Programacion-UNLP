/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

/**
 *
 * @author lucia
 */

/* 5- El dueño de un restaurante entrevista a cinco clientes y les pide que califiquen
(con puntaje de 1 a 10) los siguientes aspectos: (0) Atención al cliente (1) Calidad
de la comida (2) Precio (3) Ambiente.

Escriba un programa que lea desde teclado las calificaciones de los cinco clientes
para cada uno de los aspectos y almacene la información en una estructura. Luego
imprima la calificación promedio obtenida por cada aspecto. */
import PaqueteLectura.Lector;
public class Ej05restaurante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int matriz[][] = new int[5][4];
        int i,j;
        for(i = 0; i < 5 ;i++) {
            System.out.println("cliente " + i);
            for(j = 0; j < 4;j++) {
                System.out.println("ingrese una calificacion para: " + j + " del (1 al 10): ");
                matriz[i][j] = Lector.leerInt();
            }    
        } 
      
        for(i = 0; i < 5 ;i++) {
             System.out.println("cliente " + i);
            int cantTotal = 0;
            for(j = 0; j < 4;j++) {   
                System.out.println("puntuacion " + j + " = " + matriz[i][j]);
                cantTotal = cantTotal + matriz[i][j];        
            }
            System.out.println("promedio de la persona " + i + " = " + (double) cantTotal/5);
        }
        
    }
    
    
}
