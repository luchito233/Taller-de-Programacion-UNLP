/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_19;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author lucia
 */
public class Parcial19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        ProgramadorLider programadorL = new ProgramadorLider(GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarInt(100),
                                                             GeneradorAleatorio.generarDouble(20000),GeneradorAleatorio.generarInt(400),
                                                             GeneradorAleatorio.generarString(14),GeneradorAleatorio.generarInt(50),GeneradorAleatorio.generarInt(30));
        Empresa empresa = new Empresa("Factory",programadorL,12);
        for(int i=0; i<9 ;i++) {
            Programador unProgramador = new Programador(GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarInt(100),
                                                        GeneradorAleatorio.generarDouble(20000),GeneradorAleatorio.generarInt(400),
                                                        GeneradorAleatorio.generarString(14));
            empresa.agregarProgramador(unProgramador);
        }
        
        System.out.println(empresa.toString());
        
        empresa.aumentarSueldoBasico(4000.0);
        
        System.out.println(empresa.toString());
        
    }
    
}
