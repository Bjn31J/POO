
package poojuegosubmarino;
import javax.swing.JOptionPane;
class GUI {
    public int seleccionarOpcion(String str[], String texto)
    {
      String strOpciones = "";
      int opcion = 1;
      for(int i=0;i<str.length;i++)
      {
          strOpciones += opcion +". " + str[i] + "\n";
          opcion ++;
      }
      int n = Integer.parseInt(JOptionPane.showInputDialog(null, strOpciones));
      return n;
    }
     public void desplegarMensaje(String str)
     {
        JOptionPane.showMessageDialog(null,str);
     }
    public void desplegarMensaje(String[] str)
    {
        String strMessage="";
        for (int i=0; i <str.length;i++)
        {
            strMessage += str[i]+"\n";
        }
        
        JOptionPane.showMessageDialog(null, strMessage);
    }
}
