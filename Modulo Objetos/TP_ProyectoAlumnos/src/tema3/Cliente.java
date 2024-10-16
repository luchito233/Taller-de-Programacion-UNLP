/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author Alumno
 */
public class Cliente {
     private String nombre;
     private int dni;
     private int edad;
     
     public Cliente(String unNombre, int unDni, int unaEdad) {
         nombre = unNombre;
         dni = unDni;
         edad = unaEdad;
     }

    @Override
    public String toString() {
        return " Cliente{" + "nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + '}';
    }
     
     
}