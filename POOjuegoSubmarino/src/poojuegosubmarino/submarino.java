
package poojuegosubmarino;
import java.util.Scanner;
import javax.swing.JOptionPane;
class submarino {
    int [][] tableroOriginal;
    int cont=0;
    int cont2=0;
    public void setTableroOriginal(int arrTO[][])
  {
      this.tableroOriginal = arrTO;
  }
  public void generar_Submarino()//0 si no hay submarino 1 si hay submarino
  {
      
      for(int i=0;i<tableroOriginal.length;i++)
      {
          for(int j=0;j<tableroOriginal.length;j++)
          {
              if(cont<5)
              {
                  int aleatorio=(int)(Math.random()*2);
                  if(aleatorio==1)
                  {
                      cont++;
                  }
                  tableroOriginal[i][j]=aleatorio;
              }
              else tableroOriginal[i][j]=0;
          }
      }
  }
  public void imprimir_Tablero(int[][] tabla)
    {
        String res="Juego Submarino\n";
        for(int i=0;i<tabla.length;i++)   
        {
            for(int k=0;k<tabla[i].length;k++)    
            {
                res=res+tabla[i][k]+"   \t";  
            }
            res=res+"\t \n";   
        }
        System.out.println(res);
    }
    public void ingresar_Coordenadas(Scanner sc)
    {
       int r,c ;
       int verificacion=0; 
       System.out.println("Digite sus coordenadas");
        do{
        System.out.println("Digite su primera coordenada en x del 0 al 4");
        r=sc.nextInt();
        System.out.println("Digite su segunda coordenada en y del 0 al 4");
        c=sc.nextInt();
        if(r<5&&r>=0&&c<5&&c>=0){
            verificacion=1;
        if(cont2<=cont){
             if(tableroOriginal[r][c]==1)
             {
              System.out.println("\n¡¡Se destruyo un submarino!!\n");
              tableroOriginal[r][c]=0; 
              cont2+=1;
             }else
             {
               System.out.println("\n¡¡NO se  destruyo un submarino!!\n");
             } 
        }
        }else JOptionPane.showInputDialog("La coordenada ingresada no existe\nDigitar de nuevo las coordenadas del 0 al 4");
        sc.nextLine();
        }while(verificacion==0);
        
    }
    public Boolean verificar_Juego(){
        boolean verificar=false;
        int cont3=0;
        for(int i=0; i<tableroOriginal.length; i++){
            for(int j=0; j<tableroOriginal.length; j++){
                if(tableroOriginal[i][j]==1)
                    cont3++;
                if(cont3>0){
                  verificar=false;
                }else{
                  verificar=true;
                }
            }
        }
    return verificar;
   }
   public void estado_del_juego(){
         if(verificar_Juego()==true){
            JOptionPane.showMessageDialog(null, "Ganaste destruiste todos los submarinos");
        }else{JOptionPane.showMessageDialog(null, "Perdiste se te acabaron los intentos");}
   }
}
