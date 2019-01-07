/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
/**
 *
 * @author agilan.colbert & kevin.rattinam
 */
public class BienvenueVue extends GestionVueAbstraite /*implements ActionListener*/ {

    private JLabel labelBvn;
    

    @Override
    public void init() {
        
        super.init();
        labelBvn = new JLabel("Bienvenue");
        labelBvn.setText("Bienvenue dans notre application");
        labelBvn.setFont(new Font(labelBvn.getName(),Font.PLAIN,30));
        getPane().add(labelBvn);
        
    }

}
