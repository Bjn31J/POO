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
public class Inscripciones {

    static int TA_A = 53;
    static int TA_M = 44;
    static int TA_RE = 16;
 public void ReporteIncripciones(RandomAccessFile leer) {
        try {
            PrintWriter reporte;//canal reporte
            leer = new RandomAccessFile("Inscripciones.dat", "rw");//Acceso directo con LeerDatos
            reporte = new PrintWriter(new FileWriter("C:\\Users\\LGWID\\OneDrive\\Música\\Escritorio\\REPORTES\\Inscripciones.txt"));//Texto con reporte
            reporte.println("______________________");
            reporte.println("| Inscripciones.dat |");
            reporte.println("__________|__________");
            reporte.println(String.format("%9s%7s", "| No.CONTROL |", "|CLAVE MATERIA|"));
            reporte.println("__________|__________");
            leer.seek(0);

            String aux_nc, aux_clave;

            int num_R = (int) (leer.length() / TA_RE);//Numero de registros

            for (int i = 0; i < num_R; i++) {
                aux_nc = leer.readUTF();
                aux_clave = leer.readUTF();
                reporte.write(String.format("|%-8s | %-6s |\n", aux_nc, aux_clave));
                reporte.println("__________|__________");
            }
            JOptionPane.showMessageDialog(null, "el reporte se genero con exito");
            leer.close();
            reporte.close();
        } catch (IOException e) // captura la Excepcion
        {
            System.out.println(" No se abrio bien el fichero \n" + e.toString());
        }
    }

    private void EscribirDatos(RandomAccessFile canal, MisCapturasAux dm, int reg) {
        try {
            canal.seek(reg * TA_RE);
            canal.writeUTF(dm.nro_ctrl);
            canal.writeUTF(dm.clave_mat);
        } catch (IOException e) // captura la Excepcion
        {
            System.out.println(" No se abrio bien el fichero: \n" + e.toString());
        }
    }

    public int ShowMenu() throws IOException {
        //creo un arreglo con las opciones

        String[] Menu = new String[5];
        Menu[0] = "1-INSCRIBIR";
        Menu[1] = "2-CARGAS ACADEMICAS";
        Menu[2] = "3-REGRESAR AL MENU";
        Menu[3]="4-REPORTE INCRIPCIONES";
        Menu[4] = "5-SALIR DEL PROGRAMA";

        //y mando llamar al metodo showarray que me regresa 
        //el menu 
        String MyMenu = ShowArray(Menu);
        // lo unico que hago es pedir la opcion al usuario

        int option = parseInt(JOptionPane.showInputDialog(null, MyMenu));

        return option;
        // y esta se la mando al main

    }

    public String ShowArray(String[] Menu) {
        String ShowMyMenu = "";
        for (int i = 0; i < Menu.length; i++) {
            ShowMyMenu += Menu[i] + "\n";
        }
        return ShowMyMenu;
    }

    private MisCapturasAux LeerDatos(RandomAccessFile Abrir, int Registro) {
        MisCapturasAux Captura = new MisCapturasAux();
        try {
            Abrir.seek(Registro * TA_RE);
            Captura.nro_ctrl = Abrir.readUTF();
            Captura.clave_mat = Abrir.readUTF();
        } catch (IOException e) // captura la Excepcion
        {
            System.out.println(" No se abrio bien el fichero= \n" + e.toString());
        }
        return Captura;
    }

