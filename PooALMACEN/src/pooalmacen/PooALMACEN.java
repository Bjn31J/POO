
package pooalmacen;

import javax.swing.JOptionPane;


public class PooALMACEN {

   
    public static void main(String[] args) {
        String decision;
        double cant=0.0;
        Movimientos obj=new Movimientos();
        do{
            obj.Imprimir();
            String clavebuscar=JOptionPane.showInputDialog("Favor de ingresar la clave del articulo a modificar");
            obj=obj.BuscarArticulo(clavebuscar);
            if(clavebuscar.equalsIgnoreCase(obj.clave)){
                int mov=Integer.parseInt(JOptionPane.showInputDialog("          Menu\n"
                        + "1 Salida de almacén\n"
                        + "2 Entrada a almacén\n"
                        + "¿Que tipo de movimiento deseas hacer? 1/2"));
                if(mov==1){
                    cant=Double.parseDouble(JOptionPane.showInputDialog("¿Que cantidad deseas sacar del producto?\n"
                            + "Nota: No mas de la disponible ("+obj.existencia+")"));
                    obj.SacarProducto(obj,cant);
                }
                else if(mov==2)
                    cant=Double.parseDouble(JOptionPane.showInputDialog("¿Que cantidad deseas ingresar del producto?"));
                    obj.MeterProducto(obj,cant );
            }
            decision=JOptionPane.showInputDialog("Desea intentar otra iteracion");
            obj.Imprimir();
        }while(decision.equalsIgnoreCase("SI"));
    }
    }
    

