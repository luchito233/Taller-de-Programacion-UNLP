/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial_14;

/**
 *
 * @author lucia
 */
public class Empresa{
    private String nombre;
    private String direccion;
    private Director DirEjecutivo;
    private int cantEncargados;
    private Encargado[] sucursal;
    public Empresa(String unNombre, String unaDireccion, Director unDirectorEje, int cantMaxDeEncargados) {
        this.nombre = unNombre;
        this.direccion = unaDireccion;
        this.DirEjecutivo = unDirectorEje;
        this.cantEncargados = cantMaxDeEncargados;
        this.sucursal = new Encargado[cantMaxDeEncargados];
        this.inicializarSucursal();
    }
    
    private void inicializarSucursal() {
        for(int i=0; i<this.cantEncargados ;i++)
            this.sucursal[i] = null;
    }
    
    public void agregarEncargado(int sucursalX, Encargado unEncargado) {
        this.sucursal[sucursalX-1] = unEncargado;
    }
    
    @Override
    public String toString() {
        String aux = "Nombre de la Empresa: " + this.nombre + ", direccion: " + this.direccion + "\n" + this.DirEjecutivo.toString() + "\n";
        for(int i=0; i<this.cantEncargados ;i++) {
            if(this.sucursal[i] == null) 
                aux += "Sucursal " + (i+1) + ": sin Encargdo" + "\n";
            else
                aux += "Sucursal " + (i+1) + ": " + this.sucursal[i].toString() + "\n";
        }
        return aux;
    }    
}
