package bindata;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class BinData {
    public static void main(String[] args) throws FileNotFoundException, IOException {
       /* FileOutputStream fos=new FileOutputStream("BinData");
        DataOutputStream dos=new DataOutputStream(fos);
        dos.writeUTF(" Benjamin");
        dos.writeDouble(1.75);
        dos.writeInt(22);
        dos.writeUTF("Masculino");
        
        dos.writeUTF("Fernanda");
        dos.writeDouble(1.55);
        dos.write(18);
        dos.writeUTF("Femenino");
        
       fos.close();dos.close();*/
        
       FileInputStream fis=new FileInputStream("BinData");
       DataInputStream dis=new DataInputStream(fis);
        try{
            while(true){
                System.out.println("S= "+dis.readUTF()+"D="+dis.readDouble()+"I="+dis.readInt()+"S="+dis.readUTF());
            }
        }catch(IOException e){
            System.out.println("Fuera del file");
        }
        fis.close();dis.close();
        }}
    

