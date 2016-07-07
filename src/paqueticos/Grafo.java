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
public class Grafo {
    //Atributos
    private NodoGrafo Inicio;
    private NodoGrafo Fin;
    
    //Metodo Constructor
    public Grafo(){
        Inicio=Fin=null;
    }
    
    //Agregar una nueva arista al grafo
    public void AgregarJuego(Juego nuevo){
        NodoGrafo nuevoJuego=new NodoGrafo(nuevo, null);
                
        if(Inicio==Fin&&Fin==null){//Agrega el primer elemento
            Inicio=Fin=nuevoJuego;//Se inicializa el contenido del primer elemento
            Inicio.setSiguiente(nuevoJuego);//Se coloca la referencia del siguiente elemento del inicio al final            
        }
        
        else{//Cuando la lista solo tiene 1 elemento
            Fin.setSiguiente(nuevoJuego);//El nuevo nodo se conecta al antiguo final
            Fin=nuevoJuego;//Se cambia el final por el nuevo nodo
        }
    }

    //Buscar una arista por su nombre
    public NodoGrafo BuscarNombre(String dato){
     //Creamos auxiliar apuntando al primer nodo de la lista
        NodoGrafo aux=Inicio;
        // inicializamos una variable tipo nodo para retornar
        NodoGrafo retorno = null;
        while(aux!=null){           
            if(aux.getDato().getNombre().equals(dato)){//comparamos el nombre obtenido con el nombre del nodo
                retorno = aux;
                aux=aux.getSiguiente();
            }else{
                aux=aux.getSiguiente();
            }
        }
        return retorno;
    }

    //Metodo para obtener el numero de aristas del grafo
    public int NumAristas(){
        int cont=0;
        NodoGrafo aux=Inicio;
        
        //Ciclo para contar los elementos de la lista
        do {
            cont++;
            aux=aux.getSiguiente();
        }while(aux!=null);
        
        return cont;
    }
    
    //Metodo para obtener el juego de un lugar especifico de la lista
    public NodoGrafo ObtenerJuego(int posicion){
        NodoGrafo aux=Inicio;
        
        //Si el numero solicitado es mayor al tamanio de la lista
        if (posicion>NumAristas()){
            System.out.println("Numero incorrecto");
            return null;
        }
        
        //Ciclo for para obtener el juego deseado
        for (int i=0; i<posicion; i++){
            aux=aux.getSiguiente();
        }
        
        return aux;        
    }
    
    //Metodo que obtiene el valor mas economico de un juego adyacente
    private double precioMenor(NodoGrafo aux, double menor){
        if(aux!=null){
            if(aux.getDato().getPrecio()<menor){
                menor=aux.getDato().getPrecio();
            }
            
            precioMenor(aux.getSiguiente(), menor);
        }
        return menor;
    }
    
    private double precioMenor(){
        return precioMenor(Inicio, 0);
    }
    
    
    
    //Imprimir lista
    public void ImprimirLista(){
        //La lista esta vacia
        if (Inicio==Fin&&Inicio==null){
            System.out.println("No existen aristas en el grafo");
        }
        
        NodoGrafo aux=Inicio;//Inicializar el contador
        
        //Imprimir los elementos de la lista con un indice para posteriormente escogerlo
        for(int i=0; i<NumAristas(); i++){
            System.out.println((i+1) + ". " + aux.getDato().getNombre());
            System.out.println("Precio " + aux.getDato().getPrecio());
            System.out.println("Diversion : " + aux.getDato().getIndiceDiversion());
            aux=aux.getSiguiente();            
        }        
        
    }
    
    //Metodo del recorrido mas Optimo
    private Lista mejorRecorrido(NodoGrafo Camino, double dinero, Lista nueva, Lista aComparar, double sobrante, NodoGrafo Begining){
        if (Begining!=null){
            if (Camino!=null){
                if (sobrante<Camino.Adyacentes.precioMenor()){//Reviso si aun tengo dinero para la proxima atraccion
                    if(nueva.indiceDiversion()>aComparar.indiceDiversion()){//Comparo la lista guarda como "optima" y la comparo con la nueva
                        aComparar=nueva;
                    }                    
                }
                
                //Codigo para coger el juego siguiente
                Camino.Adyacentes.DesencolarPriori();
                nueva.AgregarNodo(Camino);//Se agrega el Juego a la lista nueva
                sobrante=sobrante-Camino.getDato().getPrecio();//Se resta el dinero del juego
                mejorRecorrido(Camino.Adyacentes.DesencolarPriori(), dinero, nueva, aComparar, sobrante, Begining);//Paso al siguiente juego de los adyacentes
                
            }        
            
            mejorRecorrido(Begining.getSiguiente().Adyacentes.Inicio, dinero, new Lista(), aComparar, dinero, Begining.getSiguiente());//Paso al siguiente juego del grafo
        }
        
        return aComparar;
        
    }
    
    public Lista mejorRecorrido(double dinero){
        return mejorRecorrido(Inicio.Adyacentes.Inicio, dinero, new Lista(), new Lista(), dinero, Inicio);
    }
    
    //Encontrar el nodo mas conveniente
    public NodoGrafo DesencolarPriori(){
        NodoGrafo aux=Inicio;
        do{
            if (aux.getDato().getIndiceDiversion()>=getMaxFun())//Condicion para encontrar el juego mas divertido disponible
                return new NodoGrafo(aux.getDato());//Regresa el primer nodo que encuentre con diversion mayor o igual al maximo
            aux=aux.getSiguiente();//Pasa al siguiente nodo de la cola
        }while(aux!=null);//Cerrar el ciclo do-while
        return null;//Solo llega a esta sentencia si algo sale mal
    }
    
    //Metodo para encontrar el indice de diversion maximo
    public int getMaxFun(){
        NodoGrafo aux=Inicio;
        int cont=0;
        while(aux!=null){
            if (cont<aux.getDato().getIndiceDiversion())
                cont=aux.getDato().getIndiceDiversion();
            aux=aux.getSiguiente();
        }
        return cont;
    }
    
}
