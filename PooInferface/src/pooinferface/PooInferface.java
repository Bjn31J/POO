package pooinferface;
import java.util.LinkedList;
public class PooInferface {
       public static void main(String[] args) {
       LinkedList<String>Fruta=new LinkedList<>();
       Fruta.add("Manzana"); Fruta.add("Durazno");
       LinkedList<Double>pFruta=new LinkedList<>();
       pFruta.add(19.50);pFruta.add(15.0);
       LinkedList<Double>Kfruta=new LinkedList<>();
       Kfruta.add(2.5); Kfruta.add(3.0);
        Interface<LinkedList<Double>>lambda;
        lambda=(a,b)->{
             double mul;
             int i=0;
             LinkedList<Double>ld=new LinkedList<>();
             for(Double d:a){
                 mul=d*b.get(i++);
                
                 ld.add(mul);
             }
            return ld;  
        };
        LinkedList<Double> resp=lambda.mul(pFruta,Kfruta);
           System.out.println("\nFruta "+Fruta);
           System.out.println("\nPrecio "+pFruta);
           System.out.println("\nKilos solicitados "+Kfruta);
           System.out.println("\nPrecio a pagar por los kilos "+resp);
    }
}
