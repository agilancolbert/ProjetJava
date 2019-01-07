package ihm;

import data.DataTransac;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.MaskFormatter;
import myutil.Constantes;

/**
 *
 * @author agilan.colbert & kevin.rattinam
 */
public abstract class GestionVueAbstraite extends JFrame implements ActionListener {

    private JPanel pane;
    private JMenuBar menuBar;
    private JMenu menuProg, menuAction, menuDisp;
    private JMenuItem menuMod, menuDel, menuAdd, menuAll, menuEx;
    protected JButton btnSearch, btnReset, btnVal, btnCancel;
    protected JLabel lblNom, lblAdresse, lblResp, lblHobby, lblPrenom, lblPseudo, lblDateNaiss, lblDateEmb, lblMat;
    protected JTextField txtNom, txtAdresse, txtResp, txtHobby, txtPrenom, txtPseudo, txtMat, txtJourEmb, txtAnneeEmb, txtJourNaiss, txtAnneeNaiss;
    protected JComboBox listMoisNaiss, listMoisEmb;
    protected DataTransac dt;
    private JPanel pnlMatricule,pnlMatriculeGr, pnlBoutons, pnlAttributs;
    
    
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

    public void init() {
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

        menuAdd.addActionListener(this);
        menuMod.addActionListener(this);
        menuDel.addActionListener(this);
        menuAll.addActionListener(this);
        menuEx.addActionListener(this);
        this.setVisible(true);
        this.setTitle("GesProg");
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Fermeture fenêtre = arrêt de l'application 
        setBounds(10,10, 900, 450);
        this.add(pane); // Ajout du panel à notre frame de base
        this.setJMenuBar(menuBar);

    }

