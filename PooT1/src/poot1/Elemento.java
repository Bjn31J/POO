package poot1;
public class Elemento 
{
    String nombreEle;
    int numeroAto;
    float masa;
    Elemento(String a,int b,float c)
    {
        nombreEle=a;
        numeroAto=b;
        masa=c; 
    }
    public int getNumeroAto() {
        return numeroAto;
    }
    public void setNumeroAto(int numeroAto) {
        this.numeroAto = numeroAto;
    }
    public float getMasa() {
        return masa;
    }
    public void setMasa(float masa) {
        this.masa = masa;
    }
    String getNombreEle()
    {
        return nombreEle;
    }
    void setnombreEle(String t)
    {
        nombreEle=t;
    }
}
