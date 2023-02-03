package pooarrays;
import java.util.LinkedList;
public class PooArrays {
    public static void main(String[] args) {
      LinkedList<mat> tecno =new LinkedList<>();
      tecno.add(new mat("POO","BM12",5));
      mat m1=tecno.getLast();
        System.out.println(""+m1);
        m1.lalum.add(new alum ("Benjamin","20030835",4));
        m1.lalum.add(new alum ("Alfredo","20030230",2));
        m1.lalum.add(new alum ("Pedro","20010020",3));
        for(alum a : m1.lalum){
            System.out.println(" "+a);
        }
        System.out.println(" ");
        tecno.add(new mat("CÁLCULO INTEGRAL","BM11",5));
      mat m2=tecno.getLast();
        System.out.println(""+m2);
        m2.lalum.add(new alum ("Karen","18031735",2));
        m2.lalum.add(new alum ("Francisco","20290035",3));
        m2.lalum.add(new alum ("Pedro","20030670",2));
        for(alum a : m2.lalum){
            System.out.println(" "+a);
        }
        System.out.println("");
        tecno.add(new mat("CÁLCULO VECTORIAL","CM11",5));
      mat m3=tecno.getLast();
        System.out.println(""+m3);
        m3.lalum.add(new alum ("Carlos","20030834",4));
        m3.lalum.add(new alum ("Fernanda","20030231",2));
        m3.lalum.add(new alum ("Andrea","20010021",3));
        for(alum a : m3.lalum){
            System.out.println(" "+a);
        }
        System.out.println("");
        //Buscar Materia
        dameMateria(tecno,"BM12");
        mat materiaEnc=dameMateria(tecno,"BM12");
        if(materiaEnc!=null){
            System.out.println("Materia "+materiaEnc);
        }else{
            System.out.println("Materia no encontrada");
        }
        System.out.println("");
        //Buscar Alumno
        alum buscaAlumno = buscaAlumno(materiaEnc.lalum,"20030835");
        if(buscaAlumno!=null){
            System.out.println("Alumno "+buscaAlumno);
        }else{
            System.out.println("ALumno no encontrado");
        }
    } 
    
    static mat dameMateria(LinkedList<mat>l,String clvS){
        for(mat m : l){
            if(m.clvS==clvS){
                return m;
            }
        }
        return null;
    }
    static alum buscaAlumno(LinkedList<alum>la,String nrcrl)
    {
        for(alum al:la){
            if(al.nrocrl==nrcrl){
                return al;
            }}
        return null;  
    }}
    

