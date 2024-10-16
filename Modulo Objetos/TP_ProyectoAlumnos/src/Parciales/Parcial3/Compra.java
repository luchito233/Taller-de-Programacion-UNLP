/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial3;

/**
  1- Queremos representar compras minoristas y mayoristas. De cualquier compra se conoce: nro. y los productos
 comprados (como máximo N). De cada producto registra: código, precio y descripción. Además: las compras
 mayoristas tienen el CUIT del comprador; y las minoristas si el comprador es jubilado.
 a- Genere las clases necesarias. Provea constructores para iniciar las compras a partir de toda su información,
 para una cantidad máxima de N productos comprados y sin productos cargados.
 b- Implemente métodos en las clases que corresponda para permitir:
 i- Agregar a la compra un producto que se recibe. Asuma que hay espacio.
 ii- Obtener el precio a pagar por la compra teniendo en cuenta que es la suma del precio de los productos
 comprados al que se adiciona el IVA (21% del total).
 iii- Obtener la representación String de la compra siguiendo el ejemplo:
 Compra minorista: “Nro:… , Productos (código/precio/descripción):…, Precio a pagar:… , Es jubilado: …”
 Compra mayorista: “Nro:…, Productos (código/precio/descripción):…, Precio a pagar:…, CUIT:…”
 2) Realice un programa que instancie una compra mayorista y una minorista. Cargue 3 productos a cada compra.
 Para finalizar, muestre la representación String de cada compra
 */
public abstract class Compra {
    private int numero;
    private int df;
    private int dl;
    private Producto[] productos;
    public Compra(int unNumero, int cantMaxima) {
        this.numero = unNumero;
        this.df = cantMaxima;
        productos = new Producto[cantMaxima];
        this.dl = 0;
    }
    
    public boolean sePuede() {
        return this.dl < this.df;
    }
    
    public void agregarProducto(Producto unProducto) {
        if(sePuede()) {
            this.productos[dl] = unProducto;
            dl++;
        }
    }
    
    public double precioApagar() {
        double total = 0.0;
        double iva = 0.0;
        for(int i=0; i<this.dl ;i++) {
            total += this.productos[i].getPrecio();
        }
        iva = total * 0.21;
        return total + iva;
    }
    
    public String informarVentas() {
        String aux = "";
        for(int i=0; i<this.dl ;i++) {
            aux += "Producto " + i + ": " + this.productos[i].toString() + "\n";
        }
        return aux;
    }
    
    public String toString() {
        return "Numero de la compra: " + this.numero + ", Productos: \n" + informarVentas() + "Precio a pagar: " + this.precioApagar();
        
    }
    
}
