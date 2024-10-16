/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_12;

/**
 *
 * @author lucia
 */
public class Concurso {
    private int cantCategorias;
    private int cantMaximaCanciones;
    private int[] cantCancionesXcate;
    private Cancion[][] concurso;
    public Concurso(int cantCate, int cantCanciones) {
        this.cantCategorias = cantCate;
        this.cantMaximaCanciones = cantCanciones;
        this.cantCancionesXcate = new int[cantCate];
        this.concurso = new Cancion[cantCate][cantCanciones];
        for(int i=0; i<this.cantCategorias ;i++) 
            this.cantCancionesXcate[i] = 0;
    }
    
    
    public void agregarCancion(Cancion unaCancion, int unaCategoria) {
        this.concurso[unaCategoria][this.cantCancionesXcate[unaCategoria]] = unaCancion;
        this.cantCancionesXcate[unaCategoria]++;
    }
    
    public void interpretarCancion(int unIdentificador, Estudiante unEstudiante, double unPuntaje) {
        boolean encontrado = false;
        int j,i=0;
        while(i<this.cantCategorias && !encontrado) {
            j=0;
            while(j<this.cantCancionesXcate[i] && !encontrado) {
                if(this.concurso[i][j].getIndentificador() == unIdentificador) {
                    encontrado = true;
                    if(this.concurso[i][j].getPuntaje() < unPuntaje) {
                        this.concurso[i][j].setGanador(unEstudiante);
                        this.concurso[i][j].setPuntaje(unPuntaje);
                    }
                } 
                j++;
            }
            i++;
        }
    }
    
    public Estudiante retornarGanador(int unIdentificador) {
        Estudiante aux = null;
        boolean encontrado = false;
        int j,i=0;
        while(i<this.cantCategorias && !encontrado) {
            j=0;
            while(j<this.cantCancionesXcate[i] && !encontrado) {
                if(this.concurso[i][j].getIndentificador() == unIdentificador) {
                    encontrado = true;
                    aux = this.concurso[i][j].getGanador();
                }
                else
                    j++;
            }
            i++;
        }
        return aux;
    }
    
    private boolean verificarPos(int unaCategoria) {
        return this.cantCancionesXcate[unaCategoria] > 0;
    }    
        
    public Cancion mayorPuntaje(int unaCategoria) {
        Cancion maxCancion = null;
        double maxPuntaje = -1;
        if(this.verificarPos(unaCategoria)) { //conpruebo que haya espacio en el vector
            for(int i=0; i<this.cantCancionesXcate[unaCategoria] ;i++) {
                if(this.concurso[unaCategoria][i].getPuntaje() > maxPuntaje) {
                    maxPuntaje = this.concurso[unaCategoria][i].getPuntaje();
                    maxCancion = this.concurso[unaCategoria][i];
                }
            }
        }
        return maxCancion;
    }
    
}
