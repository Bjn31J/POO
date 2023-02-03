package pooarraylist;
import java.util.ArrayList;
public class PooArrayList {
    public static void main(String[] args) { 
        ArrayList<Piramid>arr1;
        arr1 = new ArrayList<>();
        arr1.add(new Piramid(2,4));
        arr1.add(0,new Piramid (5,4));
        arr1.add(new Piramid(7,4));
        calculaVol(arr1); 
        System.out.println(" ");
        calculaArea(arr1);
    }
    static void calculaVol(ArrayList<Piramid>f)
    {
        for(Piramid p1:f)
        {
            p1.calcularVolumen();
            System.out.println("Volumen= " + p1.calcularVolumen());
        }
    }
    static void calculaArea(ArrayList<Piramid>f){
        for(Piramid p1:f)
        {
            p1.calcularArea();
            System.out.println("Area= "+ p1.calcularArea());
        }
    } 
}

