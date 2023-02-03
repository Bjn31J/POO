
package pooarray;


public class PooARRAY {
    public static void main(String[] args) {
        int[] arr1;
        arr1=new int[5];
        //Llenar array
        int s=0;
        for (int  j :arr1) {
           arr1[s]=s*s;
           s++; 
        }
      
        int sum=0,res=0;
        for(int f:arr1)
        {
            //imprimir array
            System.out.println(""+f);
            
            sum+=f;
            res-=f;    
        }
        //imprimir array suma y resta
        System.out.println("Suma: "+sum+"\nResta: "+res);  
    }
}
 
