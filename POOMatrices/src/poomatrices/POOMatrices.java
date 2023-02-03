
package poomatrices;

import javax.swing.JOptionPane;




public class POOMatrices {

    public static void main(String[] args) {
     ArreglosGeneral mg=new ArreglosGeneral(); // Se crea objeto
     
     int [][] ar;
     int [][] mat1=null; // Se declara arreglo pero aun no se crea
     int [][] mat2=null; // Se declara arreglo pero aun no se crea
     mat1=mg.LlenarMatriz();
     System.out.println("matriz 1:\n"+mg.imprimirMatriz(mat1));
     
    mat2=mg.LlenarMatriz();
    System.out.println("matriz 2:\n"+mg.imprimirMatriz(mat2));
    
    
    ////Declaracion suma y resta de Matrices
    
   if(mat1.length!=mat2.length || mat1[0].length!=mat2[0].length ) // para suma y resta
          JOptionPane.showMessageDialog(null,"Las matrices no se pueden sumar\nSon de diferente Orden");
    else
    {
        int [][] mat3=new int[mat1.length][mat1[0].length]; // se crea mat3
        mg.sumaMatrices(mat1, mat2, mat3); // se invoca al método para sumar
        System.out.println("Suma de las Matriz 1 + Matriz 2\n"+mg.imprimirMatriz(mat3));
        mg.sumaMatrices(mat2, mat1, mat3); // se invoca al método para sumar
        System.out.println("Suma de las Matriz 2 + Matriz 1\n"+mg.imprimirMatriz(mat3));
    
        mg.restaMatrices(mat1, mat2, mat3); // se invoca 1étodo para mat1 – mat2
        System.out.println("Resta matriz 1 - Matriz 2\n"+mg.imprimirMatriz(mat3));
        mg.restaMatrices(mat2, mat1, mat3); // se invoca 1étodo para mat2 – mat1
        System.out.println("Resta matriz 2 - Matriz 1\n"+mg.imprimirMatriz(mat3));
        
       
    }
    
   
     ///  DECLARACIÓN PARA MULTIPLICACIÓN DE MATRICES

    /* int [][] mat3=new int[mat1.length][mat2[0].length];
    mg.multiplicaMatrices(mat1, mat2, mat3);
    System.out.println("Multiplicación de matrices\n"+mg.imprimirMatriz(mat3));
      */
    
    
    
    /// DECLARACION PARA MATRIZ TRANSPUESTA
   /* int[][] mTran;
    mTran=mg.transpuesta_Matriz(mat1);
    System.out.println("Transpuesta matriz 1  \n"+mg.imprimirMatriz(mTran));
    mTran=mg.transpuesta_Matriz(mat2);
    System.out.println("Transpuesta matriz 2  \n"+mg.imprimirMatriz(mTran));
    */
   
    /// Declaracion vector a renglon columna y ordenar
   /* int [] vec;
    System.out.println("Matriz a Vector por renglon");
    vec=mg.matriz_A_VectorRenglon(mat1);
    System.out.println(mg.imprimirVector(vec));
    System.out.println("Vector por renglon Ordenado");
    mg.ordena_Vector(vec);
    System.out.println(mg.imprimirVector(vec));
    
    System.out.println("Matriz a Vector por columna");
    vec=mg.matriz_A_VectorColumna(mat1);
    System.out.println(mg.imprimirVector(vec));
    System.out.println("Vector por columna Ordenado");
    mg.ordena_Vector(vec);
    System.out.println(mg.imprimirVector(vec));
   */
   /////Declaracion suma Diagonal
   
   
 /* mg.suma_Diagonal(mat1); 
  System.out.println( mg.suma_Diagonal(mat1));
  */ 
 
 
   ///Declaracion examenes piloto
   
   
  int[][]Examen=null;
   Examen=mg.examen_1();
   System.out.println(mg.imprimirMatriz(Examen));
   Examen=mg.examen2();
   System.out.println(mg.imprimirMatriz(Examen));
   
   
   
   
   
   
    
    
  }

}
