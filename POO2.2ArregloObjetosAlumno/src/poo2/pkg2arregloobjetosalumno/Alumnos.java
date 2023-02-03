
package poo2.pkg2arregloobjetosalumno;
import javax.swing.JOptionPane;
public class Alumnos {
    String [] nombreAl;
    int [] numeroCtrl;
            
    public void setNumeroCtrl(int arrNumC[]){
      this.numeroCtrl = arrNumC;
    }
     
    public void setNombre(String arrNombre[]){
      this.nombreAl = arrNombre;
    }
      
    public void cargar_Arreglos( )
    {
        for(int i=0;i<numeroCtrl.length;i++)
        {
            numeroCtrl[i]=Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de control del alumno"));
            nombreAl[i]=JOptionPane.showInputDialog("Digite el nombre del alumno"+ numeroCtrl[i]);
        }
    }
   
   public  String mostrar_Arreglos()
    {
        String s="Numero de control \tNombre del alumno\n";
        System.out.println("Datos alumnos");
         for(int i=0;i<numeroCtrl.length;i++)   
         {
             s+=numeroCtrl[i]+"       \t\t"+nombreAl[i]+"   \t\t\n";
         }
         
         return s;
    }
   public void ordenar_NumCrtl()
   {
       int auxl;
       String auxS;
       for(int pas=1;pas<numeroCtrl.length;pas++)
       {
           for(int com=1;com<=(numeroCtrl.length)-pas;com++)
           {
               if(numeroCtrl[com-1]>numeroCtrl[com])
               {
                   auxl=numeroCtrl[com-1];
                   numeroCtrl[com-1]=numeroCtrl[com];
                   numeroCtrl[com]=auxl;
                   
                   auxS=nombreAl[com-1];
                   nombreAl[com-1]=nombreAl[com];
                   nombreAl[com]=auxS;  
               }
           }
       }
   }
   public void ordenar_Nombre()
   {
       int auxl;
       String auxS;
       for(int pas=1;pas<nombreAl.length;pas++)
       {
           for(int com=1;com<=(nombreAl.length)-pas;com++)
           {
               if(nombreAl[com-1].compareTo(nombreAl[com])>0)
               {
                   auxS=nombreAl[com-1];
                   nombreAl[com-1]=nombreAl[com];
                   nombreAl[com]=auxS;
                   
                   auxl=numeroCtrl[com-1];
                   numeroCtrl[com-1]=numeroCtrl[com];
                   numeroCtrl[com]=auxl;  
               }
           }
       } 
   }
       
   public void buscar_Alumno()
   {
       int buscar= Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de control a buscar: "));
       int cont=0;
       while(cont<numeroCtrl.length-1 && numeroCtrl[cont]!=buscar)
       {
           cont++;
       }   
       if(numeroCtrl[cont]==buscar)
       {
           JOptionPane.showInputDialog("EL alumno: "+ buscar + " Si existe");
       }else 
       {
           JOptionPane.showInputDialog("EL alumno: "+ buscar + " No existe");
       }
   }
   }
     

    

