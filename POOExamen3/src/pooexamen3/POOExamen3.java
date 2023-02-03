package pooexamen3;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class POOExamen3 {
      public static void  main(String [] args)
      {
          
          Scanner sc=new Scanner(System.in);
          int n = parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de vehiculos"));
          Vehiculo ar[]=new Vehiculo[n];
          for(int i=0;i<n;i++)
          {
              int opcion;
              opcion = parseInt(JOptionPane.showInputDialog(null, "Ingrese 1\n"+"Vehiculo electrico\n"+"ingrese 2\n"+"Vehiculo de combustion\n"));
              switch(opcion)
              {
                  
                  case 1:
                      JOptionPane.showMessageDialog(null,"Selecciono: Vehiculo Electrico");
                       ar[i]=new Electrico();
                       ar[i].capturar(sc);
                       ar[i].calcularImpuesto(sc);
                       System.out.println(ar[i].mostrar());
                       
                       break;
                  case 2:
                      JOptionPane.showMessageDialog(null,"Selecciono: Vehiculo de Combustion");
                      
                      ar[i]=new Combustion();
                      ar[i].capturar(sc);
                      ar[i].calcularImpuesto(sc);
                      System.out.println(ar[i].mostrar());
                       
                      break;
                                          
                  default:
                      JOptionPane.showMessageDialog(null,"Digite bien los numeros correspondientes a la opcion");
                      
                }
          } 
      }       
}      
           
          
               
    
