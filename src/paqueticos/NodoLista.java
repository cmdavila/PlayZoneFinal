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
public class NodoLista {
    //Atributos clase NodoLista
    private Juego juego;
    private NodoLista siguiente;

    //Metodo constructor
    public NodoLista(Juego juego) {
        this.juego = juego;
        siguiente=null;
    }

    //Metodos get y set
    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public NodoLista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    
}
