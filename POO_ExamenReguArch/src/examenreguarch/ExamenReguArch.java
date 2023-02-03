
package examenreguarch;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;




public class ExamenReguArch {

    
    public static void main(String[] args) throws FileNotFoundException {
        Empleado obj=new Empleado();
        Area obj2=new Area();
        Reporte obj3=new Reporte();
        obj.lee();
        obj2.lee();
        RandomAccessFile Datos;
        Datos = new RandomAccessFile("Reporte.dat", "rw");
        obj3.Reporte(Datos);
        
        
    }
    
}
