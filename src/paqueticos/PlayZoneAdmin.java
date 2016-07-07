
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
        System.out.println("4. Hacer conexiones");
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
        //
        Grafo coleccion = new Grafo();
        
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
            
    }


}

    
