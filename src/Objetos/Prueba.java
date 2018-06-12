/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author JavierLeon
 */
public class Prueba {
    private Integer[][] matriz;
    
    public Prueba(){
        matriz=new Integer[3][3];
        rellenar();
    }
    
    private void rellenar(){
        Integer cont=1;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                matriz[j][i]=cont;
                cont++;
            }
        }
    }
    
    public void imprimir(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                System.out.print(matriz[j][i]);
            }
            System.out.print("\n");
        }
    }
    
    public void division(Double a, Double b){
        System.out.println(a/b);
    }
}
