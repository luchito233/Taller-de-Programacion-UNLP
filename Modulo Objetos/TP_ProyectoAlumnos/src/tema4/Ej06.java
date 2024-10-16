/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/*
f) Realice un programa principal que cree un Sistema con reporte anual para 3 años
consecutivos a partir del 2021, para la estación La Plata (latitud -34.921 y longitud -
57.955). Cargue todas las temperaturas (para todos los meses y años). Informe los
promedios anuales, y el mes y año en que se registró la mayor temperatura.
Luego cree un Sistema con informe mensual para 4 años a partir de 2020, para la
estación Mar del Plata (latitud -38.002 y longitud -57.556). Cargue todas las
temperaturas (para todos los meses y años). Informe los promedios mensuales, y el
mes y año en que se registró la mayor temperatura.
NOTA: Preste atención de no violar el encapsulamiento al resolver el ejercicio.
 */
public class Ej06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estacion estacion = new Estacion("La Plata",-34.921,-57.955);
        Estacion estacion2 = new Estacion("Mar del Plata",-38.002,-57.556);
        
        SistemaAnual sistemaA = new SistemaAnual(estacion,2021,3);
        SistemaMensual sistemaM = new SistemaMensual(estacion2,2020,4);
        
        sistemaA.setTemperaturas(2021, 4, 440.1);
        sistemaM.setTemperaturas(2022, 11, 418.423);
        
        System.out.println(sistemaA.toString());
        System.out.println(sistemaM.toString());
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////");
        System.out.println(sistemaA.mayorTemperatura());
        System.out.println(sistemaM.mayorTemperatura());
        
    }
    
}
