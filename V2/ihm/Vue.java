/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.MenuListener;

/**
 *
 * @author agilan.colbert
 */
public class Vue extends GestionVueAbstraite implements ActionListener{
    private JPanel pane;
    private JMenuBar menuBar;
    private JMenu menuProg, menuAction, menuDisp;
    private JMenuItem menuMod, menuDel,menuAdd, menuAll, menuEx;

    
    @Override
    void init() {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Vue.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        pane = new JPanel(); // Créantion d'un panel pour gérer les widgets
        
        menuBar = new JMenuBar();
        
        menuProg = new JMenu("Programmeur");
        menuAction = new JMenu("Action");
        
        menuDisp = new JMenu("Afficher");
        menuMod = new JMenuItem("Modifier");
        menuDel = new JMenuItem("Supprimer");
        menuAdd = new JMenuItem("Ajouter");
        
        menuAll = new JMenuItem("Tous");
        
        menuEx = new JMenuItem("Quitter");
        
        menuBar.add(menuProg);
        menuBar.add(menuAction);
        
        menuAdd.add(menuAll);
        
        menuProg.add(menuDisp);
        menuProg.add(menuMod);
        menuProg.add(menuDel);
        menuProg.add(menuAdd);
        
        
        menuAction.add(menuEx);
        
        this.setVisible(true);
        this.setTitle("GesProg");
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Fermeture fenêtre = arrêt de l'application 
        setBounds(10, 10, 600, 300);
        this.add(pane); // Ajout du panel à notre frame de base
        this.setJMenuBar(menuBar);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
