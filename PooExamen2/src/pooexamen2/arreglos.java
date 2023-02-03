
package pooexamen2;
class arreglos {
     public int[] matriz_A_VectorRenglon(int[][]mat)//Por renglon
   {
       int r,c;
       int con=0;
       r=mat.length;
       c=mat[0].length;
       int[] vec=new int [c*r];
       for(int i=0;i<r;i++)
       {
           for(int k=0;k<c;k++)
           {
               vec[con]=mat[i][k];
               con++;
           }
       }
       return vec;
   }
  public int obtenerMax(int[] vec){
        int max=0;
        max= vec[0];
        int tam = vec.length;
        for(int i=1;i<tam;i++){
            if(vec[i]> max){
               max = vec[i];
               
            }
        }
     return max; 
    }
  public int obtenerMin(int[] vec){
        int min=0;
        min = vec[0];
        int tam = vec.length;
        for (int i=1;i<tam;i++){
            if(vec[i]<min){
                min = vec[i];
            }
        }
     return min;
    }
    public String imprimirMatriz(int[][] mat)
    {
        String res ="Matriz\n";
        for(int i=0;i<mat.length;i++)   
        {
            for(int k=0;k<mat[i].length;k++)   
            {
                res=res+mat[i][k]+"   \t";  
            }
            res=res+" \n";   
        }
        return res;
    }
    public int[][] obtener_TrianguloInferior(int[][] matriz)
    {
        
       int[][] nueva = new int[matriz.length][matriz.length];
        
        for (int i = 0; i < nueva.length; i++) {
            for (int j = 0; j < nueva.length; j++) {
                nueva[i][j] = -9;                
            }
        }
        
        for (int i = 0; i < nueva.length; i++) {
            for (int j = 0; j < i+1; j++) {
                nueva[i][j] = matriz[i][j];
            }
        }
        
        return nueva;
        
    }
    
    
   
}
