
package potenciaspooexamen;

import java.util.Scanner;


public class PotenciasPOOExamen {

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Numeros num=new Numeros();
        num.ingresar_Datos(sc);
        num.calcular_Exponente();
        num.mostrar_Potencia();
    }
    
}
