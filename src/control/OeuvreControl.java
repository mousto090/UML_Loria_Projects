package control;

import BibalExceptions.ChampsControlExceptions;
import BibalExceptions.DAOConfigurationException;
import BibalExceptions.DAOExceptions;
import DAO.DBConnection;
import DAO.implementDAO.OeuvreDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import objets_metiers.Oeuvre;
import objets_metiers.Livre;
import objets_metiers.Magazine;

public class OeuvreControl {

    public void ajouter(String titre, String auteur, String categorie, int lending,
            String typeOeuvre) throws ChampsControlExceptions {

        try {
            Oeuvre oeuvre;
            OeuvreDAO oeuvreDao = new OeuvreDAO(DBConnection.getConnection());

            if (typeOeuvre.equals(Magazine.class.getSimpleName())) {
                oeuvre = new Magazine();
                ((Magazine) oeuvre).setLending(lending);
            } else {
                oeuvre = new Livre();
                ((Livre) oeuvre).setLending(lending);
            }
            oeuvre.setTitre(titre);
            oeuvre.setAuteur(auteur);
            oeuvre.setCategorie(categorie);

            oeuvreDao.inserer(oeuvre);

        } catch (SQLException e) {
            throw new DAOConfigurationException(e.getMessage());
        }

    }

    public void ajouter(Oeuvre oeuvre) throws ChampsControlExceptions {
        String typeOeuvre = oeuvre.getClass().getSimpleName();
        int lending;
        if (typeOeuvre.equals(Magazine.class.getSimpleName())) {
            lending = ((Magazine) oeuvre).getLending();
        } else {
            lending = ((Livre) oeuvre).getLending();
        }
        ajouter(oeuvre.getTitre(), oeuvre.getAuteur(), oeuvre.getCategorie(),
                    lending, typeOeuvre);
    }

    public void modifier(int id, String titre, String auteur, String categorie,
            int lending, int nbResa, String typeOeuvre) throws ChampsControlExceptions {
        try {
            Oeuvre oeuvre;
            OeuvreDAO oeuvreDao = new OeuvreDAO(DBConnection.getConnection());

            if (typeOeuvre.equals(Magazine.class.getSimpleName())) {
                oeuvre = new Magazine();
                ((Magazine) oeuvre).setLending(lending);
            } else {
                oeuvre = new Livre();
                ((Livre) oeuvre).setLending(lending);
            }
            oeuvre.setId(id);
            oeuvre.setTitre(titre);
            oeuvre.setAuteur(auteur);
            oeuvre.setCategorie(categorie);
            oeuvre.setNbResa(nbResa);

            oeuvreDao.update(oeuvre);

        } catch (SQLException e) {
            throw new DAOConfigurationException(e.getMessage());
        }
        
    }
   
    public Oeuvre find(int id) throws DAOExceptions {
        Oeuvre oeuvre = null;
        try {
            OeuvreDAO oeuvreDao = new OeuvreDAO(DBConnection.getConnection());
            oeuvre = oeuvreDao.find(id);
        } catch (SQLException e) {
            throw new DAOExceptions(getClass().getName() + e.getMessage());
        }
        return oeuvre;
    }

    public ArrayList<Oeuvre> find(String typeOeuvre) throws DAOExceptions {
        ArrayList<Oeuvre> oeuvres = null;
        try {
            OeuvreDAO oeuvreDao = new OeuvreDAO(DBConnection.getConnection());
            oeuvres = oeuvreDao.find(typeOeuvre);
        } catch (SQLException e) {
            throw new DAOExceptions(getClass().getName() + e.getMessage());
        }
        return oeuvres;
    }
}
