
package pootriangulos;


public class POOtriangulos {

    
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] mat=new int[6][6];
        String men="";
        System.out.println("Primero\n");
        for(int f=0;f<mat.length;f++){
            for(int c=0;c<mat[f].length;c++){
                if(f>=c){
                    mat[f][c]=1;
                }else{
                    mat[f][c]=0;
                }
                men=men+mat[f][c]+"\t";
            }
            men=men+"\n";            
        }
        
        System.out.println(men);
        men="";
        System.out.println("Segundo\n");
        for(int f=0;f<mat.length;f++){
            for(int c=0;c<mat[f].length;c++){
                if(f<=c){
                    mat[f][c]=1;
                }else{
                    mat[f][c]=0;
                }
                men=men+mat[f][c]+"\t";
            }
            men=men+"\n";            
        }
        System.out.println(men);
        men="";
        System.out.println("Tercero\n");
        int cont=1;
        for(int f=0;f<mat.length;f++,cont++){
            for(int c=0;c<mat[f].length;c++){
                if(c<mat.length-cont){
                    mat[f][c]=0;
                }else{
                    mat[f][c]=1;
                }
                men=men+mat[f][c]+"\t";
            }
            men=men+"\n";
        }
        System.out.println(men);
        men="";
        System.out.println("Cuarto\n");
        cont=0;
        for(int f=0;f<mat.length;f++,cont++){
            for(int c=0;c<mat[f].length;c++){
                if(c<mat.length-cont){
                    mat[f][c]=1;
                }else{
                    mat[f][c]=0;
                }
                men=men+mat[f][c]+"\t";
            }
            men=men+"\n";
        }
        System.out.println(men);
        men="";
        System.exit(0);  
    }
    
}
