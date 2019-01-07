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
import javax.swing.JOptionPane;

/**
 *
 * @author agilan.colbert & kevin.rattinam
 */
public class ModifierVue extends GestionVueAbstraite implements ActionListener {

    @Override
    public void init() {
        super.init();
        initInterfaceAttributs();
        btnReset.setEnabled(false);
        btnVal.setEnabled(false);

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
        super.actionPerformed(event);
        if (event.getSource() == btnVal) {
            if (!fieldsFilled()) {
                JOptionPane.showMessageDialog(this, "Modification impossible", "Echec", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(this, "Modification réussie!", "Succès!", JOptionPane.INFORMATION_MESSAGE);
            dt.fermerRessources();
        } else if (event.getSource() == btnCancel) {
            new BienvenueVue().init();
            this.dispose();
        } else if (event.getSource() == btnReset) {
            reset();
        } else if (event.getSource() == btnSearch) {
            dt = new DataTransac();
            Programmeur p = dt.getProgrammeur(txtMat.getText());
            if (p == null) {
                JOptionPane.showMessageDialog(this, "Programmeur introuvable", "Echec", JOptionPane.ERROR_MESSAGE);
                txtMat.setText("");
            } else {
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

}
