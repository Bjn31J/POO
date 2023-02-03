
package examenreguarch;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;
public class Empleado {
    long tam=50;
    String clav;//-4
    String nom;//-30
    double suel;//-8
    String clav_A;//-2
   RandomAccessFile r;
    
  public void lee()
  {
       String men;
        try {
            r=new RandomAccessFile("C:\\Users\\Carlos\\Desktop\\examen2021\\empleado.dat","r");
            r.seek(0);
            System.out.println("Tamaño del archivo: "+r.length());
            System.out.println("No. de Registros: "+r.length()/tam);
            for(long i=0;i<r.length();i+=tam){                                                                              
                men=String.format("%-4s\t%-30s%-8f\t%-2s\t", r.readUTF(),r.readUTF(),r.readDouble(),r.readUTF());
                System.out.println(men);
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            r.close();
        } catch (IOException e) {
            System.err.println("Fallo en la lectura");
        }
  }
  
        
 
        
}
