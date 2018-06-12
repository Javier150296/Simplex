/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Listeners.FuncionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author JavierLeon
 */
public class FuncionPanel extends JPanel{
    private JRadioButton rbtnMax;
    private JRadioButton rbtnMin;
    private ButtonGroup rbtnGrp;
    private JLabel lblFuncion;
    private JTextField txtFuncion;
    private BtnImagen btnCheck;
    private FuncionListener listener;
    private JLabel lblCantidad;
    private JTextField txtCantidad;
    
    public FuncionPanel(){
        super();
        super.setLayout(new BorderLayout());
        
        rbtnMax=new JRadioButton("Maximizar");
        rbtnMax.setSelected(true);
        rbtnMin=new JRadioButton("Minimizar");
        rbtnGrp=new ButtonGroup();
        rbtnGrp.add(rbtnMax);
        rbtnGrp.add(rbtnMin);
        JPanel pnlBtns=new JPanel();
        pnlBtns.setLayout(new FlowLayout());
        pnlBtns.add(rbtnMax);
        pnlBtns.add(rbtnMin);
        
        lblFuncion=new JLabel("Z=");
        lblFuncion.setFont(new Font("Courier",Font.ITALIC,18));
        
        txtFuncion=new JTextField(15);
        txtFuncion.setFont(new Font("Courier",Font.ITALIC,18));
        txtFuncion.setPreferredSize(new Dimension(400,45));
        
        btnCheck=new BtnImagen("/img/002-check.png");
        btnCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean optimizacion;
                    optimizacion = rbtnMax.isSelected();
                    
                    listener.onAceptButton(Integer.valueOf(txtCantidad.getText()), FuncionPanel.this.getValores(), optimizacion);
                    
                } catch (Exception x) {
                    
                }
            }
        });
        
        lblCantidad=new JLabel("Número de variables: ");
        lblCantidad.setFont(new Font("Courier",Font.BOLD,14));
        
        txtCantidad=new JTextField("0",2);
        txtCantidad.setFont(new Font("Courier",Font.BOLD,18));
        txtCantidad.setPreferredSize(new Dimension(30,45));
        txtCantidad.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel pnlFunc=new JPanel();
        pnlFunc.setLayout(new FlowLayout());
        pnlFunc.add(lblFuncion);
        pnlFunc.add(txtFuncion);
        pnlFunc.add(lblCantidad);
        pnlFunc.add(txtCantidad);
        pnlFunc.add(btnCheck);
        
        super.add(pnlBtns, BorderLayout.NORTH);
        super.add(pnlFunc, BorderLayout.SOUTH);
    }

    public void setListener(FuncionListener listener) {
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
