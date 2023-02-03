
package poo2.pkg2arregloobjetosalumno;
import javax.swing.JOptionPane;
public class GUI {
    public int seleccionarOpcion(String str[], String texto){
      String strOpciones = "";
      int opcion = 1;
      for(int i=0;i<str.length;i++){
          strOpciones += opcion +". " + str[i] + "\n";
          opcion ++;
      }
      int n = Integer.parseInt(JOptionPane.showInputDialog(null, strOpciones));
      return n;
    }
     public void desplegarMensaje(String str){
        JOptionPane.showMessageDialog(null,str);
    }
    public void desplegarMensaje(String[] str){
        String strMessage="";
        for (int i=0; i <str.length;i++){
            strMessage += str[i]+"\n";
        }
        
        JOptionPane.showMessageDialog(null, strMessage);
    }
     public int leerAlumno(String texto){
        String str;
        int n;
        str = JOptionPane.showInputDialog(null, texto);
        n = Integer.parseInt(str);
        return n;
    }}
     
   

