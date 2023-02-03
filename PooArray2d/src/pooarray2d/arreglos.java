package pooarray2d;
class arreglos {
    public int[][] llenar_Array()
    {
        int [ ] [ ] arr2d= new int [ 3 ] [ 3];
        int i=0,j=0;
        for(int [ ] a : arr2d){
            j=0;
            for(int e : a){
             arr2d[ i ][ j++] = (int) (Math.random() *100)+1;
            }
            i++;
        }
        return arr2d;
    }
    public String imprimirMatriz(int[][] arr2d)
    {
        String res ="Matriz\n";
        for(int [ ] a : arr2d)  
        {
            for(int e: a)    
            {
                res+=e+"   \t";  
            }
            res=res+" \n";  
        }
        return res;
    }
    public void sumaFilas(int[][] arr2d) {
    for (int [ ] a : arr2d) {
        int suma = 0;
        for (int e: a) {
            System.out.printf("%d ", e);
            suma += e;
        }
        System.out.printf("= %d\n ", suma);  
    }}
     public void sumaColumnas(int[][] arr2d) 
     {
          for (int i = 0; i < arr2d[0].length; i++) {//columnas
            int suma = 0;
            for (int j = 0; j < arr2d.length; j++) {//filas
                System.out.printf("%d ", arr2d[j][i]);//%d para imprimir los 
                suma += arr2d[j][i];
            }
            System.out.printf("=%d\n ", suma);
          }
     }}
    
    
   
    
    
    
      
    
    
    

