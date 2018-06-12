/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Objetos.VariableResult;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author JavierLeon
 */
public class Resultados extends JDialog{
    private ArrayList<VariableResult> results;
    private BtnImagen btnAgain;
    private BtnImagen btnSalir;
        
    public Resultados(ArrayList<VariableResult> r){
        super();
        super.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
        super.setSize(300,300);
        super.setLayout(new GridLayout(0,1));
        
        for (VariableResult result : results) {
            LabelResult lblRes = new LabelResult(result.toString());
            super.add(lblRes);
        }
        
        btnAgain= new BtnImagen("/img/.png");
        btnAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PrincipalFrame();
                Resultados.this.setVisible(false);
            }
        });
        btnSalir= new BtnImagen("/img/.png");
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        JPanel pnlBtns= new JPanel();
        pnlBtns.add(btnSalir);
        pnlBtns.add(btnAgain);
        super.add(pnlBtns);
    }
}
