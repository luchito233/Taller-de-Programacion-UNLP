/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial4;

/**
 *
 * @author lucia
 */
public class Pareja {
    private Participante pareja1;
    private Participante pareja2;
    private String estiloBaile;
    public Pareja(Participante unaPareja1, Participante unaPareja2, String unEstilo) {
        this.pareja1 = unaPareja1;
        this.pareja2 = unaPareja2;
        this.estiloBaile = unEstilo;
    }

    public Participante getPareja1() {
        return pareja1;
    }

    public Participante getPareja2() {
        return pareja2;
    }

    @Override
    public String toString() {
        return "Pareja{" + "pareja1= \n" + this.pareja1.toString() + ", pareja2= \n" + this.pareja2.toString() + ", estiloBaile=" + this.estiloBaile + '}';
    }
    
    
    
}
