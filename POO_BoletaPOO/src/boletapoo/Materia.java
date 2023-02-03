
package boletapoo;

import java.util.Scanner;


class Materia {
    String clave_Materia;
    String nombre_Materia;
    byte creditos;
    public Materia()
    {
        clave_Materia= "";
        nombre_Materia= "";
        creditos=0;
    }
    
    void ingresar_DatosMateria(Scanner sc)
    {
        String clvM,nomM;
        byte cre;
        
        System.out.println("Digite la clave de la Materia: ");
        clvM=sc.next();
        System.out.println("Digite su nombre de la Materia: ");
        nomM=sc.next();
        System.out.println("Digite los creditos de la Materia: ");
        cre=sc.nextByte();
        
        clave_Materia=clvM;
        nombre_Materia=nomM;
        creditos=cre;
    }
    void mostrar_DatosMateria(){
        System.out.println(clave_Materia+"\t\t"+nombre_Materia+"\t\t"+creditos);
        
    }
}
