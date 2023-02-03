
package poo_interfaces;
abstract class Triangulo implements FigGeo{
    double area,perimetro;
    public abstract void capturar();
    public String mostrar()
    {
        String s;
        s="El area del triangulo es: "+area+"\nEl perimetro del triangulo es: "+perimetro;
        return s; 
     }
    public abstract void calcular();
}
