package control;

import BibalExceptions.ChampsControlExceptions;
import BibalExceptions.DAOConfigurationException;
import BibalExceptions.DAOExceptions;
import DAO.DBConnection;
import DAO.implementDAO.UsagerDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import objets_metiers.Usager;

public class UsagerControl {

    public void ajouter(String nom, String prenom, Date dateNais, String sexe,
            String adresse, String tel) throws ChampsControlExceptions {
        
        try {
            Usager usager = new Usager();
            UsagerDAO usagerDao = new UsagerDAO(DBConnection.getConnection());
            
            usager.setNom(nom);
            usager.setPrenom(prenom);
            usager.setDateNais(dateNais);
            usager.setSexe(sexe);
            usager.setAdresse(adresse);
            usager.setTel(tel);

            usagerDao.inserer(usager);

        } catch (ChampsControlExceptions e) {
            throw new ChampsControlExceptions(e.getMessage());
        } catch (SQLException e) {
            throw new DAOConfigurationException(e.getMessage());
        }
    }
    
    public void ajouter(Usager usager) throws ChampsControlExceptions{
        ajouter(usager.getNom(), usager.getPrenom(), usager.getDateNais(),
                usager.getSexe(), usager.getAdresse(), usager.getTel());
    }

    public void modifier(Usager usager) throws DAOExceptions{
        try {
            UsagerDAO usagerDao = new UsagerDAO(DBConnection.getConnection());
            usagerDao.update(usager);
        } catch (SQLException e) {
            throw new DAOExceptions(getClass().getName() + e.getMessage());
        }
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
    
    public ArrayList<Usager> find(String nom) throws DAOExceptions{
        ArrayList<Usager> usagers = null;
        try {
            UsagerDAO usagerDao = new UsagerDAO(DBConnection.getConnection());
            usagers  = usagerDao.find(nom);
        } catch (SQLException e) {
            throw new DAOExceptions(getClass().getName() + e.getMessage());
        }
        return usagers;
    }
}
