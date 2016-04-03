/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibal;

import BibalExceptions.ChampsControlExceptions;
import DAO.Utility;
import control.UsagerControl;
import objets_metiers.Livre;
import objets_metiers.Magazine;
import objets_metiers.Usager;
import static DAO.Utility.formatDate;

/**
 *
 * @author Jalloh
 */
public class Bibal {

    /**
     * @param args the command line arguments
     */
    private static final String TYPE_MAGAZINE = Magazine.class.getSimpleName();
    private static final String TYPE_LIVRE = Livre.class.getSimpleName();

    public static void main(String[] args) throws ChampsControlExceptions {
        System.out.println("\t\t===== LES TESTS  ===========");

//        ====Test creer usager========
//        System.out.println("Creer un usager");
//        try {
            UsagerControl usagerControl = new UsagerControl();
//            usagerControl.ajouter("DIALLO", "Mamadou", Utility.formatDate("12/12/1995"),
//                    "M", "kamra cym rabat", "0695949494");
//            Usager usager = new Usager(3,"BARRY", "ALIOU", Utility.formatDate("01/11/1990"),
//                    "M", "Rabat", "0695949494");
//            usager.setAdresse("kamra cym rabat");
//            usager.setTel("0695949494");
//            UsagerControl usagerControl = new UsagerControl();
//            usagerControl.ajouter(usager);
            
        usagerControl.modifier(3,"BARRY", "ALIOU", formatDate("16/06/1992"),
                    "M", "Agdal Rabat", "0695949494");
//        } catch ( ChampsControlExceptions e) {
//            System.out.println("bibal.Bibal.main()" + e.getMessage());
//        }
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
//        ============== Test oeuvres =============
//        OeuvreControl oeuvreControl = new OeuvreControl();
        //Oeuvre oeuvre = new Magazine(10,"Magazine 10", "Auteur 1", "Categorie 2", 32);
        //Oeuvre oeuvre = new Livre(1,"Livre 2", "Auteur 2", "Categorie 2", 35);

        //oeuvre.setAuteur("Auteur");
        //oeuvreControl.ajouter(oeuvre);
        //oeuvreControl.modifier(oeuvre);
        //oeuvreControl.ajouter("Magazine 7", "Auteur 4", "Categorie 3", 32, TYPE_MAGAZINE);
//        oeuvreControl.modifier(12,"Magazine 7", "Auteur 4", "Categorie 3", 30,6, TYPE_MAGAZINE);
//        System.out.println("bibal.Bibal.main()" + oeuvreControl.find("Livre"));

    }

}
