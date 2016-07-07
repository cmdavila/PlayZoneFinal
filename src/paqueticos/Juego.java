/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueticos;

/**
 *
 * @author Carlitox
 */
public class Juego {
    //Atributos 
    private String Nombre;
    private double Precio;
    private int indiceDiversion;

    public Juego() {
    }

    
    //Metodo constructor
    public Juego(String Nombre, double Precio, int indiceDiversion) {
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.indiceDiversion = indiceDiversion;
    }

    //Metodos get y set
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getIndiceDiversion() {
        return indiceDiversion;
    }

    public void setIndiceDiversion(int indiceDiversion) {
        this.indiceDiversion = indiceDiversion;
    }
    
    
    
    
}
