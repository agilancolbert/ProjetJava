/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import data.DataTransac;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author agilan.colbert & kevin.rattinam
 */
public class AjouterVue extends GestionVueAbstraite implements ActionListener {

    @Override
    public void init() {
        super.init();
        initInterfaceAttributs();
        btnSearch.setEnabled(false);
        btnVal.addActionListener(this);
        btnCancel.addActionListener(this);
        btnReset.addActionListener(this);
        txtJourNaiss.setText("");
        txtAnneeNaiss.setText("");
        txtJourEmb.setText("");
        txtAnneeEmb.setText("");
        txtMat.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        super.actionPerformed(event);
        if (event.getSource() == btnVal) {
            String matriculeEntre = txtMat.getText();
            String nomEntre = txtNom.getText();
            String prenomEntre = txtPrenom.getText();
            String adresseEntre = txtAdresse.getText();
            String pseudoEntre = txtPseudo.getText();
            String respEntre = txtResp.getText();
            String hobbyEntre = txtHobby.getText();
            String dateN = strcatDateN();
            String dateE = strcatDateE();

            if (!fieldsFilled()) {
                JOptionPane.showMessageDialog(this, "Ajout impossible", "Echec", JOptionPane.ERROR_MESSAGE);
                return;
            }

            dt = new DataTransac();
            dt.createProgrammeur(matriculeEntre, nomEntre, prenomEntre, adresseEntre, pseudoEntre, respEntre, hobbyEntre, dateN, dateE);
            JOptionPane.showMessageDialog(this, "Ajout réussi!", "Succès!", JOptionPane.INFORMATION_MESSAGE);
            dt.fermerRessources();
        }
    }

}
