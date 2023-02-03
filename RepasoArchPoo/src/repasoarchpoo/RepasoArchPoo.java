
package repasoarchpoo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class RepasoArchPoo {

    
    public static void main(String[] args) {
       long tam=76;
       String clave,nombre;
       byte años,hts;
       double sxh,ss;
       RandomAccessFile r,r2;
       String formato;
        try {
        r=new RandomAccessFile("C:\\Users\\Carlos\\Desktop\\examen2021\\empleados.dat","r");
        r.seek(0);
         System.out.println("Tamaño del archivo: "+r.length());
         System.out.println("No. de Registros: "+r.length()/tam);
         for(long i=0;i<r.length();i+=tam){                                                                              //Horas trabajadas
                formato=String.format("%-6s\t%-52s%-4d\t%-6.2f\t%-4d\t%-6.2f", r.readUTF(),r.readUTF(),r.readByte(),r.readDouble(),r.readByte(),r.readDouble());
                System.out.println(formato);
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            r.close();
        } catch (IOException e) {
            System.err.println("Fallo en la lectura");
        }
    }
    
}
