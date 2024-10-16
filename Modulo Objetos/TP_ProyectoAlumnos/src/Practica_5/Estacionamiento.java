/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica_5;

/*

2- Queremos un sistema para gestionar estacionamientos. Un estacionamiento conoce su
nombre, dirección, hora de apertura, hora de cierre, y almacena para cada número de piso
(1..N) y número de plaza (1..M), el auto que ocupa dicho lugar. De los autos se conoce
nombre del dueño y patente.
 
*/
public class Estacionamiento {
    private String nombre;
    private String direccion;
    private String hsApertura;
    private String hsCierre;
    private int cantPisos;
    private int cantPlazas;
    
    private Auto[][] parking;
    
    public Estacionamiento(String unNombre, String unaDireccion) {
        nombre = unNombre;
        direccion = unaDireccion;
        hsApertura = "8:00";
        hsCierre = "21:00";
        cantPisos = 5;
        cantPlazas = 10;
        parking = new Auto[5][10];
        inicializarParking(5,10);
    }
    
    public Estacionamiento(String unNombre, String unaDireccion, String unaHoraA, String unaHoraC, int N, int M) {
        nombre = unNombre;
        direccion = unaDireccion;
        hsApertura = unaHoraA;
        hsCierre = unaHoraC;
        cantPisos = N;
        cantPlazas = M;
        parking = new Auto[N][M];
        inicializarParking(N,M);
    }
    
    public void inicializarParking(int N, int M) {
        for(int i=0; i<N ;i++) {
            for(int j=0; j<M ;j++) {
                this.parking[i][j] = new Auto();
            }
        }
    }
    
    public void agregarAuto(Auto unAuto, int pisoX, int plazaY) {
        this.parking[pisoX][plazaY] = unAuto;  
    }
    
    public String buscar(int unaPatente) {
        int i = 0;
        int j = 0;
        while(i < this.cantPisos) {
            System.out.println("i "+i);
            j = 0;
            while(j < this.cantPlazas) {
                if(this.parking[i][j].getPatente() == unaPatente)
                    return "Piso: " + (i+1) + ", Plaza: " + (j+1);
                System.out.println("j "+j);
                j++;
            }
            i++;
        }
        return "Auto Inexistente";
    }
    
    @Override
    public String toString() {
        String aux = "";
        for(int i=0; i<this.cantPisos ;i++) {
            aux += "\n Piso: " + (i+1) + ", ";
            for(int j=0; j<this.cantPlazas ;j++) {
                aux += "\n Plaza: " + (j+1) + ", ";
                if(!this.parking[i][j].getNombre().equals("Ninguna"))
                    aux += this.parking[i][j].toString();
                else
                    aux += "libre ";
            }
        }        
        return aux;
    }
    
    public int contarPlazas(int unaPlaza) {
        int aux = 0;
        for(int i=0; i<this.cantPisos ;i++) {
            if(!this.parking[i][unaPlaza-1].getNombre().equals("Ninguna")) {
                aux++;
                System.out.println("hola");
            }
                
        }
        return aux;
    }
    
}
