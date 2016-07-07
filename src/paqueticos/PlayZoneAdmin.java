
package paqueticos;

import java.util.Scanner;


public class PlayZoneAdmin {
    
     public static String leerString(String mensaje)
    {
       Scanner ingreso=new Scanner(System.in);
        System.out.println(mensaje);
        String dato=ingreso.nextLine();
        return dato;
    }
    public static int leerInt(String  mensaje, int min, int max){
        Scanner n= new Scanner(System.in);
        System.out.println(mensaje);
        int dato=n.nextInt();
        if (dato<=max && dato>=min){
            return dato; 
            
        }else
        System.out.println("Ingrese nuevamente el valor dentro de los parametros establecidos: ");
        return leerInt(mensaje, max, min);
           
    } 
    
        public static double leerDouble(String  mensaje, int min, int max){
        Scanner n= new Scanner(System.in);
        System.out.println(mensaje);
        double dato= n.nextDouble();
        if (dato<=max && dato>=min){
            return dato;
        }else
            System.out.println("Ingrese nuevamente el valor dentro de los parametros establecidos: ");
        return leerDouble(mensaje, min, max);
    } 
//        
//    public static double leerDouble(String  mensaje){
//        Scanner n= new Scanner(System.in);
//        System.out.println(mensaje);
//        double dato=n.nextInt();
//        return dato;
//    }
    public static int menuAdmin()
    {
        //Menu de administrador para agregar juegos.
        Scanner ingreso=new Scanner(System.in);
        System.out.println("\t Modo Administrador");
        System.out.println("\n");
        System.out.println("\t Menu");
        System.out.println("Seleccione una opcion:");
        System.out.println("1. Agregar un juego");
        System.out.println("2. Imprimir Juegos.");
        System.out.println("3. Eliminar un juego por el nombre");
        System.out.println("4. Hacer conecciones");
        System.out.println("4. Salir");
        int dato=ingreso.nextInt();
        return dato;       
    }
     
       public static int menucliente()
    {
 
        //Menu de administrador para agregar juegos.
        Scanner ingreso=new Scanner(System.in);
        System.out.println("\t Modo Cliente");
        System.out.println("\n");
        System.out.println("\t Menu");
        System.out.println("Seleccione una opcion:");
        System.out.println("1. Buscar 3 juegos por diversión ");
        System.out.println("2. Optimizar juegos por precio ");
        System.out.println("3. Salir");
        int dato=ingreso.nextInt();
        return dato;         
    }
  public static int menu()
    {
 
        //Menu de administrador para agregar juegos.
        Scanner ingreso=new Scanner(System.in);
        System.out.println("\t Menu");
        System.out.println("Seleccione una opcion:");
        System.out.println("1. Administrador ");
        System.out.println("2. Cliente ");
        System.out.println("3. Salir");
        int dato=ingreso.nextInt();
        return dato;         
    }    
       
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Lista coleccion = new Lista();
        Lista diversion =new Lista();
        Lista auxiliar=new Lista();
        auxiliar=coleccion;
              Juego uno=new Juego("Uno", 0.5, 3);
        Juego dos=new Juego("Dos", 1.5, 2);
        Juego tres=new Juego("Tres", 2.5, 1);
        Juego cuatro=new Juego("Cuatro", 3.5, 5);
        Juego cinco=new Juego("Cinco", 0.5, 6);
        Juego seis=new Juego("Seis", 1.5, 7);
        Juego siete=new Juego("Siete", 2.5, 4);
        Juego ocho=new Juego("Ocho", 3.5, 8);
        
                
        coleccion.AgregarJuego(uno);       
        coleccion.AgregarJuego(dos);
        coleccion.AgregarJuego(tres);       
        coleccion.AgregarJuego(cuatro);
                coleccion.AgregarJuego(cinco);       
        coleccion.AgregarJuego(seis);
                coleccion.AgregarJuego(siete);       
        coleccion.AgregarJuego(ocho);
        
                
        int opcion;
        int opcion2;
        int opcion3;
        do{
        opcion=menu();
                if(opcion==1)
                {
                    do{
                        opcion2=menuAdmin();
                            switch(opcion2)
                            {
                                case 1: 
                                    Juego j1 =new Juego();
                                    
                                    j1.setNombre(leerString("Inserte el nombre"));
                                    j1.setPrecio(leerDouble("Ingrese el precio del juego", 5, 50));
                                    j1.setIndiceDiversion(leerInt("Ingrese indice de diversion", 1, 5));
                                    coleccion.agregarMedio(j1, coleccion.BuscarNombre(leerString("Ingrese el juego siguiente ")));
                                    coleccion.JuegoRepetido(j1);
                                    
                                    //diversion.Ordenar(j1);
                                break;

                                    case 2: 
                                        coleccion.ImprimirLista();

                                    break;

                                    case 3:
                                        coleccion.eliminarNodo(leerString("Ingrese el nombre a eliminar "));
                                        break;

                                case 4:
                                    Scanner x=new Scanner(System.in);
                                    coleccion.ImprimirLista();
                                        int ndo;
                                        ndo=x.nextInt();
                                        int opcion4;

                                        do{
                                            coleccion.ImprimirLista();
                                            opcion=x.nextInt();
                                            if(opcion!=ndo){
                                                coleccion.ObtenerJuego(ndo-1).getAdyacentes().AgregarJuego(coleccion.ObtenerJuego(opcion-1).getDato());
                                                coleccion.ObtenerJuego(opcion-1).getAdyacentes().AgregarJuego(coleccion.ObtenerJuego(ndo-1).getDato());
                                            }

                                        }while(opcion!=ndo);
                                        System.out.println("");
                                        coleccion.ObtenerJuego(ndo-1).getAdyacentes().ImprimirLista();
                            }
                    }while(opcion2<5);
                }
                else if (opcion==2){ 
                    
                        do{
                        opcion3=menucliente();
                                switch(opcion3)
                                {
                                    case 1: 
                                        Cliente a=new Cliente(leerDouble("Ingrese el total de dinero que posee",5,50));
                                        coleccion.ObtenerTamanio();
                                        int numero = leerInt("Ingrese la posicion en la que se encuentra",0,coleccion.ObtenerTamanio());
                                        while(coleccion.dineroDisponible(a,numero)>=0){
                                            auxiliar.AgregarJuego(coleccion.ObtenerJuego(numero).getDato());
                                            
                                        }
                                        
                                    break;

                                    case 2: 
                                        System.out.println("Los juegos que se puede jugar antes de que se acabe el dinero son: ");
                                        auxiliar.ImprimirLista();
                                    break;


                                    case 3:
                                        Scanner br = new Scanner (System.in);
                                        coleccion.ImprimirLista();
                                        
                                        int ir=br.nextInt();
                                        coleccion.ObtenerJuego(ir-1).getAdyacentes().ImprimirLista();
                                        ir=br.nextInt();
                                        do{
                                            int ant=ir;
                                            coleccion.ObtenerJuego(ir-1).getAdyacentes().ImprimirLista();
                                            ir=br.nextInt();
                                            coleccion.ObtenerJuego(ant-1).getAdyacentes().ObtenerJuego(ir-1);


                                        }while(ir!=0);
                                        break;

                                }
                        }while(opcion3<3);
            
                }  
                
            }while(opcion<3);

        }
    }
    
