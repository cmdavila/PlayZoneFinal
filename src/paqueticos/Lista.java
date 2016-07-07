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
public class Lista {
    //Atributos 
    private NodoLista Inicio;
    private NodoLista Final;

    //Constructor
    public Lista() {
        Inicio=Final;
    }
    
    public void AgregarNodo(NodoGrafo Juego){
        NodoLista nuevo=new NodoLista(Juego.getDato());
        
        if(Inicio==Final&&Final==null){//Agrega el primer elemento
            Inicio=Final=nuevo;//Se inicializa el contenido del primer elemento
            Inicio.setSiguiente(nuevo);//Se coloca la referencia del siguiente elemento del inicio al final            
        }
        
        else{//Cuando la lista solo tiene 1 elemento
            Final.setSiguiente(nuevo);//El nuevo nodo se conecta al antiguo final
            Final=nuevo;//Se cambia el final por el nuevo nodo
        }
    }
    
    //Metodos Get y Set
    public NodoLista getInicio() {
        return Inicio;
    }

    public void setInicio(NodoLista Inicio) {
        this.Inicio = Inicio;
    }

    public NodoLista getFinal() {
        return Final;
    }

    public void setFinal(NodoLista Final) {
        this.Final = Final;
    }
    
    //Metodo para obtener el indice total de diversion
    private int indiceDiversion(NodoLista actual, int sumatoria){
        if(actual!=null){
            sumatoria=sumatoria+actual.getJuego().getIndiceDiversion();
            indiceDiversion(actual.getSiguiente(), sumatoria);
        }
        return sumatoria;        
    }
    
    public int indiceDiversion(){
        return indiceDiversion(Inicio, 0);
    }
    

    
    
}
