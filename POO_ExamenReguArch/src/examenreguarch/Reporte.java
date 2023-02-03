
package examenreguarch;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;


public class Reporte {
    static int TA_E = 50;
    static int TA_A = 36;
    static int TA_RE = 16;
    
    public void Reporte(RandomAccessFile Datos) throws FileNotFoundException {
        String nombrem = "", Empleado, Area;
         RandomAccessFile abrir1, abrir2;
         Empleado = "Empleado.dat";
         Area = "areas.dat";
         abrir1 = new RandomAccessFile(Empleado, "rw");
         abrir2 = new RandomAccessFile(Area, "rw");
       
        RandomAccessFile Abre1, Abre2;
        try {
            Abre1 = new RandomAccessFile(Empleado, "rw");
            Abre2 = new RandomAccessFile(Area, "rw");
            PrintWriter reporte;
            Datos = new RandomAccessFile("Reporte.dat", "rw");
            reporte = new PrintWriter(new FileWriter("C:\\Users\\Carlos\\Desktop\\examen2021\\reporte.txt"));
            reporte.println("Reportes");
            Datos.seek(0);

            String Auxclav_E = "",aux_nr = "", nombreE = "", sueldo = "",aux_c = "",AuxClave = "";

            int num_R = (int) (Datos.length() / TA_RE);

            for (int i = 0; i < num_R; i++) {
                
                if (i % 2 == 0) {
                    Auxclav_E = Datos.readUTF();
                    nombreE = Datos.readUTF();
                    if (!Auxclav_E.equals(aux_nr)) {
                        reporte.println("______________________________________________________________");
                        reporte.print("Numero Control:");
                        reporte.write(String.format("%-8s \n", Auxclav_E));
                        reporte.print("Nombre:");
                        reporte.write(String.format("%-8s \n", nombreE));
                        reporte.println(String.format("%-4s\t%-30s%-8f\t%-2s\t", "Clave Empleado ", " Nombre Empleado ", " Sueldo ","ARea"));
                        aux_c =Auxclav_E ;
                    }
                } else {
                    aux_nr = Datos.readUTF();
                    Auxclav_E = Datos.readUTF();
                    if (!aux_nr.equals(Auxclav_E)) {
                        reporte.println("_______________________________________________________________");
                        reporte.print("Clave Empleado:");
                        reporte.write(String.format("%-8s \n", aux_nr));
                        reporte.print("Nombre:");
                        reporte.write(String.format("%-8s \n", nombreE));
                        reporte.println(String.format("%-4s\t%-30s%-8f\t%-2s\t", "Clave Empleado ", " Nombre Empleado ", " Sueldo ","ARea"));
                        aux_c = aux_nr;
                    }
                }
               /* if ((Aux.equals(aux_c)) || (aux_nr.equals(aux_c))) {
                    nombrem = ExisteMateria(Abre2, AuxClave);
                    credito = ConsultaMateria(Abre2, AuxClave);
                    reporte.write(String.format("%-18s%-15s%-1s \n", AuxClave, nombrem, credito));
                   
                }*/
            }
            Datos.close();
            reporte.close();
            Abre2.close();
            Abre1.close();
        } catch (IOException e) // captura la Excepcion
        {
            System.out.println(" No se abrio bien el fichero \n" + e.toString());
        }
        JOptionPane.showMessageDialog(null, "Reportes.");
    }
    
}
