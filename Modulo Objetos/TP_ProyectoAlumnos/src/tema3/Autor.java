/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author lucia
 */
public class Autor {
    private String nombre;
    private String biografia;
    private String origen;
    
    public Autor( String unNombre, String unaBiografia, String unOrigen) {
        nombre = unNombre;
        biografia = unaBiografia;
        origen = unOrigen;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    
    @Override
    public String toString() {
        return "nombre=" + nombre + ", biografia=" + biografia + ", origen=" + origen;
    }
    
    
    
}

