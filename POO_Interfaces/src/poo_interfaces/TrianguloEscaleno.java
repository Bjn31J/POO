package poo_interfaces;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
 public class TrianguloEscaleno extends Triangulo
 {
    int a;
    int b;
    int c;
    public void capturar() 
    {
      a=parseInt(JOptionPane.showInputDialog("Digite un lado a del triangulo"));
      b=parseInt(JOptionPane.showInputDialog("Digite un lado b del triangulo"));
      c=parseInt(JOptionPane.showInputDialog("Digite un lado c del triangulo"));
    }
    public void calcular() 
    {
        double semip;
        double raiz;
        
        semip=(a+b+c)/2;
        raiz=(semip)*(semip-a)*(semip-b)*(semip-c);
        area=Math.sqrt(raiz);
        perimetro=a+b+c;
             
    }
     public String mostrar()
    {
        String t="Triangulo Escaleno\n";
        t=t+super.mostrar();
        return t;
    }
}
