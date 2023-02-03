
package poot1;
public class PooT1 {
    public static void main(String[] args) {
       Elemento e1,e2;
       e1=new Elemento("Oxigeno",8, (float) 15.99);
       e2=new Elemento("Litio",3, (float) 6.94);
       System.out.println("Elemento1: "+e1.getNombreEle()+"\nNumero atomico: "+e1.getNumeroAto()+"\nMasa Atomica: "+e1.getMasa());
       System.out.println("\nElemento2: "+e2.getNombreEle()+"\nNumero atomico: "+e2.getNumeroAto()+"\nMasa Atomica: "+e2.getMasa());
       
       e1.setnombreEle("Boro");
       System.out.println("Elemento1: "+e1.getNombreEle());
       e1.setNumeroAto(5);
       System.out.println("Numero atomico: "+e1.getNumeroAto());
       e1.setMasa((float) 10.81);
       System.out.println("Masa Atomica: "+e1.getMasa());   
    }
}
