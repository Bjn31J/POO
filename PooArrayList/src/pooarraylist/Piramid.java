package pooarraylist;
public class Piramid {
    int lado,altura;
    public Piramid(int lado, int base) {
        this.lado = lado;
        this.altura = base;
    }
    public int getLado() {
        return lado;
    }
    public void setLado(int lado) {
        this.lado = lado;
    }
    public int getBase() {
        return altura;
    }
    public void setBase(int base) {
        this.altura = base;
    }
    public double calcularArea()
    {
        double A;
        A=(lado+Math.sqrt((4*altura*altura)+(lado*lado)))*lado;
        
        return A;
    }
    public double calcularVolumen()
    {
        double V;
        V=((lado*lado)*altura)/3;
        return V; 
    }
}
