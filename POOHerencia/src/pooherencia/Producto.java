
package pooherencia;

class Producto {
    public String name;
    private double price;
    private String clve;

    public Producto(String name, double price, String clve) {
        this.name = name;
        this.price = price;
        this.clve = clve;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "name=" + name + ", price=" + price+", clve="+clve;
    }
    
    public String getDetails() {
        return "Producto:\n"+"\nName: " + name + "\nPrice: " + price+ "\nclve: "+clve;
    }
    
    

   


}
