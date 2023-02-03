
package poophone;

import java.util.ArrayList;



public class POOphone {
      ArrayList<Phone> list= new ArrayList<>();
        public static void main(String[] args) {
       ArrayList<Phone> list= new ArrayList<>();
       Phone P1= new Phone("Xiaomi","MI 8 Lite","2018",3999);
       Phone P2= new Phone("Motorola","Moto G5 Plus","2016",8000);
       Phone P3= new Phone("Apple","iPhone 13","2021",17999);
       list.add(P1);
       list.add(P2);
       list.add(P3);
            System.out.println(P1.retrieve());
       
        
    }}
        
   
 