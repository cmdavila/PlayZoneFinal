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
class NodoCola {
    //Atributos
    private Juego datos;
    private NodoCola siguiente;
    
    //Constructor
    public NodoCola(NodoGrafo juego){
        datos=juego.getDato();
        siguiente=null;
    }
    
    //Metodos Get y Set
    public Juego getDatos() {
        return datos;
    }

    public void setDatos(Juego datos) {
        this.datos = datos;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }
    
}
