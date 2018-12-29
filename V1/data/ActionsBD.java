package data;

import java.sql.ResultSet;

/**
 *
 * @author agilan.colbert
 */
public interface ActionsBD {
     ResultSet getResultSet(String req);
     void fermerRessources();
}
