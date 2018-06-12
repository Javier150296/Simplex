/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.ArrayList;

/**
 *
 * @author JavierLeon
 */
public class Controlador {
    private Double[][] matriz;
    private final boolean min_Max; //true si es maximizar, false si es minimizar
    private Integer tamFilas;
    private Integer tamColumns;
    private Integer numVarBase; //numero de variables base
    private Pivote pivote;
    private ArrayList<VariableResult> resultados;
    
    public Controlador(boolean minOmax, Integer filas, Integer columnas, Integer entradas){
        this.matriz= new Double[filas][columnas];
        this.tamFilas=filas;
        this.tamColumns=columnas;
        this.numVarBase=entradas;
        this.pivote=new Pivote();
        this.min_Max=minOmax;
        this.resultados= new ArrayList<>();
    }
    
    public void resolverMatriz(){
        while(verificar()){
            getPivote();
            if(pivote.getNumero()!=1.0){
                Integer filita=pivote.getEnX();
                for(int k=0; k<tamColumns; k++){
                    matriz[filita][k]=matriz[filita][k]/pivote.getNumero();
                }
            }
            
            for (int i=0; i<tamFilas; i++){
                Double coeficiente=matriz[i][pivote.getEnY()];
                for(int j=0; j<tamColumns; j++){
                    if(i!=pivote.getEnX())
                        matriz[i][j]=(coeficiente * matriz[pivote.getEnX()][j] * -1.0) + matriz[i][j];
                }
            }
        }
        
        for(int w=0; w<numVarBase-1; w++){
            VariableResult r;
            if(w==0)
                r=new VariableResult(false, 1, matriz[w][tamColumns-1]);
            else
                r=new VariableResult(true, w, matriz[w][tamColumns-1]);
            resultados.add(r);
        }
                
    }
    
    
    private boolean verificar(){
        boolean sigue=false;
        
        for(int i=0; i<tamColumns-1; i++){
            if(min_Max){
                if(matriz[0][i]<0){
                    sigue=true;
                    break;
                }
            }else{
                if(matriz[0][i]>0){
                    sigue=true;
                    break;
                }
            }
        }
        
        return sigue;
    }
    
       
    private void getPivote(){
        Double pivoteFila=0.0;
        Integer columna=0;
        for(int i=0; i<tamColumns-1; i++){
            if(i==0){
                pivoteFila=matriz[0][i];
            }else{
                if(min_Max){
                    if(matriz[0][i]<pivoteFila){
                        pivoteFila=matriz[0][i];
                        columna=i;
                    }
                }else{
                    if(matriz[0][i]>pivoteFila){
                        pivoteFila=matriz[0][i];
                        columna=i;
                    }
                }
            }
        }
        
        for(int j=1; j<tamFilas; j++){
            if(j==1){
                pivote.setNumero(matriz[j][columna]);
                pivote.setEnX(j);
                pivote.setEnY(columna);
            }else{
                if((matriz[j][columna]/matriz[j][tamColumns-1])<pivote.getNumero() && matriz[j][columna]>0){
                    pivote.setNumero(matriz[j][columna]);
                    pivote.setEnX(j);
                    pivote.setEnY(columna);
                }
            }
        }
    }
    
    public void setFilaAt(Double[] fila, Integer index){
        for(int i=0; i<fila.length; i++){
            matriz[index][i]=fila[i];
        }
    }
    
    public ArrayList<VariableResult> recibirResultados(){
        return resultados;
    }
}
