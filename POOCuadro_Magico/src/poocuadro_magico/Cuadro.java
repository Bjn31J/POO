package poocuadro_magico;
public class Cuadro {
    int [][] matriz;
    public void set_Cuadro(int[][] cuadro)
    {
         this.matriz=cuadro;
    }
    public void obtener_CuadroMagico()
    {
        int n=matriz.length;
        int fil=0,col=n/2;
        int num=1;
        int f,c;
        while(num<=n*n)
        {
            matriz[fil][col]=num;
            num++;
            f=fil;
            c=col;
            fil=fil-1;
            col=col+1;
            if(fil==-1)
            {
                fil=n-1;
            }
            if(col==n)
            {
                col=0;
            }
            if(matriz[fil][col]!=0)
            {
                fil=f+1;
                col=c;
            }
        }
    }
    public String suma_CuadroMagico()
    {
        int n=matriz.length;
        int sr,sc,sdp = 0,sdi=0;
        String suma="\tSuma de cuadro magico\t\n";
        String sumaC="";
        for(int i=0;i<n;i++)
        {
            sr=0;
            sc=0;
            suma=suma+"Suma Renglon   "+i+"\t";
            for(int k=0;k<n;k++)
            {
                sr=sr+matriz[i][k];
                sc=sc+matriz[k][i];
                suma=suma+matriz[i][k]+"\t";
                if(i==k)
                {
                    sdp=sdp+matriz[i][k];
                }
                if((k+i)==(n-1))
                {
                    sdi=sdi+matriz[i][k];
                }                       
            }
           suma=suma+sr+"\n";
           sumaC=sumaC+sc+"\t";
        }
        suma=suma+"\nSuma Diagonal "+sdi+"\t"+sumaC+sdp;
        return suma;
    }
    public String imprimir_Cuadro(int[][] cuadro)
    {
        String res="\tCuadro Magico\n";
        for (int[] cuadro1 : cuadro) {
            for (int k = 0; k < cuadro1.length; k++) {
                res = res + cuadro1[k] + "   \t";  
            }
            res=res+"\n";   
        }
        return res;
    }
}
