
package pooarchproductos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;


public class PooarchProductos {

    
    public static void main(String[] args) {
        ArrayList<Producto> productos =new ArrayList<>();
        productos.add(new Producto(1,"Producto 1",10.5,true,'T'));
        productos.add(new Producto(2,"Producto 2",50.5,true,'R'));
        productos.add(new Producto(3,"Producto 3",10.5,false,'T'));
        productos.add(new Producto(4,"Producto 4",30.5,true,'B'));
        productos.add(new Producto(5,"Producto 5",20.5,true,'T'));
        
        try(RandomAccessFile raf=new RandomAccessFile("ejemplo_raf.dat","rw")) {
            for (Iterator<Producto> it = productos.iterator(); it.hasNext();) {
                Producto p = it.next();
                raf.write(p.getId());
                StringBuffer sb=new StringBuffer(p.getNombre());
                sb.setLength(10);
                raf.writeDouble(p.getPrecio());
                raf.writeBoolean(p.isDescuento());
                raf.writeChar(p.getTipo());
            }
            raf.seek(35);
            System.out.println(raf.readInt());
            System.out.println(raf.readUTF());
            System.out.println(raf.readInt());
            System.out.println(raf.readDouble());
            System.out.println(raf.readBoolean());
            System.out.println(raf.readChar());
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        
    }
    
}
