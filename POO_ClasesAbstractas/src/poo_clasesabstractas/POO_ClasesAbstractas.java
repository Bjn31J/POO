
package poo_clasesabstractas;
public class POO_ClasesAbstractas {
    static void afinar(Instrumento i)
    { 
         i.tocar();
    }
    static void afinarTodo(Instrumento[] e)
    {
       for(int i = 0; i < e.length; i++)
    {
   System.out.println("Es un instrumento de tipo: "+e[i].tipo());
    afinar(e[i]);
    }
    }
    public static void main(String[] args) {
       Instrumento[] orquesta = new Instrumento[5];
       int i = 0;
       orquesta[i++] = new Guitarra();
       orquesta[i++] = new Piano();
       orquesta[i++] = new Saxofon();
       orquesta[i++] = new Guzla();
       orquesta[i++] = new Ukelele();
       afinarTodo(orquesta);
       orquesta[3].afinar();
    } 
}
