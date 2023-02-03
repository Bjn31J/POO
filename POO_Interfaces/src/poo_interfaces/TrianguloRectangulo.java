package poo_interfaces;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
public class TrianguloRectangulo extends Triangulo 
{
    int a, b;
    public void capturar() 
    {
        b=parseInt(JOptionPane.showInputDialog("Digite la base del triangulo"));
        a=parseInt(JOptionPane.showInputDialog("Digite la altura  del triangulo"));        
    }
    public void calcular() 
    {
        double hipotenusa;
        
        area=(a*b)/2;
        hipotenusa=Math.sqrt((a*a)+(b*b));
        perimetro=a+b+hipotenusa;
        
    }
     public String mostrar()
    {
        String t="Triangulo Rectangulo\n";
        t=t+super.mostrar();
        return t;
    }
}
