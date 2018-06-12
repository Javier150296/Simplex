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
public class VariableResult {
    private Character nomVar;
    private Double dato;
    private Integer numero;
    
    public VariableResult(boolean isXorZ, Integer numero, Double dato){
        this.dato=dato;
        this.numero=numero;
        if(isXorZ){ //true para variables de entrada X
            nomVar='X';
        }else{ //false para la el Z optimo
            nomVar='Z';
            this.numero=1;
        }
    }
    
    @Override
    public String toString(){
        return String.format("%c%d = %.2f", nomVar,numero,dato);
    }
    
}
