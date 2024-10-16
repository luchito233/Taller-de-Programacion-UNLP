
package tema1;

//Paso 1: Importar la funcionalidad para lectura de datos

import PaqueteLectura.Lector;
public class Ej02Jugadores {

  
    public static void main(String[] args) {
        //Paso 2: Declarar la variable vector de double 
        //Paso 3: Crear el vector para 15 double   
        double[]vector = new double[15];
        //Paso 4: Declarar indice y variables auxiliares a usar
        int dimF = 15;
        int i;
        int cantAlumnos = 0;
        double sumaTotal = 0;
        //Paso 6: Ingresar 15 numeros (altura), cargarlos en el vector, ir calculando la suma de alturas
        for(i=0; i < 15; i++) {
            System.out.println("ingrese un numero");
            vector[i] = Lector.leerInt();
            cantAlumnos++;
            sumaTotal = sumaTotal + vector[i];
        }
        //Paso 7: Calcular el promedio de alturas, informarlo
        double Promedio = (double) sumaTotal/cantAlumnos;
        System.out.println(Promedio);
        //Paso 8: Recorrer el vector calculando lo pedido (cant. alturas que están por encima del promedio)
        int mayorPromedio = 0; 
        for(i=0; i < 15; i++) {
            if(Promedio > vector[i])
                mayorPromedio++;
        }
        //Paso 9: Informar la cantidad.
        System.out.println(mayorPromedio);
    }
    
}
