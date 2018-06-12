/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author JavierLeon
 */
public class LabelMIQ extends JLabel{
    
    public LabelMIQ(Integer desigualdad){
        super();
        asignarDesigualdad(desigualdad);
    }
    
    private void asignarDesigualdad(Integer a){
        switch(a){
            case 1:
                //asignar menor igual que
                this.cargarIcono("/img/003-is-less-than-or-equal-to.png");
                break;
            case 2:
                //asignar mayor igual que
                this.cargarIcono("/img/002-is-greater-than-or-equal-to.png");
                break;
        }
    }
    
    private void cargarIcono(String path){
        URL url=System.class.getResource(path);
        ImageIcon im= new ImageIcon(url);
        super.setIcon(im);
    }
}
