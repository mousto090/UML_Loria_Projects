/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibal;

import BibalExceptions.ChampsControlExceptions;
import DAO.DBConnection;
import DAO.Utility;
import DAO.implementDAO.UsagerDAO;
import control.UsagerControl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import objets_metiers.Usager;

/**
 *
 * @author Jalloh
 */
public class Bibal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\t\t===== LES TESTS  ===========");

//        ====Test creer usager========
        System.out.println("Creer un usager");
        try {
            UsagerControl usagerControl = new UsagerControl();
//            usagerControl.ajouter("DIALLO", "Mamadou", Utility.formatDate("12/12/1995"),
//                    "M", "kamra cym rabat", "0695949494");
            
            Usager usager = new Usager(3,"BARRY", "ALIOU", Utility.formatDate("01/11/1990"),
                    "M", "Rabat", "0695949494");
            usager.setAdresse("kamra cym rabat");
            usager.setTel("0695949494");
           // usagerControl.ajouter(usager);
            
            usagerControl.modifier(usager);
            
            
            
        } catch ( ChampsControlExceptions e) {
            System.out.println("bibal.Bibal.main()" + e.getMessage());
        }

//        ============Test liste usagers===========
//        try {
//
//            UsagerDAO usagerDao = new UsagerDAO(DBConnection.getConnection());
//            ArrayList<Usager> array = usagerDao.getAll();
//            System.out.println("bibal.Bibal.main()" + array);
//        } catch (SQLException ex) {
//        }

//         == == == = Test find with id == == =
//        try {
//            UsagerControl usagerControl = new UsagerControl();
//            Usager usager = usagerControl.find(3);
//            System.out.println(usager);
//        } catch (Exception e) {
//            System.out.println("bibal.Bibal.main()" + e.getMessage());
//        }
    }

}
