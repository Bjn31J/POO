
package boletapoo;

import java.util.Scanner;


public class BoletaPOO {

    
    public static void main(String[] args) {
        int cre1,cre2,cre3;
        int Tcre;
        Scanner sc= new Scanner(System.in);
        
        Alumno alm= new Alumno();
        alm.ingresar_DatosAlumno(sc);
        
        Materia mat1= new Materia();
        Materia mat2= new Materia();
        Materia mat3= new Materia();
        mat1.ingresar_DatosMateria(sc);
        mat2.ingresar_DatosMateria(sc);
        mat3.ingresar_DatosMateria(sc);
        
        cre1=mat1.creditos;
        cre2=mat2.creditos;
        cre3=mat3.creditos;
        
        Tcre=cre1+cre2+cre3;
        System.out.println("CARGA DE MATERIAS");
        System.out.println("----------------------------");
        alm.mostrar_DatosAlumno();
        System.out.println("-----------------------------");
        System.out.println("CLAVE MATERIA\t\tNOMBRE DE LA MATERIA\t\tCREDITOS");
        System.out.println("---------------------------------------------------");
        mat1.mostrar_DatosMateria();
        mat2.mostrar_DatosMateria();
        mat3.mostrar_DatosMateria();
        System.out.println("----------------------------------------------------");
        System.out.println("Total de creditos "+ Tcre);
        
    }
    
}
