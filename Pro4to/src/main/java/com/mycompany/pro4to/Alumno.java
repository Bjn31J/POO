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

public class Alumno {
    private static int Ta=53;
    String Nom,Control;
    byte Semestre;
    void Capturar(){
        Validar val = new Validar();
        Control=JOptionPane.showInputDialog(null,"Ingrese el Numero de Control:");
        while (val.VerificaControl(Control) || val.PalabraVerificar(Control)) { //VALIDA SI EL NUMERO DE CONTROL ES TAMAÑO 8 Y NO TIENE CARACTERES ESPECIALES
            JOptionPane.showMessageDialog(null, "EL NUMERO DE CONTROL DEBE TENER 8 CARACTERES Y NO DEBE TENER CARACTERES ESPECIALES, VUELVA A INGRESAR EL NUMERO DE CONTROL POR FAVOR.", "SISTEMA ALUMNOS", JOptionPane.WARNING_MESSAGE);

            Control = JOptionPane.showInputDialog(null, "Ingrese número de control del estudiante: (longitud 8 caracteres)");
        }
        Control=String.format("%-8s", Control);
        
        Nom=JOptionPane.showInputDialog(null,"Ingrese el Nombre del estudiante:");
        while (val.validarNombre(Nom, 40) || val.PalabraVerificar(Nom)) { //VALIDA SI EL NOMBRE ES DE TAMAÑO 40 O MENOR Y SI NO CONTIENE CARACTERES ESPECIALES
            JOptionPane.showMessageDialog(null, "EL NOMBRE DEL ALUMNO DEBE DE SER DE 40 CARACTERES O MENOS Y NO DEBE CONTENER CARACTERES ESPECIALES.");

            Nom = JOptionPane.showInputDialog(null, "Ingrese nombre del estudiante: (longitud 40 caracteres)");
        }
        Nom=String.format("%-40s", Nom);
        
        Semestre=Byte.parseByte(JOptionPane.showInputDialog(null,"Ingrese el semestre del alumno"));
        while (val.VerificarNegativo(Semestre) || val.validarSemestre(Semestre)) { //VALIDA SI LOS EL SEMESTRO NO ES NEGATIVO
            JOptionPane.showMessageDialog(null, "EL SEMESTRE NO DEBE SER NEGATIVOS\nSEMESTRE MINIMO: 1\nSEMESTRE MAXIMO: 12");

            Semestre = Byte.parseByte(JOptionPane.showInputDialog(null, "Ingrese el semestre del estudiante: "));
        }
    
    }
 /// ma;ana
    private void Modificar(){
        RandomAccessFile AbriCanal;
        String Aux;
        Byte sem;
        int opc;
        String TraeInfo = null;
        String busca = "";
        Validar val = new Validar();


        try {
            AbriCanal= new RandomAccessFile("Alumnos.dat", "rw");
            busca = JOptionPane.showInputDialog(null, "Ingrese el número de control a modificar: (longitud de 8)");

           // aqui validamos
            while (val.VerificaControl(busca) || val.PalabraVerificar(busca)) { //VALIDA SI EL NUMERO DE CONTROL ES TAMAÑO 8 Y NO TIENE CARACTERES ESPECIALES
                JOptionPane.showMessageDialog(null, "EL NUMERO DE CONTROL DEBE TENER 8 CARACTERES Y NO DEBE TENER CARACTERES ESPECIALES, VUELVA A INGRESAR EL NUMERO DE CONTROL POR FAVOR.", "SISTEMA ALUMNOS", JOptionPane.WARNING_MESSAGE);

                busca = JOptionPane.showInputDialog(null, "Ingrese número de control del estudiante: (longitud 8 caracteres)", "SISTEMA ALUMNOS", JOptionPane.QUESTION_MESSAGE);
            }
           
            TraeInfo = Consultar(AbriCanal, busca);
            if (TraeInfo != null) {
                opc = Integer.parseInt(JOptionPane.showInputDialog(null, TraeInfo + "\n¿Qué opción desea modificar?\n1.Nombre del alumno\n2.Semestre del alumno\n3.No modificar", "SISTEMA ALUMNOS", JOptionPane.INFORMATION_MESSAGE));
                switch (opc) {
                    case 1:
                        AbriCanal.seek((AbriCanal.getFilePointer() - Ta)); 
                        AbriCanal.readUTF(); 

                        Aux = JOptionPane.showInputDialog(null, "Ingrese nombre del estudiante: ");
                        Aux = String.format("%-40s", Aux);

                        AbriCanal.writeUTF(Aux);


                        break;
                    case 2:
                        
                          
                        AbriCanal.seek((AbriCanal.getFilePointer() - Ta)); //MUEVE EL APUNTADOR UN REGISTRO ANTERIOR (CLAVE)...
                       
                        AbriCanal.readUTF(); //LEE UN UTF; LEE LA CLAVE
                        
                        AbriCanal.readUTF(); //LEE UN UTF; LEE EL NOMBRE Y DEJA EL APUNTADOR POSICIONADO HASTA DONDE ESTAN LOS CREDITOS DE LA MATERIA
                        
                        sem = Byte.parseByte(JOptionPane.showInputDialog(null, "TECLEA EL NUEVO SEMESTRE: "));

                        while (val.VerificarNegativo(sem) || val.validarSemestre(sem)) { //VALIDA SI LOS EL SEMESTRO NO ES NEGATIVO
                            JOptionPane.showMessageDialog(null, "EL SEMESTRE NO DEBE SER NEGATIVOS, NUMEROS MENORES A 1 NI NUMEROS MAYORES A 12.");

                            sem = Byte.parseByte(JOptionPane.showInputDialog(null, "Ingrese el semestre del estudiante: "));
                        }

                        AbriCanal.seek(sem);

                        JOptionPane.showMessageDialog(null, "EL SEMESTRE DEL ALUMNO SE HA MODIFICADO CON EXITO.");
                    case 3:
                        JOptionPane.showMessageDialog(null, "No se modifica el registro.");
                        break;

                }

            } else {
                JOptionPane.showMessageDialog(null, "Información no encontrada, número de control erróneo.");
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
        String numeroC,Nombre;
        Byte sem;

        //aqui empieza el try
        try{
        LeerArchivo= new RandomAccessFile("Alumnos.dat","r");
       Sale= new PrintWriter(new FileWriter("C:\\Users\\LGWID\\OneDrive\\Música\\Escritorio\\REPORTES\\ALUMNOS.txt"));
       Sale.println("\t\t\tREPORTE DE ESTUDIANTES\n\t\t\t\n");
       Sale.println("__________________________________________________________________________________");
       Sale.println(String.format("%-20s%-40s%-1s", "NO. CONTROL", "NOMBRE ALUMNO", "SEMESTRE"));
       Sale.println("__________________________________________________________________________________");
        
        LeerArchivo.seek(0);
        int total=(int)(LeerArchivo.length()/Ta);
        for(int i=0; i<total; i++){
            numeroC=LeerArchivo.readUTF();
            Nombre=LeerArchivo.readUTF();
            sem=LeerArchivo.readByte();
            Sale.write(String.format("%-15s     %40s  %-1s\n", numeroC, Nombre, sem));
        
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
        String Aux,nombre;
        byte credi;
        Alumno Obj = new Alumno();
        try {
            ls = (int) canal.length() / (Ta - 1);
            do {
                Tam= (li + ls) / 2;
                canal.seek(Tam * Ta);
                //jair=jair
                Obj.Control = canal.readUTF();
                Obj.Nom = canal.readUTF();
                Obj.Semestre = canal.readByte();
                if (Obj.Control.compareToIgnoreCase(bus) > 0) {
                    ls = Tam -1;
                } else {
                    li = Tam + 1;
                }
            } while (!Obj.Control.equals(bus) && li <= ls);
            if (Obj.Control.equals(bus)) {
                //Impirmo informacion
                canal.seek(Tam * Ta);
                Aux = canal.readUTF();
                nombre = canal.readUTF();
                credi = canal.readByte();

                info = "Se encontró el registro.\n\nInformación encontrada.\n" + "\nNúmero de control: " + Aux + "\n\nNombre: " + nombre + "\n\nSemestre: " + credi;
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
    private Alumno lectura(RandomAccessFile entrada, int numReg)//recibe "entrada" que es el canal de lectura, así como los registros quue hay
    {
        Alumno trae = new Alumno();
        try {
            entrada.seek(numReg * Ta);//de esta manera se mueve el apuntador 
            trae.Control = entrada.readUTF();
            trae.Nom = entrada.readUTF();
            trae.Semestre = entrada.readByte();
        } catch (IOException e) {
            System.out.println("Ocurrió un error al abrir el archivo \n" + e.toString());

        }
        return trae;
    }
       private void escritura(RandomAccessFile salida, Alumno trae, int numReg)//recibe salida para la escritura de datos, tipo void ya que no devuelve nada sino que modifica
    {
        try {
            salida.seek(numReg * Ta);//de esta manera se mueve el apuntador   
            salida.writeUTF(trae.Control);
            salida.writeUTF(trae.Nom);
            salida.writeByte(trae.Semestre);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al abrir el archivo \n" + e.toString());
        }
    }
    private void Ordenar(){
        //benja validacion
        Alumno Ord = new Alumno();
        Alumno Aux = new Alumno();
        String fichero = "Alumnos.dat";
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
                        if (Ord.Control.compareToIgnoreCase(Aux.Control) > 0) {
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
            Alumno Crea= new Alumno();
            int con=0;
            RandomAccessFile Sali;
            String Archivo="Alumnos.dat";
            String respuesta="";
           
        try {
            Sali= new RandomAccessFile(Archivo, "rw");
            Sali.seek(Sali.length());
            int co=0;
            do{
                co++;
                Crea.Capturar();
                Sali.writeUTF(Crea.Control);
                Sali.writeUTF(Crea.Nom);
                Sali.writeByte(Crea.Semestre);
               // aqui va el ordenamiento
                Ordenar();
             con = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Quiere ingresar mas alumnos? 1-SI 2-NO"));

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
        Menu[0]="1-Alta de Alumnos";
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
        String Archivo="Alumnos.dat";
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
                      String buscar = JOptionPane.showInputDialog(null, "Ingrese número de control del estudiante: (longitud 8 caracteres)");
                     //AQUI DEBEMOS VALIDAR
                     while (val.VerificaControl(buscar) || val.PalabraVerificar(buscar)) { //VALIDA SI EL NUMERO DE CONTROL ES TAMAÑO 8 Y NO TIENE CARACTERES ESPECIALES
                        JOptionPane.showMessageDialog(null, "EL NUMERO DE CONTROL DEBE TENER 8 CARACTERES Y NO DEBE TENER CARACTERES ESPECIALES, VUELVA A INGRESAR EL NUMERO DE CONTROL POR FAVOR.", "SISTEMA ALUMNOS", JOptionPane.WARNING_MESSAGE);

                        buscar = JOptionPane.showInputDialog(null, "Ingrese número de control del estudiante: (longitud 8 caracteres)", "SISTEMA ALUMNOS", JOptionPane.QUESTION_MESSAGE);
                    }

                    String info = Consultar(Obj, buscar);
                    if (info == null) {
                        JOptionPane.showMessageDialog(null, "Registro no encontrado. Número de control incorrecto.");
                    } else {
                        JOptionPane.showMessageDialog(null, info);
                    }
                    con = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Quiere Buscar mas alumnos? 1-SI 2-NO"));
                    }while(con==1);
                    break;
                case 3:
                    do{
                    // aqui va el metodo modificar
                    Modificar();
                    con = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Quiere Modificar mas alumnos? 1-SI 2-NO"));
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
                    JOptionPane.showMessageDialog(null, "Esa opcion no existe por favor de ingresar una valida");
            }
         
       } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al abrir el archivo \n" + e.toString());
        }
    }
    
    
}
