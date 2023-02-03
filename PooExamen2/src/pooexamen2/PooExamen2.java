
package pooexamen2;


public class PooExamen2 {

    
    public static void main(String[] args) {
        arreglos arr=new arreglos();
        int [][] mat1= {{4,1,4,2},{5,2,5,9},{-1,-4,-2,-8},{12,14,11,21}};
        int [][] mat2= {{5,9,4,3 },{9,5,8,4},{3,8,4,1},{0,4,1,3}};
        int [][] mat3= {{4,1,2,0},{5,2,9,6},{-1,-4,-8,-3}};
        
      
      
       int[]vec; 
       
       System.out.println(arr.imprimirMatriz(mat1));
       vec=arr.matriz_A_VectorRenglon(mat1);
       System.out.println("El numero maximo de la matriz 1 es: ");
       System.out.println(arr.obtenerMax(vec));
       System.out.println("El numero minimo de la matriz 1 es: ");
       System.out.println(arr.obtenerMin(vec));
       mat1=arr.obtener_TrianguloInferior(mat1);
       System.out.println(arr.imprimirMatriz(mat1));
       
     
       System.out.println(arr.imprimirMatriz(mat2));
       vec=arr.matriz_A_VectorRenglon(mat2);
       System.out.println("El numero maximo de la matriz 2 es: ");
       System.out.println(arr.obtenerMax(vec));
       System.out.println("El numero minimode la matriz 2 es: ");
       System.out.println(arr.obtenerMin(vec));
       mat2=arr.obtener_TrianguloInferior(mat2);
       System.out.println(arr.imprimirMatriz(mat2));
       
        
       System.out.println(arr.imprimirMatriz(mat3));
       vec=arr.matriz_A_VectorRenglon(mat3);
       System.out.println("El numero maximo de la matriz 3 es: ");
       System.out.println(arr.obtenerMax(vec));
       System.out.println("El numero minimo de la matriz 3 es: ");
       System.out.println(arr.obtenerMin(vec));
       mat3=arr.obtener_TrianguloInferior(mat3);
        System.out.println(arr.imprimirMatriz(mat3));
         
       
    }
    
}
