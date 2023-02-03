
package poojuegosubmarino;
import java.util.Scanner;
public class POOjuegoSubmarino {

    
    public static void main(String[] args) {
       GUI gui=new GUI();
       Scanner sc=new Scanner(System.in); 
       String[] option = new String[3];
      
       option[0] = "Jugar hasta que se destruyan todos los submarinos. ";
       option[1] = "Jugar con limite de tiros.";
       option[2] = "Salir";
       
       submarino sub=new submarino();
       int [][] tableroOriginal = new int [5][5];
       
       gui.desplegarMensaje("Bienvenido al juego submarino");
       gui.desplegarMensaje("Instrucciones: \na)Digitar un par de coordenadas que van del 0 al 4.\n"
                + "b)Tanto columnas como filas van del 0 al 4.");
       
       int opSelected=0;
       
         do{
             opSelected=gui.seleccionarOpcion(option, "Arreglo de objetos submarino");
        switch (opSelected){
            case 1:
                gui.desplegarMensaje("Se seleccionó: Jugar hasta que se destruyan todos los submarinos.");
                gui.desplegarMensaje("Eliga un casillero (Introduciendo sus coordenadas).");
                sub.setTableroOriginal(tableroOriginal);
                sub.generar_Submarino();
                sub.imprimir_Tablero(tableroOriginal);
                do{ 
                sub.ingresar_Coordenadas(sc);
                sub.verificar_Juego();
                }while(sub.cont2<sub.cont);
                sub.estado_del_juego();
                break;
            case 2:
                int intentos=0;
                gui.desplegarMensaje("Se seleccionó: Jugar con limite de tiros.");
                gui.desplegarMensaje("Eliga un casillero (Introduciendo sus coordenadas).");
                sub.setTableroOriginal(tableroOriginal);
                sub.generar_Submarino();
                sub.imprimir_Tablero(tableroOriginal);
                System.out.println("Tienes 5 intentos");
                do{
                intentos++;
                sub.ingresar_Coordenadas(sc);
                sub.verificar_Juego();
                System.out.println("Intento numero:" + intentos );
                }while(intentos<5);
                sub.estado_del_juego();
                break;
            case 3:
                gui.desplegarMensaje("Usted a salido del juego");
                break;
            default:
                gui.desplegarMensaje("No corresponde a ninguna opcion");
    }} while( opSelected !=3);
    }}
    
    
    

