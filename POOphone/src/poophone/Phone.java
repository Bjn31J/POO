
package poophone;
import java.util.ArrayList;
public class Phone {
  
    String brand,model,date;
    int price;
    ArrayList<Phone> list= new ArrayList<>();

    public Phone(String brand, String model, String date, int price) {
        this.brand = brand;
        this.model = model;
        this.date = date;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
     void registrer(String brand,String model,String date,int price)
  {
      Phone P1=new Phone(brand,model,date,price);
      list.add(P1);
  }
  String retrieve()
  {
      String brands="";
      for(int i=0;i<list.size();i++)
      {
        brands = brands + list.get(i).getBrand()+" | "+
                list.get(i).getModel()+" | "+list.get(i).getDate()+" | "+
                list.get(i).getPrice()+ "\n";
  }
      return brands;
  }
}

    

