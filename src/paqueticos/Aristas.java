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
public class Aristas {
    //Atributos de nodo con doble referencia
    //Agregar distancia entre los juegos no se si aun es en esta clase o en juego o en lista
    private Aristas Siguiente;
    private Juego Dato;
    public Grafo Adyacentes; //Lista de juegos cercanos o a los que se puede ir
    
    //Metodo constructor
    public Aristas(Juego Dato, Aristas Siguiente) {
        this.Dato = Dato;//
        this.Siguiente=Siguiente;
        Adyacentes=new Grafo();//Se inicializa la lista de juegos cercanos
    }


    public Aristas(Juego Dato) {
        this.Dato = Dato;
        Siguiente=null;
    }
        

    //Metodos get y set
    public Aristas getSiguiente() {
        return Siguiente;
    }

    public Juego getDato() {
        return Dato;
    }

    public Grafo getAdyacentes() {
        return Adyacentes;
    }

    public void setSiguiente(Aristas Siguiente) {
        this.Siguiente = Siguiente;
    }

    public void setDato(Juego Dato) {
        this.Dato = Dato;
    }

}
