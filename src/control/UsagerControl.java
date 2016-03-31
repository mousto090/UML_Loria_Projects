package control;

import BibalExceptions.ChampsControlExceptions;
import BibalExceptions.DAOConfigurationException;
import BibalExceptions.DAOExceptions;
import DAO.DBConnection;
import DAO.implementDAO.UsagerDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import objets_metiers.Usager;

public class UsagerControl {

    public void ajouter(int id, String nom, String prenom, String dateNais, String sexe,
            String adresse, String tel) throws ChampsControlExceptions {

        
        try {
            Usager usager = new Usager();
            UsagerDAO usagerDao = new UsagerDAO(DBConnection.getConnection());
            
            controlNom(nom);
            usager.setNom(nom);
            controlPrenom(prenom);
            usager.setPrenom(prenom);
            usager.setDateNais(controlDateNaiss(dateNais));
            controlSexe(sexe);
            usager.setSexe(sexe);
            controlAdresse(adresse);
            usager.setAdresse(adresse);
            controlTel(tel);
            usager.setTel(tel);
            
            
            //usagerDao.find(5);
            //usagerDao.inserer(usager);
//            ArrayList<Usager> u ;
//            u = usagerDao.getAll();
//            System.out.println("control.UsagerControl.creerUsager() \n" + u);
//            u.get(0).setAdresse("AAAAAA");
//            u.get(0).setNom("NNNN");
//            u.get(0).setPrenom("PPPP");
//            usagerDao.update(u.get(0));
//            u = usagerDao.getAll();
//            System.out.println("control.UsagerControl.creerUsager() \n" + u.size() );
             //System.out.println("control.UsagerControl.creerUsager() \n" + usagerDao.find(3));

        } catch (ChampsControlExceptions e) {
            throw new ChampsControlExceptions(e.getMessage());
        } catch (SQLException e) {
            throw new DAOConfigurationException(e.getMessage());
        }
    }

    public void modifier(int id) throws DAOExceptions{
        
    }
    
   
    public Usager find(int id) throws DAOExceptions{
        Usager usager = null;
        try {
            UsagerDAO usagerDao = new UsagerDAO(DBConnection.getConnection());
            usager  = usagerDao.find(id);
        } catch (SQLException e) {
            throw new DAOExceptions(getClass().getName() + e.getMessage());
        }
        return usager;
    }
    
    public Usager find(String nom) throws DAOExceptions{
        return null;
    }
    
    
    
    
    private void controlNom(String nom) throws ChampsControlExceptions {
        if (null != nom) {
            if (nom.length() < 3) {
                throw new ChampsControlExceptions("Le nom de l'usager doit contenir "
                        + "au moins 3 caractères");
            }
        } else {
            throw new ChampsControlExceptions("Merci de saisir le nom de l'usager");
        }
    }

    private void controlPrenom(String prenom) throws ChampsControlExceptions {
        if (null != prenom) {
            if (prenom.length() < 3) {
                throw new ChampsControlExceptions("Le prénom de l'usager doit contenir "
                        + "au moins 3 caractères");
            }
        } else {
            throw new ChampsControlExceptions("Merci de saisir le prénom de l'usager");
        }
    }

    private Date controlDateNaiss(String dateNais) throws ChampsControlExceptions {

        if (null != dateNais) {
            try {
                return new SimpleDateFormat("dd/mm/yyyy").parse(dateNais);
            } catch (ParseException e) {
                System.out.println("control.UsagerControl.controlDateNaiss()");
                throw new ChampsControlExceptions("Date non valide ", e.getCause());
            }
        } else {
            throw new ChampsControlExceptions("Merci d'indiquer la date de naissance ");
        }
    }

    private void controlSexe(String sexe) throws ChampsControlExceptions {
        if (null == sexe) {
            throw new ChampsControlExceptions("Merci de préciser le sexe de l'usager");
        }
    }

    private void controlAdresse(String adresse) throws ChampsControlExceptions {
        if (null != adresse) {
            if (adresse.length() < 10) {
                throw new ChampsControlExceptions("L'adresse doit contenir "
                        + "au moins 10 caractères");
            }
        } else {
            throw new ChampsControlExceptions("Merci de renseigner l'adresse de l'usager");
        }
    }

    private void controlTel(String tel) throws ChampsControlExceptions {
        if (null != tel) {
            if (tel.length() < 10) {
                throw new ChampsControlExceptions("Le numero de téléphone doit se composer \n"
                        + "au moins de 10 chiffres");
            }
        } else {
            throw new ChampsControlExceptions("Merci de saisir un numéro de téléphone ");
        }
    }
}
