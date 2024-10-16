/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

//Paso 1. importar la funcionalidad para generar datos aleatorios
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
public class Ej03Matrices {

    public static void main(String[] args) {
	//Paso 2. iniciar el generador aleatorio     
	GeneradorAleatorio.iniciar();
        //Paso 3. definir la matriz de enteros de 5x5 e iniciarla con nros. aleatorios 
        int[][] matriz = new int[5][5];
        int i,j;
        for(i=0; i < 5;i++){
            for(j=0; j < 5;j++)
                matriz[i][j] = GeneradorAleatorio.generarInt(31);
        }
        //Paso 4. mostrar el contenido de la matriz en consola
         for(i=0; i < 5;i++){
            System.out.println("-");
            for(j=0; j < 5;j++)
                System.out.print(matriz[i][j] + "|");
         }
            
        //Paso 5. calcular e informar la suma de los elementos de la fila 1
        int sumaFila1 = 0;
        for(i=0; i<5 ;i++) 
            sumaFila1 = sumaFila1 + matriz[0][i];
        System.out.println("suma total de la fila 1 = " + sumaFila1);
        //Paso 6. generar un vector de 5 posiciones donde cada posición j contiene la suma de los elementos de la columna j de la matriz. 
        //        Luego, imprima el vector.
        int[] vector = new int[5];
        for(i=0; i < 5;i++){
            System.out.println("-");
            for(j=0; j < 5;j++)
                vector[j] = vector[j] + matriz[i][j];
         }
        for(i=0; i < 5 ;i++)
            System.out.println("pos: " + i + " " + vector[i]);
        //Paso 7. lea un valor entero e indique si se encuentra o no en la matriz. En caso de encontrarse indique su ubicación (fila y columna)
        //   y en caso contrario imprima "No se encontró el elemento".
        int num = Lector.leerInt();
        i = 0;
        int fila = 0,columna = 0;
        boolean esta = false;
        while(i < 5 && !esta)  {
            j = 0;
            while(j < 5 && !esta) {
                if(num == matriz[i][j]) {
                    esta = true;
                    fila = i;
                    columna = j;
                }
                    
                j++;
            }
            i++;
        }
        if(esta)
            System.out.println("columna: " + columna + " fila: " + fila);
        else
            System.out.println("no se encontro le elemento");
        
    }
}
