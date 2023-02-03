
package vectores.poo;

import javax.swing.JOptionPane;


public class VectoresPoo {

   
    public static void main(String[] args) {
       int n;
       String res="B";
        n=Integer.parseInt(JOptionPane.showInputDialog("Teclea número de elementos"));
     
       int [] vec1;   
       int [] vec2;
       
       VectoresGeneral vg=new VectoresGeneral();
       vec1=vg.LlenarVector(n);
       JOptionPane.showMessageDialog(null,"Arreglo 1"+vg.imprimirVector(vec1));
      
       vec2=vg.LlenarVector(n);
       JOptionPane.showMessageDialog(null,"Arreglo 2"+vg.imprimirVector(vec2));
      
      
       int []sumaVec=new int [vec1.length];
       vg.sumaVectores(vec1, vec2, sumaVec);
       JOptionPane.showMessageDialog(null,"Suma de vectores "+vg.imprimirVector(sumaVec));
      
       vg.sumaVectores_alrevez(vec1, vec1, sumaVec);
       JOptionPane.showMessageDialog(null,"Suma de vectores "+vg.imprimirVector(sumaVec));
       
       
       
       vg.ordenar_vectores(vec1);
       JOptionPane.showMessageDialog(null,"El orden del vector 1 es: "+vg.imprimirVector(vec1));
       
       
       
       vg.ordenar_vectores(vec2);
       JOptionPane.showMessageDialog(null,"El orden del vector 2 es: "+vg.imprimirVector(vec2));
       

       
     
      vg.busqueda_Binaria(vec1);
       JOptionPane.showMessageDialog(null,"El numero a buscar en el vector 1 es:"+vg.imprimirVector(vec1));
      
     
       
       vg.busqueda_Binaria(vec2);
       JOptionPane.showMessageDialog(null,"El numero a buscar en el vector 2 es:"+vg.imprimirVector(vec2));
     
       
       
       System.exit(0);
       
     
       
    }}
    

