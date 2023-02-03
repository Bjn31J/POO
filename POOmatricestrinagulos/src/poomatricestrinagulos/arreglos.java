
package poomatricestrinagulos;


class arreglos {
   public int[][] obtener_Triangulo1(int[][] matriz)
    {
      int[][] nueva = new int[matriz.length][matriz.length];
      for(int f=0;f<matriz.length;f++){
            for(int c=0;c<matriz[f].length;c++){
                if(f<c){
                    nueva[f][c]=-5;
                }else{
                    nueva[f][c]=matriz[f][c];
                }
            }           
        }
      return nueva;   
    }
    public int[][] obtener_Triangulo2(int[][] matriz)
    {
      int[][] nueva = new int[matriz.length][matriz.length];
      for(int f=0;f<matriz.length;f++){
            for(int c=0;c<matriz[f].length;c++){
                if(f>c){
                    nueva[f][c]=-5;
                }else{
                    nueva[f][c]=matriz[f][c];
                }
            }           
        }
      return nueva;   
    }
    public int[][] obtener_Triangulo3(int[][] matriz)
    {
        int[][] nueva = new int[matriz.length][matriz.length];
        int cont=1;
         for(int f=0;f<matriz.length;f++,cont++){
            for(int c=0;c<matriz[f].length;c++){
                if(c<matriz.length-cont){
                    nueva[f][c]=-5;
                }else{
                    nueva[f][c]=matriz[f][c];
                }
        
    }
         }
         return nueva;
    }
    public int[][] obtener_Triangulo4(int[][] matriz)
    {
        int[][] nueva = new int[matriz.length][matriz.length];
        int cont=0;
        for(int f=0;f<matriz.length;f++,cont++){
            for(int c=0;c<matriz[f].length;c++){
                if(c<matriz.length-cont){
                    nueva[f][c]=matriz[f][c];
                }else{
                    nueva[f][c]=-5;
                }
         }
    }
        return nueva;
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
   void maximosColumna(int [][] mat)
      {
         int maximo;
         int r;
         for(int i=0;i<mat[0].length;i++)
         {
            maximo=mat[0][i];
            r=0;
            for(int k=0;k<mat.length;k++)
            {
               if(maximo<mat[k][i])
               {
                  maximo=mat[k][i];
                  r=k;
               }
            }
            System.out.println("El valor maximo de columna "+i+"es "+maximo+" renglón "+r);
           
        }
      }
   void minimosColumna(int [][] mat)
      {
         int minimos;
         int r;
         for(int i=0;i<mat[0].length;i++)
         {
            minimos=mat[0][i];
            r=0;
            for(int k=0;k<mat.length;k++)
            {
               if(minimos>mat[k][i])
               {
                  minimos=mat[k][i];
                  r=k;
               }
            }
            System.out.println("El valor minimo de columna "+i+"es "+minimos+" renglón "+r);
            
        }
      }
   void maximosRenglon(int [][] mat)
      {
         int maximo;
         int r;
         for(int i=0;i<mat.length;i++)
         {
            maximo=mat[i][0];
            r=0;
            for(int k=0;k<mat.length;k++)
            {
               if(maximo<mat[i][k])
               {
                  maximo=mat[i][k];
                  r=k;
               }
            }
            System.out.println("El valor maximo de Renglon "+i+"es "+maximo+" columna "+r);
            
        }
      }
   void minimosRenglon(int [][] mat)
      {
         int minimo;
         int r;
         for(int i=0;i<mat.length;i++)
         {
            minimo=mat[i][0];
            r=0;
            for(int k=0;k<mat.length;k++)
            {
               if(minimo>mat[i][k])
               {
                  minimo=mat[i][k];
                  r=k;
               }
            }
            System.out.println("El valor minimo de Renglon "+i+"es "+minimo+" columna "+r);
            
        }
      }
   public void minimoMaximo(int[][] matriz){
        int max = matriz[0][0], min = matriz[0][0], c1 = 0, f1 = 0, c2 = 0, f2 = 0;
       
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                
                if (max < matriz[i][j]) {
                    max = matriz[i][j];
                    f1 = i;
                    c1 = j;
                }
               
                if (min > matriz[i][j]) {
                    min = matriz[i][j];
                    f2 = i;
                    c2 = j;
                }
            }
        }
        
        System.out.println("\nValor máximo: "+max+" en renglón "+f1+" columna "+c1);
        System.out.println("Valor mínimo: "+min+" en renglón "+f2+" columna "+c2);
    }
    public void suma_Diagonal(int mat1[][])
   {
        int r,c;
        int sdp=0,sdi=0;
        r=mat1.length;
        c=mat1[0].length;
        if(r==c)
        {
         for(int i=0,k=r-1;i<r;i++,k--)
         {
             sdp=sdp+mat1[i][i];
             sdi=sdi+mat1[i][k];
         }
            System.out.println("\nSuma Diagonal arriba-abajo:\t"+sdp+"\nSuma Diagonal abajo-arriba:\t"+sdi);
        }
   } 
    public void sumaFilas(int[][] matriz) {
    for (int i = 0; i < matriz.length; i++) {
        int suma = 0;
        for (int j = 0; j < matriz[i].length; j++) {
            System.out.printf("%d ", matriz[i][j]);
            suma += matriz[i][j];
        }
        System.out.printf("La suma por reglon es"+"= %d\n", suma);
    }
    
    }
    public void sumaColumnas(int[][] matriz) {
        
        for (int i = 0; i < matriz[0].length; i++) {
            int suma = 0;
            for (int j = 0; j < matriz.length; j++) {
                System.out.printf("%d ", matriz[j][i]);
                suma += matriz[j][i];
            }
            System.out.printf("La suma por columna es"+"= %d\n ", suma);
        }
    }
    public int[][] matInvertida(int[][] matriz){
        int[][] nueva = new int[matriz.length][matriz.length];
        for(int f=0;f<matriz.length;f++){
            for(int c=0,k=matriz[f].length-1;c<matriz[f].length;c++,k--){
                nueva[f][k]=matriz[f][c];
            }
        }
        return nueva;
    }

}

 

    