    private void OrdenarDatos(RandomAccessFile entrada) {
        boolean f = false;
        String fichero = "Inscripciones.dat";
        MisCapturasAux obj = new MisCapturasAux();
        MisCapturasAux objAux = new MisCapturasAux();
        do {
            try {
                f = false;
                entrada = new RandomAccessFile(fichero, "rw");
                System.out.println("Tamaño del archivo en bytes: " + entrada.length());
                int numReg = (int) (entrada.length() / TA_RE);
                System.out.println("Numero de registros: " + numReg);

                for (int pas = 1; pas < numReg; pas++) {
                    for (int com = 1; com <= (numReg - pas); com++) {
                        obj = LeerDatos(entrada, (com - 1));  //leer(Abre1,com-1)
                        objAux = LeerDatos(entrada, com); //leer(Abre1,com)
                        if (obj.nro_ctrl.compareToIgnoreCase(objAux.nro_ctrl) > 0) {
                            EscribirDatos(entrada, objAux, com - 1);
                            EscribirDatos(entrada, obj, com);
                        }
                    }
                }
                ReporteIncripciones(entrada);
                entrada.close();
                JOptionPane.showMessageDialog(null, "Reporte generado con exito");
            } catch (IOException e) // captura la Excepcion
            {
                System.out.println(" No se abrio bien el fichero \n" + e.toString());
                System.out.println("Valor de f " + f);
                f = true;
            } finally {
                System.out.println("Hace finally " + f);
            }
        } while (f);
    }

    private boolean pedirNumeroControl(RandomAccessFile canal, String buscar) {
        boolean encontrado = false;
        int pm, li, ls;
        li = 0;
        String naux, nombre;
        byte credi;
        Alumno dm = new Alumno();
        try {
            ls = (int) canal.length() / (TA_A - 1);
            do {
                pm = (li + ls) / 2;
                canal.seek(pm * TA_A);
                dm.Control = canal.readUTF();
                dm.Nom = canal.readUTF();
                dm.Semestre = canal.readByte();
                if (dm.Control.compareToIgnoreCase(buscar) > 0) {
                    ls = pm - 1;
                } else {
                    li = pm + 1;
                }
            } while (!dm.Control.equals(buscar) && li <= ls);
            if (dm.Control.equals(buscar)) {
                //Impirmo informacion
                canal.seek(pm * TA_A);
                naux = dm.Control = canal.readUTF();
                nombre = dm.Nom = canal.readUTF();
                credi = dm.Semestre = canal.readByte();
                JOptionPane.showMessageDialog(null, "Informacion encontrada!\nInformacion:\nNumero Control: " + naux + "\n Nombre del Alumno: " + nombre + "\nSemestre: " + credi, "SISTEMA INSCRIPCIONES", JOptionPane.INFORMATION_MESSAGE);
                encontrado = true;
                /////
            } else {
                JOptionPane.showMessageDialog(null, "Informacion no encontrada.");
            }
        } catch (IOException e) // captura la Excepcion
        {
            System.out.println(" No se abrio bien el fichero= \n" + e.toString());
        }
        return encontrado;
    }

