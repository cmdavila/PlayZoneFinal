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
public class ColaPriori {
    //Atributos
    NodoCola Primero;
    NodoCola Ultimo;
    
    //Constructor
    public ColaPriori(){
        Ultimo=Primero=null;
    }
    
    public void Encolar(NodoGrafo nuevo){
        
        NodoCola juegoPriori=new NodoCola(nuevo);
        
        if (Primero==Ultimo && Primero==null){//Ningun Elementos
            Primero=Ultimo=juegoPriori;
        }
        else if(Primero==Ultimo && Primero!=null){//Un solo elemento
            Primero.setSiguiente(juegoPriori);
            Ultimo=juegoPriori;
        }
        else{//2 o mas elementos
            Ultimo.setSiguiente(juegoPriori);
            Ultimo=juegoPriori;
        }
    }
    
    public NodoGrafo DesencolarPriori(){
        NodoCola aux=Primero;
        while(aux!=null){
            if (aux.getDatos().getIndiceDiversion()>=getMaxFun())
                return new NodoGrafo(aux.getDatos());
            aux=aux.getSiguiente();
        }
    }
    
    public int getMaxFun(){
        NodoCola aux=Primero;
        int cont=0;
        while(aux!=null){
            if (cont<aux.getDatos().getIndiceDiversion())
                cont=aux.getDatos().getIndiceDiversion();
            aux=aux.getSiguiente();
        }
        return cont;
    }
    
    public double getEconomico(){
        NodoCola aux=Primero;
        double cont=aux.getDatos().getPrecio();
        while(aux!=null){
            if(cont>aux.getDatos().getPrecio())
                cont=aux.getDatos().getPrecio();
            aux=aux.getSiguiente();
        }
        return cont;
    }
    
}
