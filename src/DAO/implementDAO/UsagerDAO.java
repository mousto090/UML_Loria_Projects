package DAO.implementDAO;

import BibalExceptions.DAOExceptions;
import DAO.DAO;
import static DAO.DAOUtility.initialiseRequetePreparee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import objets_metiers.Usager;

public class UsagerDAO extends DAO<Usager> {

    public static final String DATE_FORMAT = "yyyy-mm-dd";
    // public static final String DATE_FORMAT_BD = "%Y-%m-%d";
    private static final String SQL_INSERT = "INSERT INTO usager "
            + "(Nom, Prenom, DateNais, Sexe, Adresse,Tel ) "
            + "VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM usager WHERE id = ? ";
    private static final String SQL_SELECT = "SELECT * FROM usager ORDER BY id";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM usager WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE usager "
            + " SET Nom = ?, Prenom = ?, DateNais = ?, Sexe = ?, Adresse = ?,Tel = ? "
            + "WHERE id = ?";

    public UsagerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void inserer(Usager usager) throws DAOExceptions {

        PreparedStatement preparedStatement = null;
        try {
            String formatedDateNais = new SimpleDateFormat(DATE_FORMAT).format(usager.getDateNais());
            System.out.println("DAO.implementDAO.UsagerDAO.inserer() formateddate = " + formatedDateNais);
            preparedStatement = initialiseRequetePreparee(connection, SQL_INSERT,
                    usager.getNom(), usager.getPrenom(),
                    formatedDateNais, usager.getSexe(),
                    usager.getAdresse(), usager.getTel());
            System.out.println("DAO.implementDAO.UsagerDAO.inserer()" + preparedStatement);
            int statut = preparedStatement.executeUpdate();
            if (statut == 0) {
                throw new DAOExceptions("Erreurs lors de l'ajout d'un usager");
            }

        } catch (SQLException | DAOExceptions e) {
            throw new DAOExceptions("Erreurs lors de l'ajout d'un usager", e.getCause());
        }
    }

    @Override
    public void update(Usager usager) {

        PreparedStatement preparedStatement = null;
        try {
            String formatedDateNais = new SimpleDateFormat(DATE_FORMAT).format(usager.getDateNais());
            preparedStatement = initialiseRequetePreparee(connection, SQL_UPDATE,
                    usager.getNom(), usager.getPrenom(),
                    formatedDateNais, usager.getSexe(),
                    usager.getAdresse(), usager.getTel(),
                    usager.getId());
            int statut = preparedStatement.executeUpdate();
            if (statut == 0) {
                throw new DAOExceptions("Echec de la mise à jour de l'usager");
            }
        } catch (SQLException | DAOExceptions e) {
            throw new DAOExceptions("Erreurs lors de la mise à jour de l'usager ", e.getCause());
        }
    }

    @Override
    public void delete(Usager usager) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = initialiseRequetePreparee(connection, SQL_DELETE_BY_ID,
                    usager.getId());
            int statut = preparedStatement.executeUpdate();
            if (statut == 0) {
                throw new DAOExceptions("Echec de la suppression de l'usager");
            }
        } catch (SQLException | DAOExceptions e) {
            throw new DAOExceptions("Erreurs lors de la suppression de l'usager ", e.getCause());
        }
    }

    @Override
    public ArrayList<Usager> getAll() throws DAOExceptions {
//        PreparedStatement preparedStatement;
//        ResultSet resultSet;
//        ArrayList<Usager> listUsagers = new ArrayList<>();
//
//        try {
//            preparedStatement = connection.prepareStatement(SQL_SELECT);
//            resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                listUsagers.add(mappingUsager(resultSet));
//            }
//        } catch (SQLException e) {
//            throw new DAOExceptions("Erreur d'accès à la liste des usagers " + e.getMessage());
//        }
//        return listUsagers;
          return find(SQL_SELECT, new Object[0]);
    }

    @Override
    public Usager find(int id) {
//        PreparedStatement preparedStatement;
//        ResultSet resultSet;
//        Usager usager = null;
//        try {
//            preparedStatement = initialiseRequetePreparee(connection, SQL_SELECT_BY_ID, id);
//            resultSet = preparedStatement.executeQuery();
//            
//            if (resultSet.next()) {
//                usager = mappingUsager(resultSet);
//            }
//        } catch (SQLException | DAOExceptions e) {
//            throw new DAOExceptions("Aucun enregistrement trouvé ", e.getCause());
//        }
//        return usager;
        return find(SQL_SELECT_BY_ID, id).get(0);
    }

    public ArrayList<Usager> find(String nom) {
        return find(SQL_SELECT_BY_ID, nom);
    }

    private ArrayList<Usager> find(String sql, Object... objets) throws DAOExceptions {
//        PreparedStatement preparedStatement;
//        ResultSet resultSet;
//        Usager usager = null;
//        try {
//            preparedStatement = initialiseRequetePreparee(connection, sql, objets);
//            resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                usager = mappingUsager(resultSet);
//            }
//        } catch (SQLException | DAOExceptions e) {
//            throw new DAOExceptions("Aucun enregistrement trouvé ", e.getCause());
//        }
//        return usager;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Usager> listUsagers = new ArrayList<>();

        try {
            preparedStatement = initialiseRequetePreparee(connection, sql, objets);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listUsagers.add(mappingUsager(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOExceptions("Aucun enregistrement trouvé " + e.getMessage());
        }
        return listUsagers;
    }

    private static Usager mappingUsager(ResultSet resultSet) throws SQLException {
        Usager usager = new Usager();
        usager.setId(resultSet.getInt("id"));
        usager.setNom(resultSet.getString("nom"));
        usager.setPrenom(resultSet.getString("prenom"));
        usager.setDateNais(resultSet.getDate("dateNais"));
        usager.setSexe(resultSet.getString("sexe"));
        usager.setAdresse(resultSet.getString("adresse"));
        usager.setTel(resultSet.getString("tel"));

        return usager;
    }

}
