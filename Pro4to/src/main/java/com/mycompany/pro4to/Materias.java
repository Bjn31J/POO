package com.mycompany.pro4to;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
/*
Carla Itzel Tierrablanca Rojas 20031602
Benjamin Jaramillo Nava 20030835
Velazquez Reyes Jair 20030039
*/


public class Materias{
     private static int Ta=44;
    
    String ClaveMateria, NombreMateria;
    byte Creditos;
    // validar metodo capturar
    private void Capturar(){
        Validar val = new Validar();
        ClaveMateria=JOptionPane.showInputDialog(null,"Ingrese el Clave Materia:");
        while (val.VerificaClaveMateria(ClaveMateria) || val.PalabraVerificar(ClaveMateria)) { //VALIDA SI LA CLAVE DE LA MATERIA ES TAMAÑO 4 Y NO TIENE CARACTERES ESPECIALES
            JOptionPane.showMessageDialog(null, "LA CLAVE DE LA MATERIA DEBE TENER 4 CARACTERES Y NO DEBE TENER CARACTERES ESPECIALES, VUELVA A INGRESAR LA CLAVE POR FAVOR.", "SISTEMA MATERIAS", JOptionPane.WARNING_MESSAGE);

            ClaveMateria = JOptionPane.showInputDialog(null, "Teclea la clave de la materia: (longitud de 4)", "SISTEMA MATERIAS", JOptionPane.QUESTION_MESSAGE);
        }

        ClaveMateria=String.format("%-4s", ClaveMateria);
        
        NombreMateria=JOptionPane.showInputDialog(null,"Ingrese el Nombre de la materia:");
        while (val.validarNombre(NombreMateria, 35) || val.PalabraVerificar(NombreMateria)) { //VALIDA SI EL NOMBRE ES DE TAMAÑO 35 O MENOR Y SI NO CONTIENE CARACTERES ESPECIALES
            JOptionPane.showMessageDialog(null, "EL NOMBRE DE LA MATERIA DEBE DE SER DE 35 CARACTERES O MENOS Y NO DEBE CONTENER CARACTERES ESPECIALES.", "SISTEMA MATERIAS", JOptionPane.WARNING_MESSAGE);

            NombreMateria = JOptionPane.showInputDialog(null, "Teclea el nombre de la materia: (longitud 35)", "SISTEMA MATERIAS", JOptionPane.QUESTION_MESSAGE);
        }
        NombreMateria=String.format("%-35s", NombreMateria);
        
        Creditos=Byte.parseByte(JOptionPane.showInputDialog(null,"Ingrese los creditos"));
        while (val.VerificarNegativo(Creditos) || val.VerificaCreditos(Creditos)) { //VALIDA SI LOS CREDITOS NO SON NEGATIVOS
            JOptionPane.showMessageDialog(null, "LOS CREDITOS DE LA MATERIA NO DEBEN SER NEGATIVOS.\nCREDITOS MINIMOS: 2\nCREDITOS MAXIMOS: 6", "SISTEMA MATERIAS", JOptionPane.WARNING_MESSAGE);

            Creditos = Byte.parseByte(JOptionPane.showInputDialog(null, "Teclea los creditos: ", "SISTEMA MATERIAS", JOptionPane.QUESTION_MESSAGE));
        }
    
    }
 /// ma;ana
private void Modificar(){
        RandomAccessFile AbriCanal;
        String Aux;
        Byte creditos;
        int opc;
        String TraeInfo = null;
        String busca = "";
        Validar val = new Validar();


        try {
            AbriCanal= new RandomAccessFile("Materias.dat", "rw");
            busca = JOptionPane.showInputDialog(null, "Ingrese la clave de la materia");

           // aqui validamos
           while (val.VerificaClaveMateria(busca) || val.PalabraVerificar(busca)) {
                JOptionPane.showMessageDialog(null, "LA CLAVE DE LA MATERIA DEBE TENER 4 CARACTERES Y NO DEBE TENER CARACTERES ESPECIALES, VUELVA A INGRESAR LA CLAVE POR FAVOR.");
                busca = JOptionPane.showInputDialog(null, "Teclea la clave de la materia:");
            }
           
            TraeInfo = Consultar(AbriCanal, busca);
            if (TraeInfo != null) {
                opc = Integer.parseInt(JOptionPane.showInputDialog(null, TraeInfo + "\n¿Qué opción desea modificar?\n1.Nombre de la materia\n2.creditos de la materia\n3.No modificar"));
                switch (opc) {
                    case 1:
                        AbriCanal.seek((AbriCanal.getFilePointer() - Ta)); 
                        AbriCanal.readUTF(); 

                        Aux = JOptionPane.showInputDialog(null, "Ingrese nombre de la materia: ");
                        Aux = String.format("%-40s", Aux);

                        AbriCanal.writeUTF(Aux);


                        break;
                    case 2:
                        
                        AbriCanal.seek((AbriCanal.getFilePointer() - Ta));                        
                        AbriCanal.readUTF();                       
                        
                        creditos = Byte.parseByte(JOptionPane.showInputDialog(null, "Ingrese los creditos de la materia: "));
                        AbriCanal.write(creditos);

                        JOptionPane.showMessageDialog(null, "LOS CREDITOS DE LA MATERIA SE HA MODIFICADO CON EXITO.");

                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "No se modifica el registro.");
                        break;

                }

            } else {
                JOptionPane.showMessageDialog(null, "Información no encontrada, clave de la materia erróneo.");
                System.out.println("No se encontró el registro.");
            }
            AbriCanal.close();
        } catch (IOException e) {
            System.out.println("Ocurrió un error al abrir el archivo \n" + e.toString());
        } catch (NumberFormatException e) {
            System.out.println("Se introdujo un valor no numerico. " + e);
            JOptionPane.showMessageDialog(null, "Se introdujo un valor no numerico. " + e);
        }
    }
    public void Reporte() throws IOException{
        RandomAccessFile LeerArchivo;
        PrintWriter Sale;
        String ClaveMate,NombreMateria;
        Byte Credito;

        //aqui empieza el try
        try{
        LeerArchivo= new RandomAccessFile("Materias.dat","r");
       Sale= new PrintWriter(new FileWriter("C:\\Users\\LGWID\\OneDrive\\Música\\Escritorio\\REPORTES\\MATERIA.txt"));
       Sale.println("\t\t\tREPORTE DE MATERIAS\n\t\t\t\n");
       Sale.println("__________________________________________________________________________________");
       Sale.println(String.format("%-20s%-40s%-1s", "CLAVE DE LA MATERIA", "NOMBRE DE LA MATERIA", "CREDITOS"));
       Sale.println("__________________________________________________________________________________");
        
        LeerArchivo.seek(0);
        int total=(int)(LeerArchivo.length()/Ta);
        for(int i=0; i<total; i++){
            ClaveMate=LeerArchivo.readUTF();
            NombreMateria=LeerArchivo.readUTF();
            Credito=LeerArchivo.readByte();
            Sale.write(String.format("%-15s     %40s  %-1s\n", ClaveMate, NombreMateria, Credito));
        
        }
        JOptionPane.showMessageDialog(null, "Reporte generado con éxito");
        Sale.close();
        LeerArchivo.close();
         } catch (IOException e) {
            System.out.println("Ocurrió un error al abrir el archivo \n" + e.toString());
        }
    }
    private String Consultar(RandomAccessFile canal, String bus){
        String info = null;
        int Tam, li, ls;
        li = 0;
        String Aux,nombreMateria;
        byte credi;
        Materias Obj = new Materias();
        try {
            ls = (int) canal.length() / (Ta - 1);
            do {
                Tam= (li + ls) / 2;
                canal.seek(Tam * Ta);
                //jair=jair
                Obj.ClaveMateria = canal.readUTF();
                Obj.NombreMateria = canal.readUTF();
                Obj.Creditos = canal.readByte();
                if (Obj.ClaveMateria.compareToIgnoreCase(bus) > 0) {
                    ls = Tam -1;
                } else {
                    li = Tam + 1;
                }
            } while (!Obj.ClaveMateria.equals(bus) && li <= ls);
            if (Obj.ClaveMateria.equals(bus)) {
                //Impirmo informacion
                canal.seek(Tam * Ta);
                Aux = canal.readUTF();
                nombreMateria = canal.readUTF();
                credi = canal.readByte();

                info = "Se encontró el registro.\n\nInformación encontrada.\n" + "\nClave Materia: " + Aux + "\n\nNombre: " + nombreMateria + "\n\nCreditos: " + credi;
                /////
            } else {
                System.out.println("Informacion no encontrada.");
            }
        } catch (IOException e) // captura la Excepcion
        {
            System.out.println(" No se abrio bien el fichero= \n" + e.toString());
        }
        return info;
    }
    private Materias lectura(RandomAccessFile entrada, int numReg)//recibe "entrada" que es el canal de lectura, así como los registros quue hay
    {
        Materias trae = new Materias();
        try {
            entrada.seek(numReg * Ta);//de esta manera se mueve el apuntador 
            trae.ClaveMateria = entrada.readUTF();
            trae.NombreMateria= entrada.readUTF();
            trae.Creditos = entrada.readByte();
        } catch (IOException e) {
            System.out.println("Ocurrió un error al abrir el archivo \n" + e.toString());

        }
        return trae;
    }
       private void escritura(RandomAccessFile salida, Materias trae, int numReg)//recibe salida para la escritura de datos, tipo void ya que no devuelve nada sino que modifica
    {
        try {
            salida.seek(numReg * Ta);//de esta manera se mueve el apuntador   
            salida.writeUTF(trae.ClaveMateria);
            salida.writeUTF(trae.NombreMateria);
            salida.writeByte(trae.Creditos);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al abrir el archivo \n" + e.toString());
        }
    }
    private void Ordenar(){
        Materias Ord = new Materias();
        Materias Aux = new Materias();
        String fichero = "Materias.dat";
        RandomAccessFile canal;
        boolean f = false;
        do {

            try {
                f = false;
                canal = new RandomAccessFile(fichero, "rw");
                int numReg = (int) (canal.length() / Ta);//casting long a entero, defino num de registro del archivo
                System.out.println("Hay un total de: " + numReg);

                for (int pas = 1; pas < numReg; pas++) {
                    for (int com = 1; com <= (numReg - pas); com++) {
                        Ord = lectura(canal, com - 1);
                        Aux = lectura(canal, com);
                        if (Ord.ClaveMateria.compareToIgnoreCase(Aux.ClaveMateria) > 0) {
                            escritura(canal, Aux, com - 1);
                            escritura(canal, Ord, com);
                        }
                    }
                }
                canal.close();
                JOptionPane.showMessageDialog(null, "El ordenamiento se ha ejecutado correctamente,", "SISTEMA ALUMNOS", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("El ordenamiento se ha ejecutado correctamente.");
            } catch (IOException e) {
                System.out.println("Ocurrió un error al abrir el archivo \n" + e.toString());
                System.out.println("Valor de f: " + f);
                f = true;
            }

        } while (f);
    }

    private void Alta(){
            Materias Crea= new Materias();
            int con=0;
            RandomAccessFile Sali;
            String Archivo="Materias.dat";
            String respuesta="";
           
        try {
            Sali= new RandomAccessFile(Archivo, "rw");
            Sali.seek(Sali.length());
            int co=0;
            do{
                co++;
                Crea.Capturar();
                Sali.writeUTF(Crea.ClaveMateria);
                Sali.writeUTF(Crea.NombreMateria);
                Sali.writeByte(Crea.Creditos);
               // aqui va el ordenamiento
                Ordenar();
             con = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Quiere ingresar mas materias? 1-SI 2-NO"));

            }while(con==1);
               Sali.close();
       } catch (IOException e) {
            System.out.println("Ocurrio un error al abrir el archivo \n" + e.toString());

        } catch (NumberFormatException e) { // EXCEPCION AL INTRODUCIR NUMEROS NO NUMERICOS EN JOPTIONPANE
            System.out.println("SE ENCONTRO UN ERROR : " + e);
            JOptionPane.showMessageDialog(null, "SE INTRODUJO UN VALOR NO NUMERICO. POR FAVOR, INGRESE UN VALOR NUMERICO. ", "Error valor no numerico", 2);
        }     
    }
    
     public void  ShowMenu() throws IOException{
        //creo un arreglo con las opciones
        int option=0;
        do{
        String[] Menu= new String[6];
        Menu[0]="1-Alta de Materias";
        Menu[1]="2-Buscar";
        Menu[2]="3-Modificar";
        Menu[3]="4-Reporte";
        Menu[4]="5-Regresar al menu principal";
        Menu[5]="6-Salir del programa";
        //y mando llamar al metodo showarray que me regresa 
        //el menu 
        String MyMenu=ShowArray(Menu);
        // lo unico que hago es pedir la opcion al usuario
        
        option=parseInt(JOptionPane.showInputDialog(null,MyMenu));
        opciones(option);
        }while(option!=5);
        // y esta se la mando al main
        
   
    }
     public String  ShowArray(String [] Menu){
     String ShowMyMenu="";
     for(int i=0; i<Menu.length; i++)
           ShowMyMenu+=Menu[i]+"\n";    
           return  ShowMyMenu;
    }
    
    public void opciones(int sele) {
        String Archivo="Materias.dat";
        RandomAccessFile Obj;
        Validar val = new Validar();
        int con=0;
        
        try {
            /// Aqui va codigo de validar
            Obj=new RandomAccessFile(Archivo,"rw");
            
            switch (sele){
                
                case 1:
                   // aqui el metodo 
                    JOptionPane.showMessageDialog(null, "Aqui Metodo alta");
                    Alta();
                   
                    break;
                case 2:
                    do{
                    // aqui va el metodo buscar
                      String buscar = JOptionPane.showInputDialog(null, "Ingrese la clave de la materia.");
                     //AQUI DEBEMOS VALIDAR
                      while (val.VerificaClaveMateria(buscar) || val.PalabraVerificar(buscar)) {
                        JOptionPane.showMessageDialog(null, "LA CLAVE DE LA MATERIA DEBE TENER 4 CARACTERES Y NO DEBE TENER CARACTERES ESPECIALES, VUELVA A INGRESAR LA CLAVE POR FAVOR.", "SISTEMA MATERIAS", JOptionPane.WARNING_MESSAGE);
                        buscar = JOptionPane.showInputDialog(null, "Teclea la clave de la materia: (longitud de 4)", "SISTEMA MATERIAS", JOptionPane.QUESTION_MESSAGE);
                    }
                    String info = Consultar(Obj, buscar);
                    if (info == null) {
                        JOptionPane.showMessageDialog(null, "Registro no encontrado. Clave Materia incorrecto.");
                    } else {
                        JOptionPane.showMessageDialog(null, info);
                    }
                     con = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Quiere Buscar mas Materias? 1-SI 2-NO"));
                    }while(con==1);
                    break;
                case 3:
                    do{
                    // aqui va el metodo modificar
                    Modificar();
                    con = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Quiere Modificar mas Materias? 1-SI 2-NO"));
                    }while(con==1);
                    break;
                case 4: 
                    //aqui va el metodo reporte
                     Reporte();
                    break;
                case 5:
                    Principal obj = new Principal();
                    obj.ShowMenu();
                    break;
                case 6: 
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Esa opcion no existe por favor de ingresar una valida");
                    
            }
          
       } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al abrir el archivo \n" + e.toString());
        }
        
        
    }
    

}
