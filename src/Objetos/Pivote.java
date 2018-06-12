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
public class Pivote {
    private Double numero;
    private Integer enX;
    private Integer enY;

    public Pivote(Double numero, Integer enX, Integer enY) {
        this.numero = numero;
        this.enX = enX;
        this.enY = enY;
    }

    public Pivote(){
        
    }
    
    public Double getNumero() {
        return numero;
    }

    public void setNumero(Double numero) {
        this.numero = numero;
    }

    public Integer getEnX() {
        return enX;
    }

    public void setEnX(Integer enX) {
        this.enX = enX;
    }

    public Integer getEnY() {
        return enY;
    }

    public void setEnY(Integer enY) {
        this.enY = enY;
    }
    
    
}
