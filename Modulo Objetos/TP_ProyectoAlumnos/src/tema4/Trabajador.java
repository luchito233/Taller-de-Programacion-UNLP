/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author lucia
 */
public class Trabajador extends Persona {
    private String trabajo;
    public Trabajador(String unNombre, int unDni, int unaEdad, String unTrabajo) {
        super(unNombre,unDni,unaEdad);
        trabajo = unTrabajo;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }
    
    @Override
    public String toString() {
        String aux = super.toString() +
                     " trabajo de: " + this.trabajo;
        return aux;
    }
}
