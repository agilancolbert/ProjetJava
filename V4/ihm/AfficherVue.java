/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import data.DataTransac;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author agilan.colbert
 */
public class AfficherVue extends GestionVueAbstraite implements ActionListener{
    private JMenuItem menuMod, menuDel,menuAdd, menuAll, menuEx;
    private JTextArea zoneAffichageProg;
    private JScrollPane scroll;
    private String contenuTextArea;
    private DataTransac dt;

    
    @Override
    public void init() {
        
        super.init();
        
        zoneAffichageProg = new JTextArea(10,65);
        scroll = new JScrollPane(zoneAffichageProg);
        super.getPane().add(scroll);
        
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
        
        dt = new DataTransac();
        contenuTextArea = dt.afficherProgrammeurs();
        zoneAffichageProg.setText(contenuTextArea);
        dt.fermerRessources();
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
        
        else if(event.getSource() == menuDel){
            new SupprimerVue().init();
            this.dispose();
        }
        
        else if(event.getSource() == menuAdd){
            new AjouterVue().init();
            this.dispose();
        }
        
        else if(event.getSource() == menuMod){
            new ModifierVue().init();
            this.dispose();
        }       
    }
}
