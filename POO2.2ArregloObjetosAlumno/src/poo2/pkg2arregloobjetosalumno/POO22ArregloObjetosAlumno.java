
package poo2.pkg2arregloobjetosalumno;
public class POO22ArregloObjetosAlumno {
    public static void main(String[] args) {
       GUI gui=new GUI();
       String[] option = new String[6];
      
       option[0] = "Alta de alumnos ";
       option[1] = "Mostrar tabla";
       option[2] = "Ordenar arreglo por numero de control ";
       option[3] = "Ordenar arreglo por nombre ";
       option[4] = "Consulta de datos (Busqueda binaria por numero de control) ";
       option[5] = "Salir";
       
        int opSelected=0;
       
        gui.desplegarMensaje("Bienvenido a la aplicacion Alumno");
        int n = gui.leerAlumno("Digite el numero de alumnos a ingresar: ");
        String [] nombreAl=new String[n];
        int [] numeroCtrl=new int[n];
        Alumnos alm=new Alumnos();
       
         do{
             opSelected=gui.seleccionarOpcion(option, "Arreglo de objetos alumno");
               
        switch (opSelected){
            
            case 1:
              
              gui.desplegarMensaje("Se seleccionó: Alta alumnos ");
              alm.setNombre(nombreAl);
              alm.setNumeroCtrl(numeroCtrl);
              alm.cargar_Arreglos();
              break;
              
            case 2:
               gui.desplegarMensaje("Se seleccionó: Mostrar tabla");
               alm.setNombre(nombreAl);
               alm.setNumeroCtrl(numeroCtrl);
               System.out.println(alm.mostrar_Arreglos());
               break;
               
            case 3:
                gui.desplegarMensaje("Se Seleccionó: Ordenar arreglo por numero de control");
                alm.setNombre(nombreAl);
                alm.setNumeroCtrl(numeroCtrl);
                alm.ordenar_NumCrtl();
                System.out.println(alm.mostrar_Arreglos());
                break;
                
            case 4:
                gui.desplegarMensaje("Se Seleccionó: Ordenar arreglo por nombre");
                alm.setNombre(nombreAl);
                alm.setNumeroCtrl(numeroCtrl);
                alm.ordenar_Nombre();
                System.out.println(alm.mostrar_Arreglos());
                break;
                
            case 5:
                gui.desplegarMensaje("Se Seleccionó: Consulta de Datos");
                alm.setNombre(nombreAl);
                alm.setNumeroCtrl(numeroCtrl);
                alm.buscar_Alumno();
                break;
                
            case 6:
                gui.desplegarMensaje("Usted ha salido de la aplicacion");
                break;
                
            default:
                gui.desplegarMensaje("No corresponde a ninguna opcion");
    }} while( opSelected !=6);
    }}
    

      
    
    

