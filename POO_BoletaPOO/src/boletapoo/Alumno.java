
package boletapoo;

import java.util.Scanner;

class Alumno 
{
    String numero_Control;
    String nombre_Alumno;
    byte semestre;

    public Alumno()
    {
        numero_Control= "";
        nombre_Alumno= "";
        semestre=0;
    }    
    void ingresar_DatosAlumno(Scanner sc)
    {
        String nom,nucrtl;
        byte sem;
        System.out.println("Digite Su numero de control: ");
        nucrtl=sc.nextLine();
        System.out.println("Digite su nombre: ");
        nom=sc.nextLine();
        System.out.println("Digite su semestre");
        sem=sc.nextByte();
        
        numero_Control=nucrtl;
        nombre_Alumno=nom;
        semestre=sem;
        
    }
    void mostrar_DatosAlumno()
    {
        System.out.println
        ("NÚMERO DE CONTROL: "+numero_Control);
        System.out.println
        ("NOMBRE: "+nombre_Alumno);
        System.out.println
        ("SEMESTRE: "+semestre);   
    }
    
    
    
}
