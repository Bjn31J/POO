

package examen4;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;

public class Examen4 {

    
     public static void main(String[] args) {
        // TODO code application logic here
        long tR=76;
        String clv,name;
        byte aS,hr;
        double sH,sS;
        RandomAccessFile r,mod;
        
        String men;
        try {
            r=new RandomAccessFile("C:\\Users\\Carlos\\Desktop\\examen2021\\empleados.dat","r");
            r.seek(0);
            System.out.println("Tamaño del archivo: "+r.length());
            System.out.println("No. de Registros: "+r.length()/tR);
            for(long i=0;i<r.length();i+=tR){                                                                              //Horas trabajadas
                men=String.format("%-6s\t%-52s%-4d\t%-6.2f\t%-4d\t%-6.2f", r.readUTF(),r.readUTF(),r.readByte(),r.readDouble(),r.readByte(),r.readDouble());
                System.out.println(men);
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            r.close();
        } catch (IOException e) {
            System.err.println("Fallo en la lectura");
        }
          
        long li=0,ls,pm;
        boolean b=true;
        try {
            mod=new RandomAccessFile("C:\\Users\\Carlos\\Desktop\\examen2021\\empleados.dat","rw");            
            String cod=JOptionPane.showInputDialog("Clave del empleado que quiera modificar");
            ls=mod.length()/tR-1;
            do {                
                pm=(li+ls)/2;
                mod.seek(pm*tR);
                clv=mod.readUTF();
                name=mod.readUTF();
                aS=mod.readByte();
                sH=mod.readDouble();
                hr=mod.readByte();
                sS=mod.readDouble();
                if(clv.compareTo(cod)>0){
                    ls=pm-1;
                }else{
                    li=pm+1;
                }
            } while (!clv.equals(cod)&&li<=ls);
            if(clv.equals(cod)){
                byte hr_n=Byte.parseByte(JOptionPane.showInputDialog("Horas trabajadas"));                            
                mod.seek(pm*tR+67);
                mod.writeByte(hr_n);
            }else{
                JOptionPane.showMessageDialog(null, "El producto no existe", "Modificación", 0);
            }
        } catch (IOException e) {
            System.err.println("Error en modificación");
        }
    }
    
    }
    