    public void InscripcionesOpciones() throws IOException {
        String Alumnos, materias, inscrip;
        inscrip = "Inscripciones.dat";
        Alumnos = "Alumnos.dat";
        materias = "Materias.dat";
        RandomAccessFile Abrir1, abrir2, abrir3;
        String resp = "Si", Respuesta = "", resp2;
        boolean r, rm, repeticion;
        MisCapturasAux ob = new MisCapturasAux();
        int op = 0;
        do {
            op = ShowMenu();
            switch (op) {
                case 1:
                    //Preguntamos si queremos inscribir
                    Respuesta = JOptionPane.showInputDialog(null, "INSCRIPCIONES\n¿Desea inscribir un alumno? (si/no)");
                    if (Respuesta.toUpperCase().equals("SI")) {//Usamos un if para ingresar si tecle "si"
                        try {
                            Abrir1 = new RandomAccessFile(Alumnos, "rw");//abrimos el archivo de Alumnos.dat
                            abrir2 = new RandomAccessFile(materias, "rw");//canal para Materias.dat
                            abrir3 = new RandomAccessFile(inscrip, "rw");//canal para Inscripciones.dat
                            do {//Ciclo por si quiere inscribir
                                //Pedimos numero de control
                                ob.ControlCapturar();
                                abrir3.seek(abrir3.length()); // Se mueve el apuntador al final del inscrip
                                r = pedirNumeroControl(Abrir1, ob.nro_ctrl);
                                if (r) {//Nos regresa un bollean si es verdad se registra y pedimos materia
                                    do {//Ciclo por si quiere registrar mas materias con el mismo alumno
                                        ob.MateriaCapturar();
                                        rm = LlamaMateria_Clave(abrir2, ob.clave_mat);
                                        repeticion = VerificarRepeticion(abrir3, ob.nro_ctrl, ob.clave_mat);
                                        if (repeticion == false) {
                                            if (rm) {//Si encuentra la materia registra los datos
                                                abrir3.writeUTF(ob.nro_ctrl);
                                                abrir3.writeUTF(ob.clave_mat);
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "El alumno " + ob.nro_ctrl + " ya esta inscrito en la materia " + ob.clave_mat, "SISTEMA INSCRIPCIONES", JOptionPane.INFORMATION_MESSAGE);
                                        }
                                        resp = JOptionPane.showInputDialog(null, "Desea continuar inscribiendo al alumno " + ob.nro_ctrl + " en otras materias: (si/no)", "SISTEMA INSCRIPCIONES", JOptionPane.QUESTION_MESSAGE);
                                    } while (resp.toUpperCase().equals("SI"));
                                    OrdenarDatos(abrir3);
                                    ReporteIncripciones(abrir3);
                                } else {//Falso salimos
                                    OrdenarDatos(abrir3);
                                    ReporteIncripciones(abrir3);
                                }
                                resp2 = JOptionPane.showInputDialog(null, "¿Desea inscribir un alumno?: (si/no)");
                            } while (resp2.toUpperCase().equals("SI"));//Sale del do de inscripcion por si quiere inscribir otro alumno
                            Abrir1.close();//Cerramos
                            abrir2.close();
                            abrir3.close();
                            JOptionPane.showMessageDialog(null, "Salida de inscripciones");
                        } catch (IOException e) // captura la Excepcion
                        {
                            System.out.println(" No se abrio bien el fichero \n" + e.toString());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Salida de inscripciones");
                    }
                case 2:
                    try {
                    abrir3 = new RandomAccessFile(inscrip, "rw");//canal para Inscripciones.dat
                    ReporteCargarAcademica(abrir3);
                    abrir3.close();

                } catch (IOException e) // captura la Excepcion
                {
                    System.out.println(" No se abrio bien el fichero \n" + e.toString());
                }
                break;
                case 3:
                    Principal m = new Principal();
                    m.ShowMenu();
                    break;
                case 4:
               Inscripciones obj3= new Inscripciones();
               RandomAccessFile k1;
               k1=new RandomAccessFile("Inscripciones.dat","rw");
               obj3.ReporteIncripciones(k1);
                    break;
                case 5:
                    System.exit(0);
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Esa opcion no existe");
            }
        } while (op != 4 || op != 3);
    }

    private boolean LlamaMateria_Clave(RandomAccessFile Abrir, String buscar) {
        //Busqueda
        int Suma, Menor, Mayor;
        Menor = 0;
         byte Creditos;
        boolean Bandera = false;
        
        String GuardaClave, nombre;
        Materias mate = new Materias();
        try {
            Mayor = (int) Abrir.length() / (TA_M - 1);
            do {
                Suma = (Menor + Mayor) / 2;
                Abrir.seek(Suma * TA_M);
                mate.ClaveMateria = Abrir.readUTF();
                mate.NombreMateria = Abrir.readUTF();
                mate.Creditos = Abrir.readByte();
                if (mate.ClaveMateria.compareToIgnoreCase(buscar) > 0) {
                    Mayor = Suma - 1;
                } else {
                    Menor = Suma + 1;
                }
            } while (!mate.ClaveMateria.equals(buscar) && Menor <= Mayor);
            if (mate.ClaveMateria.equals(buscar)) {
                //Impirmo informacion
                Abrir.seek(Suma * TA_M);
                GuardaClave = mate.ClaveMateria = Abrir.readUTF();
                nombre = mate.NombreMateria = Abrir.readUTF();
                Creditos = mate.Creditos = Abrir.readByte();
                JOptionPane.showMessageDialog(null, "Materia encontrada!\nInformacion:\nClave Materia: " + GuardaClave + "\nNombre Materia: " + nombre + "\nCredito de la Materia: " + Creditos, "SISTEMA INSCRIPCIONES", JOptionPane.INFORMATION_MESSAGE);
                Bandera = true;
                /////
            } else {
                JOptionPane.showMessageDialog(null, "Materia no encontrado favor de revisar..");
            }
        } catch (IOException e) // captura la Excepcion
        {
            System.out.println(" No se abrio bien el fichero= \n" + e.toString());
        }
        return Bandera;
    }

   
    public void ReporteCargarAcademica(RandomAccessFile Datos) {
        String nombrem = "", Alumnos, Materias;
        byte credito;
        Alumnos = "Alumnos.dat";
        Materias = "Materias.dat";
        RandomAccessFile Abre1, Abre2;
        try {
            Abre1 = new RandomAccessFile(Alumnos, "rw");//abrimos el archivo de Alumnos.dat
            Abre2 = new RandomAccessFile(Materias, "rw");//canal para Materias.dat
            PrintWriter reporte;//canal reporte
            Datos = new RandomAccessFile("Inscripciones.dat", "rw");//Acceso directo con LeerDatos
            reporte = new PrintWriter(new FileWriter("C:\\Users\\LGWID\\OneDrive\\Música\\Escritorio\\REPORTES\\CargasAcademicas.txt"));//Texto con reporte
            reporte.println("CARGAS ACADEMICAS");
            Datos.seek(0);

            String AuxNumeroControl = "", AuxClave = "", aux_nr = "", aux_c = "", nombreA = "";

            int num_R = (int) (Datos.length() / TA_RE);//Numero de registros

            for (int i = 0; i < num_R; i++) {
                //Usamos if para comparar valores
                if (i % 2 == 0) {//Usamos dos variables uno que guardadra los numeros de control de la poscion pares e impares para comparar
                    AuxNumeroControl = Datos.readUTF();
                    AuxClave = Datos.readUTF();
                    if (!AuxNumeroControl.equals(aux_nr)) {
                        reporte.println("______________________________________________________________");
                        reporte.print("Numero Control:");
                        reporte.write(String.format("%-8s \n", AuxNumeroControl));//Imprimimos numero control
                        reporte.print("Nombre:");
                        nombreA = BuscarAlumno(Abre1, AuxNumeroControl);//Damos el numero de control y obtenemos el nombre del alumno
                        reporte.write(String.format("%-8s \n", nombreA));//Imprimimos nombrealumno
                        reporte.println(String.format("%-17s%-33s%-1s", "CLAVE MATERIA ", " MATERIA ", " CREDITOS "));
                        aux_c = AuxNumeroControl;
                    }
                } else {
                    aux_nr = Datos.readUTF();
                    AuxClave = Datos.readUTF();
                    if (!aux_nr.equals(AuxNumeroControl)) {
                        reporte.println("_______________________________________________________________");
                        reporte.print("Numero Control:");
                        reporte.write(String.format("%-8s \n", aux_nr));//Imprimimos numero control
                        reporte.print("Nombre:");
                        nombreA = BuscarAlumno(Abre1, aux_nr);//Damos el numero de control y obtenemos el nombre del alumno
                        reporte.write(String.format("%-8s \n", nombreA));//Imprimimos nombrealumno
                        reporte.println(String.format("%-17s%-33s%-1s", "CLAVE MATERIA ", " MATERIA ", " CREDITOS "));
                        aux_c = aux_nr;//Este valor es importante pues lo ocuparemos en el if siguiente
                    }
                }
                if ((AuxNumeroControl.equals(aux_c)) || (aux_nr.equals(aux_c))) {//Si los valores obtenidos es igual a los anteriormente
                    //Le damos el valor que cumpla el if
                    nombrem = ExisteMateria(Abre2, AuxClave);//Obtenemos el nombre de la materia
                    credito = ConsultaMateria(Abre2, AuxClave);//Obtenemos el valor del credito
                    reporte.write(String.format("%-18s%-15s%-1s \n", AuxClave, nombrem, credito));
                    //reporte.write(String.format("%-8s      %-8s    %-1s\n", AuxClave,nombrem,credito));
                }
            }
            Datos.close();
            reporte.close();
            Abre2.close();
            Abre1.close();
        } catch (IOException e) // captura la Excepcion
        {
            System.out.println(" No se abrio bien el fichero \n" + e.toString());
        }
        JOptionPane.showMessageDialog(null, "Cargas Academicas creadas con exito..");
    }

    private String ExisteMateria(RandomAccessFile canal, String buscar) {
        //Busqueda
        int pm, li, ls;
        li = 0;
        String naux, materia = "";
        byte credi;
        Materias dm = new Materias();
        try {
            ls = (int) canal.length() / (TA_M - 1);
            do {
                pm = (li + ls) / 2;
                canal.seek(pm * TA_M);
                dm.ClaveMateria = canal.readUTF();
                dm.NombreMateria = canal.readUTF();
                dm.Creditos = canal.readByte();
                if (dm.ClaveMateria.compareToIgnoreCase(buscar) > 0) {
                    ls = pm - 1;
                } else {
                    li = pm + 1;
                }
            } while (!dm.ClaveMateria.equals(buscar) && li <= ls);
            if (dm.ClaveMateria.equals(buscar)) {
                //Impirmo informacion
                canal.seek(pm * TA_M);
                naux = dm.ClaveMateria = canal.readUTF();
                materia = dm.NombreMateria = canal.readUTF();
                credi = dm.Creditos = canal.readByte();
            }
        } catch (IOException e) // captura la Excepcion
        {
            System.out.println(" No se abrio bien el fichero= \n" + e.toString());
        }
        return materia;
    }

    private byte ConsultaMateria(RandomAccessFile canal, String buscar) {
        //Busqueda
        int Suma, li, ls;
        li = 0;
        String Aux, materia = "";
        byte Creditos = 0;
        Materias Objeto = new Materias();
        try {
            ls = (int) canal.length() / (TA_M - 1);
            do {
                Suma = (li + ls) / 2;
                canal.seek(Suma * TA_M);
                Objeto.ClaveMateria = canal.readUTF();
                Objeto.NombreMateria = canal.readUTF();
                Objeto.Creditos = canal.readByte();
                if (Objeto.ClaveMateria.compareToIgnoreCase(buscar) > 0) {
                    ls = Suma - 1;
                } else {
                    li = Suma + 1;
                }
            } while (!Objeto.ClaveMateria.equals(buscar) && li <= ls);
            if (Objeto.ClaveMateria.equals(buscar)) {
                //Impirmo informacion
                canal.seek(Suma * TA_M);
                Aux = Objeto.ClaveMateria = canal.readUTF();
                materia = Objeto.NombreMateria = canal.readUTF();
                Creditos = Objeto.Creditos = canal.readByte();
            }
        } catch (IOException e) // captura la Excepcion
        {
            System.out.println(" No se abrio bien el fichero= \n" + e.toString());
        }
        return Creditos;
    }

    private String BuscarAlumno(RandomAccessFile AbrirCanal, String buscar) {
        //Busqueda
        int Suma, li, ls;
        li = 0;
        String AuxNombre = "", nombre = "";
        byte Creditos = 0;
        Alumno Objeto = new Alumno();
        try {
            ls = (int) AbrirCanal.length() / (TA_A - 1);
            do {
                Suma = (li + ls) / 2;
                AbrirCanal.seek(Suma * TA_A);
                Objeto.Control = AbrirCanal.readUTF();
                Objeto.Nom = AbrirCanal.readUTF();
                Objeto.Semestre = AbrirCanal.readByte();
                if (Objeto.Control.compareToIgnoreCase(buscar) > 0) {
                    ls = Suma - 1;
                } else {
                    li = Suma + 1;
                }
            } while (!Objeto.Control.equals(buscar) && li <= ls);
            if (Objeto.Control.equals(buscar)) {
                //Impirmo informacion
                AbrirCanal.seek(Suma * TA_A);
                AuxNombre = Objeto.Control = AbrirCanal.readUTF();
                nombre = Objeto.Nom = AbrirCanal.readUTF();
                Creditos = Objeto.Semestre = AbrirCanal.readByte();
            }
        } catch (IOException e) // captura la Excepcion
        {
            System.out.println(" No se abrio bien el fichero= \n" + e.toString());
        }
        return nombre;
    }

    private boolean VerificarRepeticion(RandomAccessFile DatosLEctura, String ctrol, String clve) {
        boolean Bandera = false;
        MisCapturasAux dt = new MisCapturasAux();
        try {
            PrintWriter reporte;//canal reporte
            DatosLEctura = new RandomAccessFile("Inscripciones.dat", "rw");//Acceso directo con LeerDatos
            reporte = new PrintWriter(new FileWriter("C:\\Users\\LGWID\\OneDrive\\Música\\Escritorio\\REPORTES CargasAcademicas.txt"));//Texto con reporte
            reporte.println("Cargas Academicas   ");
            DatosLEctura.seek(0);

            String AuxNumeroControl = "", AuxClaveMateria = "";

            int num_R = (int) (DatosLEctura.length() / TA_RE);//Numero de registros

            for (int i = 0; i < num_R; i++) {
                AuxNumeroControl = dt.nro_ctrl = DatosLEctura.readUTF();
                AuxClaveMateria = dt.clave_mat = DatosLEctura.readUTF();
                if (AuxNumeroControl.equalsIgnoreCase(ctrol) && AuxClaveMateria.equalsIgnoreCase(clve)) {
                    Bandera = true;
                }
            }
            DatosLEctura.close();
            reporte.close();
        } catch (IOException e) // captura la Excepcion
        {
            System.out.println(" No se abrio bien el fichero \n" + e.toString());
        }
        return Bandera;
    }
}

class MisCapturasAux {

