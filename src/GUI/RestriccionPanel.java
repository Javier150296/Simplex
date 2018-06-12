/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Listeners.RestriccionListener;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author JavierLeon
 */
public class RestriccionPanel extends JPanel{
    private JTextField txtEcuacion;
    private JTextField txtIgualA;
    private LabelMIQ lblDesigualdad;
    private Integer numeroLabel;
    private RestriccionListener listener;
    
    public RestriccionPanel(Integer num){
        super();
        super.setLayout(new FlowLayout());
        
        numeroLabel=num;
        txtEcuacion=new JTextField(20);
        txtEcuacion.setFont(new Font("Courier",Font.BOLD,18));
        txtEcuacion.setHorizontalAlignment(SwingConstants.CENTER);
        
        txtIgualA= new JTextField(3);
        txtIgualA.setFont(new Font("Courier",Font.BOLD,18));
        txtIgualA.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblDesigualdad=new LabelMIQ(1);
        
                
        super.add(txtEcuacion);
        super.add(lblDesigualdad);
        super.add(txtIgualA);
    }
    
    public void obtenerEcuacion(){
        listener.onSolveButton(txtEcuacion.getText());
    }
    
    public void obtenerIgualdad(){
        listener.onSolveButton(txtIgualA.getText());
    }
    
    public Integer getNumeroLabel() {
        return numeroLabel;
    }

    public void setNumeroLabel(Integer numeroLabel) {
        this.numeroLabel = numeroLabel;
    }

    public void setListener(RestriccionListener listener) {
        this.listener = listener;
    }
    
}