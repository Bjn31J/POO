
package pooexamen3;

import java.util.Scanner;


abstract class Vehiculo 
{
    String color;
    String modelo;
    double precio;
    double impuesto;
    double precioImpuesto;
    public abstract void capturar(Scanner sc);
    public abstract void calcularImpuesto(Scanner sc);
    public String  mostrar()
    {
        String s;
        s="\nColor: "+color+"\nModelo: "+modelo+"\nPrecio: "+precio+"\nImpuesto: "+impuesto+
                "\nEl precio con impuesto es: "+precioImpuesto+"\n";
        return s;
    }
}
