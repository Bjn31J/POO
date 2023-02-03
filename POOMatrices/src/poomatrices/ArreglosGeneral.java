
package poomatrices;
import javax.swing.JOptionPane;
public class ArreglosGeneral {
    public int [][] LlenarMatriz()
    {
        int r,c;
        r=Integer.parseInt(JOptionPane.showInputDialog("Teclea número de renglones"));
        c=Integer.parseInt(JOptionPane.showInputDialog("Teclea número de columnas"));
        int [][] matriz=new int [r][c];
        for(int i=0; i<matriz.length; i++)  // i<r  RENGLONES
        {
            for(int k=0; k<matriz[i].length; k++)   // j<c   COLUMNAS
            {
                matriz[i][k]= Integer.parseInt(JOptionPane.showInputDialog("Teclea el elemento ["+ i+"] [" + k+"]"));
            }
        }
        return matriz;
    }
    public String imprimirMatriz(int[][] mat)
    {
        String res ="Matriz\n";
        for(int i=0;i<mat.length;i++)   // mat.length NUMERO DE RENGLOMES 
        {
            for(int k=0;k<mat[i].length;k++)    //mat[i].length NUMERO DE COLUMNAS
            {
                res=res+mat[i][k]+"   \t";  //adicionando elementos 1   2   3
            }
            res=res+" \n";   // adiciona salto de renglon
        }
        return res;
    }
    public void sumaMatrices(int[][] mat1,int[][] mat2,int[][] matSuma)
    {
        if(!(mat1.length==mat2.length && mat1[0].length==mat2[0].length) )
            JOptionPane.showMessageDialog(null,"Las matrices no se pueden sumar\nSon de diferente Orden");
        else
        {
             for(int i=0;i<mat1.length;i++)
             {
                 for(int k=0;k<mat1[i].length;k++)
                 {
                     matSuma[i][k]=mat1[i][k]+mat2[i][k];
                 }
             }
        }
    }
    public void restaMatrices(int[][] mat1,int[][] mat2,int[][] matResta)
    {
        if(!(mat1.length==mat2.length && mat1[0].length==mat2[0].length) )
            JOptionPane.showMessageDialog(null,"Las matrices no se pueden restar\nSon de diferente Orden");
        else
        {
             for(int i=0;i<mat1.length;i++)
             {
                 for(int k=0;k<mat1[i].length;k++)
                 {
                     matResta[i][k]=mat1[i][k]-mat2[i][k];
                 }
             }
        }
    }
    void multiplicaMatrices(int [][]mat1,int [][]mat2,int [][]mat3)
    {
       for(int i=0;i<mat1.length;i++)  // 4
       {
           for(int k=0;k<mat2[0].length;k++)  // 2
           {
             mat3[i][k]=0;
             for(int l=0;l<mat1[0].length;l++)  //5
             {         // l<mat2.length   //5
                 mat3[i][k]= mat3[i][k]+mat1[i][l]*mat2[l][k];
             }
           }
       }
   }
   int[][] transpuesta_Matriz(int[][] mat)
    {
        int r,c;
        r=mat.length;
        c=mat[0].length;
        int[][] maTran=new int [c][r];
        for(int i=0;i<r;i++)
        {
            for(int k=0;k<c;k++)
            {
                maTran[k][i]=mat[i][k];
            }
        }
        return maTran;
    }
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
   public int[] matriz_A_VectorColumna(int[][]mat)
   {
       int r,c;
       int con=0;
       r=mat.length;
       c=mat[0].length;
       int[] vec=new int [c*r];
       for(int i=0;i<c;i++)
       {
           for(int k=0;k<r;k++)
           {
               vec[con]=mat[k][i];
               con++;
           }
       }
       return vec;  
   }
    public String imprimirVector(int[] vector)   
    {
        String res ="Elementos\n";       
        for(int i=0;i<vector.length;i++)
        {
           res=res+vector[i]+"\n";
        }
        return res;     
    }
   public void ordena_Vector(int[]vector)
   {
       int aux;
       for(int pas=1;pas<=vector.length;pas++)
       {
           for(int com =1;com<=vector.length-pas;com++)
           {
               if(vector[com-1]>vector[com])
               {
                   aux=vector[com-1];
                   vector[com-1]=vector[com];
                   vector[com]=aux;
               }  
           }
       }
   }
    public String suma_Diagonal(int mat1[][])
   {
        int r,c;
        int sdp=0,sdi=0;
        String suma="\tSuma de Diagonales\t\n";
        r=mat1.length;
        c=mat1[0].length;
        if(r==c)
        {
         for(int i=0,k=r-1;i<r;i++,k--)
         {
             sdp=sdp+mat1[i][i];
             sdi=sdi+mat1[i][k];
         }
         suma=suma+"\nSuma Diagonal arriba-abajo:\t"+sdp+"\nSuma Diagonal abajo-arriba:\t"+sdi;
        }
        return suma;
   } 
   public int[][] examen_1()
   {
        int r,c;
        r=Integer.parseInt(JOptionPane.showInputDialog("Teclea número de renglones"));
        c=Integer.parseInt(JOptionPane.showInputDialog("Teclea número de columnas"));
        int [][] mat=new int [r][c];
        int mul=3;
        boolean ban=true;
        for(int i=mat.length-1;i>=0;i--)
        {
            if(ban)
            {
                ban=false;
                for(int j=mat[i].length-1;j>=0;j--)
                {
                    mat[i][j]=mul;
                    mul+=3;
                }
            }
            else
            {
                ban=true;
                for(int j=0;j<mat[i].length;j++)
                {
                    mat[i][j]=mul;
                    mul+=3;
                }
            }
        }
        return mat;
   }
   public int [][] examen2()
   {
        int r,c;
        r=Integer.parseInt(JOptionPane.showInputDialog("Teclea número de renglones"));
        c=Integer.parseInt(JOptionPane.showInputDialog("Teclea número de columnas"));
        int [][] mat=new int [r][c];
        int mul=3;
        boolean ban=true;
        for(int i=mat[0].length-1;i>=0;i--)
        {
            if(ban)
            {
                ban=false;
                for(int j=mat[i].length-1;j>=0;j--)
                {
                    mat[j][i]=mul;
                    mul+=3;
                }
            }
            else
            {
                ban=true;
                for(int j=0;j<mat.length;j++)
                {
                    mat[j][i]=mul;
                    mul+=3;
                } 
            }
        }
       return mat;
   }
}
    
   