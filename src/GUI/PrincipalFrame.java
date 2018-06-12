/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Listeners.SujetoListener;
import Objetos.Controlador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author JavierLeon
 */
public class PrincipalFrame extends JFrame{
    private JLabel lblEncabezado;
    private FuncionPanel pnlFunc;
    private SujetoAPanel pnlRestric;
    private BtnImagen btnSolve;
    private Controlador control;
    private Integer numeroRestricciones;
    private Integer numeroVariables;
    
    public PrincipalFrame(){
        super("Método Simplex");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(700,500);
        super.setLayout(new BorderLayout());
        super.setLocationRelativeTo(null);
        
        lblEncabezado=new JLabel("Método Simplex");
        lblEncabezado.setFont(new Font("Impact",Font.BOLD,34));
        lblEncabezado.setForeground(new Color(254,201,80));
        lblEncabezado.setHorizontalAlignment(JLabel.CENTER);
        
        pnlFunc= new FuncionPanel();
        pnlRestric= new SujetoAPanel();
        pnlRestric.setListener(new SujetoListener() {
            @Override
            public void onClick(Integer number) {
                PrincipalFrame.this.numeroRestricciones=number;
                PrincipalFrame.this.repaint();
            }

            @Override
            public void onSolveButton() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        JPanel pnlCentral= new JPanel();
        pnlCentral.setLayout(new BorderLayout());
        pnlCentral.add(pnlFunc, BorderLayout.NORTH);
        pnlCentral.add(pnlRestric, BorderLayout.CENTER);
        
        btnSolve=new BtnImagen("/img/calculator.png");
        btnSolve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
                
        super.add(lblEncabezado, BorderLayout.NORTH);
        super.add(pnlCentral, BorderLayout.CENTER);
        super.add(btnSolve, BorderLayout.SOUTH);
        super.setVisible(true);
    }
    
    private Integer[] rellenarCeroZ(Integer[] valores){
        Integer[] valoresEnZ= new Integer[valores.length+this.numeroRestricciones+1];
        
        for(int i=0; i<(valores.length+this.numeroRestricciones+1); i++){
            if(i<valores.length)
                valoresEnZ[i]=valores[i];
            else
                valoresEnZ[i]=0;
        }
        
        return valoresEnZ;
    }
    
    private Integer[] rellenarFila(Integer[] valores, Integer numRestrict){
        Integer[] row= new Integer[valores.length+this.numeroRestricciones+1];
        
        for(int j=0; j<(valores.length+this.numeroRestricciones+1); j++){
            
        }
    }
}
