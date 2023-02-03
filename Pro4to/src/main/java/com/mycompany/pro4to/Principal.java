  package com.mycompany.pro4to;
import com.mycompany.pro4to.Materias;
import com.mycompany.pro4to.Inscripciones;
import com.mycompany.pro4to.Alumno;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
/*
Carla Itzel Tierrablanca Rojas 20031602
Benjamin Jaramillo Nava 20030835
Velazquez Reyes Jair 20030039
*/

public class Principal {
    public static void main(String [] args) throws IOException{
    Principal obj=new Principal();
    obj.ShowMenu();
    
    }
   public void opciones(int a) throws IOException{
       
       
           
       switch (a){
           case 1:
               Alumno obj=new Alumno();
               obj.ShowMenu();
               break;
           case 2:
               Materias obj1=new Materias();
               obj1.ShowMenu();
               // aqui va objeto  materias
               break;
           case 3:
               Inscripciones obj2= new Inscripciones();
               obj2.InscripcionesOpciones();
               // aqui va objeto InscripcionesOpciones
               break;
           case 4:
               Reportes mo=new Reportes();
               mo.ShowMenu();
               break;
           case 5:
               System.exit(0);
           default:
               JOptionPane.showMessageDialog(null, "Esa opcion no existe por favor de ingresar una valida");
              
       }
       
     
   }
 public void  ShowMenu() throws IOException{
        //creo un arreglo con las opciones
        int option=0;
        do{
        String[] Menu= new String[5];
        Menu[0]="1-Alumnos";
        Menu[1]="2-Materias";
        Menu[2]="3-Inscripciones";
        Menu[3]="4-Reportes";
        Menu[4]="5-Salir del programa";
        //y mando llamar al metodo showarray que me regresa 
        //el menu 
        String MyMenu=ShowArray(Menu);
        // lo unico que hago es pedir la opcion al usuario
        
        option=parseInt(JOptionPane.showInputDialog(null,MyMenu));
        opciones(option);
        }while(option!=4);
        // y esta se la mando al main
    }
     public String  ShowArray(String [] Menu){
     String ShowMyMenu="";
     for(int i=0; i<Menu.length; i++)
           ShowMyMenu+=Menu[i]+"\n";    
           return  ShowMyMenu;
    }
    
 
}
