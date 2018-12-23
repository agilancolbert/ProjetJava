/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author agilan.colbert
 */
public class Vue extends GestionVueAbstraite implements ActionListener{
    private JPanel pane;
    
    @Override
    void init() {
        pane = new JPanel(); // Créantion d'un panel pour gérer les widgets
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
