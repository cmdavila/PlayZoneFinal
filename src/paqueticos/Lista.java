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
    private Nodo Inicio;
    private Nodo Fin;
    
    //Metodo Constructor
    public Lista(){
        Inicio=Fin=null;
    }
    
public void AgregarJuego(Juego nuevo){
        Nodo nuevoPremio=new Nodo(nuevo, null, null);
                
        if(Inicio==Fin&&Fin==null){//Agrega el primer elemento
            Inicio=nuevoPremio;//Se inicializa el contenido del primer elemento
            Fin=nuevoPremio;//Se inicializa el contenido del ultimo elemento, al ser el primer elemento, los datos son iguales
            Inicio.setSiguiente(Fin);//Se coloca la referencia del siguiente elemento del inicio al final
            Inicio.setAnterior(null);//Se coloca la referencia del anterior elemento del inicio al final
            Fin.setAnterior(Inicio);//Se coloca la referencia del anterior elemento del final al inicio
            Fin.setSiguiente(null);//Se coloca la referencia del siguiente elemento del final al inicio
            
            
                     
        }
        else if(Inicio==Fin&&Fin!=null){//Cuando la lista solo tiene 1 elemento
            Fin=nuevoPremio;//Se cambia el contenido del "ultimo" nodo de la lista por el nuevo
            Fin.setAnterior(Inicio);//Referencia anterior del nuevo final se cambian al Inicio
            Fin.setSiguiente(null);//Referencia siguiente del nuevo final se cambia a Inicio por ser unicamente 2 elementos
            Inicio.setSiguiente(Fin);
        }
        else{//Cuando la lista tiene mas de de dos elementos
            Fin.setSiguiente(nuevoPremio);//Se cambia la referencia siguiente del antiguo final por el del nuevo nodo
            nuevoPremio.setAnterior(Fin);//Se cambia la referencia anterior del nuevo nodo por el antiguo final
            nuevoPremio.setSiguiente(null);//Se cambia la referencia siguiente del nuevo nodo por el inicio ya que se agrega al final
            Inicio.setAnterior(null);//Se cambia la referencia anterior del INICIO por el nuevo nodo
            Fin=nuevoPremio;//Se cambia el apuntador del final por el nuevo nodo(Se cambia el final)
        }
        
    }
    
    //Metodo para agregar un juego en cualuier parte de la lista
    //se utiliza para agregar el juego antes del juego mencionado.
    public void agregarMedio(Juego datos, Nodo nodoAnterior){
        Nodo aux1=Inicio;
        Nodo aux2=Inicio;
        
        while(aux1!=nodoAnterior){
            aux2=aux1;
            aux1=aux1.getSiguiente();
        }
        Nodo nuevo=new Nodo(aux1, datos);
        if(aux1==Inicio){
                if(Inicio==Fin && Inicio==null){
                    Inicio=Fin=nuevo;
                }else{
                    Inicio.setAnterior(nuevo);
                    nuevo.setSiguiente(Inicio);
                    Inicio=nuevo;
                   
                 }
        }else
            aux2.setSiguiente(nuevo);   
    }
    
   
    //con este método comparamos el nombre agregado con el nombre de cada juego de la lista
    //retornamos un nodo para utilizar en el método anterior.
 public Nodo BuscarNombre(String dato){
     //Creamos auxiliar apuntando al primer nodo de la lista
        Nodo aux=Inicio;
        // inicializamos una variable tipo nodo para retornar
        Nodo retorno = null;
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

    //Metodo para obtener el tamanio de la lista
    public int ObtenerTamanio(){
        int cont=0;
        Nodo aux=Inicio;
        
        //Ciclo para contar los elementos de la lista
        do {
            cont++;
            aux=aux.getSiguiente();
        }while(aux!=null);
        
        return cont;
    }
    
    //Metodo para obtener el juego de un lugar especifico de la lista
    public Nodo ObtenerJuego(int posicion){
        Nodo aux=Inicio;
        
        //Si el numero solicitado es mayor al tamanio de la lista
        if (posicion>ObtenerTamanio()){
            System.out.println("Numero incorrecto");
            return null;
        }
        
        //Ciclo for para obtener el juego deseado
        for (int i=0; i<posicion; i++){
            aux=aux.getSiguiente();
        }
        
        return aux;        
    }
    
    
    
    //Imprimir lista
    public void ImprimirLista(){
        //La lista esta vacia
        if (Inicio==Fin&&Inicio==null){
            System.out.println("La lista esta vacia");
        }
        
        Nodo aux=Inicio;//Inicializar el contador
        
        //Imprimir los elementos de la lista con un indice para posteriormente escogerlo
        for(int i=0; i<ObtenerTamanio(); i++){
            System.out.println((i+1) + ". " + aux.getDato().getNombre());
            System.out.println("Precio " + aux.getDato().getPrecio());
            System.out.println("Diversion : " + aux.getDato().getIndiceDiversion());
            aux=aux.getSiguiente();            
        }        
        
    }
    
    public boolean eliminarNodo(String nombre) {
 
        if (Inicio != null) {
            //Cuando solo existe un elemento
            if (Inicio == Fin && Inicio.getDato().getNombre().equals(nombre)) {
                Inicio = Fin = null;
                return true;
            //Cuando el elemento a eliminar esta en el inicio
            } else if (Inicio.getDato().getNombre().equals(nombre)) { 
                Inicio=Inicio.getSiguiente(); 
             
            //Cuando no esta ni en el inicio ni en el fin el elemento a eliminar
            } else {
                
                Nodo anterior = Inicio; 
                Nodo temporal = Inicio.getSiguiente(); 
               
                //Para recorrer la lista y encontrar el elemento para eliminar
                while (temporal != null && temporal.getDato().getNombre().contains(nombre)==false) {
                    anterior=anterior.getSiguiente(); 
                    temporal=temporal.getSiguiente();
                }
                
                    //Aqui se elimina el elemento encontrado
                    if (temporal != null && temporal.getDato().getNombre().contains(nombre)==true) {
                        anterior.setSiguiente(temporal.getSiguiente());
                        //Si el elemento esta en el final
                        if (temporal == Fin ) { 
                            Fin = anterior;        
                        }
                    return true;
                    }
 
                return false;
            }
 
        }return false;
 
    }
    
//    public void buscarDiversion(int dato){
//     //Creamos auxiliar apuntando al primer nodo de la lista
//        Nodo aux=Inicio;
//        Lista lista=new Lista();
//        while(aux!=null){           
//            if(aux.getDato().getIndiceDiversion()==dato){//comparamos la diverci[on necesaria obtenido con la diverci[on de los nodos
//                System.out.println(" Juego  " + aux.getAnterior().getDato().getNombre() + 
//                        " \n Diversion " + aux.getAnterior().getDato().getIndiceDiversion());
//                System.out.println(" Juego  " + aux.getDato().getNombre() + 
//                        " \n Diversion " + aux.getDato().getIndiceDiversion());
//                System.out.println(" Juego  " + aux.getSiguiente().getDato().getNombre() + 
//                        " \n Diversion " + aux.getSiguiente().getDato().getIndiceDiversion());
//                aux=aux.getSiguiente();
//            }else{
//                aux=aux.getSiguiente();
//            }
//        }
//    }
    
    public void Ordenar(Juego datos){
            Nodo aux=Inicio;
            Nodo nuevo=new Nodo(datos);
            if(Inicio==Fin && Inicio==null){
                 Inicio=nuevo=Fin;
            }
            else{
                if(Inicio.getDato().getIndiceDiversion()>nuevo.getDato().getIndiceDiversion()){
                    nuevo.setSiguiente(Inicio);
                    Inicio=nuevo;
                }
                else{
                    while(aux.getSiguiente()!=null && aux.getSiguiente().getDato().getIndiceDiversion()<=nuevo.getDato().getIndiceDiversion()){
                        aux=aux.getSiguiente();
                    }
                    nuevo.setSiguiente(aux.getSiguiente());
                    nuevo.setAnterior(aux);
                    aux.setSiguiente(nuevo);
                    aux=nuevo.getSiguiente();
                    aux.setAnterior(nuevo);
                }
            }
        }
    public double dineroDisponible(Cliente a , int posicion){
        Nodo aux= ObtenerJuego(posicion);
        double disponible=a.getPresupuesto();
        while (aux!=null){
            disponible=disponible-aux.getDato().getPrecio();
            System.out.println("El total de dinero que tiene despues del juego "+ aux.getDato().getNombre()+" es: "+ disponible);
            aux=aux.getSiguiente();
        }
        return disponible;
    }
    
    public boolean JuegoRepetido(Juego comparacion){
        Nodo aux=Inicio;
            
            for(int i=0; i<ObtenerTamanio(); i++){
                if(aux.getDato().getNombre().contains(comparacion.getNombre())== false){
                    System.out.println("Ya existe este juego");
                }else
                    System.out.println("No existe ese juego.");
                    return false;                       
        } 
        return false;
    }
    
}
