package pooarray2d;
public class PooArray2d {
    public static void main(String[] args) {
        arreglos arr=new arreglos();
        int[][] mat1=null;
        mat1=arr.llenar_Array();
        System.out.println("matriz 1:\n"+arr.imprimirMatriz(mat1));
        System.out.println("\tLa suma por Renglon es: ");
        arr.sumaFilas(mat1);
        System.out.println(" ");
        System.out.println("\tLa suma por columna es: ");
        arr.sumaColumnas(mat1);
        }}
        
        

      
       
      
       
       
       
    
    

