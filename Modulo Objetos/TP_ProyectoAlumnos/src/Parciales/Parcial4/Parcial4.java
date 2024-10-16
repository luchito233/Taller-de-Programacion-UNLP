/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial4;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Parcial4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Concurso concurso = new Concurso(5);
        for(int i=0; i<2 ;i++) {
            Participante participante1 = new Participante(GeneradorAleatorio.generarInt(100),GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarInt(100));
            Participante participante2 = new Participante(GeneradorAleatorio.generarInt(100),GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarInt(100));
            Pareja pareja = new Pareja(participante1,participante2,GeneradorAleatorio.generarString(10));
            concurso.agregarPareja(pareja);
        }
        
        for(int i=0; i<2 ;i++) {
            System.out.println(concurso.retornarPos(i).toString());
        }
        
        concurso.mayorDiferencia();       
        
    }
    
}
