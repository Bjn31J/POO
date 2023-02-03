package com.mycompany.pro4to;

/*
Carla Itzel Tierrablanca Rojas 20031602
Benjamin Jaramillo Nava 20030835
Velazquez Reyes Jair 20030039
*/

public class Validar {
     boolean VerificaControl(String txt) {
        return (txt.length() != 8 || txt.equals("        ") || txt.equals("00000000"));
    }
   
    
  
      boolean PalabraVerificar(String palabra) {
        boolean b = false;
        String letra = "";
        
        for (int i = 0; i < palabra.length(); i++) {
            letra = Character.toString(palabra.charAt(i));
            System.out.println(letra);
            
            if (CaracteresEspeciales(letra)) {
                b = true;
            }
            
        }
        
        return b;
    }
   
      boolean VerificaCreditos(byte creditos) {
        return (creditos <= 1 || creditos >= 7);
    }
    boolean validarNombre(String txt, int tamaño) {
        return (txt.length() > tamaño);
    }
    
   
     boolean VerificaClaveMateria(String txt) {
        
        return (txt.length() != 4 || txt.equals("    "));
    }
    
    boolean CaracteresEspeciales(String letra) {
        boolean b = true;
        //String[] c = {"á", "é", "í", "ó", "ú", "ñ", "!", "¡", "¿", "?", "«", "#", "$", "%", "&", "‘", "(", ")", "*", "+", ",", "-", ".", "/"};
        String[] c = {" ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        
        for (int i = 0; i < c.length; i++) {
            if (letra.equalsIgnoreCase(c[i])) {
                System.out.println(letra);
                b = false;
            }
            
        }
        
        return b;
    }
    
    boolean VerificarNegativo(byte n) {
        return n < 0;
    }
    
   boolean validarSemestre(byte semestre) {
        return (semestre <= 0 || semestre >= 13);
    }
    
}
//
