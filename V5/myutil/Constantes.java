package myutil;

/**
 *
 * @author agilan.colbert
 */
public class Constantes {
    
    public static final String OCCUPATION = "Programmeur";
    public static final String URL = "jdbc:derby://localhost:1527/LSI_L3_JAVA";
    public static final String USER = "adm";
    public static final String MDP = "adm";
    public static final String REQUETE_TOUS = "SELECT * from PROGRAMMEUR";    
    public static final String REQUETE_UNIQUE = "SELECT * from PROGRAMMEUR WHERE MATRICULE = ?";
    public static final String REQUETE_ADD = "INSERT INTO PROGRAMMEUR(MATRICULE,NOM,PRENOM,ADRESSE,"
            + "PSEUDO,RESPONSABLE,HOBBY,DATE_NAISS,DATE_EMB) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ?)";
    public static final String REQUETE_DELETE = "DELETE FROM PROGRAMMEUR WHERE MATRICULE = ?";
    public static final String REQUETE_UPDATE = "UPDATE PROGRAMMEUR SET NOM = ?," +
            "PRENOM = ?, ADRESSE = ?, PSEUDO = ?, RESPONSABLE = ?, HOBBY = ?, DATE_NAISS = ?, DATE_EMB= ?" +
            "WHERE MATRICULE = ?";
    
    public static final String[] CONTENU_COMBOBOX = {"01","02","03","04","05","06","07","08","09","10","11","12"};
}