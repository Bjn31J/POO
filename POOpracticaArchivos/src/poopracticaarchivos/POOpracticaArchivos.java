
package poopracticaarchivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class POOpracticaArchivos {
    public void escribir()
    {
        try {
            FileWriter fw=new FileWriter(new File("Ejercicios.txt"));
            BufferedWriter bw=new BufferedWriter(fw);
            for (int i=0;i<=10;i++)
            {
             linea(i,'*',bw);
             bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public void leer()
    {
        try {
            FileReader fr=new FileReader(new File("Ejercicios.txt"));
            BufferedReader br=new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null)
            {
                System.out.println(linea);
            }
            
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public void linea(int veces,char caracter,BufferedWriter bw)
    {
        try {
            for(int i=0;i<veces;i++)
       {
           bw.write(caracter);
       } 
            
        } catch (IOException e) {
            System.out.println(e);
        }
       
    }

    
    public static void main(String[] args) {
       POOpracticaArchivos obj= new POOpracticaArchivos();
        obj.escribir();
        obj.leer();
    }
    
}
