package pooherencia;
public class Lacteo extends Producto {
    
    String departament;
    
    public Lacteo(String departament, String name, double price,String clve) {
        super(name,price,clve);
        this.departament = departament;
    }
    public Lacteo (String depa)
    {  
        super("Yogurt",0.0,"LLA8");
        this.departament = depa;
    }
    @Override
    public String toString() {
       
        return name+"  "+getPrice()+" Lacteo:  Departament=" + departament ;

    }
    @Override
    public String getDetails() {
        return super.getDetails() + "\nDepartment: " + departament;
    }//getDetails
    
    public void Descuento(double des){
        double newDes = getPrice()*(1.0 -des);
        setPrice(newDes);    
    }
    public void Descuento()
     {
       double newDes = getPrice()*(1.0 -0.1);
        setPrice(newDes);   
     }

    



    
    
        
    
    
    
}
