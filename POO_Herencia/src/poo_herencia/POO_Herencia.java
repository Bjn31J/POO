
package poo_herencia;

import java.util.Scanner;


public class POO_Herencia {

   
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Persona per=new Persona();
        Alumno alm=new Alumno();
        AlumoDep almd=new AlumoDep();
        
        per.leerDatos(sc);
        System.out.println(per.mostrarDatos());
        alm.leerDatos(sc);
        System.out.println(alm.mostrarDatos());
        almd.leerDatos(sc);
        System.out.println(almd.mostrarDatos());
        
        System.out.println(per.mostrarDatos()+"\n"+alm.mostrarDatos()+"\n"+almd.mostrarDatos());
       
        
    }
    
    
}
