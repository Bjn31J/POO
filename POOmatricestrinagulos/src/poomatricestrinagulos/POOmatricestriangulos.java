
package poomatricestrinagulos;




public class POOmatricestriangulos {

    public static void main(String[] args) {
        arreglos arr=new arreglos();
        int [][] mat1= {{4,1,4,2},{5,2,5,9},{-1,-4,-2,-8},{12,14,11,21}};
        int [][] mat2= {{5,9,4,3 },{9,5,8,4},{3,8,4,1},{0,4,1,3}};
        int [][] mat3= {{4,1,2,0},{5,2,9,6},{-1,-4,-8,-3},{1,2,3,4}};
        int [][] mat4= {{4,1,40,2},{5,20,5,90},{-1,-4,-2,-8},{12,14,11,21}};
        
    

        System.out.println("Triangulo1");
        System.out.println(arr.imprimirMatriz(mat1));
        arr.maximosColumna(mat1);
        arr.minimosColumna(mat1);
        arr.maximosRenglon(mat1);
        arr.minimosRenglon(mat1);
        arr.minimoMaximo(mat1);
        arr.suma_Diagonal(mat1);
        arr.sumaFilas(mat1);
        arr.sumaColumnas(mat1);
        System.out.println("La matriz invertida es:");
        mat1=arr.matInvertida(mat1);
        System.out.println(arr.imprimirMatriz(mat1));
        
        mat1=arr.obtener_Triangulo1(mat1);
        System.out.println(arr.imprimirMatriz(mat1));
        
        
        
        
        System.out.println("Triangulo2");
        System.out.println(arr.imprimirMatriz(mat2));
        mat2=arr.obtener_Triangulo2(mat2);
        System.out.println(arr.imprimirMatriz(mat2));
        
        System.out.println("Triangulo3");
        System.out.println(arr.imprimirMatriz(mat3));
        mat3=arr.obtener_Triangulo3(mat3);
        System.out.println(arr.imprimirMatriz(mat3));
        
        System.out.println("Triangulo4");
        System.out.println(arr.imprimirMatriz(mat4));
        mat4=arr.obtener_Triangulo4(mat4);
        System.out.println(arr.imprimirMatriz(mat4));
        
        
    }
    
}
