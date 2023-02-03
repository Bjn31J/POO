package filetxt;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class FileTxt {  
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("Datos");
        fw.write("Name : Benjamin\n");
        fw.write("Age : 22\n");
        fw.write("Height : 1.75\n");
        fw.write("Name : Pedro\n");
        fw.write("Age : 28\n");
        fw.write("Height : 1.80\n");
        fw.close();
        
        PrintWriter pw = new PrintWriter("print1");
        pw.println("Reporte de Alumnos");
        pw.println("Alumno\t  Edad\t Altura");
        pw.println("Benjamin\t 22\t 1.75");
        pw.println("Pedro\t 28\t 1.80 ");
        pw.println("Luis\t 23\t 1.90 ");
        pw.close();
        
        FileReader fr = new FileReader("print1");
        BufferedReader br = new BufferedReader(fr);
        String s = "";
        while (s != null ) {
            System.out.println(" " + s);
            s = br.readLine();
       }
        fr.close(); br.close();
    }}

