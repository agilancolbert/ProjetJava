package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import myutil.Constantes;

/**
 *
 * @author agilan.colbert
 */
public class DataTransac implements ActionsBD {
    private Connection dbConn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private ArrayList<Programmeur> listeProgrammeurs;
    private Programmeur prog;
    
      /**
     * Le constructeur permet d'initialiser la connexion
     *
     */
    public DataTransac() {
        try {
            dbConn = DriverManager.getConnection(Constantes.URL, Constantes.USER, Constantes.MDP);
        } catch (SQLException sqle) {
            Logger.getLogger(DataTransac.class.getName()).log(Level.SEVERE, null, sqle);
        }

    }
    
      /**
     * Cette méthode récupère toutes les infos d'un programmeur et retourne une
     * liste de l'ensemble des programmeurs
     *
     * @return listeProgrammeurs Une variable de type ArryList
     */
    public ArrayList getProgrammeurs() {
        rs = this.getResultSet(Constantes.REQUETE_TOUS);
        listeProgrammeurs = new ArrayList<>();

        try {
            while (rs.next()) {
                prog = new Programmeur();
                prog.setId(rs.getInt("ID"));
                prog.setMatricule(rs.getString("MATRICULE"));
                prog.setNom(rs.getString("NOM"));
                prog.setPrenom(rs.getString("PRENOM"));
                prog.setAdresse(rs.getString("ADRESSE"));
                prog.setPseudo(rs.getString("PSEUDO"));
                prog.setResponsable(rs.getString("RESPONSABLE"));
                prog.setHobby(rs.getString("HOBBY"));
                prog.setDateNaiss(rs.getString("DATE_NAISS"));
                prog.setPseudo(rs.getString("DATE_EMB"));
                listeProgrammeurs.add(prog);
            }
        } catch (SQLException sqle) {
            Logger.getLogger(DataTransac.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return listeProgrammeurs;
    }
    
      /**
     * Cette méthode permet de construire la chaîne de caractères qui sera
     * affichée lorsqu'on choisit Programmeur - Afficher - Tous
     *
     * @return listeProg Une variable de type String
     *
     */
    public String afficherProgrammeurs() {
        String listeProg = "";

        listeProgrammeurs = this.getProgrammeurs();
        for (Programmeur progr : listeProgrammeurs) {
            listeProg = listeProg + progr;
        }

        return listeProg;
    }
    
    /**
     * Lance la récupère passée en paramètre et retourne le ResultSet
     * correspondant à cette requête
     *
     * @param req La requête SQL que l'on souhaite exécuter
     * @return rs Une variable de type ResultSet
     */
    @Override
    public ResultSet getResultSet(String req) {
          try {
            stmt = dbConn.createStatement();
            rs = stmt.executeQuery(req);
        } catch (SQLException sqle) {
            Logger.getLogger(DataTransac.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return rs;
    }
    
    /**
     * Cette méthode permet de libérer les ressources liées à la base de données
     * *
     */
    @Override
    public void fermerRessources() {
        if (dbConn != null) {
            try {
                dbConn.close();
                if (stmt != null) {
                    stmt.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                dbConn = null;
            } catch (SQLException ex) {
                Logger.getLogger(DataTransac.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
