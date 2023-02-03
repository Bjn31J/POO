package com.mycompany.pro4to;


import com.mycompany.pro4to.Principal;
import com.mycompany.pro4to.Materias;
import com.mycompany.pro4to.Inscripciones;
import com.mycompany.pro4to.Alumno;
import java.io.IOException;
import java.io.RandomAccessFile;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LGWID
 */
public class Reportes {
     public void  ShowMenu() throws IOException{
        //creo un arreglo con las opciones
        int option=0;
        do{
        String[] Menu= new String[6];
        Menu[0]="1-GENERAR REPORTE ALUMNOS";
        Menu[1]="2-GENERAR REPORTE MATERIAS";
        Menu[2]="3-GENERAR REPORTE INSCRIPCIONES";
        Menu[3]="4-GENERAR REPORTE CARGA ACADEMICA";
        Menu[4]="5-Regresar al menu principal";
        Menu[5]="6-Salir del programa";
        //y mando llamar al metodo showarray que me regresa 
        //el menu 
        String MyMenu=ShowArray(Menu);
        // lo unico que hago es pedir la opcion al usuario
        
         option=parseInt(JOptionPane.showInputDialog(null,MyMenu));
         opciones(option);
        }while(option!=5);
        // y esta se la mando al main
        
   
    }
        public void opciones(int a) throws IOException{
       switch (a){
           case 1:
               Alumno obj=new Alumno();
               obj.Reporte();
               break;
           case 2:
               Materias obj1=new Materias();
               obj1.Reporte();
               // aqui va objeto  materias
               break;
           case 3:
               Inscripciones obj2= new Inscripciones();
               RandomAccessFile k;
               k=new RandomAccessFile("Inscripciones.dat","rw");
               obj2.ReporteIncripciones(k);
               // aqui va objeto InscripcionesOpciones
               break;
           case 4:
               Inscripciones obj3= new Inscripciones();
               RandomAccessFile k1;
               k1=new RandomAccessFile("Inscripciones.dat","rw");
               obj3.ReporteCargarAcademica(k1);
               break;
           case 5:
               Principal oj=new Principal();
               oj.ShowMenu();
               break;
           case 6: 
               System.exit(0);
               break;
           default:
               JOptionPane.showMessageDialog(null, "Esa opcion no existe por favor de ingresar una valida");
              
       }
       
     
   }
     public String  ShowArray(String [] Menu){
     String ShowMyMenu="";
     for(int i=0; i<Menu.length; i++)
           ShowMyMenu+=Menu[i]+"\n";    
           return  ShowMyMenu;
    }
    
}
