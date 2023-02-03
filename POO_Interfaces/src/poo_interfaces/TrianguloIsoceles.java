package poo_interfaces;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
public class TrianguloIsoceles extends Triangulo 
{
int b;//base
int a;//lado
    public void capturar() {
        b=parseInt(JOptionPane.showInputDialog("Digite la base del triangulo"));
        a=parseInt(JOptionPane.showInputDialog("Digite un lado del triangulo"));        
    }
    public void calcular() {
        double h;//altura
        h=Math.sqrt((a*a)-((b*b)/4));
        area=(b*h)/2;
        perimetro=(2*a)+b;
    }
     public String mostrar()
    {
        String t="Triangulo Isoceles\n";
        t=t+super.mostrar();
        return t;
    }
}
