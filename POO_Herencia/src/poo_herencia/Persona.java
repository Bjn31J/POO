
package poo_herencia;
import java.util.Scanner;
class Persona {
    String nombre;
      byte edad;
void leerDatos(Scanner sc)
{
System.out.println("Digite el nombre de la persona");
nombre=sc.nextLine();
sc.nextLine();
System.out.println("Digite la edad de la persona");
edad=sc.nextByte();
}
String mostrarDatos()
{
String aux= nombre + " " + edad;
return aux;
}
    
}
