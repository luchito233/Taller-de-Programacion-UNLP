/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_11;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Parcial11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sala sala = new Sala(5);
        for(int i=0; i<3 ;i++) {
            Pc pc = new Pc(GeneradorAleatorio.generarDouble(2000));
            sala.agregarPc(pc, i);
        }
        
        System.out.println(sala.toString());
        
        for(int j=0; j<2 ;j++)
            sala.prenderPcMinConsumo();
        
        System.out.println(sala.toString());
        
        System.out.println(sala.informarPrendidas());
        
    }
    
}
