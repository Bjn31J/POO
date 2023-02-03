
package acvidad1.pkg1boleta;

import java.util.Scanner;


public class Acvidad11Boleta {

    
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       Alumno alu= new Alumno();
       Materia mat= new Materia();
       alu.leer_DatosAlumno(sc);
       mat.leer_DatosMateria(sc);
       alu.mostrar_DatosAlumno();
       mat.mostrar_DatosMateria();
       
      
    }
    
}
class Alumno
{
    String nombre,nroCtrol;
    byte semestre;
    
    void leer_DatosAlumno(Scanner sc)
    {
        System.out.println("Teclea el nombre del alumno");
        nombre = sc.nextLine();
        System.out.println("Teclea Número de control del alumno");
        nroCtrol = sc.nextLine();
        System.out.println("Teclea el semestre");
        semestre = sc.nextByte();
    }
    void mostrar_DatosAlumno()
    {
        System.out.println("Carga de Materias");
        System.out.println("--------------------------------");
        System.out.println("Numero de control: " + nroCtrol);
        System.out.println("Nombre: " + nombre);
        System.out.println("Semestre: " + semestre);
        
    }
}
class Materia
{
    String clav_Materia, nom_Materia;
    byte creditos;
    int numero_Materias=0;
    int Total;
    int count=0;
    void leer_DatosMateria(Scanner sc)
    {
     
        System.out.println("Digite el numero de materias a ingresar");
        numero_Materias=sc.nextInt();
        for(int i = 1; i<=numero_Materias;i++)
        {
            System.out.println("Digite la clave de la materia");
            clav_Materia = sc.next();
            
            
            System.out.println("Digite el nombre de la materia");
            
            nom_Materia= sc.next();
            
            System.out.println("Digite los créditos de la materia");
            creditos= sc.nextByte();
            
            Total += creditos;
           
            count ++;
            
        }
        
        
    }
    
    void  mostrar_DatosMateria()
    {
        System.out.println("CLAVE MATERIA \t "+ " NOMBRE  \t"+"CRÉDITOS");
        for(int i = 1; i<=count;i++)
        {
        System.out.println( clav_Materia+"\t\t\t"+nom_Materia+"\t\t"+creditos);
        }
        System.out.println("El total de creditos es : " + Total);
    
    }
}