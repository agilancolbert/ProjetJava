/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import data.DataTransac;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import myutil.Constantes;

/**
 *
 * @author Kevin
 */
public class SupprimerVue extends GestionVueAbstraite implements ActionListener {
    
    private JButton btnSearch, btnReset, btnVal, btnCancel;
    private JLabel lblNom, lblAdresse, lblResp, lblHobby, lblPrenom, lblPseudo, lblDateNaiss, lblDateEmb, lblMat;
    private JTextField txtNom, txtAdresse, txtResp, txtHobby, txtPrenom, txtPseudo, txtJourNaiss, txtAnneeNaiss, txtJourEmb, txtAnneeEmb, txtMat;
    private JComboBox listMoisNaiss, listMoisEmb;
    private JMenuItem menuMod, menuDel,menuAdd, menuAll, menuEx;
    private DataTransac dt;    
    
    public void init()
    {
        super.init();
        
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
        
        txtAnneeNaiss = new JTextField();
        txtAnneeNaiss.setColumns(10);
        
        txtAnneeEmb = new JTextField();
        txtAnneeEmb.setColumns(10);
        
        txtJourEmb = new JTextField();
        txtJourEmb.setColumns(10);
        
        txtJourNaiss = new JTextField();
        txtJourNaiss.setColumns(10);
        
        txtMat = new JTextField();
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
        super.getPane().add(btnSearch);
        
        
        lblNom.setEnabled(false);
        txtNom.setEnabled(false);
        
        lblAdresse.setEnabled(false);
        txtAdresse.setEnabled(false);
        
        lblResp.setEnabled(false);
        txtResp.setEnabled(false);
        
        lblHobby.setEnabled(false);
        txtHobby.setEnabled(false);
        
        lblPrenom.setEnabled(false);
        txtPrenom.setEnabled(false);
        
        lblPseudo.setEnabled(false);
        txtPseudo.setEnabled(false);
        
        lblDateNaiss.setEnabled(false);
        txtJourNaiss.setEnabled(false);
        listMoisNaiss.setEnabled(false);
        txtAnneeNaiss.setEnabled(false);
        
        lblDateEmb.setEnabled(false);
        txtJourEmb.setEnabled(false);
        listMoisEmb.setEnabled(false);
        txtAnneeEmb.setEnabled(false);
        
        btnSearch.setEnabled(false);
        btnReset.setEnabled(false);
        
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
        
        btnVal.addActionListener(this);
        btnCancel.addActionListener(this);
        
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
        
        else if(event.getSource() == btnVal){
            String matriculeEntre = txtMat.getText();
            dt = new DataTransac();
            int res = dt.deleteProgrammeur(matriculeEntre);
            if (res == 0){
                JOptionPane.showMessageDialog(this, "Programmeur introuvable", "Echec",JOptionPane.ERROR_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(this, "Suppression réussie!", "Succès!",JOptionPane.INFORMATION_MESSAGE);
            }
            dt.fermerRessources();
            
        }
        
        else if(event.getSource() == btnCancel)
        {
            new BienvenueVue().init();
            this.dispose();
        }
        
        else if(event.getSource() == menuAdd){
            new AjouterVue().init();
            this.dispose();
        }
    }
}
   
