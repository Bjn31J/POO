package com.mycompany.pro4to;


import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;

public class Menu {
    public int  ShowMenu(){
        //creo un arreglo con las opciones
        String[] Menu= new String[6];
        Menu[0]="1-Alta de Alumnos";
        Menu[1]="2-Buscar";
        Menu[2]="3-Modificar";
        Menu[3]="4-Reporte";
        Menu[4]="5-Regresar al menu principal";
        Menu[5]="6-Salir del programa";
        //y mando llamar al metodo showarray que me regresa 
        //el menu 
        String MyMenu=ShowArray(Menu);
        // lo unico que hago es pedir la opcion al usuario
        int option=parseInt(JOptionPane.showInputDialog(null,MyMenu));
        // y esta se la mando al main
        return option;
   
    }
     public String  ShowArray(String [] Menu){
     String ShowMyMenu="";
        int option=0;
     for(int i=0; i<Menu.length; i++)
           ShowMyMenu+=Menu[i]+"\n";
           return  ShowMyMenu;
    }
    
    void opciones(){
    
    }
}
