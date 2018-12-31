package ihm;

import data.DataTransac;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author agilan.colbert
 */
public abstract class GestionVueAbstraite extends JFrame 
{
    private JPanel pane;

    public JPanel getPane() {
        return pane;
    }

    public JMenu getMenuProg() {
        return menuProg;
    }

    public JMenu getMenuAction() {
        return menuAction;
    }

    public JMenu getMenuDisp() {
        return menuDisp;
    }
    private JMenuBar menuBar;
    private JMenu menuProg, menuAction, menuDisp;
    private JMenuItem menuMod, menuDel,menuAdd, menuAll, menuEx;

    public JMenuItem getMenuMod() {
        return menuMod;
    }

    public JMenuItem getMenuDel() {
        return menuDel;
    }

    public JMenuItem getMenuAdd() {
        return menuAdd;
    }

    public JMenuItem getMenuAll() {
        return menuAll;
    }

    public JMenuItem getMenuEx() {
        return menuEx;
    }
    
   public void init(){
       try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(BienvenueVue.class.getName()).log(Level.SEVERE, null, ex);
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
        
        menuDisp.add(menuAll);
        
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
   
   
   
    
    
    
}
