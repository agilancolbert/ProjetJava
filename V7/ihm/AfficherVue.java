package ihm;

import data.DataTransac;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author agilan.colbert & kevin.rattinam
 */
public class AfficherVue extends GestionVueAbstraite {

    private JTextArea zoneAffichageProg;
    private JScrollPane scroll;
    private String contenuTextArea;

    @Override
    public void init() {

        super.init();
        zoneAffichageProg = new JTextArea(10, 65);
        scroll = new JScrollPane(zoneAffichageProg);
        super.getPane().add(scroll);
        dt = new DataTransac();
        contenuTextArea = dt.afficherProgrammeurs();
        zoneAffichageProg.setText(contenuTextArea);
        dt.fermerRessources();
    }

}
