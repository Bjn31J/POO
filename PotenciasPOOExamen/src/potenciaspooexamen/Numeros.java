
package potenciaspooexamen;

import java.util.Scanner;


public class Numeros {
    int base;
    int exponente;
    double potencia;
    public Numeros()
    {
        base=0;
        exponente=0;
        potencia=1;
    }
    void ingresar_Datos(Scanner sc)
    {
        System.out.println("Digite su numero base:");
        base=sc.nextInt();
        System.out.println("Digite su potencia");
        exponente=sc.nextInt();
    }
    
    void calcular_Exponente()
    {   
        if (exponente == 0)
            {
                potencia = 1;
            }
        if (exponente > 0)
        {
            for (int i = 0; i < exponente; i++)
            {
                potencia *= base;
            }    
        }
        if (exponente < 0)
        {
            for (int i = 0; i < -exponente; i++) 
            {
                potencia *= base;
            }
            potencia = 1/potencia;
        }
    }
    
    void mostrar_Potencia()
    {
        System.out.println(base+"^"+exponente+ " = "+ potencia);
    }
    
    }
        
        
                
        
        
        
        
            
        
            
        
    
    
    
    
     
    
    
   
        


