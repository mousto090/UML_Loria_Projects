/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BibalExceptions.ChampsControlExceptions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jalloh
 */
public final class Utility {
    
    public static final String DATE_FORMAT = "yyyy-mm-dd";
    /**
     * Fermeture du ResultSet
     * @param resultSet 
     */
    public static void closeResultSet( ResultSet resultSet ) {
        if ( resultSet != null ) {
            try {
                resultSet.close();
            } catch ( SQLException e ) {
                System.out.println( "Echec de la fermeture du ResultSet : " + e.getMessage() );
            }
        }
    }
    /**
     * Fermeture du statement
     * @param statement 
     */
    public static void closeStatement( Statement statement ) {
        if ( statement != null ) {
            try {
                statement.close();
            } catch ( SQLException e ) {
                System.out.println( "Echec de la fermeture du Statement : " + e.getMessage() );
            }
        }
    }
    
    /**
     * Fermeture de la connexion
     * @param connexion 
     */
    public static void closeConnection( Connection connexion ) {
        if ( connexion != null ) {
            try {
                connexion.close();
            } catch ( SQLException e ) {
                System.out.println( "Echec de la fermeture de la connexion : " + e.getMessage() );
            }
        }
    }
    /**
     * 
     * @param statement
     * @param resultSet 
     */
    public static void closeStatementResultSet( Statement statement, ResultSet resultSet ) {
        closeStatement(statement );
        closeResultSet(resultSet );
    }
    
    public static void closeConnectionStatementResultSet(Connection connexion, Statement statement, ResultSet resultSet ) {
        closeConnection(connexion);
        closeStatement(statement );
        closeResultSet(resultSet );
    }
    /**
     * Initialisation des requêtes préparées des objets
     * @param connexion
     * @param sql
     * @param objets
     * @return
     * @throws SQLException 
     */
    public static PreparedStatement initialiseRequetePreparee( Connection connexion, String sql, Object... objets ) throws SQLException {
        PreparedStatement preparedStatement = connexion.prepareStatement( sql);
        for ( int i = 0; i < objets.length; i++ ) {
            preparedStatement.setObject( i + 1, objets[i] );
        }
        return preparedStatement;
    }
    
    
    public static Date formatDate(String dateNais) throws ChampsControlExceptions {

        if (null != dateNais) {
            try {
                return new SimpleDateFormat("dd/mm/yyyy").parse(dateNais);
            } catch (ParseException e) {
                throw new ChampsControlExceptions("Date non valide ", e.getCause());
            }
        } else {
            throw new ChampsControlExceptions("Merci d'indiquer une date ");
        }
    }
    
    public static String dateToStr(Date date){
        return new SimpleDateFormat(DATE_FORMAT).format(date);
    }
}
