/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 Los jugadores son empleados que se caracterizan por el número de partidos jugados y
el número de goles anotados.
* 
B- Cualquier empleado debe responder al mensaje calcularEfectividad. La efectividad
del entrenador es el promedio de campeonatos ganados por año de antigüedad, mientras
que la del jugador es el promedio de goles por partido.
* 
C- Cualquier empleado debe responder al mensaje calcularSueldoACobrar. El sueldo a
cobrar es el sueldo básico más un 10% del básico por cada año de antigüedad y además:

 Para los jugadores: si el promedio de goles por partido es superior a 0,5 se adiciona un
plus de otro sueldo básico.


*/
public class Jugador extends Empleado {
    private int numPartidosJugados;
    private int numGolesAnotados;
    public Jugador(int cantPartidosJ, int cantGolesA, String unNombre, double unSueldo, int unaAntiguedad) {
        super(unNombre,unSueldo,unaAntiguedad);
        setNumGolesAnotados(cantGolesA);
        setNumPartidosJugados(cantPartidosJ);
    }

    public int getNumPartidosJugados() {
        return numPartidosJugados;
    }

    public void setNumPartidosJugados(int numPartidosJugados) {
        this.numPartidosJugados = numPartidosJugados;
    }

    public int getNumGolesAnotados() {
        return numGolesAnotados;
    }

    public void setNumGolesAnotados(int numGolesAnotados) {
        this.numGolesAnotados = numGolesAnotados;
    }
    
    @Override
    public double calcularEfectividad() {
        double aux = (double) this.getNumGolesAnotados()/this.getNumPartidosJugados();
        return aux;
    }
    
    @Override
    public double calcularSueldoACobrar() {
        double aux =  super.calcularSueldoACobrar();
        if(this.calcularEfectividad() > 0.5) 
            aux += this.getSueldo();
        return aux;
    }
    
}
