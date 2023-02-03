
package poo_herencia;

import java.util.Scanner;


class Alumno extends Persona {
 String noCtrl, Especialidad;
void leerDatos (Scanner sc)
{
super.leerDatos(sc);
//leerDatos(); // NO FUNCIONA
System.out.println("Digite su numero de control");
noCtrl=sc.nextLine();
sc.nextLine();
System.out.println("Digite su especialidad");
Especialidad=sc.nextLine();
sc.nextLine();
}
String mostrarDatos()
{
String aux;
aux="   "+noCtrl+"  "+Especialidad;
aux=super.mostrarDatos()+aux;
return aux;
}

    

}

