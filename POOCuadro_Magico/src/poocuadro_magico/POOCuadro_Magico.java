package poocuadro_magico;
import javax.swing.JOptionPane;
public class POOCuadro_Magico {
    public static void main(String[] args) {
        int n;
        n = Integer.parseInt(JOptionPane.showInputDialog("Digite la dimension de su matriz"));
        int[][] matriz = new int[n][n];
        Cuadro cua = new Cuadro();
        if (matriz.length == matriz[0].length && matriz.length % 2 != 0) {//debe ser numero impar para que funcione
           cua.set_Cuadro(matriz);
           cua.obtener_CuadroMagico();
           System.out.println(cua.imprimir_Cuadro(matriz));
           System.out.println(cua.suma_CuadroMagico());
        } else {
            JOptionPane.showMessageDialog(null, "No se puede formar cuadro magico");
        }
    }
}
