
package ihm;

import data.DataTransac;

/**
 *
 * @author agilan.colbert
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //DataTransac dt = new DataTransac();
        //dt.createProgrammeur("test", "test", "test", "test", "test", "test", "test", "2002-12-05", "2018-10-24");
        //dt.deleteProgrammeur("test");
        //dt.updateProgrammeur("test", "BENZEBUT", "Karime", "test", "test", "test", "test", "2002-12-05", "2018-10-24");
        
        new Vue().init();
    }
    
}
