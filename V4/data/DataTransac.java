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
     * Cette méthode récupère toutes les infos d'un programmeur et retourne ce
     * programmeur sous la forme d'un Java  Cette méthode est utilisée pour
     * rechercher un progammeur via son matricule
     *
     * @param matricule Le matricule saisi par l'utilisateur pour lancer la recherche
     * @return prog Une variable de type Programmeur
     *
     */
    public Programmeur getProgrammeur(String matricule) {
        try {
            pstmt = dbConn.prepareStatement(Constantes.REQUETE_UNIQUE);
            pstmt.setString(1, matricule);
            rs = pstmt.executeQuery();

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
                prog.setDateEmb(rs.getString("DATE_EMB"));
            }
        } catch (SQLException sqle) {
            Logger.getLogger(DataTransac.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return prog;
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
                prog.setDateEmb(rs.getString("DATE_EMB"));
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
            listeProg += progr;
            listeProg += "\n";
        }

        return listeProg;
    }
     /**
     * Cette méthode permet d'ajouter/créer un programmeur dans la JDBC
     *
     * @param matricule : matricule du programmeur
     * @param nom : nom du programmeur
     * @param prenom : prenom du programmeur
     * @param adresse : adresse du programmeur
     * @param pseudo : pseudo du programmeur
     * @param responsable : responsable du programmeur
     * @param hobby : hobby du programmeur
     * @param dateNaiss : date de naissance du programmeur
     * @param dateEmb : : date d'embauche du programmeur
     * @return une valeur positive indiquant la création de ligne
     *        ou -1 qui indique l'erreur
     */
    public int createProgrammeur(String matricule,String nom,String prenom,
                                 String adresse, String pseudo, String responsable,
                                 String hobby, String dateNaiss, String dateEmb){
       
        try {
            pstmt = dbConn.prepareStatement(Constantes.REQUETE_ADD);
            pstmt.setString(1,matricule);
            pstmt.setString(2,nom);
            pstmt.setString(3,prenom);
            pstmt.setString(4,adresse);
            pstmt.setString(5,pseudo);
            pstmt.setString(6,responsable);
            pstmt.setString(7,hobby);
            pstmt.setString(8,dateNaiss);
            pstmt.setString(9,dateEmb);
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataTransac.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return -1;
    }
    
    /**
     * Cette méthode permet de supprimer un programmeur dans la JDBC en fonction du matricule 
     *
     * @param matricule : matricule du programmeur à effacer
     * 
     * @return une valeur positive indiquant la suppréssion de ligne
     *        ou -1 pour indiquer l'erreur de suppression
     * */
    public int deleteProgrammeur(String matricule){
        try {
            pstmt = dbConn.prepareStatement(Constantes.REQUETE_DELETE);
            pstmt.setString(1, matricule);
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataTransac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public int updateProgrammeur(String matricule,String nom,String prenom,
                                 String adresse, String pseudo, String responsable,
                                 String hobby, String dateNaiss, String dateEmb){
        try {
            pstmt = dbConn.prepareStatement(Constantes.REQUETE_UPDATE);
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, adresse);
            pstmt.setString(4, pseudo);
            pstmt.setString(5, responsable);
            pstmt.setString(6, hobby);
            pstmt.setString(7, dateNaiss);
            pstmt.setString(8, dateEmb);
            pstmt.setString(9, matricule);
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataTransac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
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
