
package examenreguarch;

import java.io.IOException;
import java.io.RandomAccessFile;


public class Area {
    long tam=36;
    String clav_a;//-2
    String nom_d;//-30
   RandomAccessFile r;
    public void lee()
    {
         String men;
        try {
            r=new RandomAccessFile("C:\\Users\\Carlos\\Desktop\\examen2021\\areas.dat","r");
            r.seek(0);
            System.out.println("Tamaño del archivo: "+r.length());
            System.out.println("No. de Registros: "+r.length()/tam);
            for(long i=0;i<r.length();i+=tam){                                                                              
                men=String.format("%-2s\t%-30s", r.readUTF(),r.readUTF());
                System.out.println(men);
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            r.close();
        } catch (IOException e) {
            System.err.println("Fallo en la lectura");
        }
    }
    
}
