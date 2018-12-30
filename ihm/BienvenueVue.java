/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author agilan.colbert
 */
public class BienvenueVue extends GestionVueAbstraite implements ActionListener{
    private JMenuItem menuMod, menuDel,menuAdd, menuAll, menuEx;

    
    @Override
    public void init() {
        
        super.init();
        menuAdd = super.getMenuAdd();
        menuAdd.addActionListener(this);
        
        menuMod = super.getMenuMod();
        menuMod.addActionListener(this);
        
        menuDel = super.getMenuDel();
        menuDel.addActionListener(this);
        
        menuAll = super.getMenuAll();
        menuAll.addActionListener(this);
        
        menuEx = super.getMenuEx();
        menuEx.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == menuEx){
            int choix = JOptionPane.showConfirmDialog(this,"Vérification","Voulez-vous vraiment quitter?", JOptionPane.YES_NO_OPTION);
            if (choix == JOptionPane.YES_OPTION){
                this.dispose();
            }
        }
        else if(event.getSource() == menuAll){
            new AfficherVue().init();
            this.dispose();
            
        }
    }
    
}
