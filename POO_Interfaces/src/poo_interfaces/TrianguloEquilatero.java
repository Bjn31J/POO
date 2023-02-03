package poo_interfaces;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
public class TrianguloEquilatero extends Triangulo
{
    int a;//lado
    public void capturar() 
    {
        a=parseInt(JOptionPane.showInputDialog("Digite un lado del triangulo"));        
    }
    public void calcular() 
    {
        
        area=((Math.sqrt(3)/4)*(a*a));
        perimetro=a*3;
       
        
    }
    public String mostrar()
    {
        String t="Triangulo Equilatero\n";
        t=t+super.mostrar();
        return t;
    }
}

