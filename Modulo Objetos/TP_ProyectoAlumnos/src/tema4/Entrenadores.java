/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 Los entrenadores son empleados que se caracterizan por la cantidad de campeonatos
ganados.
* 
* B- Cualquier empleado debe responder al mensaje calcularEfectividad. La efectividad
del entrenador es el promedio de campeonatos ganados por año de antigüedad, mientras
que la del jugador es el promedio de goles por partido.
* 
C- Cualquier empleado debe responder al mensaje calcularSueldoACobrar. El sueldo a
cobrar es el sueldo básico más un 10% del básico por cada año de antigüedad y además:
* 
 Para los entrenadores: se adiciona un plus por campeonatos ganados (5000$ si ha
ganado entre 1 y 4 campeonatos; $30.000 si ha ganado entre 5 y 10 campeonatos;
50.000$ si ha ganado más de 10 campeonatos).
 */
public class Entrenadores extends Empleado {
    private int cantCampeonatosGanados;
    public Entrenadores(int cantCampeonatosG, String unNombre, double unSueldo, int unaAntiguedad) {
        super(unNombre,unSueldo,unaAntiguedad);
        setCantCampeonatosGanados(cantCampeonatosG);
    }

    public int getCantCampeonatosGanados() {
        return cantCampeonatosGanados;
    }

    public void setCantCampeonatosGanados(int cantCampeonatosGanados) {
        this.cantCampeonatosGanados = cantCampeonatosGanados;
    }
    
    @Override
    public double calcularEfectividad() {
        double aux = (double) this.getCantCampeonatosGanados()/this.getAntiguedad();
        return aux;
    }
    
    @Override
    public double calcularSueldoACobrar() {
        double aux = (double) this.getSueldo() + (this.getSueldo() * 0.10 * this.getAntiguedad());
        if(this.getCantCampeonatosGanados() > 1 && this.getCantCampeonatosGanados() < 4 ) {
            aux += 5000;
        }
        else 
            if(this.getCantCampeonatosGanados() > 5 && this.getCantCampeonatosGanados() < 10){
                aux += 30000;
            }
            else 
                aux += 5000;  
    return aux;
    }
}
