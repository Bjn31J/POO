package poo_jerarquiaclases;
import java.util.Scanner;
public class POO_JerarquiaClases {
    public static void main(String[] args) {
        GUI gui=new GUI();
       Scanner sc=new Scanner(System.in); 
       String[] option = new String[4];
      
       option[0] = " Archivo Alumno ";
       option[1] = " Archivo Maestro";
       option[2] = " Archivo Materia";
       option[3] = " Salir";
      
       int opSelected=0;
       Alumno obj= new Alumno();
       Maestros obj1= new Maestros();
       Materias obj2= new Materias();
       
       String [] opcion = new String[7];
       opcion[0] = " Capturar ";
       opcion[1] = " Ordenar ";
       opcion[2] = " Buscar ";
       opcion[3] = " Modificar ";
       opcion[4] = " Consultar ";
       opcion[5] = " Reporte ";
       opcion[6] = " Salir ";
       int opSelected2=0;

       gui.desplegarMensaje("Digite el numero del archivo que desea consultar");
         do{
             opSelected=gui.seleccionarOpcion(option, "Manejo de archivos");
        switch (opSelected){
            case 1:
                gui.desplegarMensaje("Se seleccionó: Archivo Alumno ");
                gui.desplegarMensaje("Digite el numero de lo que desea hacer con el archivo");
                do{
                    opSelected2=gui.seleccionarOpcion(opcion, "Menu alumno");
                switch(opSelected2){
                    case 1:
                        gui.desplegarMensaje("Se seleciono: Capturar ");
                        obj.capturar();
                        
                        break;
                    case 2:
                        gui.desplegarMensaje("Se seleciono: Ordenar ");
                        obj.ordenar();
                        
                        break;
                    case 3:
                        gui.desplegarMensaje("Se seleciono: Buscar ");
                        obj.buscar();
                        
                        break;
                    case 4:
                        gui.desplegarMensaje("Se seleciono: Modificar ");
                        obj.modificar();
                        
                        break;
                    case 5:
                        gui.desplegarMensaje("Se seleciono: Consultar ");
                        obj.consultar();
                        
                        break;
                    case 6:
                        gui.desplegarMensaje("Se seleciono: Reporte ");
                        obj.reporte();
                        
                        break;
                    case 7:
                        gui.desplegarMensaje("Usted a salido del archivo alumno ");
                        
                        break;
                    default:
                        gui.desplegarMensaje("No corresponde a ninguna opcion ");     
                }}while(opSelected2 !=7);
                break;
            case 2:
                gui.desplegarMensaje("Se seleccionó: Archivo Maestro");
                gui.desplegarMensaje("Digite el numero de lo que desea hacer con el archivo");
                do{
                    opSelected2=gui.seleccionarOpcion(opcion, "Menu Maestro");
                switch(opSelected2){
                    case 1:
                        gui.desplegarMensaje("Se seleciono: Capturar ");
                        obj1.capturar();
                        
                        break;
                    case 2:
                        gui.desplegarMensaje("Se seleciono: Ordenar ");
                        obj1.ordenar();
                        
                        break;
                    case 3:
                        gui.desplegarMensaje("Se seleciono: Buscar ");
                        obj1.buscar();
                        
                        break;
                    case 4:
                        gui.desplegarMensaje("Se seleciono: Modificar ");
                        obj1.modificar();
                        
                        break;
                    case 5:
                        gui.desplegarMensaje("Se seleciono: Consultar ");
                        obj1.consultar();
                        
                        break;
                    case 6:
                        gui.desplegarMensaje("Se seleciono: Reporte ");
                        obj1.reporte();
                        
                        break;
                    case 7:
                        gui.desplegarMensaje("Usted a salido del archivo Maestro ");
                        
                        break;
                    default:
                        gui.desplegarMensaje("No corresponde a ninguna opcion ");     
                }}while(opSelected2 !=7);
                break;
                
            case 3:
                gui.desplegarMensaje("Se seleccionó: Archivo Materia");
                gui.desplegarMensaje("Digite el numero de lo que desea hacer con el archivo");
                do{
                    opSelected2=gui.seleccionarOpcion(opcion, "Menu Materia5"
                            + "");
                switch(opSelected2){
                    case 1:
                        gui.desplegarMensaje("Se seleciono: Capturar ");
                        obj2.capturar();
                        
                        break;
                    case 2:
                        gui.desplegarMensaje("Se seleciono: Ordenar ");
                        obj2.ordenar();
                        
                        break;
                    case 3:
                        gui.desplegarMensaje("Se seleciono: Buscar ");
                        obj2.buscar();
                        
                        break;
                    case 4:
                        gui.desplegarMensaje("Se seleciono: Modificar ");
                        obj2.modificar();
                        
                        break;
                    case 5:
                        gui.desplegarMensaje("Se seleciono: Consultar ");
                        obj2.consultar();
                        
                        break;
                    case 6:
                        gui.desplegarMensaje("Se seleciono: Reporte ");
                        obj2.reporte();
                        
                        break;
                    case 7:
                        gui.desplegarMensaje("Usted a salido del archivo Materia ");
                        
                        break;
                    default:
                        gui.desplegarMensaje("No corresponde a ninguna opcion ");     
                }}while(opSelected2 !=7);
                break;
                           
            case 4:
                gui.desplegarMensaje("Usted a salido de la aplicación");
                break;
            default:
                gui.desplegarMensaje("No corresponde a ninguna opcion");
    }} while( opSelected !=4);
    }}
    

