/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import data.DataTransac;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author agilan.colbert & kevin.rattinam
 */
public class SupprimerVue extends GestionVueAbstraite implements ActionListener {

    @Override
    public void init() {
        super.init();
        initInterfaceAttributs();

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

        btnVal.addActionListener(this);
        btnCancel.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event);
        if (event.getSource() == btnVal) {
            String matriculeEntre = txtMat.getText();
            dt = new DataTransac();
            int res = dt.deleteProgrammeur(matriculeEntre);
            if (res == 0) {
                JOptionPane.showMessageDialog(this, "Programmeur introuvable", "Echec", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Suppression réussie!", "Succès!", JOptionPane.INFORMATION_MESSAGE);
            }
            dt.fermerRessources();

        } else if (event.getSource() == btnCancel) {
            new BienvenueVue().init();
            this.dispose();
        }
    }
}