    String nro_ctrl, clave_mat;

    void ControlCapturar() {
        Validar val = new Validar();
        nro_ctrl = JOptionPane.showInputDialog(null, "Teclea el numero de control del alumno a registrar: ");
        while (val.VerificaControl(nro_ctrl) || val.PalabraVerificar(nro_ctrl)) { //VALIDA SI EL NUMERO DE CONTROL ES TAMAÑO 8 Y NO TIENE CARACTERES ESPECIALES
            JOptionPane.showMessageDialog(null, "EL NUMERO DE CONTROL DEBE TENER 8 CARACTERES Y NO DEBE TENER CARACTERES ESPECIALES, VUELVA A INGRESAR EL NUMERO DE CONTROL POR FAVOR.");

            nro_ctrl = JOptionPane.showInputDialog(null, "Ingrese número de control del estudiante: (longitud 8 caracteres)");
        }
        nro_ctrl = String.format("%-8s", nro_ctrl);

    }

    void MateriaCapturar() {
        Validar val = new Validar();

        clave_mat = JOptionPane.showInputDialog(null, "Teclea la clave de la materia a buscar: ");

        while (val.VerificaClaveMateria(clave_mat) || val.PalabraVerificar(clave_mat)) { //VALIDA SI LA CLAVE DE LA MATERIA ES TAMAÑO 4 Y NO TIENE CARACTERES ESPECIALES
            JOptionPane.showMessageDialog(null, "LA CLAVE DE LA MATERIA DEBE TENER 4 CARACTERES Y NO DEBE TENER CARACTERES ESPECIALES, VUELVA A INGRESAR LA CLAVE POR FAVOR.");

            clave_mat = JOptionPane.showInputDialog(null, "Teclea la clave de la materia: (longitud de 4)");
        }
        clave_mat = String.format("%-4s", clave_mat);
    }

}
