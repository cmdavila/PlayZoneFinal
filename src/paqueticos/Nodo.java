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
public class Nodo {
    //Atributos de nodo con doble referencia
    //Agregar distancia entre los juegos no se si aun es en esta clase o en juego o en lista
    private Nodo Siguiente;
    private Juego Dato;
    private Nodo Anterior;
    public Lista Adyacentes; //Lista de juegos cercanos o a los que se puede ir
    
    //Metodo constructor
    public Nodo(Juego Dato, Nodo Anterior, Nodo Siguiente) {
        this.Dato = Dato;//
        this.Siguiente=Siguiente;
        this.Anterior=Anterior;
        Adyacentes=new Lista();//Se inicializa la lista de juegos cercanos
    }

    public Nodo(Nodo Siguiente, Juego Dato) {
        this.Siguiente = Siguiente;
        this.Dato = Dato;
    }

    public Nodo(Juego Dato) {
        this.Dato = Dato;
    }
    
    

    //Metodos get y set
    public Nodo getSiguiente() {
        return Siguiente;
    }

    public Juego getDato() {
        return Dato;
    }

    public Nodo getAnterior() {
        return Anterior;
    }

    public Lista getAdyacentes() {
        return Adyacentes;
    }

    public void setSiguiente(Nodo Siguiente) {
        this.Siguiente = Siguiente;
    }

    public void setAnterior(Nodo Anterior) {
        this.Anterior = Anterior;
    }

    public void setDato(Juego Dato) {
        this.Dato = Dato;
    }

    public void setAdyacentes(Lista Adyacentes) {
        this.Adyacentes = Adyacentes;
    }
 
}
