
package pooherencia;


public class POOHerencia {
    public static void main(String[] args) {
        Lacteo lac=new Lacteo("Lacteos","Leche",20.50,"looop");
        System.out.println(lac.getDetails());
        lac.Descuento();
        System.out.println(lac.getDetails());
        lac.Descuento(0.2);
        System.out.println(lac.getDetails());
        Producto pro=lac;
        System.out.println(pro.getDetails());
        
        Lacteo lac2=new Lacteo("Lacteos","Queso",15.50,"gugu");
        System.out.println(lac2.getDetails());
        
    }
    
}
