/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import data.DataTransac;
import data.Programmeur;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import myutil.Constantes;

/**
 *
 * @author Kevin
 */
public class ModifierVue extends GestionVueAbstraite implements ActionListener {
    
  /*  private JButton btnSearch, btnReset, btnVal, btnCancel;
    private JLabel lblNom, lblAdresse, lblResp, lblHobby, lblPrenom, lblPseudo, lblDateNaiss, lblDateEmb, lblMat;
    private JTextField txtNom, txtAdresse, txtResp, txtHobby, txtPrenom, txtPseudo, txtMat,txtJourEmb,txtAnneeEmb,txtJourNaiss,txtAnneeNaiss;    
    private JComboBox listMoisNaiss, listMoisEmb;*/
  //  private JMenuItem menuMod, menuDel,menuAdd, menuAll, menuEx;
   // private DataTransac dt;
    
    
    @Override
    public void init()
    {
        super.init();
        
      /*  btnSearch = new JButton("Rechercher");
        btnReset = new JButton("Réinitialiser");
        btnVal = new JButton("Valider");
        btnCancel = new JButton("Annuler");
        
        lblNom = new JLabel("Nom");
        lblAdresse = new JLabel("Adresse");
        lblResp = new JLabel("Responsable");
        lblHobby = new JLabel("Hobby");
        lblPrenom = new JLabel("Prénom");
        lblPseudo = new JLabel("Pseudo");
        lblDateNaiss= new JLabel("Date de naissance");
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
        
        super.getPane().add(lblMat);
        super.getPane().add(txtMat);
        
        super.getPane().add(lblNom);
        super.getPane().add(txtNom);
        
        super.getPane().add(lblAdresse);
        super.getPane().add(txtAdresse);
        
        super.getPane().add(lblResp);
        super.getPane().add(txtResp);
        
        super.getPane().add(lblHobby);
        super.getPane().add(txtHobby);

        super.getPane().add(lblPrenom);
        super.getPane().add(txtPrenom);
        
        super.getPane().add(lblPseudo);
        super.getPane().add(txtPseudo);
        
        super.getPane().add(lblDateNaiss);
        super.getPane().add(txtJourNaiss);
        super.getPane().add(listMoisNaiss);
        super.getPane().add(txtAnneeNaiss);
        
        super.getPane().add(lblDateEmb);
        super.getPane().add(txtJourEmb);
        super.getPane().add(listMoisEmb);
        super.getPane().add(txtAnneeEmb);
                
        
        super.getPane().add(btnCancel);
        super.getPane().add(btnReset);
        super.getPane().add(btnVal);
        super.getPane().add(btnSearch);*/
        initInterfaceAttributs();
        
        btnReset.setEnabled(false);
        btnVal.setEnabled(false);
        
        
        
       /* 
        menuAdd = super.getMenuAdd();
        menuAdd.addActionListener(this);
        
        menuMod = super.getMenuMod();
        menuMod.addActionListener(this);
        
        menuDel = super.getMenuDel();
        menuDel.addActionListener(this);
        
        menuAll = super.getMenuAll();
        menuAll.addActionListener(this);
        
        menuEx = super.getMenuEx();
        menuEx.addActionListener(this);*/
        
        btnVal.addActionListener(this);
        btnCancel.addActionListener(this);
        btnReset.addActionListener(this);
        btnSearch.addActionListener(this);
        
        txtJourNaiss.setText("");
        txtAnneeNaiss.setText("");
        
        txtJourEmb.setText("");
        txtAnneeEmb.setText("");
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent event) {
       /* if (event.getSource() == menuEx){
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
        
        else*/
       super.actionPerformed(event);
        if(event.getSource() == btnVal){
            if(!fieldsFilled()){
                JOptionPane.showMessageDialog(this, "Modification impossible", "Echec",JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String matriculeEntre = txtMat.getText();
            String nomEntre = txtNom.getText();
            String prenomEntre = txtPrenom.getText();
            String adresseEntre = txtAdresse.getText();
            String pseudoEntre = txtPseudo.getText();
            String respEntre = txtResp.getText();
            String hobbyEntre = txtHobby.getText();
            String dateN = strcatDateN();
            String dateE = strcatDateE();
            
            dt = new DataTransac();
            dt.updateProgrammeur(matriculeEntre, nomEntre, prenomEntre, adresseEntre, pseudoEntre, respEntre, hobbyEntre, dateN, dateE);
            JOptionPane.showMessageDialog(this, "Modification réussie!", "Succès!",JOptionPane.INFORMATION_MESSAGE);
            dt.fermerRessources();
        }
        else if(event.getSource() == btnCancel)
        {
            new BienvenueVue().init();
            this.dispose();
        }
        else if(event.getSource() == btnReset)
            reset();
        
        else if(event.getSource() == btnSearch){
            dt = new DataTransac();
            Programmeur p = dt.getProgrammeur(txtMat.getText());
            if(p == null){
                JOptionPane.showMessageDialog(this, "Programmeur introuvable", "Echec",JOptionPane.ERROR_MESSAGE);
                txtMat.setText("");
            }
            else
            {
                txtNom.setText(p.getNom());
                txtAdresse.setText(p.getAdresse());
                txtResp.setText(p.getResponsable());
                txtHobby.setText(p.getHobby());
                txtPrenom.setText(p.getPrenom());
                txtPseudo.setText(p.getPseudo());
                txtJourNaiss.setText(p.getJourDateNaiss());
                txtJourEmb.setText(p.getJourDateEmb());
                txtAnneeEmb.setText(p.getAnneeDateEmb());
                txtAnneeNaiss.setText(p.getAnneeDateNaiss());
                int numb = Integer.parseInt(p.getMoisDateNaiss()) - 1;
                listMoisNaiss.setSelectedIndex(numb);
                numb = Integer.parseInt(p.getMoisDateEmb()) - 1;
                listMoisEmb.setSelectedIndex(numb);
                btnSearch.setEnabled(false);
                btnVal.setEnabled(true);
            }
        }
    }
    
    private String strcatDateE(){
        return txtAnneeEmb.getText() + '-' + (String)listMoisEmb.getSelectedItem() + '-' + txtJourEmb.getText() ;
    }
    
    private String strcatDateN(){
        return txtAnneeNaiss.getText() + '-' + (String)listMoisNaiss.getSelectedItem() + '-' + txtJourNaiss.getText() ;
    }
    
    /*private void reset(){
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
    }*/

    private boolean fieldsFilled() {
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
        
        if(txtMat.getText().equals("")){
            lblMat.setForeground(Color.RED);
            res = false;
        }
        else
            lblMat.setForeground(Color.BLACK);
        
        if(txtNom.getText().equals("")){
            lblNom.setForeground(Color.RED);
            res = false;
        }
        else
            lblNom.setForeground(Color.BLACK);
        
        if(txtAdresse.getText().equals("")){
            lblAdresse.setForeground(Color.RED);
            res = false;
        }
        else
            lblAdresse.setForeground(Color.BLACK);
        
        if(txtResp.getText().equals("")){
            lblResp.setForeground(Color.RED);
            res = false;
        }
        else
            lblResp.setForeground(Color.BLACK);
        
        if(txtHobby.getText().equals("")){
            lblHobby.setForeground(Color.RED);
            res = false;
        }
        else
            lblHobby.setForeground(Color.BLACK);
        
        if(txtPrenom.getText().equals("")){
            lblPrenom.setForeground(Color.RED);
            res = false;
        }
        else
            lblPrenom.setForeground(Color.BLACK);
        
        if(txtPseudo.getText().equals("")){
            lblPseudo.setForeground(Color.RED);
            res = false;
        }
        else
            lblPseudo.setForeground(Color.BLACK);
        
        if(txtJourNaiss.getText().equals("")){
            lblDateNaiss.setForeground(Color.RED);
            res = false;
        }
        else
            lblDateNaiss.setForeground(Color.BLACK);
        
        if(txtAnneeNaiss.getText().equals("")){
            lblDateNaiss.setForeground(Color.RED);
            res = false;
        }
        else
            lblDateNaiss.setForeground(Color.BLACK);
        
        if(txtJourEmb.getText().equals("")){
            lblDateEmb.setForeground(Color.RED);
            res = false;
        }
        else
            lblDateEmb.setForeground(Color.BLACK);
        
        if(txtAnneeEmb.getText().equals("")){
            lblDateEmb.setForeground(Color.RED);
            res = false;
        }
        else
            lblDateEmb.setForeground(Color.BLACK);
        
        return res;
    }
}