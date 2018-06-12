/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author JavierLeon
 */
public class LabelResult extends JLabel{
    
    public LabelResult(String s){
        super(s);
        super.setFont(new Font("Impact", Font.BOLD,20));
        super.setForeground(new Color(254,201,80));
        super.setHorizontalAlignment(JLabel.CENTER);
        
    }
}
