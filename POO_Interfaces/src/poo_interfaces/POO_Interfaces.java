package poo_interfaces;
import javax.swing.JOptionPane;
public class POO_Interfaces {
    public static void main(String[] args) 
    {
        TrianguloEquilatero tequ= new TrianguloEquilatero();
        TrianguloIsoceles tiso = new TrianguloIsoceles();
        TrianguloEscaleno tesc= new TrianguloEscaleno();
        TrianguloRectangulo trec= new TrianguloRectangulo();
       
         JOptionPane.showMessageDialog(null, "Triangulo Equilatero");
         tequ.capturar();
         tequ.calcular();
         System.out.println(tequ.mostrar());
         JOptionPane.showMessageDialog(null, "Triangulo Isoceles");
         tiso.capturar();
         tiso.calcular();
         System.out.println(tiso.mostrar());
         JOptionPane.showMessageDialog(null, "Triangulo Escaleno");
         tesc.capturar();
         tesc.calcular();
         System.out.println(tesc.mostrar());
        
         JOptionPane.showMessageDialog(null, "Triangulo rectangulo");
         trec.capturar();
         trec.calcular();
         System.out.println(trec.mostrar());
         
        
    }
}
