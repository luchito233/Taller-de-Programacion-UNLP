/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/*
3-A- Implemente las clases para el siguiente problema. Una garita de seguridad quiere
identificar los distintos tipos de personas que entran a un barrio cerrado. Al barrio pueden
entrar: personas, que se caracterizan por nombre, DNI y edad; y trabajadores, estos son
personas que se caracterizan además por la tarea realizada en el predio.

Implemente constructores, getters y setters para las clases. Además tanto las personas
como los trabajadores deben responder al mensaje toString siguiendo el formato:

 Personas “Mi nombre es Mauro, mi DNI es 11203737 y tengo 70 años”

 Trabajadores “Mi nombre es Mauro, mi DNI es 11203737 y tengo 70 años. Soy jardinero.”

B- Realice un programa que instancie una persona y un trabajador y muestre la
representación de cada uno en consola. 

*/
public class Persona {
    private String nombre;
    private int dni;
    private int edad;
    public Persona(String unNombre, int unDni, int unaEdad) {
        nombre = unNombre;
        dni = unDni;
        edad = unaEdad;        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    @Override
    public String toString() {
        String aux = "mi nombre es: " + this.nombre +
                     " mi dni es: " + this.dni + 
                     " mi edad es: " + this.edad;
        return aux;
    }
    
    
}
