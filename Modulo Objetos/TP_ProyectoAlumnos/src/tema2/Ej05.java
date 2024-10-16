/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;
import PaqueteLectura.Lector;
/**
 *
 * @author lucia
 */

/* 5- Se dispone de la clase Partido (en la carpeta tema2). Un objeto partido representa un
encuentro entre dos equipos (local y visitante). Un objeto partido puede crearse sin
valores iniciales o enviando en el mensaje de creación el nombre del equipo local, el
nombre del visitante, la cantidad de goles del local y del visitante (en ese orden). Un objeto
partido sabe responder a los siguientes mensajes:


    getLocal() retorna el nombre (String) del equipo local
    getVisitante() retorna el nombre (String) del equipo visitante
    getGolesLocal() retorna la cantidad de goles (int) del equipo local
    getGolesVisitante() retorna la cantidad de goles (int) del equipo visitante
    setLocal(X) modifica el nombre del equipo local al “String” X
    setVisitante(X) modifica el nombre del equipo visitante al “String” X
    setGolesLocal(X) modifica la cantidad de goles del equipo local al “int” X
    setGolesVisitante(X) modifica la cantidad de goles del equipo visitante al “int” X
    hayGanador() retorna un boolean que indica si hubo (true) o no hubo (false) ganador
    getGanador() retorna el nombre (String) del ganador del partido (si no hubo retorna un String vacío).
    hayEmpate() retorna un boolean que indica si hubo (true) o no hubo (false) empate


Implemente un programa que cargue un vector con a lo sumo 20 partidos disputados en
el campeonato. La información de cada partido se lee desde teclado hasta ingresar uno con
nombre de visitante “ZZZ” o alcanzar los 20 partidos. Luego de la carga:
- Para cada partido, armar e informar una representación String del estilo:
{EQUIPO-LOCAL golesLocal VS EQUIPO-VISITANTE golesVisitante }
- Calcular e informar la cantidad de partidos que ganó River.
- Calcular e informar el total de goles que realizó Boca jugando de local. */

public class Ej05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Partido vPartidos[] = new Partido[20];
        int dl = 0;
        int cantRiver = 0;
        int cantGolesBoca = 0;
        System.out.println("ingrese un equipo visitante: ");
        String visitante = Lector.leerString();
        while(dl < 20 && !visitante.equals("ZZZ")) {
            System.out.println("ingrese un equipo local. ");
            String local = Lector.leerString();
            System.out.println("ingrese la cantidad de goles del Local: ");
            int golesLocal = Lector.leerInt();
            System.out.println("ingrese la cantidad de goles del Visitante: ");
            int golesVisitante = Lector.leerInt();
            vPartidos[dl] = new Partido(local,visitante,golesLocal,golesVisitante);
            dl++;
            System.out.println("ingrese un equipo visitante: ");
            visitante = Lector.leerString();
        }
        for(int i=0; i<dl ;i++) {
            System.out.println(vPartidos[i].getLocal() + " " + vPartidos[i].getGolesLocal() + " VS " + vPartidos[i].getVisitante() + " " + vPartidos[i].getGolesVisitante());
            if(vPartidos[i].getGanador().equals("River"))
                cantRiver++;
            if(vPartidos[i].getLocal().equals("Boca"))
                cantGolesBoca = cantGolesBoca + vPartidos[i].getGolesLocal();
        }
        System.out.println("la cantidad de veces que gano river en el campeonato es: " + cantRiver);
        System.out.println("--------------------------");
        System.out.println("la cantidad de goles que realizo Boca en Local es de: " + cantGolesBoca);
    }
    
}
