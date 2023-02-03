
package vectores.poo;
import javax.swing.JOptionPane;
public class VectoresGeneral {
    public int [] LlenarVector(int n) // Como dato de retorno (no es void) nos regresa un arreglo de tipo entero de 2 dimemnsión
    {
        //        vec1=vg.LlenarVector(n);
        int [] vector=new int [n];   // Se crea vector que es un arreglo de "e" elementos  
        
        for(int i=0; i<vector.length; i++)//  for(int i=0; i<e; i++)
        {
           vector[i]= Integer.parseInt(JOptionPane.showInputDialog("Teclea valor ["+ (i+1)+"]"));
        }
        return vector;
    }
    /*
        Metodo para imprimir vectores
    */
    public String imprimirVector(int[] vector)   //  Recibe como parámetro un vector que será el que se desea imprimir
    {
        String res ="Elementos\n";       //  Variable que irá almacenando los valores de los elementos de la matriz para posteriomente imprimirlos
        for(int i=0;i<vector.length;i++)
        {
           res=res+vector[i]+"\n";
        }
        System.out.print("desde el método\n"+res+"\n antes de salir del metodo\n");
        return res;     //  Retorna la cadena almaacenada
    }
    
   public void sumaVectores(int[] vec1,int[] vec2,int[] vecSuma)
    {
          for(int i=0;i<vec1.length;i++)
             {
                     vecSuma[i]=vec1[i]+vec2[i];
             }
    }
    public void sumaVectores_alrevez(int[] vec1,int[] vec2,int[] vecSuma)
    {
        for(int i=0,k=vec2.length-1;i<vec1.length;i++,k--)
        {
            vecSuma[i]=vec1[i]+vec2[k];
        }
    }
    
    public void ordenar_vectores(int[] vec){
        //Metodo de Ordenacíon de Seleccion
       
       int menor,posicion,temporal;
       int tam=vec.length;
       for(int i=0;i<tam-1;i++){
           menor= vec[i];
           posicion = i;
           for(int j=i+1;j<tam;j++){
               if(vec[j]<menor){
                   menor = vec[j];
                   posicion = j;
               }
           }
           if(posicion !=i){
               temporal=vec[i];
               vec[i]=vec[posicion];
               vec[posicion]=temporal;
           }
    }
    }
    public void busqueda_Binaria(int[] vec){
        
       int buscar= Integer.parseInt(JOptionPane.showInputDialog("Digite el numero a buscar: "));
       int cont=0;
       while(cont<vec.length-1 && vec[cont]!=buscar)
       {
           cont++;
       }   
       if(vec[cont]==buscar)
       {
           JOptionPane.showInputDialog("EL numero: "+ buscar + " Si existe");
       }else 
       {
           JOptionPane.showInputDialog("EL numero: "+ buscar + " NO existe");
       }
        
        
        
        
    }

    
    
   
    
    }
    
      

    


