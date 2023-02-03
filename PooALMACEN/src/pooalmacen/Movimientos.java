
package pooalmacen;

import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;

class Movimientos {
    String clave, nombre;
    double preciou, existencia;
    int tamreg=64;
    Movimientos BuscarArticulo(String clave){
        RandomAccessFile canal;
        Movimientos mo=new Movimientos();
        boolean res=false;
        try{
            canal=new RandomAccessFile("articulos.dat","rw");
            int li=0;
            int ls=(int)((canal.length()/tamreg)-1);
            int pm;
            do{
                pm=(li+ls)/2;
                canal.seek(pm*tamreg);
                mo.clave=canal.readUTF();
                mo.nombre=canal.readUTF();
                mo.preciou=canal.readDouble();
                mo.existencia=canal.readDouble();
                if(mo.clave.compareToIgnoreCase(clave)>0)
                    ls=pm-1;
                else
                    li=pm+1;
            }while(!mo.clave.equals(clave) && li<=ls);
            if(mo.clave.equals(clave)){
                JOptionPane.showMessageDialog(null,"Se ha encontrado el articulo");
                canal.close();
            }
            else
                JOptionPane.showMessageDialog(null,"No se ha encontrado el articulo");
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo AL "+e.toString());
        }
        return mo;
    }
    void SacarProducto(Movimientos obj, double cantidad){
        RandomAccessFile canal;
        Movimientos objaux=new Movimientos();
        try{
         canal=new RandomAccessFile("articulos.dat","rw");
         int numreg=(int)(canal.length()/tamreg);
         for(int i=0;i<numreg;i++){
             canal.seek(tamreg*i);
             objaux.clave=canal.readUTF();
             objaux.nombre=canal.readUTF();
             objaux.preciou=canal.readDouble();
             objaux.existencia=canal.readDouble();
             if(obj.clave.equalsIgnoreCase(objaux.clave)){
                 obj.existencia=objaux.existencia-cantidad;
                 canal.seek(tamreg*i);
                 canal.writeUTF(obj.clave);
                 canal.writeUTF(obj.nombre);
                 canal.writeDouble(obj.preciou);
                 canal.writeDouble(obj.existencia);
             }
         }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null,"No se ha encontrado el archivo "+e.toString());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al ingresar el tipo de dato incorrecto "+e.toString());
        }
    }
    void MeterProducto(Movimientos obj, double cantidad){
        RandomAccessFile canal;
        Movimientos objaux=new Movimientos();
        try{
         canal=new RandomAccessFile("articulos.dat","rw");
         int numreg=(int)(canal.length()/tamreg);
         for(int i=0;i<numreg;i++){
             canal.seek(tamreg*i);
             objaux.clave=canal.readUTF();
             objaux.nombre=canal.readUTF();
             objaux.preciou=canal.readDouble();
             objaux.existencia=canal.readDouble();
             if(obj.clave.equalsIgnoreCase(objaux.clave)){
                 obj.existencia=objaux.existencia+cantidad;
                 canal.seek(tamreg*i);
                 canal.writeUTF(obj.clave);
                 canal.writeUTF(obj.nombre);
                 canal.writeDouble(obj.preciou);
                 canal.writeDouble(obj.existencia);
             }
         }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null,"No se ha encontrado el archivo "+e.toString());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al ingresar el tipo de dato incorrecto "+e.toString());
        }
    }
    void Imprimir(){
        RandomAccessFile canal;
        Movimientos objaux=new Movimientos();
        try{
            canal=new RandomAccessFile("articulos.dat","rw");
            int numreg=(int)(canal.length()/tamreg);
            for(int i=0;i<numreg;i++){
                canal.seek(i*tamreg);
                objaux.clave=canal.readUTF();
                objaux.nombre=canal.readUTF();
                objaux.preciou=canal.readDouble();
                objaux.existencia=canal.readDouble();
                System.out.print(objaux.clave);
                System.out.print(objaux.nombre);
                System.out.print(objaux.preciou);
                System.out.println(objaux.existencia);
            }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    
}
