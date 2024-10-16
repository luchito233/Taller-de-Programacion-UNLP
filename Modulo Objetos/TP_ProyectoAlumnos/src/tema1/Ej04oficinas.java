/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;
import PaqueteLectura.Lector;
/**
 *
 * @author lucia
 */

/* 4- Un edificio de oficinas está conformado por 8 pisos (1..8) y 4 oficinas por piso
(1..4). Realice un programa que permita informar la cantidad de personas que
concurrieron a cada oficina de cada piso. Para esto, simule la llegada de personas al
edificio de la siguiente manera: a cada persona se le pide el nro. de piso y nro. de
oficina a la cual quiere concurrir. La llegada de personas finaliza al indicar un nro.
de piso 9. Al finalizar la llegada de personas, informe lo pedido. */

public class Ej04oficinas { 
    
    
    public static void main(String[] args) {
        String edificio[][] = new String[8][4];
        int i,j;
        for(i=0; i<8; i++)
            for(j=0; j<4 ;j++)
                edificio[i][j]= "0"; 
        System.out.println("ingrese el piso: ");
        int piso = Lector.leerInt();
        while(piso != 9) {
            System.out.println("ingrese la oficina: ");
            int oficina = Lector.leerInt();
            System.out.println("ingrese el nombre de la persona");
            String nombre = Lector.leerString();
            edificio[piso][oficina] = nombre;
            System.out.println("ingrese el piso: ");
            piso = Lector.leerInt();
        }
        for(i=0; i<8; i++) {
            System.out.println("|");
            for(j=0; j<4 ;j++) {
                System.out.print("nombre: " + edificio[i][j] + " | ");
            }
        }
        int cantTotal = 0;
        for(i=0; i<8; i++) 
            for(j=0; j<4 ;j++) {
                if(!"0".equals(edificio[i][j]))
                    cantTotal++;
            }
        System.out.println("cantidad de empleados en el edificio: " + cantTotal);
    }    
} 