package DAO.implementDAO;

import BibalExceptions.ChampsControlExceptions;
import BibalExceptions.DAOExceptions;
import DAO.DAO;
import static DAO.Utility.closeStatement;
import static DAO.Utility.closeStatementResultSet;
import static DAO.Utility.initialiseRequetePreparee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import objets_metiers.Livre;
import objets_metiers.Magazine;
import objets_metiers.Oeuvre;

public class OeuvreDAO extends DAO<Oeuvre> {

    private static final String SQL_INSERT = "INSERT INTO oeuvre "
            + "(Titre, Auteur, Categorie, NbResa, Lending,TypeOeuvre ) "
            + "VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM oeuvre WHERE id = ? ";
    private static final String SQL_SELECT = "SELECT * FROM oeuvre ORDER BY id";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM oeuvre WHERE id = ?";
    private static final String SQL_SELECT_BY_TYPE_OEUVRE = "SELECT * FROM oeuvre WHERE TypeOeuvre = ?";
    private static final String SQL_UPDATE = "UPDATE oeuvre "
            + " SET Titre = ?, Auteur = ?, Categorie = ?, NbResa = ?, Lending = ?,TypeOeuvre = ? "
            + "WHERE id = ?";

    public OeuvreDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void inserer(Oeuvre oeuvre) throws DAOExceptions {
        PreparedStatement preparedStatement = null;
        try {

            String typeOeuvre = oeuvre.getClass().getSimpleName();
            int lending;
            if (typeOeuvre.equals(Magazine.class.getSimpleName())) {
                lending = ((Magazine) oeuvre).getLending();
            } else {
                lending = ((Livre) oeuvre).getLending();
            }

            preparedStatement = initialiseRequetePreparee(connection, SQL_INSERT,
                    oeuvre.getTitre(), oeuvre.getAuteur(),
                    oeuvre.getCategorie(), oeuvre.getNbResa(),
                    lending, typeOeuvre);
            int statut = preparedStatement.executeUpdate();
            if (statut == 0) {
                throw new DAOExceptions("Echec d'ajout de l'oeuvre");
            }

        } catch (SQLException | DAOExceptions e) {
            throw new DAOExceptions("Erreurs lors de l'ajout de l'oeuvre", e.getCause());
        } finally {
            closeStatement(preparedStatement);
        }
    }

    @Override
    public void update(Oeuvre oeuvre) throws DAOExceptions {
        PreparedStatement preparedStatement = null;
        try {
            int lending;
            String typeOeuvre = oeuvre.getClass().getSimpleName();

            if (typeOeuvre.equals(Magazine.class.getSimpleName())) {
                lending = ((Magazine) oeuvre).getLending();
            } else {
                lending = ((Livre) oeuvre).getLending();
            }
            preparedStatement = initialiseRequetePreparee(connection, SQL_UPDATE,
                    oeuvre.getTitre(), oeuvre.getAuteur(),
                    oeuvre.getCategorie(), oeuvre.getNbResa(),
                    lending, typeOeuvre,
                    oeuvre.getId());
            int statut = preparedStatement.executeUpdate();
            if (statut == 0) {
                throw new DAOExceptions("Echec de la mise à jour de l'oeuvre");
            }
        } catch (SQLException e) {
            throw new DAOExceptions("Erreurs lors de la mise à jour de l'oeuvre ", e.getCause());
        } finally {
            closeStatement(preparedStatement);
        }
    }

    @Override
    public void delete(Oeuvre object) throws DAOExceptions {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Oeuvre> getAll() throws DAOExceptions {
        return find(SQL_SELECT, new Object[0]);
    }

    @Override
    public Oeuvre find(int id) throws DAOExceptions {
        return find(SQL_SELECT_BY_ID, id).get(0);
    }

    public ArrayList<Oeuvre> find(String typeOeuvre) {
        return find(SQL_SELECT_BY_TYPE_OEUVRE, typeOeuvre);
    }

    private ArrayList<Oeuvre> find(String sql, Object... objets) throws DAOExceptions {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Oeuvre> listOeuvres = new ArrayList<>();

        try {
            preparedStatement = initialiseRequetePreparee(connection, sql, objets);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listOeuvres.add(mappingUsager(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOExceptions("Aucun enregistrement trouvé " + e.getMessage());
        } finally {
            closeStatementResultSet(preparedStatement, resultSet);
        }
        if (listOeuvres.isEmpty()) {
            throw new DAOExceptions("Aucun enregistrement trouvé ");
        }
        return listOeuvres;
    }

    private static Oeuvre mappingUsager(ResultSet resultSet) throws SQLException {
        Oeuvre oeuvre = null;
        try {
            String typeOeuvre = resultSet.getString("TypeOeuvre");
            if (typeOeuvre.equals(Magazine.class.getSimpleName())) {
                oeuvre = new Magazine();
                ((Magazine) oeuvre).setLending(resultSet.getInt("Lending"));
            } else {
                oeuvre = new Livre();
                ((Livre) oeuvre).setLending(resultSet.getInt("Lending"));
            }
            oeuvre.setId(resultSet.getInt("id"));
            oeuvre.setTitre(resultSet.getString("Titre"));
            oeuvre.setCategorie(resultSet.getString("Categorie"));
            oeuvre.setAuteur(resultSet.getString("Auteur"));
            oeuvre.setNbResa(resultSet.getInt("NbResa"));
        } catch (ChampsControlExceptions e) {
            System.out.println(e.getMessage());
        }
        return oeuvre;
    }

}
