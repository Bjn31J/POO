package pooarraobjetos;
public class Promedios {
      String alumno;
    double calificacion;
    String materia;
    //MÉTODO CONSTRUCTOR
    public Promedios(String alumno, double calificacion, String materia) {
        this.alumno = alumno;
        this.calificacion = calificacion;
        this.materia = materia;
    }
    //SETTERS
    public void setCalificacion(double calif){
        calif = calificacion;
    }
    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }
    public void setmATERIA(String materia) {
        this.materia=materia;
    }
    //GETTERS
    public double getCalificacion(){
        return calificacion;
    }
    public String getAlumno() {
        return alumno;
    }
    public String getMateria() {
        return materia;
    }
    @Override
    public String toString() {
        return "Promedios{" + "alumno=" + alumno + ", calificacion=" + calificacion + ", materia=" + materia + '}';
    }
    //MÉTODO PARA MOSTRAR DATOS
    public String showData(){
        return "--Datos del alumno-- \n"+
                "\nAlumno: "+alumno
               +"\nMateria: "+materia
               +"\nCalificación: "+calificacion+"\n";
    } 
}
