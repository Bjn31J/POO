
package poo_herencia;

import java.util.Scanner;


class AlumoDep extends Alumno {
String deporte;
double estatura,peso;
void leerDatos(Scanner sc)
{
super.leerDatos(sc);
System.out.println("Digite el deporte que practica");
deporte=sc.next();
System.out.println("Digite su peso");
peso=sc.nextDouble();
System.out.println("Digite su estatura");
estatura=sc.nextDouble();
}
 public String mostrarDatos()
{
String aux;
aux="  "+deporte +"  "+"  "+peso+"  "+ estatura;
aux=super.mostrarDatos()+aux;
return aux;  
}
}
