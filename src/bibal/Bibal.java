/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibal;

import DAO.DBConnection;
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
//        System.out.println("Creer un usager");
//        try {
//
//            UsagerDAO usagerDao = new UsagerDAO(DBConnection.getConnection());
//            Usager usager = new Usager(1, "Diallo", "Mamadou", new Date("12/12/2000"),
//                    "M", "Rabat", "0695949494");
//
//            usager.setAdresse("Rabat");
//            usager.setTel("0695949494");
//            usagerDao.inserer(usager);
//        } catch (SQLException ex) {
//        }

//        ============Test liste usagers===========
        try {

            UsagerDAO usagerDao = new UsagerDAO(DBConnection.getConnection());
            ArrayList<Usager> array = usagerDao.getAll();
            System.out.println("bibal.Bibal.main()" + array);
        } catch (SQLException ex) {
        }

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
