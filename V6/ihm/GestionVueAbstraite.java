package ihm;

import data.DataTransac;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
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
        setBounds(10, 10, 600, 300);
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
        txtAnneeNaiss.setColumns(10);

        txtAnneeEmb = new JFormattedTextField(maskAnnee);
        txtAnneeEmb.setColumns(10);

        txtJourEmb = new JFormattedTextField(maskJour);
        txtJourEmb.setColumns(10);

        txtJourNaiss = new JFormattedTextField(maskJour);
        txtJourNaiss.setColumns(10);

        txtMat = new JFormattedTextField(maskMat);
        txtMat.setColumns(10);

        listMoisEmb = new JComboBox(Constantes.CONTENU_COMBOBOX);

        listMoisNaiss = new JComboBox(Constantes.CONTENU_COMBOBOX);

        pane.add(lblMat);
        pane.add(txtMat);
        pane.add(Box.createRigidArea(new Dimension(430, 50)));
        pane.add(lblNom);
        pane.add(Box.createRigidArea(new Dimension(10, 0)));
        pane.add(txtNom);
        pane.add(Box.createRigidArea(new Dimension(150, 0)));
        pane.add(lblPrenom);
        pane.add(Box.createRigidArea(new Dimension(10, 0)));
        pane.add(txtPrenom);
        pane.add(Box.createRigidArea(new Dimension(104, 0)));
        pane.add(lblAdresse);
        pane.add(txtAdresse);
        pane.add(Box.createRigidArea(new Dimension(150, 0)));
        pane.add(lblPseudo);
        pane.add(Box.createRigidArea(new Dimension(10, 0)));
        pane.add(txtPseudo);
        pane.add(Box.createRigidArea(new Dimension(80, 0)));
        pane.add(lblResp);
        pane.add(txtResp);
        pane.add(Box.createRigidArea(new Dimension(80, 0)));
        pane.add(lblDateNaiss);
        pane.add(txtJourNaiss);
        pane.add(listMoisNaiss);
        pane.add(txtAnneeNaiss);

        pane.add(lblHobby);
        pane.add(txtHobby);
        pane.add(Box.createRigidArea(new Dimension(80, 0)));

        pane.add(lblDateEmb);
        pane.add(txtJourEmb);
        pane.add(listMoisEmb);
        pane.add(txtAnneeEmb);
        pane.add(Box.createRigidArea(new Dimension(80, 100)));

        pane.add(btnSearch);
        pane.add(btnReset);
        pane.add(btnVal);
        pane.add(btnCancel);

    }

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
            lblMat.setForeground(Color.BLACK);
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
