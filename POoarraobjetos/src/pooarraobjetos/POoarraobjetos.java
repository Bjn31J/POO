
package pooarraobjetos;
public class POoarraobjetos {
    
    public static void main(String[] args) {
        
        Promedios[] array= new Promedios[3]; 
        array[0] = new Promedios("pepe",10,"Cálculo Integral");
        array[1] = new Promedios("Francis",70,"POO");
        
        System.out.println(array[0].showData());
        System.out.println(array[0].toString());
        
        System.out.println(array[1].showData());
        System.out.println(array[1].toString());
    }
    
}
