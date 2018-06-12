/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Listeners.RestriccionListener;
import Listeners.SujetoListener;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author JavierLeon
 */
public class SujetoAPanel extends JPanel{
    private JLabel lblSujetoA;
    private BtnImagen btnNuevo;
    private JTextField txtNumRestrict;
    private SujetoListener listener;
    private JPanel pnlRestricciones;
        
    public SujetoAPanel(){
        super();
        super.setLayout(new GridLayout(0,1));
        
        lblSujetoA= new JLabel("Sujeto a:          ");
        lblSujetoA.setFont(new Font("Courier",Font.BOLD,18));
        
        txtNumRestrict=new JTextField("0",3);
        txtNumRestrict.setPreferredSize(new Dimension(30,45));
        txtNumRestrict.setFont(new Font("Courier",Font.BOLD,18));
        txtNumRestrict.setHorizontalAlignment(SwingConstants.CENTER);
        
        pnlRestricciones= new JPanel();
        
        btnNuevo=new BtnImagen("/img/005-add.png");
        btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SujetoAPanel.this.pnlRestricciones.removeAll();
                    Integer cantidad=Integer.valueOf(txtNumRestrict.getText());
                    
                    for(int i=0; i<cantidad; i++){
                        RestriccionPanel pnlR= new RestriccionPanel(i);
                        SujetoAPanel.this.pnlRestricciones.add(pnlR);
                    }
                    SujetoAPanel.this.repaint();
                    listener.onClick(cantidad);
                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null, "Error al ingresar número de restricciones", "Error Input", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        
        JPanel pnlEncabezado=new JPanel();
        pnlEncabezado.setLayout(new FlowLayout());
        pnlEncabezado.add(lblSujetoA);
        pnlEncabezado.add(txtNumRestrict);
        pnlEncabezado.add(btnNuevo);
        super.add(pnlEncabezado);
        super.add(pnlRestricciones);
    }

    public void setListener(SujetoListener listener) {
        this.listener = listener;
    }
    
    private Integer[] getValores(){
        Integer[] array= new Integer[Integer.valueOf(txtCantidad.getText())];
        String cadena=txtFuncion.getText();
        Character c;
        String s;
        int x=0;
        int i=0;
        
        if(Character.isDigit(cadena.charAt(0))){
            array[0]=Integer.valueOf(Character.toString(cadena.charAt(0)));
            x=2;
            i++;
        }
        
        while(x<cadena.length()){
            c=cadena.charAt(x);
            s="";
            if(c!='+' && Character.isLetter(c)){
                c=cadena.charAt(x-2);
                if(c=='-'){
                    c=cadena.charAt(x-1);
                    s=s.concat("-"+c);
                }else{
                    c=cadena.charAt(x-1);
                    s=Character.toString(c);
                }
                
                array[i]=Integer.valueOf(s);
                i++;
            }
            x++;
        }
        
        
        return array;
    }
    
}
