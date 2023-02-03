
package pooexamen3;

import java.util.Scanner;


class Combustion extends Vehiculo{
int cilindrada;
    
    public void capturar(Scanner sc) 
    {
       System.out.println("Digite el color del vehiculo");
       color=sc.next();
       System.out.println("Digite el modelo del vehiculo");
       modelo=sc.next();
       System.out.println("Digite el precio del vehidulo");
       precio=sc.nextDouble();
    }
    
     public void calcularImpuesto(Scanner sc)
    {
        System.out.println("Digite la cilindrada");
        cilindrada=sc.nextInt();
        impuesto = cilindrada*3;
        precioImpuesto=precio+impuesto;
    }
     
     public String mostrar() 
    {
        String v="\nVehiculo combustion";
        v=v+super.mostrar();
        return v;
    }
    
}
