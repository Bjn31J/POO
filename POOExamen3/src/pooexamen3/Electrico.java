
package pooexamen3;

import java.util.Scanner;


 class Electrico extends Vehiculo {
     String modelo_bateria;

    public void capturar(Scanner sc) 
    {
        System.out.println("Digite el color del vehiculo");
        color=sc.next();
        System.out.println("Digite el modelo del vehiculo");
        modelo=sc.next();
        System.out.println("Digite el precio del vehiculo");
        precio=sc.nextDouble();
       
    }
    public void calcularImpuesto(Scanner sc)
    {
        impuesto=precio*0.09;
        precioImpuesto=precio+impuesto;
        
    }
    public String mostrar() 
    {
        String v="\nVehiculo electrico";
        v=v+super.mostrar();
        return v;
        
    }
}
