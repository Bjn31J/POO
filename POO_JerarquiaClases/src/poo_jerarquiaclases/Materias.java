
package poo_jerarquiaclases;


public class Materias extends Archivos{
    String clave_materia;
    String nombre_mat,nom_arch;
    byte creditos;
    int tam;

    @Override
    public void capturar() {
        System.out.println("Estoy en el metodo CAPTURAR");
    }

    @Override
    public void ordenar() {
        System.out.println("Estoy en el metodo ORDENAR");    
    }

    @Override
    public void buscar() {
        System.out.println("Estoy en el metodo BUSCAR");    
    }

    @Override
    public void modificar() {
        System.out.println("Estoy en el metodo MODIFICAR"); 
    }

    @Override
    public void consultar() {
        System.out.println("Estoy en el metodo CONSULTAR");
    }

    @Override
    public void reporte() {
        System.out.println("Estoy en el metodo REPORTE");
    }
    
}