    protected void initInterfaceAttributs() {
        btnSearch = new JButton("Rechercher");
        btnReset = new JButton("Réinitialiser");
        btnVal = new JButton("Valider");
        btnCancel = new JButton("Annuler");

        lblNom = new JLabel("Nom");
        lblAdresse = new JLabel("Adresse");
        lblResp = new JLabel("Responsable");
        lblHobby = new JLabel("Hobby");
        lblPrenom = new JLabel("Prénom");
        lblPseudo = new JLabel("Pseudo");
        lblDateNaiss = new JLabel("Date de naissance");
        lblDateEmb = new JLabel("Date Embauche");
        lblMat = new JLabel("Matricule");
        lblMat.setForeground(Color.white);

        txtNom = new JTextField();
        txtNom.setColumns(10);

        txtAdresse = new JTextField();
        txtAdresse.setColumns(10);

        txtResp = new JTextField();
        txtResp.setColumns(10);

        txtHobby = new JTextField();
        txtHobby.setColumns(10);

        txtPrenom = new JTextField();
        txtPrenom.setColumns(10);

        txtPseudo = new JTextField();
        txtPseudo.setColumns(10);

        MaskFormatter maskJour = null, maskAnnee = null, maskMat = null;
        try {
            maskJour = new MaskFormatter("##");
            maskAnnee = new MaskFormatter("####");
            maskMat = new MaskFormatter("#####");
        } catch (ParseException ex) {
            Logger.getLogger(AjouterVue.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtAnneeNaiss = new JFormattedTextField(maskAnnee);
        txtAnneeNaiss.setColumns(6);

        txtAnneeEmb = new JFormattedTextField(maskAnnee);
        txtAnneeEmb.setColumns(6);

        txtJourEmb = new JFormattedTextField(maskJour);
        txtJourEmb.setColumns(4);

        txtJourNaiss = new JFormattedTextField(maskJour);
        txtJourNaiss.setColumns(4);

        txtMat = new JFormattedTextField(maskMat);
        txtMat.setColumns(10);

        listMoisEmb = new JComboBox(Constantes.CONTENU_COMBOBOX);

        listMoisNaiss = new JComboBox(Constantes.CONTENU_COMBOBOX);
        pnlMatricule = new JPanel();
        pnlMatriculeGr = new JPanel();
        pane.setLayout(new BorderLayout());
        
        pnlMatricule.add(lblMat);
        pnlMatricule.add(txtMat);
        pnlMatricule.setBackground(Color.BLACK);
        pnlMatriculeGr.setLayout(new BorderLayout());
        pnlMatriculeGr.add(pnlMatricule,BorderLayout.WEST);
        pnlMatriculeGr.setBackground(Color.BLACK);
        //pnlMatriculeGr.setForeground(Color.RED);
        pane.add(pnlMatriculeGr,BorderLayout.NORTH);
       
        pnlAttributs = new JPanel();
        pnlAttributs.setLayout(new GridBagLayout());
        JPanel cell1 = new JPanel();
        cell1.setPreferredSize(new Dimension(100,75));	
        cell1.add(lblNom);
        JPanel cell2 = new JPanel();
        cell2.setPreferredSize(new Dimension(100,75));	
        cell2.add(txtNom);
        JPanel cell3 = new JPanel();
        cell3.setPreferredSize(new Dimension(100,75));	
        cell3.add(lblPrenom);
        JPanel cell4 = new JPanel();
        cell4.setPreferredSize(new Dimension(100,75));	
        cell4.add(txtPrenom);
        JPanel cell5 = new JPanel();
        cell5.setPreferredSize(new Dimension(100,75));	
        JPanel cell6 = new JPanel();
        cell6.setPreferredSize(new Dimension(100,75));	
        JPanel cell7 = new JPanel();
        cell7.setPreferredSize(new Dimension(100,75));	
        cell7.add(lblAdresse);
        JPanel cell8 = new JPanel();
        cell8.setPreferredSize(new Dimension(100,75));	
        cell8.add(txtAdresse);
        JPanel cell9 = new JPanel();
        cell9.setPreferredSize(new Dimension(100,75));	
        cell9.add(lblPseudo);
        JPanel cell10 = new JPanel();
        cell10.setPreferredSize(new Dimension(100,75));	
        cell10.add(txtPseudo);
        JPanel cell11 = new JPanel();
        cell11.setPreferredSize(new Dimension(100,75));	
        JPanel cell12 = new JPanel();
        cell12.setPreferredSize(new Dimension(100,75));	
        JPanel cell13 = new JPanel();
        cell13.setPreferredSize(new Dimension(100,75));	
        cell13.add(lblResp);
        JPanel cell14 = new JPanel();
        cell14.setPreferredSize(new Dimension(100,75));	
        cell14.add(txtResp);
        JPanel cell15 = new JPanel();
        cell15.setPreferredSize(new Dimension(100,75));	
        cell15.add(lblDateNaiss);
        JPanel cell16 = new JPanel();
        cell16.setPreferredSize(new Dimension(100,75));	
        cell16.add(txtJourNaiss);
        JPanel cell17 = new JPanel();
        cell17.setPreferredSize(new Dimension(100,75));
        cell17.add(listMoisNaiss);
        JPanel cell18 = new JPanel();
        cell18.setPreferredSize(new Dimension(100,75));	
        cell18.add(txtAnneeNaiss);
        JPanel cell19 = new JPanel();
        cell19.setPreferredSize(new Dimension(100,75));	
        cell19.add(lblHobby);
        JPanel cell20 = new JPanel();
        cell20.setPreferredSize(new Dimension(100,75));	
        cell20.add(txtHobby);
        JPanel cell21 = new JPanel();
        cell21.setPreferredSize(new Dimension(100,75));	
        cell21.add(lblDateEmb);
        JPanel cell22 = new JPanel();
        cell22.setPreferredSize(new Dimension(100,75));	
        cell22.add(txtJourEmb);
        JPanel cell23 = new JPanel();
        cell23.setPreferredSize(new Dimension(100,75));
        cell23.add(listMoisEmb);
        JPanel cell24 = new JPanel();
        cell24.setPreferredSize(new Dimension(100,75));	
        cell24.add(txtAnneeEmb);
        
            //L'objet servant à positionner les composants
    GridBagConstraints gbc = new GridBagConstraints();
		
    //On positionne la case de départ du composant
    gbc.gridx = 0;
    gbc.gridy = 0;
    //La taille en hauteur et en largeur
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    pnlAttributs.add(cell1, gbc);
    //---------------------------------------------
    gbc.gridx = 1;
    pnlAttributs.add(cell2, gbc);
    //---------------------------------------------
    gbc.gridx = 2;		
    pnlAttributs.add(cell3, gbc);		
    //---------------------------------------------
    gbc.gridx = 3;		
    pnlAttributs.add(cell4, gbc);		
    //---------------------------------------------
    gbc.gridx = 4;		
    pnlAttributs.add(cell5, gbc);		
    //---------------------------------------------
    //Cette instruction informe le layout que c'est une fin de ligne
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    gbc.gridx = 5;	
    pnlAttributs.add(cell6, gbc);
    //---------------------------------------------
    //On positionne la case de départ du composant
    gbc.gridx = 0;
    gbc.gridy = 1;
    //La taille en hauteur et en largeur
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    pnlAttributs.add(cell7, gbc);
    //---------------------------------------------
    gbc.gridx = 1;
    pnlAttributs.add(cell8, gbc);
    //---------------------------------------------
    gbc.gridx = 2;		
    pnlAttributs.add(cell9, gbc);		
    //---------------------------------------------
    gbc.gridx = 3;		
    pnlAttributs.add(cell10, gbc);		
    //---------------------------------------------
    gbc.gridx = 4;		
    pnlAttributs.add(cell11, gbc);		
    //---------------------------------------------
    //Cette instruction informe le layout que c'est une fin de ligne
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    gbc.gridx = 5;	
    pnlAttributs.add(cell12, gbc);
    //---------------------------------------------
     //On positionne la case de départ du composant
    gbc.gridx = 0;
    gbc.gridy = 2;
    //La taille en hauteur et en largeur
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    pnlAttributs.add(cell13, gbc);
    //---------------------------------------------
    gbc.gridx = 1;
    pnlAttributs.add(cell14, gbc);
    //---------------------------------------------
    gbc.gridx = 2;		
    pnlAttributs.add(cell15, gbc);		
    //---------------------------------------------
    gbc.gridx = 3;		
    pnlAttributs.add(cell16, gbc);		
    //---------------------------------------------
    gbc.gridx = 4;		
    pnlAttributs.add(cell17, gbc);		
    //---------------------------------------------
    //Cette instruction informe le layout que c'est une fin de ligne
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    gbc.gridx = 5;	
    pnlAttributs.add(cell18, gbc);
    //---------------------------------------------
     //On positionne la case de départ du composant
    gbc.gridx = 0;
    gbc.gridy = 3;
    //La taille en hauteur et en largeur
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    pnlAttributs.add(cell19, gbc);
    //---------------------------------------------
    gbc.gridx = 1;
    pnlAttributs.add(cell20, gbc);
    //---------------------------------------------
    gbc.gridx = 2;		
    pnlAttributs.add(cell21, gbc);		
    //---------------------------------------------
    gbc.gridx = 3;		
    pnlAttributs.add(cell22, gbc);		
    //---------------------------------------------
    gbc.gridx = 4;		
    pnlAttributs.add(cell23, gbc);		
    //---------------------------------------------
    //Cette instruction informe le layout que c'est une fin de ligne
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    gbc.gridx = 5;	
    pnlAttributs.add(cell24, gbc);
    pane.add(pnlAttributs,BorderLayout.CENTER);

        pnlBoutons = new JPanel();
        pnlBoutons.add(btnSearch);
        pnlBoutons.add(btnReset);
        pnlBoutons.add(btnVal);
        pnlBoutons.add(btnCancel);
        pane.add(pnlBoutons,BorderLayout.SOUTH);

    }

    /**
     *
     * @param event
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == menuEx) {
            int choix = JOptionPane.showConfirmDialog(this, "Vérification", "Voulez-vous vraiment quitter?", JOptionPane.YES_NO_OPTION);
            if (choix == JOptionPane.YES_OPTION) {
                this.dispose();
            }
        } else if (event.getSource() == menuAll) {
            new AfficherVue().init();
            this.dispose();

        } else if (event.getSource() == menuDel) {
            new SupprimerVue().init();
            this.dispose();
        } else if (event.getSource() == menuAdd) {
            new AjouterVue().init();
            this.dispose();
        } else if (event.getSource() == menuMod) {
            new ModifierVue().init();
            this.dispose();
        } else if (event.getSource() == btnCancel) {
            new BienvenueVue().init();
            this.dispose();
        } else if (event.getSource() == btnReset) {
            reset();
        }
    }

    protected void reset() {
        txtNom.setText("");
        txtAdresse.setText("");
        txtResp.setText("");
        txtHobby.setText("");
        txtPrenom.setText("");
        txtPseudo.setText("");
        txtMat.setText("");
        txtJourNaiss.setText("");
        txtJourEmb.setText("");
        txtAnneeEmb.setText("");
        txtAnneeNaiss.setText("");
        listMoisEmb.setSelectedIndex(0);
        listMoisNaiss.setSelectedIndex(0);
    }

    protected String strcatDateE() {
        return txtAnneeEmb.getText() + '-' + (String) listMoisEmb.getSelectedItem() + '-' + txtJourEmb.getText();
    }

    protected String strcatDateN() {
        return txtAnneeNaiss.getText() + '-' + (String) listMoisNaiss.getSelectedItem() + '-' + txtJourNaiss.getText();
    }

    protected boolean fieldsFilled() {
        boolean res = true;

        txtNom.setText(txtNom.getText().trim().toUpperCase());
        txtAdresse.setText(txtAdresse.getText().trim());
        txtResp.setText(txtResp.getText().trim());
        txtHobby.setText(txtHobby.getText().trim());
        txtPrenom.setText(txtPrenom.getText().trim());
        txtPseudo.setText(txtPseudo.getText().trim());
        txtMat.setText(txtMat.getText().trim());
        txtJourNaiss.setText(txtJourNaiss.getText().trim());
        txtJourEmb.setText(txtJourEmb.getText().trim());
        txtAnneeEmb.setText(txtAnneeEmb.getText().trim());
        txtAnneeNaiss.setText(txtAnneeNaiss.getText().trim());

        if (txtMat.getText().equals("")) {
            lblMat.setForeground(Color.RED);
            res = false;
        } else {
            lblMat.setForeground(Color.WHITE);
        }

        if (txtNom.getText().equals("")) {
            lblNom.setForeground(Color.RED);
            res = false;
        } else {
            lblNom.setForeground(Color.BLACK);
        }

        if (txtAdresse.getText().equals("")) {
            lblAdresse.setForeground(Color.RED);
            res = false;
        } else {
            lblAdresse.setForeground(Color.BLACK);
        }

        if (txtResp.getText().equals("")) {
            lblResp.setForeground(Color.RED);
            res = false;
        } else {
            lblResp.setForeground(Color.BLACK);
        }

        if (txtHobby.getText().equals("")) {
            lblHobby.setForeground(Color.RED);
            res = false;
        } else {
            lblHobby.setForeground(Color.BLACK);
        }

        if (txtPrenom.getText().equals("")) {
            lblPrenom.setForeground(Color.RED);
            res = false;
        } else {
            lblPrenom.setForeground(Color.BLACK);
        }

        if (txtPseudo.getText().equals("")) {
            lblPseudo.setForeground(Color.RED);
            res = false;
        } else {
            lblPseudo.setForeground(Color.BLACK);
        }

        if (txtJourNaiss.getText().equals("")) {
            lblDateNaiss.setForeground(Color.RED);
            res = false;
        } else {
            lblDateNaiss.setForeground(Color.BLACK);
        }

        if (txtAnneeNaiss.getText().equals("")) {
            lblDateNaiss.setForeground(Color.RED);
            res = false;
        } else {
            lblDateNaiss.setForeground(Color.BLACK);
        }

        if (txtJourEmb.getText().equals("")) {
            lblDateEmb.setForeground(Color.RED);
            res = false;
        } else {
            lblDateEmb.setForeground(Color.BLACK);
        }

        if (txtAnneeEmb.getText().equals("")) {
            lblDateEmb.setForeground(Color.RED);
            res = false;
        } else {
            lblDateEmb.setForeground(Color.BLACK);
        }

        return res;
    }

}
